import Controller.BookManager;
import Exception.AppException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AppException {
        Scanner scn = new Scanner(System.in);
        int choose;
        int flag = 1;
        BookManager controller = BookManager.getInstance();
        // show main menu
        showMenu();
        do {
            choose = scn.nextInt();
            switch (choose) {
                case 1:
                    controller.addToDb();
                    break;
                case 2:
                    System.out.println("2123");
                    break;
                case 3:
                    System.out.println("exited");
                    flag = 2;
                    break;
                default:
                    System.out.println("default");
                    break;
            }
            if(flag == 2){
                break;
            }
            showMenu();
        }while (flag == 1);

    }
    /**
     * create menu
     */
    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Add Book.");
        System.out.println("2. Edit Book by id.");
        System.out.println("3. Delete Book by id.");
        System.out.println("6. Show all book.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

}
