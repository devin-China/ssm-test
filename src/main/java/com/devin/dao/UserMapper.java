package com.devin.dao;

import com.devin.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;


public interface UserMapper {

    @Select("select * from sys_user where id=#{id}")
    User findUser(Long id);

    @Insert({" insert into sys_user values(" +
            "null," +
            "#{username,jdbcType=VARCHAR}," +
            "#{email,jdbcType=VARCHAR}," +
            "#{password,jdbcType=VARCHAR}," +
            "#{phoneNum,jdbcType=VARCHAR}," +
            "#{birthday,javaType=Date,jdbcType=VARCHAR,typeHandler=com.devin.handler.MyTypeHandler})"})
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void addUser(User user);

    @Select(" select * from sys_user ")
    @Results({@Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday",
                    typeHandler=com.devin.handler.MyTypeHandler.class,
                    javaType = Date.class,
                    jdbcType = JdbcType.VARCHAR)
    })
    List<User> findAll();







}
