package Menu;

import dao.accountDAO;
import model.account;
import model.infoUser;
import dao.staffDAO;
import model.staff;
import dao.departmentDAO;
import model.department;
import dao.positionDAO;
import model.position;
import dao.bonusDAO;
import model.bonus;

import java.util.List;
import java.util.Scanner;

public class adminAccount {
    // Menu Login có quyền
    private static void menu0() {
        System.out.println("\t--- QUẢN LÝ ADMIN ---");
        System.out.println("\t\t1. Thông tin nhân viên");
        System.out.println("\t\t2. Quản lý tài khoản");
        System.out.println("\t\t3. Quản lý nhân sự");
        System.out.println();
        System.out.println("\t0. Đăng xuất");
    }
    // (Option 2)Quản lý tài khoản - Menu Login có quyền
    private static void submenu0() {
        System.out.println("\t--- QUẢN LÝ TÀI KHOẢN ---");
        System.out.println("\t\t1. Thêm mới tài khoản");
        System.out.println("\t\t2. Cập nhật thông tin tài khoản");
        System.out.println("\t\t3. Xóa tài khoản");
        System.out.println();
        System.out.println("\t0. Quay lại");
    }
    // (Option 3)Quản lý nhân sự - Menu Login có quyền
    private static void mainMenu() {
        System.out.println("\t--- QUẢN LÝ NHÂN SỰ ---");
        System.out.println("\t\t1. Tìm kiếm");
        System.out.println("\t\t2. Quản lý thông tin nhân viên");
        System.out.println("\t\t3. Quản lý phòng ban");
        System.out.println("\t\t4. Thuế");
        System.out.println();
        System.out.println("\t0. Thoát");
    }
    // (Option 3-2) Quản lý thông tin nhân viên - Quản lý nhân sự
    private static void menu2() {
        System.out.println("\t--- QUẢN LÝ THÔNG TIN NHÂN VIÊN ---");
        System.out.println("\t\t1. Danh sách nhân viên");
        System.out.println("\t\t2. Thêm nhân viên");
        System.out.println("\t\t3. Sửa thông tin nhân viên");
        System.out.println("\t\t4. Chuyển phòng ban, trạng thái nhân viên");
        System.out.println("\t\t5. Thay đổi chức danh");
        System.out.println("\t\t6. Thưởng");
        System.out.println("\t\t7. Xóa nhân viên");
        System.out.println();
        System.out.println("\t0. Quay lại");
    }

    //(Option 3-3) Quản lý phòng ban - Quản lý nhân sự
    private static void menu3() {
        System.out.println("\t--- QUẢN LÝ PHÒNG BAN ---");
        System.out.println("\t\t1. Thêm phòng ban");
        System.out.println("\t\t2. Sửa thông tin phòng ban");
        System.out.println("\t\t3. Xóa phòng ban");
        System.out.println();
        System.out.println("\t0. Quay lại");
    }

    //Thêm mới tài khoản - Quản lý tài khoản - Menu Login có quyền
    private static void submenu0_1(Scanner in){
        account acc = new account();
        System.out.print("\tNhập tài khoản: ");
        acc.setUser(in.nextLine());
        System.out.print("\tNhập Password: ");
        acc.setPassword(in.nextLine());
        System.out.print("\tNhập mã nhân viên: ");
        acc.setStaff_id(in.nextLine());
        System.out.print("\tNhập quyền hạn: ");
        acc.setPermission(Integer.parseInt(in.nextLine()));

        accountDAO.insert(acc);
    System.out.println("\tTài khoàn:" + acc.getUser() + "\t\tPassword:" + acc.getPassword() + "\t\tMã nhân viên:" + acc.getStaff_id() + "\t\tQuyền hạn:" + acc.getPermission());
    }

    // Cập nhật thông tin tài khoản - Quản lý tài khoản - Menu Login có quyền
    public static void submenu0_2(Scanner in){
        System.out.print("\tNhập từ khóa tìm kiếm(user,staff_id,staff_name): ");
        String keyword = in.nextLine();
        accountDAO.search(keyword);
        List<infoUser> infoUserList = accountDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "Mã tài khoản", "Tài khoản", "Mật Khẩu","Mã nhân viên", "Tên nhân viên", "Quyền hạn");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20d\n", info.getAccount_id(), info.getUser(), info.getPassword(), info.getStaff_id(), info.getStaff_name(), info.getPermission());
        };
        if (infoUserList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }else
        System.out.print("\tNhập Mã tài khoản muốn cập nhật: ");
        int id = Integer.parseInt(in.nextLine());
        account account_user = accountDAO.getById(id);
        System.out.println("\tTài khoản:" + account_user.getUser());
        account acc = new account();
        System.out.print("\tCập nhật mật khẩu: ");
        acc.setPassword(in.nextLine());
        System.out.print("\tCập nhật mã nhân viên: ");
        acc.setStaff_id(in.nextLine());
        System.out.print("\tCập nhật quyền hạn: ");
        acc.setPermission(Integer.parseInt(in.nextLine()));
        accountDAO.update(acc,id);
        //In ra
        System.out.println("Thông tin tài khoản sau khi cập nhật:");
        System.out.println("\tTài khoản:" + account_user.getUser() + "\t\tPassword:" + acc.getPassword() + "\t\tMã nhân viên:" + acc.getStaff_id() + "\t\tQuyền hạn:" + acc.getPermission());
    }

    // Xóa tài khoản - Quản lý tài khoản - Menu Login có quyền
    private static void submenu0_3(Scanner in){
        System.out.print("\tNhập từ khóa tìm kiếm(user,staff_id,staff_name): ");
        String keyword = in.nextLine();
        accountDAO.search(keyword);
        List<infoUser> infoUserList = accountDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "Mã tài khoản", "Tài khoản", "Mật Khẩu","Mã nhân viên", "Tên nhân viên", "Quyền hạn");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20d\n", info.getAccount_id(), info.getUser(), info.getPassword(), info.getStaff_id(), info.getStaff_name(), info.getPermission());
        };
        if (infoUserList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }else
        System.out.println("Nhập Mã tài khoản muốn xóa: ");
        int id = Integer.parseInt(in.nextLine());
        accountDAO.delete(id);
        List<infoUser> infoUserList1 = accountDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "Mã tài khoản", "Tài khoản", "Mật Khẩu","Mã nhân viên", "Tên nhân viên", "Quyền hạn");
        System.out.println();
        for (int i = 0; i < infoUserList1.size(); i++) {
            infoUser info = infoUserList1.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20d\n", info.getAccount_id(), info.getUser(), info.getPassword(), info.getStaff_id(), info.getStaff_name(), info.getPermission());
        };
    }

    // Tìm kiếm - Quản lý nhân sự - Menu Login có quyền
    private static void mainMenu_1(Scanner in){
        System.out.println("\tNhập từ khóa tìm kiếm(staff_id,staff_name,phone,email): ");
        String keyword = in.nextLine();
        staffDAO.search(keyword);
        List<infoUser> infoUserList = staffDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Lương", "Phòng ban");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            int totalSalary =0;
            if(info.getSalary_bonus() ==0){
                totalSalary = info.getPosition_salary();
            }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
            System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20d %-20s\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), totalSalary,info.getDepartment_name());
        };
        if (infoUserList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }
    }

    // Danh sách nhân viên - Quản lý thông tin nhân viên - Quản lý nhân sự
    private static void menu2_1(){
        List<infoUser> infoUserList = staffDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            int totalSalary =0;
            if(info.getSalary_bonus() ==0){
                totalSalary = info.getPosition_salary();
            }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
            System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20d %-20s %-20d\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), totalSalary,info.getDepartment_name(), info.getSalary_bonus());
        };
    }

    // Thêm mới nhân viên - Quản lý thông tin nhân viên - Quản lý nhân sự
    private static void menu2_2(Scanner in){
        staff staff = new staff();
        System.out.print("\tNhập mã nhân viên: ");
        staff.setStaff_id(in.nextLine());
        System.out.print("\tNhập tên nhân viên: ");
        staff.setStaff_name(in.nextLine());
        System.out.print("\tNhập giới tính: ");
        System.out.println("\n\t\t0-Nữ");
        System.out.println("\t\t1-Nam");
        staff.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập ngày sinh(dd/mm/yy): ");
        staff.setBirthday(in.nextLine());
        System.out.print("\tNhập địa chỉ: ");
        staff.setAddress(in.nextLine());
        System.out.print("\tNhập số điện thoại: ");
        staff.setPhone(in.nextLine());
        System.out.print("\tNhập email: ");
        staff.setEmail(in.nextLine());
        System.out.print("\tChức danh: \n");
        List<position> positionList = positionDAO.getAll();
        System.out.printf("%-20s %-20s %-30s", "Mã chức danh", "Tên chức danh", "Mức lương");
        System.out.println();
        for (int i = 0; i < positionList.size(); i++) {
            System.out.printf("%-20s %-20s %-30d\n", positionList.get(i).getPosition_id(), positionList.get(i).getPosition_name(), positionList.get(i).getPosition_salary());
        }
        // Tam thoi nhap chinh xac
        System.out.print("\tNhập mã chức danh: ");
        staff.setPosition_id(in.nextLine());
        System.out.print("\tPhòng ban: \n");
        List<department> departmentList = departmentDAO.getAll();
        System.out.printf("%-20s %-20s", "Mã phòng ban", "Tên phòng ban");
        System.out.println();
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.printf("%-20s %-20s \n", departmentList.get(i).getDepartment_id(), departmentList.get(i).getDepartment_name());
        }
        // Tam thoi nhap chinh xac
        System.out.print("\tNhập mã phòng ban: ");
        staff.setDepartment_id(in.nextLine());
        System.out.print("\tNhập trạng thái đi làm: ");
        System.out.println("\n\t\t0-Đã nghỉ");
        System.out.println("\t\t1-Đang đi làm");
        staff.setStatus(Integer.parseInt(in.nextLine()));

        staffDAO.insert(staff);
        System.out.println("Thông tin nhân viên vừa thêm:");
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Phòng ban");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s\n", staff.getStaff_id(), staff.getStaff_name(), staff.getGender(), staff.getBirthday(), staff.getAddress(), staff.getPhone(), staff.getEmail(), staff.getPosition_id(),staff.getDepartment_id());
    }

    // Cập nhật thông tin nhân viên - Quản lý thông tin nhân viên - Quản lý nhân sự
    public static void menu2_3(Scanner in){
        System.out.println("\tNhập từ khóa tìm kiếm(staff_id,staff_name,phone,email): ");
        String keyword = in.nextLine();
        staffDAO.search(keyword);
        List<infoUser> infoUserList = staffDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            int totalSalary =0;
            if(info.getSalary_bonus() ==0){
                totalSalary = info.getPosition_salary();
            }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
            System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20d %-20s %-20d\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), totalSalary,info.getDepartment_name(), info.getSalary_bonus());
        }
        if (infoUserList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }else
            System.out.print("\tNhập Mã nhân viên muốn cập nhật: ");
        String id = in.nextLine();
        staff s = staffDAO.getById(id);
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s\n", s.getStaff_id(), s.getStaff_name(), s.getGender(), s.getBirthday(), s.getAddress(), s.getPhone(), s.getEmail());

        staff staff = new staff();
        System.out.print("\tCập nhật tên nhân viên: ");
        staff.setStaff_name(in.nextLine());
        System.out.print("\tCập nhật giới tính: ");
        System.out.println("\n\t\t0-Nữ");
        System.out.println("\t\t1-Nam");
        staff.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("\tCập nhật ngày sinh(dd/mm/yy): ");
        staff.setBirthday(in.nextLine());
        System.out.print("\tCập nhật địa chỉ: ");
        staff.setAddress(in.nextLine());
        System.out.print("\tCập nhật số điện thoại: ");
        staff.setPhone(in.nextLine());
        System.out.print("\tCập nhật email: ");
        staff.setEmail(in.nextLine());
        staffDAO.update(staff,id);
        //In ra
        System.out.println("Thông tin nhân viên vừa cập nhật:");
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s\n", staff.getStaff_id(), staff.getStaff_name(), staff.getGender(), staff.getBirthday(), staff.getAddress(), staff.getPhone(), staff.getEmail());
    }

    // Chuyển phòng ban, trạng thái nhân viên - Quản lý thông tin nhân viên - Quản lý nhân sự
    public static void menu2_4(Scanner in){
        System.out.println("\tNhập từ khóa tìm kiếm(staff_id,staff_name,phone,email): ");
        String keyword = in.nextLine();
        staffDAO.search(keyword);
        List<infoUser> infoUserList = staffDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            int totalSalary =0;
            if(info.getSalary_bonus() ==0){
                totalSalary = info.getPosition_salary();
            }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
            System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20d %-20s %-20d\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), totalSalary,info.getDepartment_name(), info.getSalary_bonus());
        }
        if (infoUserList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }else
            System.out.print("\tNhập Mã nhân viên muốn cập nhật: ");
        String id = in.nextLine();
        staff s = staffDAO.getById(id);
        System.out.printf("%-20s %-20s %-20s %-30s", "Mã nhân viên", "Tên nhân viên", "Phòng ban", "Trạng thái làm việc");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-30s\n", s.getStaff_id(), s.getStaff_name(), s.getDepartment_id(), s.getStatus());

        staff staff = new staff();
        System.out.print("\tPhòng ban: \n");
        List<department> departmentList = departmentDAO.getAllNotIn(id);
        System.out.printf("%-20s %-20s", "Mã phòng ban", "Tên phòng ban");
        System.out.println();
        for (int i = 0; i < departmentList.size(); i++) {
            System.out.printf("%-20s %-20s \n", departmentList.get(i).getDepartment_id(), departmentList.get(i).getDepartment_name());
        }
        // Tam thoi nhap chinh xac
        System.out.print("\tCập nhật mã phòng ban: ");
        staff.setDepartment_id(in.nextLine());
        System.out.print("\tCập nhật trạng thái đi làm: ");
        System.out.println("\n\t\t0-Đã nghỉ");
        System.out.println("\t\t1-Đang đi làm");
        staff.setStatus(Integer.parseInt(in.nextLine()));
        staffDAO.updateDepart(staff,id);
        //In ra
        System.out.println("Thông tin nhân viên vừa cập nhật:");
        System.out.printf("%-20s %-20s %-20s %-30s", "Mã nhân viên", "Tên nhân viên", "Phòng ban", "Trạng thái làm việc");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-30s\n", staff.getStaff_id(), staff.getStaff_name(), staff.getDepartment_id(), staff.getStatus());
    }

    //Thay đổi chức danh - Quản lý thông tin nhân viên - Quản lý nhân sự
    public static void menu2_5(Scanner in){
        System.out.println("\tNhập từ khóa tìm kiếm(staff_id,staff_name,phone,email): ");
        String keyword = in.nextLine();
        staffDAO.search(keyword);
        List<infoUser> infoUserList = staffDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            int totalSalary =0;
            if(info.getSalary_bonus() ==0){
                totalSalary = info.getPosition_salary();
            }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
            System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20d %-20s %-20d\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), totalSalary,info.getDepartment_name(), info.getSalary_bonus());
        }
        if (infoUserList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }else
            System.out.print("\tNhập Mã nhân viên muốn cập nhật: ");
        String id = in.nextLine();
        staff s = staffDAO.getById(id);
        System.out.printf("%-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Chức danh");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s\n", s.getStaff_id(), s.getStaff_name(), s.getPosition_id());

        staff staff = new staff();
        System.out.print("\tChức danh: \n");
        List<position> positionList = positionDAO.getAllNotIn(id);
        System.out.printf("%-20s %-20s %-30s", "Mã chức danh", "Tên chức danh", "Mức lương");
        System.out.println();
        for (int i = 0; i < positionList.size(); i++) {
            System.out.printf("%-20s %-20s %-30d\n", positionList.get(i).getPosition_id(), positionList.get(i).getPosition_name(), positionList.get(i).getPosition_salary());
        }
        // Tam thoi nhap chinh xac
        System.out.print("\tNhập mã chức danh: ");
        staff.setPosition_id(in.nextLine());
        staffDAO.updatePosition(staff,id);
        //In ra
        System.out.println("Thông tin nhân viên vừa cập nhật:");
        System.out.printf("%-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Chức danh");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s\n", s.getStaff_id(), s.getStaff_name(), s.getPosition_id());
    }

    //Thưởng - Quản lý thông tin nhân viên - Quản lý nhân sự
    public static void menu2_6(Scanner in){
        System.out.println("\tNhập từ khóa tìm kiếm(staff_id,staff_name,phone,email): ");
        String keyword = in.nextLine();
        staffDAO.search(keyword);
        List<infoUser> infoUserList = staffDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            int totalSalary =0;
            if(info.getSalary_bonus() ==0){
                totalSalary = info.getPosition_salary();
            }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
            System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20d %-20s %-20d\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), totalSalary,info.getDepartment_name(), info.getSalary_bonus());
        }
        if (infoUserList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }else
            System.out.print("\tNhập Mã nhân viên muốn cập nhật: ");
        String id = in.nextLine();
        infoUser info = bonusDAO.getAllById(id);
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        int totalSalary =0;
        if(info.getSalary_bonus() ==0){
            totalSalary = info.getPosition_salary();
        }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
        System.out.printf("%-20s %-20s %-20s %-20d %-20s %-20d\n", info.getStaff_id(), info.getStaff_name(), info.getPosition_name(), totalSalary, info.getDepartment_name(), info.getSalary_bonus());

        bonus bonus = new bonus();
        bonus.setStaff_id(id);
        System.out.print("\tNhập số tiền thưởng: ");
        bonus.setSalary_bonus(Integer.parseInt(in.nextLine()));
        System.out.print("\tNhập ghi chú: ");
        bonus.setBonus_describe(in.nextLine());

        bonusDAO.insert(bonus);
        //In ra
        infoUser info1 = bonusDAO.getAllById(id);
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        int totalSalary1 =0;
        if(info1.getSalary_bonus() == 0){
            totalSalary1 = info1.getPosition_salary();
        }else totalSalary1 = (info1.getPosition_salary() + info1.getSalary_bonus());
        System.out.printf("%-20s %-20s %-20s %-20d %-20s %-20d\n", info1.getStaff_id(), info1.getStaff_name(), info1.getPosition_name(), totalSalary1, info1.getDepartment_name(), info1.getSalary_bonus());
    }

    // Xóa nhân viên - Quản lý thông tin nhân viên - Quản lý nhân sự
    private static void menu2_7(Scanner in){
        System.out.println("\tNhập từ khóa tìm kiếm(staff_id,staff_name,phone,email): ");
        String keyword = in.nextLine();
        staffDAO.search(keyword);
        List<infoUser> infoUserList = staffDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            int totalSalary =0;
            if(info.getSalary_bonus() ==0){
                totalSalary = info.getPosition_salary();
            }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
            System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20d %-20s %-20d\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), totalSalary,info.getDepartment_name(), info.getSalary_bonus());
        }
        if (infoUserList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }else
            System.out.println("Nhập Mã nhân viên muốn xóa: ");
        String id = in.nextLine();
        staffDAO.delete(id);
        List<infoUser> infoUserList1 = staffDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        for (int i = 0; i < infoUserList1.size(); i++) {
            infoUser info = infoUserList1.get(i);
            int totalSalary =0;
            if(info.getSalary_bonus() ==0){
                totalSalary = info.getPosition_salary();
            }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
            System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20d %-20s %-20d\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), totalSalary,info.getDepartment_name(), info.getSalary_bonus());
        }
    }

    // Thêm mới phòng ban - Quản lý phòng ban - Quản lý nhân sự
    private static void menu3_1(Scanner in){
        department depart = new department();
        System.out.print("\tNhập mã phòng ban: ");
        depart.setDepartment_id(in.nextLine());
        System.out.print("\tNhập tên phòng ban: ");
        depart.setDepartment_name(in.nextLine());
        System.out.print("\tNhập số điện thoại bàn: ");
        depart.setDepartment_phone(in.nextLine());
        System.out.print("\tNhập địa chỉ phòng ban: ");
        depart.setDepartment_adress(in.nextLine());

        departmentDAO.insert(depart);
        System.out.println("Thông tin phòng ban vừa thêm:");
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã phòng ban", "Tên phòng ban", "Số điện thoại", "Địa chỉ");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-20s\n", depart.getDepartment_id(), depart.getDepartment_name(), depart.getDepartment_phone(), depart.getDepartment_adress());
    }

    // Chỉnh sửa phòng ban - Quản lý phòng ban - Quản lý nhân sự
    private static void menu3_2(Scanner in){
        System.out.println("\tNhập từ khóa tìm kiếm: ");
        String keyword = in.nextLine();
        departmentDAO.search(keyword);
        List<department> departmentList = departmentDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã phòng ban", "Tên phòng ban", "Số điện thoại", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < departmentList.size(); i++) {
            department depart = departmentList.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s\n", depart.getDepartment_id(), depart.getDepartment_name(), depart.getDepartment_phone(), depart.getDepartment_adress());
        }
        if (departmentList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }else
            System.out.print("\tNhập Mã phòng ban muốn cập nhật: ");
        String id = in.nextLine();
        department depart = departmentDAO.getById(id);
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã phòng ban", "Tên phòng ban", "Số điện thoại", "Địa chỉ");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-20s\n", depart.getDepartment_id(), depart.getDepartment_name(), depart.getDepartment_phone(), depart.getDepartment_adress());

        department depart1 = new department();
        System.out.print("\tCập nhật tên phòng ban: ");
        depart1.setDepartment_name(in.nextLine());
        System.out.print("\tCập nhật số điện thoại phòng ban: ");
        depart1.setDepartment_phone(in.nextLine());
        System.out.print("\tCập nhật địa chỉ phòng ban: ");
        depart1.setDepartment_adress(in.nextLine());
        departmentDAO.update(depart1,id);
        //In ra
        System.out.println("Thông tin phòng ban vừa cập nhật:");
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã phòng ban", "Tên phòng ban", "Số điện thoại", "Địa chỉ");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-20s\n", depart1.getDepartment_id(), depart1.getDepartment_name(), depart1.getDepartment_phone(), depart1.getDepartment_adress());
    }

    // Xóa phòng ban - Quản lý phòng ban - Quản lý nhân sự
    private static void menu3_3(Scanner in){
        System.out.println("\tNhập từ khóa tìm kiếm: ");
        String keyword = in.nextLine();
        departmentDAO.search(keyword);
        List<department> departmentList = departmentDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã phòng ban", "Tên phòng ban", "Số điện thoại", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < departmentList.size(); i++) {
            department depart = departmentList.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s\n", depart.getDepartment_id(), depart.getDepartment_name(), depart.getDepartment_phone(), depart.getDepartment_adress());
        }
        if (departmentList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }else
            System.out.print("\tNhập Mã phòng ban muốn xóa: ");
        String id = in.nextLine();
        departmentDAO.delete(id);
        List<department> departmentList1 = departmentDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã phòng ban", "Tên phòng ban", "Số điện thoại", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < departmentList1.size(); i++) {
            department depart = departmentList1.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s\n", depart.getDepartment_id(), depart.getDepartment_name(), depart.getDepartment_phone(), depart.getDepartment_adress());
        }
    }

    // Tính thuế - Quản lý nhân sự (chưa làm)
    private static void menu0_4(Scanner in){
        System.out.println("\tNhập từ khóa tìm kiếm(staff_id,staff_name,phone,email): ");
        String keyword = in.nextLine();
        staffDAO.search(keyword);
        List<infoUser> infoUserList = staffDAO.search(keyword);
        System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20s %-20s %-20s", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày Sinh", "Địa chỉ", "Số điện thoại", "Email", "Chức danh", "Lương", "Phòng ban", "Thưởng");
        System.out.println();
        for (int i = 0; i < infoUserList.size(); i++) {
            infoUser info = infoUserList.get(i);
            int totalSalary =0;
            if(info.getSalary_bonus() ==0){
                totalSalary = info.getPosition_salary();
            }else totalSalary = (info.getPosition_salary() + info.getSalary_bonus());
            System.out.printf("%-20s %-20s %-20s %-20s %-10s %-20s %-20s %-20s %-20d %-20s %-20d\n", info.getStaff_id(), info.getStaff_name(), info.getGender(), info.getBirthday(), info.getAddress(), info.getPhone(), info.getEmail(), info.getPosition_name(), totalSalary,info.getDepartment_name(), info.getSalary_bonus());
        }
        if (infoUserList.size() ==0){
            System.out.println();
            System.out.println("Không có dữ liệu hợp lệ!");
            System.exit(0);
        }
    }

    public static void main(String username, String password) {
        Scanner in = new Scanner(System.in);

        int option = -1;

        do {
            menu0();
            System.out.print("Nhập lựa chọn: ");
            option = Integer.parseInt(in.nextLine());
            // try-catch khi người dùng nhập lỗi
            if (option < 0 || option > 3) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
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
                case 2:
                    // Quản lý tài khoản
                    int option2 = -1;
                    do {
                        submenu0();
                        System.out.print("Nhập lựa chọn: ");
                        option2 = Integer.parseInt(in.nextLine());
                        // try-catch khi người dùng nhập lỗi
                        if (option2 < 0 || option2 > 3) {
                            System.out.println("Vui lòng nhập lại!");
                            continue;
                        }
                        switch (option2) {
                            case 1:
                                // Thêm mới tài khoản
                                submenu0_1(in);
                                break;
                            case 2:
                                // Cập nhật thông tin tài khoản
                                submenu0_2(in);
                                break;
                            case 3:
                                // Xóa tài khoản
                                submenu0_3(in);
                                break;
                        }
                    } while (option2 != 0);
                    break;
                case 3:
                    // Quản lý nhân sự
                    int option3 = -1;
                    do {
                        mainMenu();
                        System.out.print("Nhập lựa chọn: ");
                        option3 = Integer.parseInt(in.nextLine());
                        // try-catch khi người dùng nhập lỗi
                        if (option3 < 0 || option3 > 4) {
                            System.out.println("Vui lòng nhập lại!");
                            continue;
                        }
                        switch (option3) {
                            case 1:
                                // Tìm kiếm
                                mainMenu_1(in);
                                break;
                            case 2:
                                // Quản lý thông tin nhân viên
                                int option3_2 = -1;
                                do {
                                    menu2();
                                    System.out.print("Nhập lựa chọn: ");
                                    option3_2 = Integer.parseInt(in.nextLine());
                                    // try-catch khi người dùng nhập lỗi
                                    if (option3_2 < 0 || option3_2 > 7) {
                                        System.out.println("Vui lòng nhập lại!");
                                        continue;
                                    }
                                    switch (option3_2) {
                                        case 1:
                                            // Danh sách nhân viên
                                            menu2_1();
                                            break;
                                        case 2:
                                            // Thêm nhân viên
                                            menu2_2(in);
                                            break;
                                        case 3:
                                            // Sửa trạng thái nhân viên
                                            menu2_3(in);
                                            break;
                                        case 4:
                                            // Chuyển phòng ban, trạng thái nhân viên
                                            menu2_4(in);
                                            break;
                                        case 5:
                                            // Thay đổi chức danh
                                            menu2_5(in);
                                            break;
                                        case 6:
                                            // Tăng Lương
                                            menu2_6(in);
                                            break;
                                        case 7:
                                            // Xóa nhân viên
                                            menu2_7(in);
                                            break;
                                    }
                                } while (option3_2 != 0);
                                break;
                            case 3:
                                // Quản lý thông tin phòng ban
                                int option3_3 = -1;
                                do {
                                    menu3();
                                    System.out.print("Nhập lựa chọn: ");
                                    option3_3 = Integer.parseInt(in.nextLine());
                                    // try-catch khi người dùng nhập lỗi
                                    if (option3_3 < 0 || option3_3 > 3) {
                                        System.out.println("Vui lòng nhập lại!");
                                        continue;
                                    }
                                    switch (option3_3) {
                                        case 1:
                                            // Thêm phòng ban
                                            menu3_1(in);
                                            break;
                                        case 2:
                                            // Sửa thông tin phòng ban
                                            menu3_2(in);
                                            break;
                                        case 3:
                                            // Xóa phòng ban
                                            menu3_3(in);
                                            break;
                                    }
                                } while (option3_3 != 0);
                                break;
                        }
                    } while (option3 != 0);
                    break;
                case 4:
                    // Thuế
                    menu0_4(in);
                    break;
            }

        } while (option != 0);
        in.close();

    }
}
