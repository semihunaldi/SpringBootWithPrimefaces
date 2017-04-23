package com.company.springbootwithprimefaces.ws.user;

import com.company.springbootwithprimefaces.ws.user.model.CreateUserDTO;
import com.company.springbootwithprimefaces.ws.user.model.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */

@RequestMapping(path = "/api")
public interface UserWebService
{
    @RequestMapping(value = "/user/queryUserByEmail", method = {RequestMethod.GET})
    //http://localhost:8080/api/user/queryUserByEmail?email=dummy@dummy.com
    public UserDTO queryUserByEmail(@RequestParam(value = "email", defaultValue = "") String email);

    @RequestMapping(value = "/user/queryUserById", method = {RequestMethod.GET})
    //http://localhost:8080/api/user/queryUserById?id=
    public UserDTO queryUserById(@RequestParam(value = "id", defaultValue = "") String id);

    @RequestMapping(value = "/user/createUser", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.OK )
    //http://localhost:8080/api/user/createUser
    public CreateUserDTO createUser(@RequestBody CreateUserDTO createUserDTO);

    @RequestMapping(value = "/user/updateUser", method = {RequestMethod.POST})
    @ResponseStatus(value = HttpStatus.OK )
    //http://localhost:8080/api/user/updateUser
    public CreateUserDTO updateUser(@RequestBody CreateUserDTO createUserDTO);
}
