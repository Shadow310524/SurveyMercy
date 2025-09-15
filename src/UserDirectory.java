import java.util.HashMap;
import java.util.Map;

public class UserDirectory implements UserRepository{
    private final Map<String,Users> storage=new HashMap<>();
    @Override
    public boolean addUser(Users user) {
        String name= user.getName();
        if(!storage.containsKey(name)) {
            storage.put(name,user);
            return true;
        }
        return false;
    }

    @Override
    public Users checkuser(String name) {
        if(storage.containsKey(name)){
           return storage.get(name);
        }
        return null;
    }
}
