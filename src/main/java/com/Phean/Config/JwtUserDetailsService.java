package com.Phean.Config;

import java.util.ArrayList;

import com.Phean.Models.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	Configuration configuration = new Configuration().configure().addAnnotatedClass(UserInfo.class);
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	Session session = sessionFactory.openSession();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Query query = session.createQuery("from UserInfo where userName=:name");
		query.setParameter("name", username);

		UserInfo userInfo = (UserInfo) query.uniqueResult();

		if (userInfo != null) {
			if (userInfo.getUserName().equals(username)) {
				return new User(userInfo.getUserName(), userInfo.getPassword(), new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		}
		else
			throw new UsernameNotFoundException("User not found with username: " + username);
	}
}
