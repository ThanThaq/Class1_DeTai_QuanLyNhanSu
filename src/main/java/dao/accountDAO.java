package dao;
import java.sql.Connection;
import connection.MyConnection;
import model.account;
import model.infoUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class accountDAO {



    public static boolean login(String username, String password) {
        final  String sql = String.format("SELECT `user`, `password` FROM `account` WHERE `user`='%s' AND `password`='%s' LIMIT 1 ",
                username, password);
//        System.out.println(sql);
        try{
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static infoUser getInfo(String username, String password) {
        final  String sql = String.format("select a.`user` as user, a.`password` as password, a.`staff_id` as staff_id, a.`permission` as permission, b.`staff_name` as staff_name, b.`gender` as gender, b.`birthday` as birthday, b.`address` as address, b.`phone` as phone, b.`email` as email, c.`position_name` as position_name, c.`position_salary` as position_salary, d.`department_name` as department_name" +
                        " from `account` a" +
                        " left join `staff` b on a.`staff_id` = b.`staff_id`" +
                        " left join `position` c on b.`position_id` = c.`position_id`" +
                        " left join `department` d on b.`department_id` = d.`department_id`" +
                        " WHERE `user`='%s' AND `password`='%s' LIMIT 1 ",
                username, password);
//        System.out.println(sql);
        infoUser info = null;
        try{
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                info = new infoUser();
                info.setUser(rs.getString("user"));
                info.setPassword(rs.getString("password"));
                info.setStaff_id(rs.getString("staff_id"));
                info.setPermission(rs.getInt("permission"));
                info.setStaff_name(rs.getString("staff_name"));
                info.setGender(rs.getInt("gender"));
                info.setBirthday(rs.getString("birthday"));
                info.setAddress(rs.getString("address"));
                info.setPhone(rs.getString("phone"));
                info.setEmail(rs.getString("email"));
                info.setPosition_name(rs.getString("position_name"));
                info.setPosition_salary(rs.getInt("position_salary"));
                info.setDepartment_name(rs.getString("department_name"));
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }
    public static List<infoUser> search(String keyword) {
        final  String sql ="select a.`account_id` as account_id,a.`user` as user, a.`password` as password, a.`staff_id` as staff_id, a.`permission` as permission, b.`staff_name` as staff_name, b.`gender` as gender, b.`birthday` as birthday, b.`address` as address, b.`phone` as phone, b.`email` as email, c.`position_name` as position_name, c.`position_salary` as position_salary, d.`department_name` as department_name" +
                        " from `account` a" +
                        " left join `staff` b on a.`staff_id` = b.`staff_id`" +
                        " left join `position` c on b.`position_id` = c.`position_id`" +
                        " left join `department` d on b.`department_id` = d.`department_id`" +
                        " WHERE a.`user` like '%" + keyword +"%' OR a.`staff_id` like '%" + keyword + "%' OR b.`staff_name` like '%" + keyword +"%' AND b.`status` = 1";
//               System.out.println(sql);
        List<infoUser> infoUserList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                infoUser info = new infoUser();
                info.setAccount_id(rs.getString("account_id"));
                info.setUser(rs.getString("user"));
                info.setPassword(rs.getString("password"));
                info.setStaff_id(rs.getString("staff_id"));
                info.setPermission(rs.getInt("permission"));
                info.setStaff_name(rs.getString("staff_name"));
                info.setGender(rs.getInt("gender"));
                info.setBirthday(rs.getString("birthday"));
                info.setAddress(rs.getString("address"));
                info.setPhone(rs.getString("phone"));
                info.setEmail(rs.getString("email"));
                info.setPosition_name(rs.getString("position_name"));
                info.setPosition_salary(rs.getInt("position_salary"));
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
    public static void insert(account acc) {
        final String sql = String.format("INSERT INTO `java_quanlynhansu`.`account` (`user`, `password`, `staff_id`, `permission`) VALUES ('%s', '%s', '%s', '%d')",
                acc.getUser(), acc.getPassword(),acc.getStaff_id(),acc.getPermission()
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
    public static account getById(int id) {
        final String sql = "SELECT * FROM `account` WHERE  `account_id` = " +id;
        account acc = null;
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                acc = new account();
                acc.setAccount_id(rs.getInt("account_id"));
                acc.setUser(rs.getString("user"));
                acc.setPassword(rs.getString("password"));
                acc.setStaff_id(rs.getString("staff_id"));
                acc.setPermission(rs.getInt("permission"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }
    public static void update(account acc, int id) {
        account tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Không tồn tại tài khoản này!");
        }

        final String sql = String.format("UPDATE `java_quanlynhansu`.`account` SET `password` = '%s', `staff_id` = '%s', `permission` = '%d' WHERE (`account_id` = '%d')",
                acc.getPassword(),acc.getStaff_id(),acc.getPermission(), id
        );
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            } else System.out.println("Cập nhật thành công");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete(int id) {
        account acc = getById(id);
        if (acc == null) {
            throw new RuntimeException("Không tồn tại tài khoản này này!");
        }

        final String sql = "DELETE FROM `java_quanlynhansu`.`account` WHERE  `account_id` = " +id;
//        System.out.println(sql);
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
    public static List<infoUser> getAll() {
        final String sql = "select a.`account_id` as account_id,a.`user` as user, a.`password` as password, a.`staff_id` as staff_id, a.`permission` as permission, b.`staff_name` as staff_name, b.`gender` as gender, b.`birthday` as birthday, b.`address` as address, b.`phone` as phone, b.`email` as email, c.`position_name` as position_name, c.`position_salary` as position_salary, d.`department_name` as department_name" +
                " from `account` a" +
                " left join `staff` b on a.`staff_id` = b.`staff_id`" +
                " left join `position` c on b.`position_id` = c.`position_id`" +
                " left join `department` d on b.`department_id` = d.`department_id`" +
                " WHERE b.`status` = 1" +
                " ORDER BY account_id asc";
        System.out.println(sql);
        List<infoUser> infoUserList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                infoUser info = new infoUser();
                info.setAccount_id(rs.getString("account_id"));
                info.setUser(rs.getString("user"));
                info.setPassword(rs.getString("password"));
                info.setStaff_id(rs.getString("staff_id"));
                info.setPermission(rs.getInt("permission"));
                info.setStaff_name(rs.getString("staff_name"));
                info.setGender(rs.getInt("gender"));
                info.setBirthday(rs.getString("birthday"));
                info.setAddress(rs.getString("address"));
                info.setPhone(rs.getString("phone"));
                info.setEmail(rs.getString("email"));
                info.setPosition_name(rs.getString("position_name"));
                info.setPosition_salary(rs.getInt("position_salary"));
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
    public static void updateByUser(account acc, String user, String password) {
        final String sql = String.format("UPDATE `java_quanlynhansu`.`account` SET `password` = '%s' WHERE (`user` = '%s' and `password` = '%s')",
                acc.getPassword(), user, password
        );
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            } else System.out.println("Cập nhật thành công");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
