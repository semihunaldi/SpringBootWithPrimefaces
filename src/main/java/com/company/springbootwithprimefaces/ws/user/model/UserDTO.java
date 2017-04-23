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
public class UserDTO extends BaseResult
{
    private String id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String mobilePhone;

    private Integer age;

    public UserDTO(Integer errorCode, String errorDescription)
    {
        super(errorCode,errorDescription);
    }

    public UserDTO()
    {
    }

    public static UserDTO create(User user)
    {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAge(user.getAge());
        userDTO.setMobilePhone(user.getMobilePhone());
        return userDTO;
    }
}
