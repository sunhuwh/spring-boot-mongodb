package com.sunhuwh.springboot.springbootmongodb;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sunhuwh.springboot.springbootmongodb.domain.User;
import com.sunhuwh.springboot.springbootmongodb.domain.UserRespository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMongodbApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private UserRespository userRespository;
	
	@Before
	public void setUp() {
		userRespository.deleteAll();
	}
	
	@Test
	public void test() {
		User user = new User(1L, "sh", 26);
		userRespository.save(user);
		
		User user2 = new User(2L, "sh2", 26);
		userRespository.save(user2);
		
		List<User> allUsers = userRespository.findAll();
		Assert.assertEquals(2, allUsers.size());
		
		userRespository.deleteById(1L);
		allUsers = userRespository.findAll();
		Assert.assertNotEquals(2, allUsers.size());
		
		String username = allUsers.get(0).getUsername();
		Assert.assertEquals(username, "sh2");
		
		User oldUser = allUsers.get(0);
		oldUser.setUsername("sh22");
		username = allUsers.get(0).getUsername();
		Assert.assertEquals(username, "sh22");
	}

}
