package dao;
import java.sql.Connection;
import connection.MyConnection;
import model.infoUser;
import model.staff;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class staffDAO {
    public static List<infoUser> search(String keyword) {
        final String sql = "select b.`staff_id` as staff_id, b.`staff_name` as staff_name, b.`gender` as gender, b.`birthday` as birthday, b.`address` as address, b.`phone` as phone, b.`email` as email, c.`position_name` as position_name, c.`position_salary` as position_salary, sum(e.`salary_bonus`) as salary_bonus, d.`department_name` as department_name" +
                " from `staff` b" +
                " left join `position` c on b.`position_id` = c.`position_id`" +
                " left join `department` d on b.`department_id` = d.`department_id`" +
                " left join `bonus` e on b.`staff_id` = e.`staff_id`" +
                " WHERE b.`staff_id` like '%" + keyword + "%' OR b.`staff_name` like '%" + keyword +"%' OR b.`phone` like '%" + keyword +"%' OR d.`department_name` like '%" + keyword +"%'" + "AND b.`status` = 1" +
                " GROUP BY b.`staff_id`" +
                " ORDER BY c.`position_salary` desc";
        System.out.println(sql);
        List<infoUser> infoUserList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                infoUser info = new infoUser();
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
                infoUserList.add(info);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infoUserList;
    }
    public static infoUser getInfoById(String id) {
        final String sql = "select b.`staff_id` as staff_id, b.`staff_name` as staff_name, b.`gender` as gender, b.`birthday` as birthday, b.`address` as address, b.`phone` as phone, b.`email` as email, c.`position_name` as position_name, c.`position_salary` as position_salary, sum(e.`salary_bonus`) as salary_bonus, d.`department_name` as department_name" +
                " from `staff` b" +
                " left join `position` c on b.`position_id` = c.`position_id`" +
                " left join `department` d on b.`department_id` = d.`department_id`" +
                " left join `bonus` e on b.`staff_id` = e.`staff_id`" +
                " WHERE b.`staff_id` = '" + id + "'" + "AND b.`status` = 1" +
                " GROUP BY b.`staff_id`" +
                " ORDER BY c.`position_salary` asc";
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
    public static List<infoUser> getAll() {
        final String sql = "select b.`staff_id` as staff_id, b.`staff_name` as staff_name, b.`gender` as gender, b.`birthday` as birthday, b.`address` as address, b.`phone` as phone, b.`email` as email, c.`position_name` as position_name, c.`position_salary` as position_salary, e.`salary_bonus` as salary_bonus, d.`department_name` as department_name" +
                " from `staff` b" +
                " left join `position` c on b.`position_id` = c.`position_id`" +
                " left join `department` d on b.`department_id` = d.`department_id`" +
                " left join `bonus` e on b.`staff_id` = e.`staff_id`" +
                " WHERE b.`status` = 1" +
                " GROUP BY b.`staff_id`" +
                " ORDER BY `position_salary` asc";
//        System.out.println(sql);
        List<infoUser> infoUserList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                infoUser info = new infoUser();
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
                infoUserList.add(info);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infoUserList;
    }

    public static void insert(staff staff) {
        final String sql = String.format("INSERT INTO `java_quanlynhansu`.`staff` (`staff_id`, `staff_name`, `gender`, `birthday`, `address`, `phone`, `email`, `position_id`, `department_id`, `status`) VALUES ('%s', '%s', '%d', '%s', '%s', '%s', '%s', '%s', '%s', '1')",
                staff.getStaff_id(), staff.getStaff_name(), staff.getGender(), staff.getBirthday(), staff.getAddress(), staff.getPhone(), staff.getEmail(), staff.getPosition_id(), staff.getDepartment_id()
        );
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm mới thất bại");
            } else System.out.println("Thêm mới thành công");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static staff getById(String id) {
        final String sql = "SELECT * FROM `staff` WHERE  `staff_id` = " + "'" + id + "'" + "AND b.`status` = 1";
        staff staff = null;
//       System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                staff = new staff();
                staff.setStaff_id(rs.getString("staff_id"));
                staff.setStaff_name(rs.getString("staff_name"));
                staff.setGender(rs.getInt("gender"));
                staff.setBirthday(rs.getString("birthday"));
                staff.setAddress(rs.getString("address"));
                staff.setPhone(rs.getString("phone"));
                staff.setEmail(rs.getString("email"));
                staff.setPosition_id(rs.getString("position_id"));
                staff.setDepartment_id(rs.getString("department_id"));
                staff.setStatus(rs.getInt("status"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }
    public static void update(staff staff, String id) {
        staff tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Không tồn tại nhân viên này!");
        }

        final String sql = String.format("UPDATE `java_quanlynhansu`.`staff` SET `staff_name` = '%s', `gender` = '%d', `birthday` = '%s', `address` = '%s', `phone` = '%s', `email` = '%s' WHERE `staff_id` = '%s'",
                staff.getStaff_name(), staff.getGender(), staff.getBirthday(), staff.getAddress(), staff.getPhone(), staff.getEmail(), id
        );
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }System.out.println("Cập nhật thành công");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updatePosition(staff staff, String id) {
        staff tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Không tồn tại nhân viên này!");
        }

        final String sql = String.format("UPDATE `java_quanlynhansu`.`staff` SET `position_id` = '%s' WHERE `staff_id` = '%s'",
                staff.getPosition_id(), id
        );
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }System.out.println("Cập nhật thành công");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateDepart(staff staff, String id) {
        staff tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Không tồn tại nhân viên này!");
        }

        final String sql = String.format("UPDATE `java_quanlynhansu`.`staff` SET `department_id` = '%s', `status` = '%d' WHERE `staff_id` = '%s'",
                staff.getDepartment_id(), staff.getStatus(), id
        );
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }System.out.println("Cập nhật thành công");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete(String id) {
        staff tmp= getById(id);
        if (tmp == null) {
            throw new RuntimeException("Không tồn tại nhân viên này này!");
        }
        final String sql = "DELETE FROM `staff` WHERE  `staff_id` = " + "'" + id + "'";
        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }System.out.println("Xoá thành công");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<infoUser> getAllByAccount(String user, String password) {
        final String sql = "select b.`staff_id` as staff_id, b.`staff_name` as staff_name, b.`gender` as gender, b.`birthday` as birthday, b.`address` as address, b.`phone` as phone, b.`email` as email, c.`position_name` as position_name, c.`position_salary` as position_salary, e.`salary_bonus` as salary_bonus, d.`department_name` as department_name" +
                " from `staff` b" +
                " left join `account` a on a.`staff_id` = b.`staff_id`" +
                " left join `position` c on b.`position_id` = c.`position_id`" +
                " left join `department` d on b.`department_id` = d.`department_id`" +
                " left join `bonus` e on b.`staff_id` = e.`staff_id`" +
                " WHERE b.`status` = 1 AND b.`department_id` = " +
                " (select `department_id` from `staff` where `staff_id` =" +
                " (select `staff_id` from `account` WHERE `user`= '" + user + "' AND `password`='" + password + "'))" +
                " ORDER BY c.`position_salary` asc";
//           System.out.println(sql);
        List<infoUser> infoUserList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                infoUser info = new infoUser();
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
                infoUserList.add(info);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return infoUserList;
    }
}
