package org.kpi.fift.bean;

import org.kpi.fift.dao.UserDAO;
import org.kpi.fift.pojo.User;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named(value = "adminBean")
public class AdminBean {

    private String log;

    private String pass;

    private String rol;

    private UserDAO userDAO = new UserDAO();

    private User selUser;

    private List<User> users;

    @PostConstruct
    public void init(){
        users = userDAO.findAll();
    }

    public List<User> getUsers() {
        return userDAO.findAll();
    }

    public void delete (String login, String password, String role){
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);

        userDAO.deleteUser(user);
    }

    public void save(){
        User user = new User();
        user.setPassword(pass);
        user.setLogin(log);
        user.setRole(rol);

        userDAO.saveUser(user);
    }

    public void save(String login, String password, String role){
        User user = new User();
        user.setPassword(password);
        user.setLogin(login);
        user.setRole(role);

        userDAO.saveUser(user);
    }

    public String getLogin() {
        return log;
    }

    public void setLogin(String login) {
        this.log = login;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    public String getRole() {
        return rol;
    }

    public void setRole(String role) {
        this.rol = role;
    }

    public User getSelUser() {
        return selUser;
    }

    public void setSelUser(User selUser) {
        this.selUser = selUser;
    }

//    public void onRowSelect(SelectEvent event) {
//        Faces
//    }
}
