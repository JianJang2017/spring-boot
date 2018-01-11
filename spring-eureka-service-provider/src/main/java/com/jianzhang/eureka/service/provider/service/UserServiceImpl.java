package com.jianzhang.eureka.service.provider.service;

import com.google.common.collect.Lists;
import com.jianzhang.cloud.message.User;
import com.jianzhang.cloud.message.UserRequest;
import com.jianzhang.cloud.message.UserResponse;
import com.jianzhang.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description: 服务实现类
 * @author Jian Jang
 * @version 1.0 2017/12/2
 */
@Slf4j
@RestController
public class UserServiceImpl implements UserService {
	@GetMapping("/getUserById")
	@Override
	public User getUserById(@RequestParam Long id) {
		log.info("userId:{}", id);
		User user = User.builder().id(id).name("张三").email("zhangsan@zj.com")
				.registerTime(new Date()).build();
		log.info("user:{}" + user.toString());
		return user;
	}

	@GetMapping("/getUserList")
	@Override
	public UserResponse getUserList(UserRequest request) {
		log.info("request2:{}", request.toString());
		List<User> userList = Lists.newArrayList();
		User user = User.builder().build();
		user.setId(2001l);
		user.setName("张三");
		user.setEmail("zhangsan@zj.com");
		user.setRegisterTime(new Date());
		userList.add(user);
		userList.add(user);
		userList.add(user);
		UserResponse response = UserResponse.builder().userList(userList).build();
		log.info("response:{}", response.toString());
		return response;
	}
	@PostMapping("/postUserById")
	@Override
	public User postUserById(@RequestBody Long id) {
		log.info("userId:{}", id);
		User user = User.builder().id(id).name("张三").email("zhangsan@zj.com")
				.registerTime(new Date()).build();
		log.info("user:{}" + user.toString());
		return user;
	}
	@PostMapping(value="/postUserList",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@Override
	public UserResponse postUserList(@RequestBody UserRequest request) {
		log.info("request:{}",request);
		List<User> userList = Lists.newArrayList();
		User user = User.builder().build();
		user.setId(2002l);
		user.setName("张三");
		user.setEmail("zhangsan@zj.com");
		user.setRegisterTime(new Date());
		userList.add(user);
		userList.add(user);
		userList.add(user);
		UserResponse response = UserResponse.builder().userList(userList).build();
		log.info("response:{}", response.toString());
		return response;
	}
}
