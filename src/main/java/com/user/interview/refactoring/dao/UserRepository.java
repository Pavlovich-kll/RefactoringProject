package com.user.interview.refactoring.dao;

import com.user.interview.refactoring.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    User findById(Long id);

    void save(@Param("user") User user);

    User update(@Param("user") User user);

    void deleteById(Long id);
}
