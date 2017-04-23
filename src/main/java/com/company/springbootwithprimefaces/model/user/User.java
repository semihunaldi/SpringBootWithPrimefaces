package com.company.springbootwithprimefaces.model.user;

import com.company.springbootwithprimefaces.model.SimpleAbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 */

@Entity
@Data
@Table(name = "T_USER",  uniqueConstraints = {@UniqueConstraint(name = "T_USER_EMAIL_UNIQUE",columnNames = "email")})
@DynamicUpdate
@EqualsAndHashCode(callSuper = true)
@Where(clause = "DELETED = '0'")
public class User extends SimpleAbstractEntity
{
    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String mobilePhone;

    private Integer age;
}
