import java.util.Scanner;
import Menu.adminAccount;
import Menu.staffAccount;
import dao.accountDAO;
import model.account;
import model.infoUser;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        accountDAO accDAO = new accountDAO();
        String username = "", password = "";
        System.out.println("ĐĂNG NHẬP");
        int count = 0;
        boolean login = false;
        while (count != 5){
            count = count + 1;
            System.out.println("Nhập Username: ");
            username = in.nextLine();
            System.out.println("Nhập Password: ");
            password = in.nextLine();
            if(accountDAO.login(username,password)){
                login = true;
                break;
            }
            if(count == 5){
            }else {
                System.out.println("Tài khoản hoặc mật khẩu khẩu không chính xác!");
                System.out.printf("Bạn còn %d lần nhập!\n",(5-count));
            }
        }
        if (!login){
            System.out.println("Đăng nhập thất bại");
            System.exit(0);
        }
        else {
            infoUser infoList = accountDAO.getInfo(username,password);
            infoUser info = infoList;
            if(info.getStaff_id() == null){
                System.out.println("\tChào mừng nhân viên "+ info.getUser() + " trở lại!");
            } else {
                System.out.println("\tChào mừng nhân viên " + info.getStaff_name() + " trở lại!");
            }
            if(info.getPermission() == 0){
                staffAccount.main(username,password);
            }else{
                adminAccount.main(username, password);
            }
        }
    }
}
