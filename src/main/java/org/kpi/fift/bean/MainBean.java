package org.kpi.fift.bean;

import org.kpi.fift.dao.UserDAO;
import org.kpi.fift.pojo.User;

import javax.inject.Named;

@Named(value = "mainBean")
public class MainBean {
    private UserDAO usrDao = new UserDAO();

    private String login;

    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkUser() {
        checkAdmin();
        if (!login.equals(null)) {
            User user = usrDao.findUser(login);

            if (login.equals(user.getLogin()) && password.equals(user.getPassword()) && user.getRole().equals("admin")){
                return "adminPage?faces-redirect=true";
            } else if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return "Hello " + login + " !";
            }
        }

        return "Wrong login or password";
    }

    public void checkAdmin(){
        if (usrDao.checkForAdmin() == 0){
            User user = new User();
            user.setLogin("admin");
            user.setPassword("admin");
            user.setRole("admin");

            usrDao.saveUser(user);
        }
    }
}
