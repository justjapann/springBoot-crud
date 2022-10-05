package DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Model.Paciente;

@Repository
public class Paciente_DAO_Imp  implements Paciente_DAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean savePaciente(Paciente paciente) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query=currentSession.createQuery("from Paciente where paciente_name=:paciente_name", Paciente.class);
        query.setParameter("paciente_name", paciente.getPaciente_name());
        List list = query.list();
        System.out.println("lista aqui = " + list);
        if (list.isEmpty()) {
           currentSession.save(paciente);
            return true;
        }else{
            return false;
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

    @Override
    public boolean updatePaciente(Paciente paciente) {
        boolean status=false;
        try {
            sessionFactory.getCurrentSession().update(paciente);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }



}