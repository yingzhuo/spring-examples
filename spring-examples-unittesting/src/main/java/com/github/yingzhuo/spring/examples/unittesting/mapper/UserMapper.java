package com.github.yingzhuo.spring.examples.unittesting.mapper;

import com.github.yingzhuo.spring.examples.unittesting.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from T_USER where id = #{id}")
    public User findById(@Param("id") String id);

}
