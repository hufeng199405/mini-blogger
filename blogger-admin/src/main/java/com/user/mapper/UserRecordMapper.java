package com.user.mapper;

import com.user.domain.UserRecord;
import com.user.domain.UserRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserRecordMapper {
    int countByExample(UserRecordExample example);

    int deleteByExample(UserRecordExample example);

    @Insert({
        "insert into user_record (user_id, user_name, ",
        "credits, password, ",
        "last_visit, last_ip)",
        "values (#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{credits,jdbcType=INTEGER}, #{password,jdbcType=VARCHAR}, ",
        "#{lastVisit,jdbcType=TIMESTAMP}, #{lastIp,jdbcType=VARCHAR})"
    })
    int insert(UserRecord record);

    int insertSelective(UserRecord record);

    List<UserRecord> selectByExample(UserRecordExample example);

    int updateByExampleSelective(@Param("record") UserRecord record, @Param("example") UserRecordExample example);

    int updateByExample(@Param("record") UserRecord record, @Param("example") UserRecordExample example);
}