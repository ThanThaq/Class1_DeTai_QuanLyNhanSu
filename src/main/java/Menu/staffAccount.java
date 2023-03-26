package Menu;

import dao.accountDAO;
import model.infoUser;

import java.util.Scanner;

public class staffAccount {
    private static void menu0_2() {
        System.out.println("--- NHÂN VIÊN ---");
        System.out.println("1. Thông tin nhân viên");
        System.out.println();
        System.out.println("0. Đăng xuất");
    }

    public static void main(String username, String password) {
        Scanner in = new Scanner(System.in);

        int option = -1;

        do {
            menu0_2();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(in.nextLine());
            // try-catch khi người dùng nhập lỗi
            if (option < 0 || option > 1) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    // Thông tin nhân viên
                    infoUser infoList = accountDAO.getInfo(username,password);
                    infoUser info = infoList;
                    if(info.getStaff_id() == null){
                        System.out.println("\tTên tài khoản: " + info.getUser());
                        System.out.println("\t \tTài khoản bạn chưa liên kết với thông tin nhân viên " +
                                "Vui lòng liên hệ với HR để điều chỉnh");
                        break;
                    }else
                        System.out.printf("%-20s %-20s %-20s %-20s %-20s", "Tên tài khoản", "Mã nhân viên", "Họ tên", "Giới tính", "Ngày sinh");
                    System.out.println();
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", info.getUser(), info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday());
                    System.out.println();
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "Địa chỉ", "Số điện thoại", "Email", "Vị trí", "Lương", "Phòng ban");
                    System.out.println();
                    System.out.printf("%-20s %-20s %-20s %-20s %-20d %-20s\n", info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), info.getPosition_salary(), info.getDepartment_name());
                    break;
            }
        }
        while (option != 0);
        in.close();
    }
}