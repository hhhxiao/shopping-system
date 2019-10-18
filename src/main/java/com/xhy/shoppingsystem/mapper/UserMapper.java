package com.xhy.shoppingsystem.mapper;

import com.xhy.shoppingsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Mapper
@Repository
public interface UserMapper {
    User queueUserByID(Integer id);
}
