package com.jianzhang.eureka.service.consumer;

import com.google.common.collect.Maps;
import com.jianzhang.cloud.message.User;
import com.jianzhang.cloud.message.UserRequest;
import com.jianzhang.cloud.message.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

/**
 * @Description: 测试类
 * @author Jian Jang
 * @version 1.0 2017/12/2
 */
@Slf4j
@RestController
public class UserController {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${user.service.getUser.url}")
	private String GET_USER_URL;
	@Value("${user.service.postUser.url}")
	private String POST_USER_URL;
	@Value("${user.service.getUserList.url}")
	private String GET_USER_LIST_URL;
	@Value("${user.service.postUserList.url}")
	private String POST_USER_LIST_URL;

	@GetMapping("/user")
	public User getUserById(Long id) {
		log.info("GET_USER_URL:{}", GET_USER_URL);
		// 方法1：
		// ResponseEntity<User> entity= restTemplate.getForEntity(GET_USER_URL +
		// "?id={1}", User.class, id);
		// User user =entity.getBody();
		User user = restTemplate.getForObject(GET_USER_URL + "?id={id}", User.class, id);
		log.info("response User:{}", user.toString());
		return user;

	}

	@GetMapping("/users")
	public UserResponse getUserList(UserRequest request) {
		log.info("GET_USER_LIST_URL:{}", GET_USER_LIST_URL);
		Map<String, String> params = Maps.newHashMap();
		params.put("id", request.getId() + "");
		params.put("name", request.getName());
		// 方法1：
		// ResponseEntity<UserResponse> entity
		// restTemplate.getForEntity(GET_USER_LIST_URL
		// + "?id={id}&name={name}", UserResponse.class, params);
		// UserResponse userResponse=entity.getBody();
		UserResponse userResponse = restTemplate.getForObject(GET_USER_LIST_URL
				+ "?id={id}&name={name}", UserResponse.class, params);
		log.info("response User:{}", userResponse.toString());
		return userResponse;

	}

	@PostMapping("/postUserById")
	public User postUserById(Long id) {
		log.info("GET_USER_URL:{}", POST_USER_URL);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		HttpEntity<Long> httpEntity= new HttpEntity<>(id,headers);
		ResponseEntity<User> entity = restTemplate.postForEntity(POST_USER_URL, httpEntity, User.class);
		// 方法2：
		// User user = restTemplate.postForObject(POST_USER_URL, httpEntity,
		// User.class);
		log.info("response User:{}", entity.getBody().toString());
		return entity.getBody();

	}

	@PostMapping("/postUserList")
	public UserResponse postUserList(UserRequest request) {
		log.info("request:{}",request);
		log.info("GET_USER_LIST_URL:{}", POST_USER_LIST_URL);
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		HttpEntity<UserRequest> httpEntity = new HttpEntity<>(request, headers);

		// 方法1：使用postForEntity
		 ResponseEntity<UserResponse> entity =restTemplate.postForEntity(POST_USER_LIST_URL,httpEntity, UserResponse.class);
		// 方法2：postForObject
		/*UserResponse userResponse = restTemplate.postForObject(POST_USER_LIST_URL, httpEntity,
				UserResponse.class);*/
		//log.info("response User:{}", userResponse);
		log.info("response User:{}", entity.getBody());
		return entity.getBody();
	}
}
