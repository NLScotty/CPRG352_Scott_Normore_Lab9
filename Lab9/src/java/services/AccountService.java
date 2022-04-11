package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

public class AccountService {
    
    public User login(String email, String password) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
    public boolean isAdmin(String email) {
        UserDB userDB = new UserDB();
        
        try {
            User user = userDB.get(email);
            if (user.getRole().getRoleId()==1) {
                return true;
            }
        } catch (Exception e) {
        
        }
        return false;
    }
    public User getByEmail(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public boolean update(String email, boolean active, String firstName, String lastName, String password,Role role,String reset_password_uuid) throws Exception {
        UserDB userDB = new UserDB();
        User user = new User(email, active, firstName, lastName, password, role ,reset_password_uuid);
        return userDB.update(user);
    }
    
    public User getByUUID(String uuid) throws Exception {
        UserDB userDB = new UserDB();
        List<User> userlist = userDB.getByUUID(uuid);
        if(userlist.size() == 1 && uuid != null && !uuid.equals("")){
            return userlist.get(0);
        }
        return null;
    }
    
}
