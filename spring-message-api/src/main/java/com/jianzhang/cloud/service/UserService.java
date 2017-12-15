package com.jianzhang.cloud.service;

import com.jianzhang.cloud.message.User;
import com.jianzhang.cloud.message.UserRequest;
import com.jianzhang.cloud.message.UserResponse;

/**
 * @Description: 用户服务接口
 * @author Jian Jang
 * @version 1.0 2017/12/2
 */
public interface UserService {
    /***
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public User getUserById(Long id);

    /**
     * 查询用户列表信息
     * @param request
     * @return
     */
    public UserResponse getUserList(UserRequest request);


    /***
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public User postUserById(Long id);

    /**
     * 查询用户列表信息
     * @param request
     * @return
     */
    public UserResponse postUserList(UserRequest request);


}
