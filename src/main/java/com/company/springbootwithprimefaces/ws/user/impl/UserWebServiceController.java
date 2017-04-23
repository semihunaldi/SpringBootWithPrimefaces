package com.company.springbootwithprimefaces.ws.user.impl;

import com.company.springbootwithprimefaces.model.user.User;
import com.company.springbootwithprimefaces.services.user.UserService;
import com.company.springbootwithprimefaces.ws.BaseRestController;
import com.company.springbootwithprimefaces.ws.user.UserWebService;
import com.company.springbootwithprimefaces.ws.user.model.CreateUserDTO;
import com.company.springbootwithprimefaces.ws.user.model.UserDTO;
import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class UserWebServiceController extends BaseRestController implements UserWebService
{
    @Autowired
    private UserService userService;

    public UserDTO queryUserByEmail(@RequestParam(value="email", defaultValue="") String email)
    {
        try
        {
            User user = userService.findUserByEmail(email);
            if(user != null)
            {
                return UserDTO.create(user);
            }
            else
            {
                throw new RuntimeException("User not found");
            }
        }
        catch (RuntimeException e)
        {
            logger.error("queryUserByEmail error",e);
            return new UserDTO(-1,e.getMessage());
        }
        catch (Exception e)
        {
            logger.error("queryUserByEmail error",e);
            return new UserDTO(-2,"error");
        }
    }

    @Override
    public UserDTO queryUserById(@RequestParam(value = "id", defaultValue = "") String id)
    {
        try
        {
            User user = userService.findUserById(id);
            if(user != null)
            {
                return UserDTO.create(user);
            }
            else
            {
                throw new RuntimeException("User not found");
            }
        }
        catch (RuntimeException e)
        {
            logger.error("queryUserById error",e);
            return new UserDTO(-1,e.getMessage());
        }
        catch (Exception e)
        {
            logger.error("queryUserById error",e);
            return new UserDTO(-2,"error");
        }
    }

    @Override
    public CreateUserDTO createUser(@RequestBody CreateUserDTO createUserDTO)
    {
        try
        {
            User user = createUserDTO.createUserEntity();
            user = userService.saveUser(user);
            return CreateUserDTO.createCreateUserDTO(user);
        }
        catch (RuntimeException e)
        {
            logger.error("createUser error",e);
            return new CreateUserDTO(-1,"createUser error");
        }
        catch (Exception e)
        {
            logger.error("createUser error",e);
            return new CreateUserDTO(-2,"createUser error");
        }
    }

    @Override
    public CreateUserDTO updateUser(@RequestBody CreateUserDTO createUserDTO)
    {
        try
        {
            Preconditions.checkNotNull(createUserDTO,"request can not be empty");
            Preconditions.checkArgument(StringUtils.isNotBlank(createUserDTO.getUserId()),"user id cannot be empty");
            User user = userService.findUserById(createUserDTO.getUserId());
            if(user == null)
            {
                throw new RuntimeException("User not found");
            }
            CreateUserDTO.updateUserEntityFields(user,createUserDTO);
            user = userService.saveUser(user);
            return CreateUserDTO.createCreateUserDTO(user);
        }
        catch (RuntimeException e)
        {
            logger.error("updateUser error",e);
            return new CreateUserDTO(-1,e.getMessage());
        }
        catch (Exception e)
        {
            logger.error("updateUser error",e);
            return new CreateUserDTO(-2,e.getMessage());
        }
    }
}
