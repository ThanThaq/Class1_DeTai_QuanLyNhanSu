package model;

public class department {
    private String department_id;
    private String department_name;
    private String department_phone;
    private String department_adress;

    public department() {
    }

    public department(String department_id, String department_name, String department_phone, String department_adress) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_phone = department_phone;
        this.department_adress = department_adress;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDepartment_phone() {
        return department_phone;
    }

    public void setDepartment_phone(String department_phone) {
        this.department_phone = department_phone;
    }

    public String getDepartment_adress() {
        return department_adress;
    }

    public void setDepartment_adress(String department_adress) {
        this.department_adress = department_adress;
    }


    @Override
    public String toString() {
        return "department[" +
                "department_id='" + department_id + '\'' +
                ", department_name='" + department_name + '\'' +
                ", department_phone='" + department_phone + '\'' +
                ", department_adress='" + department_adress + '\'' +
                ']' + "\n";
    }
}
