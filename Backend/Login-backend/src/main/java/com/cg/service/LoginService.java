package com.cg.service;

import com.cg.entity.User;
import com.cg.exceptions.LoginException;

public interface LoginService {
    public User doLogin(String userId, String password)throws LoginException;
    public String encryptUser(User user);
    
}
