package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public class UserService {
    private List<User> users;

    public UserService() {
    }

    public List<User> getUsers(int count) {
        if(count >= users.size()) {
            return users;
        } else {
            return users.subList(0, count);
        }
    }
}
