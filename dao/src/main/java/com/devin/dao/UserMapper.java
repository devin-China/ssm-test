package com.devin.dao;

import com.devin.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select(" select * from sys_user where id=#{id}")
    User findUser(Long id);
}
