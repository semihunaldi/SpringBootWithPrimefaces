package com.company.springbootwithprimefaces.ws.user.model;

import com.company.springbootwithprimefaces.model.user.User;
import com.company.springbootwithprimefaces.ws.BaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 */

@EqualsAndHashCode(callSuper = false)
@Data
public class CreateUserDTO extends BaseResult
{
    private String userId;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String mobilePhone;

    private Integer age;

    public CreateUserDTO(Integer errorCode, String errorDescription)
    {
        super(errorCode,errorDescription);
    }

    public CreateUserDTO()
    {
    }

    public User createUserEntity()
    {
        User user = new User();
        setUserCommonFields(user,this);
        return user;
    }

    public static void updateUserEntityFields(User user, CreateUserDTO createUserDTO)
    {
        setUserCommonFields(user,createUserDTO);
    }

    private static void setUserCommonFields(User user, CreateUserDTO createUserDTO)
    {
        user.setFirstName(createUserDTO.getFirstName());
        user.setLastName(createUserDTO.getLastName());
        user.setUserName(createUserDTO.getUserName());
        user.setEmail(createUserDTO.getEmail());
        user.setMobilePhone(createUserDTO.getMobilePhone());
        user.setAge(createUserDTO.getAge());
    }

    public static CreateUserDTO createCreateUserDTO(User user)
    {
        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setFirstName(user.getFirstName());
        createUserDTO.setLastName(user.getLastName());
        createUserDTO.setUserName(user.getUserName());
        createUserDTO.setEmail(user.getEmail());
        createUserDTO.setMobilePhone(user.getMobilePhone());
        createUserDTO.setAge(user.getAge());
        return createUserDTO;
    }
}