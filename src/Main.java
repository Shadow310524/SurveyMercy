import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------");
        System.out.println("User Registration page");
        System.out.println("------------------------");
        Scanner inp=new Scanner(System.in);
        UserRepository repo=new UserDirectory();
        UserService userService=new UserService(repo);
        boolean current=true;
        int val;
        String name;
        String password;
        String current_user="";
        while(true){
            while(current){
            System.out.println("1)Add User");
            System.out.println("2)Login");
            System.out.println("3)Logout");
            System.out.println("4)Exit");
            val=inp.nextInt();
            inp.nextLine();
            switch (val) {
                case 1:
                    System.out.println("Enter Username");
                    name=inp.nextLine();
                    System.out.println("Enter Password");
                    password=inp.nextLine();
                    userService.add(name,password);
                    break;
                case 2:
                    System.out.println("Enter Username");
                    name=inp.nextLine();
                    System.out.println("Enter Password");
                    password=inp.nextLine();
                    if(userService.check(name,password)) {
                        current_user=name;
                        current = false;
                    }
                    break;
                case 3:
                    System.out.println("Logging out!!");
                    current=true;
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bye byee");
                    break;
            }
        }
            }
    }
}