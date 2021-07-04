package com.dao;

import com.domain.account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao {
    public account findaccountbyid(int id);
    public List<account> findall ();
    public  void addaccount(account ac);
    public  void updataaccount(@Param("a") account ac);
}
