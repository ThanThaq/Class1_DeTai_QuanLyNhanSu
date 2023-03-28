package dao;
import java.sql.Connection;
import connection.MyConnection;
import model.bonus;
import model.infoUser;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class bonusDAO {
    public static void insert(bonus bonus) {
        final String sql = String.format("INSERT INTO `java_quanlynhansu`.`bonus` (`staff_id`, `salary_bonus`, `bonus_describe`) VALUES ('%s', '%d', '%s')",
                bonus.getStaff_id(),bonus.getSalary_bonus(),bonus.getBonus_describe()
        );
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm mới thất bại");
            }System.out.println("Thêm mới thành công");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static infoUser getAllById(String id) {
        final String sql = "select b.`staff_id` as staff_id, b.`staff_name` as staff_name, b.`gender` as gender, b.`birthday` as birthday, b.`address` as address, b.`phone` as phone, b.`email` as email, c.`position_name` as position_name, c.`position_salary` as position_salary, Sum(e.`salary_bonus`) as salary_bonus, d.`department_name` as department_name" +
                " from `staff` b" +
                " left join `position` c on b.`position_id` = c.`position_id`" +
                " left join `department` d on b.`department_id` = d.`department_id`" +
                " left join `bonus` e on b.`staff_id` = e.`staff_id`" +
                " WHERE b.`staff_id` =" + "'" + id + "'" +
                " ORDER BY b.`staff_id` asc";
//        System.out.println(sql);
        infoUser info = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                info = new infoUser();
                info.setStaff_id(rs.getString("staff_id"));
                info.setStaff_name(rs.getString("staff_name"));
                info.setGender(rs.getInt("gender"));
                info.setBirthday(rs.getString("birthday"));
                info.setAddress(rs.getString("address"));
                info.setPhone(rs.getString("phone"));
                info.setEmail(rs.getString("email"));
                info.setPosition_name(rs.getString("position_name"));
                info.setPosition_salary(rs.getInt("position_salary"));
                info.setSalary_bonus(rs.getInt("salary_bonus"));
                info.setDepartment_name(rs.getString("department_name"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }
    public static bonus getById(String id) {
        final String sql = "SELECT * FROM `bonus` WHERE  `staff_id` = " + "'" + id + "'";
        bonus bonus = null;
//       System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                bonus = new bonus();
                bonus.setBonus_id(rs.getInt("bonus_id"));
                bonus.setStaff_id(rs.getString("staff_id"));
                bonus.setSalary_bonus(rs.getInt("salary_bonus"));
                bonus.setBonus_describe(rs.getString("bonus_describe"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bonus;
    }
    public static void delete(String id) {
        bonus tmp= getById(id);
        if (tmp == null) {
            throw new RuntimeException("Nhân viên chưa có thưởng!");
        }
        final String sql = "DELETE FROM `bonus` WHERE  `staff_id` = " + "'" + id + "'";
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
