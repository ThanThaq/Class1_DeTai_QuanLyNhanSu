package model;

public class infoUser {
    private String account_id;
    private String user;
    private String password;
    private String staff_id;
    private int permission;
    private String staff_name;
    private int gender;
    private String birthday;
    private String address;
    private String phone;
    private String email;
    private String position_name;
    private int position_salary;
    private String department_name;
    private int bonus_id;
    private int salary_bonus;
    private String bonus_describe;
    public infoUser() {
    }

    public infoUser(String user, String password, String staff_id, int permission, String staff_name, int gender, String birthday, String address, String phone, String email, String position_name, int position_salary, String department_name) {
        this.user = user;
        this.password = password;
        this.staff_id = staff_id;
        this.permission = permission;
        this.staff_name = staff_name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.position_name = position_name;
        this.position_salary = position_salary;
        this.department_name = department_name;
    }

    public infoUser(String account_id, String user, String password, String staff_id, int permission, String staff_name, int gender, String birthday, String address, String phone, String email, String position_name, int position_salary, String department_name) {
        this.account_id = account_id;
        this.user = user;
        this.password = password;
        this.staff_id = staff_id;
        this.permission = permission;
        this.staff_name = staff_name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.position_name = position_name;
        this.position_salary = position_salary;
        this.department_name = department_name;
    }

    public infoUser(String account_id, String user, String password, String staff_id, int permission, String staff_name, int gender, String birthday, String address, String phone, String email, String position_name, int position_salary, String department_name, int salary_bonus, String bonus_describe) {
        this.account_id = account_id;
        this.user = user;
        this.password = password;
        this.staff_id = staff_id;
        this.permission = permission;
        this.staff_name = staff_name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.position_name = position_name;
        this.position_salary = position_salary;
        this.department_name = department_name;
        this.salary_bonus = salary_bonus;
        this.bonus_describe = bonus_describe;
    }

    public infoUser(String account_id, String user, String password, String staff_id, int permission, String staff_name, int gender, String birthday, String address, String phone, String email, String position_name, int position_salary, String department_name, int bonus_id, int salary_bonus, String bonus_describe) {
        this.account_id = account_id;
        this.user = user;
        this.password = password;
        this.staff_id = staff_id;
        this.permission = permission;
        this.staff_name = staff_name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.position_name = position_name;
        this.position_salary = position_salary;
        this.department_name = department_name;
        this.bonus_id = bonus_id;
        this.salary_bonus = salary_bonus;
        this.bonus_describe = bonus_describe;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
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

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public int getPosition_salary() {
        return position_salary;
    }

    public void setPosition_salary(int position_salary) {
        this.position_salary = position_salary;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getBonus_id() {
        return bonus_id;
    }

    public void setBonus_id(int bonus_id) {
        this.bonus_id = bonus_id;
    }

    public int getSalary_bonus() {
        return salary_bonus;
    }

    public void setSalary_bonus(int salary_bonus) {
        this.salary_bonus = salary_bonus;
    }

    public String getBonus_describe() {
        return bonus_describe;
    }

    public void setBonus_describe(String bonus_describe) {
        this.bonus_describe = bonus_describe;
    }

    @Override
    public String toString() {
        return "infoUser[" +
                "account_id='" + account_id + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", staff_id='" + staff_id + '\'' +
                ", permission=" + permission +
                ", staff_name='" + staff_name + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", position_name='" + position_name + '\'' +
                ", position_salary=" + position_salary +
                ", department_name='" + department_name + '\'' +
                ", bonus_id=" + bonus_id +
                ", salary_bonus=" + salary_bonus +
                ", bonus_describe='" + bonus_describe + '\'' +
                ']';
    }
}
