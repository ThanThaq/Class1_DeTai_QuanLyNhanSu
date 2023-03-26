package model;

public class position {
    private String position_id;
    private String position_name;
    private String position_describe;
    private int position_salary;

    public position() {
    }

    public position(String position_id, String position_name, String position_describe, int position_salary) {
        this.position_id = position_id;
        this.position_name = position_name;
        this.position_describe = position_describe;
        this.position_salary = position_salary;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPosition_describe() {
        return position_describe;
    }

    public void setPosition_describe(String position_describe) {
        this.position_describe = position_describe;
    }

    public int getPosition_salary() {
        return position_salary;
    }

    public void setPosition_salary(int position_salary) {
        this.position_salary = position_salary;
    }

    @Override
    public String toString() {
        return "position[" +
                "position_id='" + position_id + '\'' +
                ", position_name='" + position_name + '\'' +
                ", position_describe='" + position_describe + '\'' +
                ", position_salary=" + position_salary +
                ']'+ "\n";
    }
}
