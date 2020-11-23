package com.hrms.dao;

import com.hrms.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @auther thk
 * @date 2020/11/22 - 11:27
 */
public interface UserDao {

    String TABLE_NAME = "user";

    String INSERT_FIELDS = "username,password,permissions,status";


    @Select({"select * from ",TABLE_NAME," where username = #{username}"})
    public User findUserByUsername(String username);



    @Insert({"INSERT INTO",TABLE_NAME,"(",INSERT_FIELDS,")"+
            "VALUES(#{username},#{password},#{permissions},#{status})"})
    public int register(User user);


    @Select({"select * from",TABLE_NAME,"where id = #{id}"})
    public User findUserById(Integer id);

    @Select({"select name from",TABLE_NAME,"where id = #{id}"})
    public String findNameById(Integer id);

    @Select({"select * from ",TABLE_NAME})
    public List<User> getUsers();

    @Update({"update ",TABLE_NAME," set status = #{status} where id = #{id}"})
    public int banned(User user);
}
