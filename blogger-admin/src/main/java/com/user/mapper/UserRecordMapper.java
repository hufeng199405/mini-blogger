package com.user.mapper;

import com.user.domain.UserRecord;
import com.user.domain.UserRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRecordMapper {
    int countByExample(UserRecordExample example);

    int deleteByExample(UserRecordExample example);

    int insert(UserRecord record);

    int insertSelective(UserRecord record);

    List<UserRecord> selectByExample(UserRecordExample example);

    int updateByExampleSelective(@Param("record") UserRecord record, @Param("example") UserRecordExample example);

    int updateByExample(@Param("record") UserRecord record, @Param("example") UserRecordExample example);
}