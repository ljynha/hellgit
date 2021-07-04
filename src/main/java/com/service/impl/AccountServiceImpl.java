package com.service.impl;

import com.dao.AccountDao;
import com.domain.account;
import com.service.AccountService;
import com.utils.SqlSessionutils;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao=null;
    public void addaccount(account ac) {
        SqlSession sqlSession=null;
        try {
            sqlSession= SqlSessionutils.getSqlsession();
            accountDao=sqlSession.getMapper(AccountDao.class);
            accountDao.addaccount(ac);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            SqlSessionutils.close();
        }

    }
}
