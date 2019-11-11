package com.cvc.provider.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.cvc.common.domain.User;


@Mapper
public interface UserMapper {
	@Results(id = "userMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "age", property = "age"),
            @Result(column = "sex", property = "sex")})
    @Select("SELECT * FROM u_user")
    List<User> getAll();

    @Select("SELECT * FROM u_user t WHERE t.id = #{id}")
    @ResultMap("userMap")
    User getOne(Long id);
}
