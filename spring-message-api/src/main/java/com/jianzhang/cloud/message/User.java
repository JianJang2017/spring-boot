package com.jianzhang.cloud.message;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户实体
 * @author Jian Jang
 * @version 1.0 2017/12/2
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 7373820917096429330L;
    private Long id;

    private String name;

    private String email;

    private Date registerTime;

}
