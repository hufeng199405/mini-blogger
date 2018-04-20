
package com.user.service.impl;

import com.user.domain.UserRecord;
import com.user.domain.UserRecordExample;
import com.user.mapper.UserRecordMapper;
import com.user.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-01-22 21:55
 * @desc
 * @since 1.8
 */

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRecordMapper mapper;

    @Transactional
    public UserRecord updateUserLogin(String userName, String password) throws Exception {

        try {

            // 1、验证账户的有效性
            UserRecordExample example = new UserRecordExample();
            UserRecordExample.Criteria criteria = example.createCriteria();

            criteria.andUserNameEqualTo(userName);
            criteria.andLoginPasswordEqualTo(password);

            int count = this.mapper.countByExample(example);

            if (count <= 0) {

                this.logger.error("账户密码不正确！");
                return null;
            }

            UserRecordExample example1 = new UserRecordExample();
            UserRecordExample.Criteria criteria1 = example.createCriteria();

            criteria1.andUserNameEqualTo(userName);

            // 查询当前的用户信息
            List<UserRecord> recordList = this.mapper.selectByExample(example1);

            return recordList.get(0);
        } catch (Exception e) {

            logger.error("事务出错", e);
            throw e;
        }
    }
}
