package com.example.registration;

public class User {

    private String login;
    private String email;
    private String password;
    private String confirmPasword;
    private int age;
    private String adress;


    public User(String login, String email, String password, String confirmPasword, int age, String adress) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.confirmPasword = confirmPasword;
        this.age = age;
        this.adress = adress;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPasword() {
        return confirmPasword;
    }

    public void setConfirmPasword(String confirmPasword) {
        this.confirmPasword = confirmPasword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}

