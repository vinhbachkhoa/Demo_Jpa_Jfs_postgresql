package service;

import entity.StudentEntity;

import javax.persistence.*;
import java.util.List;

public class ServiceStudent {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("PeopleDS");
    EntityManager em = emf.createEntityManager();

    /*Add Student*/
    public void addStudent(int id, String name, String diachi) {
        em.getTransaction().begin();
        StudentEntity clazz = new StudentEntity();
        clazz.setName(name);
        clazz.setDiachi(diachi);
        clazz.setId(id);
        em.persist(clazz);
        em.getTransaction().commit();
    }

    /* Login */
    public boolean getStudentByName(int id) throws Exception {
        try {
            TypedQuery<StudentEntity> query = em.createQuery(
                    "SELECT c FROM student c WHERE c.id = :id", StudentEntity.class);
            StudentEntity studentEntity = query.setParameter("id", id).getSingleResult();
            if (studentEntity != null)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }

    }

    /*List Student*/

    public List<StudentEntity> studentEntityList() {
        try {
            TypedQuery<StudentEntity> query =
                    em.createNamedQuery("ListUSer", StudentEntity.class);
            List<StudentEntity> results = query.getResultList();
            return results;
        } catch (Exception e) {
            return null;
        }
    }
}
