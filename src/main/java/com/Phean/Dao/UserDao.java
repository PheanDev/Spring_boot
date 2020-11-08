package com.Phean.Dao;

import com.Phean.Models.UserInfo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    public List<UserInfo> getListUserInfo();
    public UserInfo getUserInfoByUserName(String username);
}
