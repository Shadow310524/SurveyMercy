public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(String name, String password) {
        Users user=new Users(name,password);
        if(userRepository.addUser(user)){
            System.out.println(name+" added successfully");
        }
        else{
            System.out.println("Username already found");
        }
    }

    public boolean check(String name, String password) {
        Users user=userRepository.checkuser(name);
        if(user!=null){
             if(user.getName().equals(name) && user.getPassword().equals(password)) {
                 System.out.println("Logged in Successfullly");
                 return true;
             }
             else {
                 System.out.println("Invalid Password");
                 return false;
             }
        }
        else {
            System.out.println("User not found");
            return false;
        }
    }
}
