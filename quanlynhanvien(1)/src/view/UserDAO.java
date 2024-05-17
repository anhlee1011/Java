package view;

import java.util.ArrayList;
import java.util.List;
public class UserDAO {
    List <User> ls = new ArrayList<>();

    public UserDAO() {
        ls.add(new User("admin", "admin", true)); 
    }
    public boolean checkLogIn(String username, String password){
        for( User u : ls){
            if(u.getUsername().equals(username)
                    &&u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
