package managerbean;

import service.ServiceStudent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Login {
    private String name;
    private int id;

    private ServiceStudent serviceStudent = new ServiceStudent();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String login() throws Exception {
        boolean islog = serviceStudent.getStudentByName(id);
        if (islog) {
            return "/page/index.xhtml";
        } else
            return "/page/login.xhtml";
    }

}
