FROM openjdk:8
VOLUME /tmp
EXPOSE 8080
ADD ../../target/Paciente-0.0.1-SNAPSHOT.jar crud.jar
ENTRYPOINT ["java","-jar","Paciente-0.0.1-SNAPSHOT.jar"]