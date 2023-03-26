package dao;
import java.sql.Connection;
import connection.MyConnection;
import model.position;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class positionDAO {
    public static List<position> getAll() {
        final String sql = "SELECT * FROM `position`";

        List<position> positionList = new ArrayList<>();

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                position po = new position();
                po.setPosition_id(rs.getString("position_id"));
                po.setPosition_name(rs.getString("position_name"));
                po.setPosition_salary(rs.getInt("position_salary"));
                po.setPosition_describe(rs.getString("position_describe"));
                positionList.add(po);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return positionList;
    }
    public static List<position> getAllNotIn(String id) {
        final String sql = "SELECT * FROM java_quanlynhansu.position WHERE  `position_id` not in (select `position_id` from `java_quanlynhansu`.`staff` where  `position_id` = 'Manager' and `department_id` = (select `department_id` from `java_quanlynhansu`.`staff` where `staff_id` = " + "'" + id + "'))";
//        System.out.println(sql);
        List<position> positionList = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                position po = new position();
                po.setPosition_id(rs.getString("position_id"));
                po.setPosition_name(rs.getString("position_name"));
                po.setPosition_salary(rs.getInt("position_salary"));
                po.setPosition_describe(rs.getString("position_describe"));
                positionList.add(po);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return positionList;
    }
}
