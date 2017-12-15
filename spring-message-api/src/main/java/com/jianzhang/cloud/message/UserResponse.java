package com.jianzhang.cloud.message;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 响应对象
 * @author Jian Jang
 * @version 1.0 2017/12/2
 */
@Setter
@Getter
@Builder
@ToString
public class UserResponse implements Serializable {

    private static final long serialVersionUID = 8877287740859532051L;

    private String repCode;

    private String repMsg;

    private List<User> userList;
}
