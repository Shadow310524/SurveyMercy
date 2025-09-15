public interface UserRepository {
    boolean addUser(Users user);
    Users checkuser(String name);
}
