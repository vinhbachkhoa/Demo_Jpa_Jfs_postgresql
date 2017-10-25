package managerbean;

import entity.StudentEntity;
import service.ServiceStudent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class StudentBean {


    ServiceStudent serviceStudent = new ServiceStudent();

    private StudentEntity studentEntity = new StudentEntity();
    private List<StudentEntity> studentEntityList = new ArrayList<StudentEntity>();

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public ServiceStudent getServiceStudent() {
        return serviceStudent;
    }

    public void setServiceStudent(ServiceStudent serviceStudent) {
        this.serviceStudent = serviceStudent;
    }

    public List<StudentEntity> getStudentEntityList() {
        return studentEntityList;
    }

    public void setStudentEntityList(List<StudentEntity> studentEntityList) {
        this.studentEntityList = studentEntityList;
    }

    /*Add Student*/
    public String add() {
        serviceStudent.addStudent(studentEntity.getId(), studentEntity.getName(), studentEntity.getDiachi());
        return "/page/student.xhtml";
    }

    /*List Student*/
    public String list() {
        this.studentEntityList = serviceStudent.studentEntityList();
        System.out.print(studentEntityList);
        return "student.xhtml";
    }
}
