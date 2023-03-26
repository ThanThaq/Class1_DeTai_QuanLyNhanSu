package model;

public class staff {
    private String staff_id;
    private String staff_name;
    private int gender;
    private String birthday;
    private String address;
    private String phone;
    private String email;
    private String position_id;
    private String department_id;
    private int status;

    public staff() {
    }

    public staff(String staff_id, String staff_name, int gender, String birthday, String address, String phone, String email, String position_id, String department_id, int status) {
        if (gender < 0 || gender > 1) {
            throw new IllegalArgumentException("Giới tính nhập không đúng, vui lòng nhập lại\n 0-nữ\n 1-nam");
        }
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.position_id = position_id;
        this.department_id = department_id;
        this.status = status;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
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
        if (gender < 0 || gender > 1) {
            throw new IllegalArgumentException("Giới tính nhập không đúng, vui lòng nhập lại\n 0-nữ\n 1-nam");
        }
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

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "staff[" +
                "staff_id='" + staff_id + '\'' +
                ", staff_name='" + staff_name + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", position_id='" + position_id + '\'' +
                ", department_id='" + department_id + '\'' +
                ", status=" + status +
                ']' + "\n";
    }
}
