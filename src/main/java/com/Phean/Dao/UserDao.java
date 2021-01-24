package com.Phean.Dao;

import com.Phean.Models.UserInfo;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserDao {
    public List<UserInfo> getListUserInfo();
    public UserInfo getUserInfoByUserName(String username);

    //Add more CRUD here
}
