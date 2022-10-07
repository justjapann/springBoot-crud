package DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;


import Model.Paciente;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public class Paciente_DAO_Imp  implements Paciente_DAO{



    @Autowired
    private SessionFactory sessionFactory;

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="oops")
    @Override
    public boolean savePaciente(Paciente paciente) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query=currentSession.createQuery("from Paciente where paciente_name=:paciente_name", Paciente.class);
        query.setParameter("paciente_name", paciente.getPaciente_name());
        List list = query.list();
        System.out.println("lista aqui = " + list);
        if (list.isEmpty()) {
           currentSession.save(paciente);
            throw new ResourceAccept("Paciente " + paciente.getPaciente_name() + " criado com sucesso");
        }else{
            throw new ResourceNotFoundException("Ja existe um paciente com o nome " + paciente.getPaciente_name());
        }

    }

    @Override
    public List<Paciente> getPacientes() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Paciente> query=currentSession.createQuery("from Paciente", Paciente.class);
        List<Paciente> list=query.getResultList();
        return list;
    }

    @Override
    public boolean deletePaciente(Paciente paciente) {
        boolean status=false;
        try {
            sessionFactory.getCurrentSession().delete(paciente);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Paciente> getPacienteByID(Paciente paciente) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Paciente> query=currentSession.createQuery("from Paciente where paciente_id=:paciente_id", Paciente.class);
        query.setParameter("paciente_id", paciente.getPaciente_id());
        List<Paciente> list=query.getResultList();
        return list;
    }

    @Override
    public List<Paciente> getPacienteByName(Paciente paciente) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Paciente> query=currentSession.createQuery("from Paciente where paciente_name=:paciente_name", Paciente.class);
        query.setParameter("paciente_name", paciente.getPaciente_name());
        List<Paciente> list=query.getResultList();
        return list;
    }

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="oops")
    @Override
    public boolean updatePaciente(Paciente paciente) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query=currentSession.createQuery("from Paciente where paciente_name=:paciente_name and paciente_especialidade=:paciente_especialidade", Paciente.class);
        query.setParameter("paciente_name", paciente.getPaciente_name());
        query.setParameter("paciente_especialidade", paciente.getPaciente_especialidade());
        List list = query.list();
        System.out.println("lista aqui update = " + list);

        if (list.isEmpty()) {
            sessionFactory.getCurrentSession().update(paciente);
            return true;
        }else{
            throw new ResourceNotFoundException("O paciente ja tem a especialidade " + paciente.getPaciente_especialidade() + " no plano " + paciente.getPaciente_planodesaude());
        }
    }



}