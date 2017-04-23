package com.company.springbootwithprimefaces.dao.user;

import com.company.springbootwithprimefaces.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
    @Query("select user from User user where user.deleted='0'")
    public List<User> findAllUsers();

    @Query("select user from User user where user.email=:email and user.deleted='0'")
    public User findUserByEmail(@Param("email") String email);

    @Query("select user from User user where user.id=:id and user.deleted='0'")
    public User findUserById(@Param("id") String id);
}
