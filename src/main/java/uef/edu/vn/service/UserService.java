/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uef.edu.vn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uef.edu.vn.model.User;
import uef.edu.vn.repository.UserRepository;

/**
 *
 * @author ADMIN
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
     // Đăng nhập
    public User login(String username, String password) {
        return repository.login(username, password);
    }

    // Tìm username
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    // Đổi mật khẩu
    public boolean changePassword(int userId,
                                  String oldPassword,
                                  String newPassword) {

        User user = repository.findById(userId);

        if (user == null) {
            return false;
        }

        if (!user.getPassword().equals(oldPassword)) {
            return false;
        }

        repository.changePassword(userId, newPassword);

        return true;
    }
    
}
