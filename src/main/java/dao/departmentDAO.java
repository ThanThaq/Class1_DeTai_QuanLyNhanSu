package dao;
import java.sql.Connection;
import connection.MyConnection;
import model.department;
import model.position;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class departmentDAO {
    public static List<department> search(String keyword) {
        final String sql = "SELECT * FROM `department` " +
                " WHERE `department_id` like '%" + keyword + "%' OR `department_name` like '%" + keyword +"%' OR `department_phone` like '%" + keyword +"%'";

        List<department> departmentList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                department depart = new department();
                depart.setDepartment_id(rs.getString("department_id"));
                depart.setDepartment_name(rs.getString("department_name"));
                depart.setDepartment_phone(rs.getString("department_phone"));
                depart.setDepartment_adress(rs.getString("department_address"));
                departmentList.add(depart);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return departmentList;
    }
    public static List<department> getAll() {
        final String sql = "SELECT * FROM `department`";

        List<department> departmentList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                department depart = new department();
                depart.setDepartment_id(rs.getString("department_id"));
                depart.setDepartment_name(rs.getString("department_name"));
                depart.setDepartment_phone(rs.getString("department_phone"));
                depart.setDepartment_adress(rs.getString("department_address"));
                departmentList.add(depart);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return departmentList;
    }
    public static void insert(department depart) {
        final String sql = String.format("INSERT  INTO `department` VALUES ('%s','%s','%s','%s') ",
                depart.getDepartment_id(),depart.getDepartment_name(),depart.getDepartment_phone(),depart.getDepartment_adress()
        );
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }System.out.println("Thêm thành công");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static department getById(String id) {
        final String sql = "SELECT * FROM `department` WHERE  `department_id` = " + "'" + id + "'";
        department depart = null;
//        System.out.println(sql);
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                depart = new department();
                depart.setDepartment_id(rs.getString("department_id"));
                depart.setDepartment_name(rs.getString("department_name"));
                depart.setDepartment_phone(rs.getString("department_phone"));
                depart.setDepartment_adress(rs.getString("department_address"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return depart;
    }
    public static void update(department depart, String id) {
        department tmp = getById(id);
        if (tmp == null) {
            throw new RuntimeException("Không tồn tại phòng ban này!");
        }

        final String sql = String.format("UPDATE `java_quanlynhansu`.`department` SET `department_name` = '%s', `department_phone` = '%s', `department_address` = '%s' WHERE `department_id` = '%s'",
                depart.getDepartment_name(),depart.getDepartment_phone(),depart.getDepartment_adress(), id
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
        department depart = getById(id);
        if (depart == null) {
            throw new RuntimeException("Không tồn tại phòng ban này!");
        }

        final String sql = "DELETE FROM `department` WHERE  `department_id` = " + "'" + id + "'";
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
    public static List<department> getAllNotIn(String id) {
        final String sql = "SELECT * FROM java_quanlynhansu.department where department_id not in (select department_id from staff where position_id = 'Manager')  and department_id not in(select department_id from staff where staff_id = " + "'" + id + "')";
//        System.out.println(sql);
        List<department> departmentList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                department depart = new department();
                depart.setDepartment_id(rs.getString("department_id"));
                depart.setDepartment_name(rs.getString("department_name"));
                depart.setDepartment_phone(rs.getString("department_phone"));
                depart.setDepartment_adress(rs.getString("department_address"));
                departmentList.add(depart);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departmentList;
    }
}
