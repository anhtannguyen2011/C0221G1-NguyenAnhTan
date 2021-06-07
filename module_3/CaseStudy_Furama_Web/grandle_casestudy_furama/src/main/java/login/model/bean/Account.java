package login.model.bean;

public class Account {
    private String userName;
    private String password;
    private int idUser;
    private int idAdmin;

    public Account() {
    }

    public Account(String userName, String password, int idUser, int idAdmin) {
        this.userName = userName;
        this.password = password;
        this.idUser = idUser;
        this.idAdmin = idAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
}
