package Menu;

import dao.accountDAO;
import dao.staffDAO;
import model.account;
import model.infoUser;

import java.util.List;
import java.util.Scanner;

public class staffAccount {
    private static void menu0_2() {
        System.out.println("--- NHÂN VIÊN ---");
        System.out.println("1. Tìm kiếm");
        System.out.println("2. Thông tin nhân viên");
        System.out.println("3. Đổi mật khẩu");
        System.out.println("4. Phòng ban");
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
            if (option < 0 || option > 4) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    // Tìm kiếm
                    System.out.println("\tNhập từ khóa tìm kiếm(staff_id,staff_name,phone,email): ");
                    String keyword = in.nextLine();
                    staffDAO.search(keyword);
                    List<infoUser> infoUserList = staffDAO.search(keyword);
                    System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Phòng ban");
                    System.out.println();
                    for (int i = 0; i < infoUserList.size(); i++) {
                        infoUser info = infoUserList.get(i);
                        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(),info.getDepartment_name());
                    }
                    if (infoUserList.size() ==0){
                        System.out.println();
                        System.out.println("Không có dữ liệu hợp lệ!");
                        System.exit(0);
                    }
                   break;
                case 2:
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
                case 3:
                    // Đổi mật khẩu
                    infoUser account_user = accountDAO.getInfo(username,password);
                    System.out.println("\tTài khoản:" + account_user.getUser());
                    account acc = new account();
                    System.out.print("\tCập nhật mật khẩu: ");
                    acc.setPassword(in.nextLine());
                    accountDAO.updateByUser(acc,username,password);
                    //In ra
                    System.out.println("Thông tin tài khoản sau khi cập nhật:");
                    System.out.println("\tTài khoản:" + account_user.getUser() + "\t\tPassword:" + acc.getPassword());
                    break;
                case 4:
                    // Phòng ban
                    List<infoUser> DepartUserList = staffDAO.getAllByAccount(username,password);
                    infoUser infoList2 = accountDAO.getInfo(username,password);
                    infoUser info2 = infoList2;
                    System.out.println("Phòng ban: " + info2.getDepartment_name());
                    System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Phòng ban");
                    System.out.println();
                    for (int i = 0; i < DepartUserList.size(); i++) {
                        infoUser info1 = DepartUserList.get(i);
                        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s\n", info1.getStaff_id(), info1.getStaff_name(), info1.getGender(), info1.getBirthday(), info1.getAddress(), info1.getPhone(), info1.getEmail(), info1.getPosition_name(),info1.getDepartment_name());
                    }
                    break;
            }
        }
        while (option != 0);
        in.close();
    }
}