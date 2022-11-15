package me.dev.santiago.login;

public class Login implements LoginInterface{
    private boolean logged;
    private String password;

    public Login(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void login() {
        this.logged = true;
    }

    @Override
    public void logout() {
        this.logged = false;
    }

    @Override
    public void register(String password) {
        this.password = password;
    }

    @Override
    public void unregister() {
        this.password = null;
    }
}
