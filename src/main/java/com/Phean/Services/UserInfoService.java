package com.Phean.Services;

import com.Phean.Dao.UserDao;
import com.Phean.Models.Student;
import com.Phean.Models.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserInfoService implements UserDao {
    Configuration con = new Configuration().configure().addAnnotatedClass(UserInfo.class);

    SessionFactory sf = con.buildSessionFactory();
    Session session = sf.openSession();
    Transaction tran;

    @Override
    public List<UserInfo> getListUserInfo() {
        return session.createQuery("from UserInfo ").list();
    }

    @Override
    public UserInfo getUserInfoByUserName(String username) {
        Query query=session.createQuery("from UserInfo where userName=:name and enabled=:enabled");
        query.setParameter("name",username);
        query.setParameter("enabled",(short)1);

       return (UserInfo)query.uniqueResult();
    }
}
