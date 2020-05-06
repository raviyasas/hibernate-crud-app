package com.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {

    public void saveStudent(Student student){

        Transaction transaction = null;
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (Exception e){
            try{
                transaction.rollback();
            }catch(RuntimeException re){
                re.getMessage();
            }
            throw e;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Student> getStudents(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Student", Student.class).list();
        }
    }

    public void deleteStudent(Integer id){

        Transaction transaction = null;
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            transaction.commit();
        }catch (Exception e){
            try{
                transaction.rollback();
            }catch(RuntimeException re){
                re.getMessage();
            }
            throw e;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void updateStudent(Integer id, String firstName, String lastName, String email) {
        Transaction transaction = null;
        Session session = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Student student = session.get(Student.class, id);

            if(firstName != null){
                student.setFirstName(firstName);
            }
            if(lastName != null){
                student.setLastName(lastName);
            }
            if(email != null){
                student.setEmail(email);
            }
            session.update(student);
            transaction.commit();

        }catch (Exception e){
            try{
                transaction.rollback();
            }catch(RuntimeException re){
                re.getMessage();
            }
            throw e;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
