package com.alan.dashboard.DAO.Mybatis;

import com.alan.dashboard.model.security.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Mapper
@Repository
public interface UserDao {
    public void createUser(User user);

    public User findOne(Long userId);

    public void updateUser(User user);

    public void deleteUser(Long userId);

//    public void correlationRoles(Long userId, Long... roleIds);
//    public void uncorrelationRoles(Long userId, Long... roleIds);

    public void correlationRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    public void uncorrelationRole(@Param("userId") Long userId, @Param("roleId") Long roleId);


    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
