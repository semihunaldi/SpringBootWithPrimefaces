package com.company.springbootwithprimefaces.services.user.impl;

import com.company.springbootwithprimefaces.dao.user.UserRepository;
import com.company.springbootwithprimefaces.model.user.User;
import com.company.springbootwithprimefaces.services.BaseServiceImpl;
import com.company.springbootwithprimefaces.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */

@Component(value = "userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByEmail(String email)
    {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserById(String id)
    {
        return userRepository.findUserById(id);
    }

    @Override
    @Transactional
    public User saveUser(User user)
    {
        try
        {
            User mergedUser = this.userRepository.save(user);
            return mergedUser;
        }
        catch (DataIntegrityViolationException e)
        {
            throw new RuntimeException("Error while saving user");
        }
    }
}
