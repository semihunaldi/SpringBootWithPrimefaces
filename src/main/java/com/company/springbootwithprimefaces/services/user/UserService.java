package com.company.springbootwithprimefaces.services.user;


import com.company.springbootwithprimefaces.model.user.User;
import com.company.springbootwithprimefaces.services.BaseService;

/**
 *
 */
public interface UserService extends BaseService
{
    User findUserByEmail(String email);

    User findUserById(String id);

    User saveUser(User user);
}
