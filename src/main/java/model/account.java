package model;

public class account {
    private int account_id;
    private String user;
    private String password;
    private String staff_id;
    private int permission;

    public account() {
    }

    public account(String user, String password, String staff_id, int permission) {
        this.user = user;
        this.password = password;
        this.staff_id = staff_id;
        this.permission = permission;
    }

    public account(int account_id, String user, String password, String staff_id, int permission) {
        this.account_id = account_id;
        this.user = user;
        this.password = password;
        this.staff_id = staff_id;
        this.permission = permission;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Account[" +
                "account_id=" + account_id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", staff_id='" + staff_id + '\'' +
                ", permission=" + permission +
                ']'+ "\n";
    }
}
