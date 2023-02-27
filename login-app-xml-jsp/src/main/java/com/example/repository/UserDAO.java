package com.example.repository;

import com.example.model.Login;
import com.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        users.add(new User("Bill","12345","Bill","bill@gmail.com",10));
        users.add(new User("Mike","12345","Mike","mike@gmail.com",15));
        users.add(new User("Harry","12345","Harry","harry@gmail.com",20));
    }
    public UserDAO(){}
    public static User checkLogin(Login login){
        for(User u: users){
            if (u.getAccount().equals(login.getUsername()) &&
                    u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }


}
