package model;

public class bonus {
    private int bonus_id;
    private String staff_id;
    private int salary_bonus;
    private String bonus_describe;

    public bonus() {
    }

    public bonus(String staff_id, int salary_bonus, String bonus_describe) {
        this.staff_id = staff_id;
        this.salary_bonus = salary_bonus;
        this.bonus_describe = bonus_describe;
    }

    public bonus(int bonus_id, String staff_id, int salary_bonus, String bonus_describe) {
        this.bonus_id = bonus_id;
        this.staff_id = staff_id;
        this.salary_bonus = salary_bonus;
        this.bonus_describe = bonus_describe;
    }

    public int getBonus_id() {
        return bonus_id;
    }

    public void setBonus_id(int bonus_id) {
        this.bonus_id = bonus_id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
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
        return "bonus[" +
                "bonus_id=" + bonus_id +
                ", staff_id='" + staff_id + '\'' +
                ", salary_bonus=" + salary_bonus +
                ", bonus_describe='" + bonus_describe + '\'' +
                ']' + "\n";
    }
}
