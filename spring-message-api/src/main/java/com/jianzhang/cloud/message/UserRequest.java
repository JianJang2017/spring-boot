package com.jianzhang.cloud.message;

import lombok.*;

import java.io.Serializable;

/**
 * @Description:
 * @author Jian Jang
 * @version 1.0 2017/12/2
 */
@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest implements Serializable {
    private static final long serialVersionUID = 4040443965553696016L;
    private Long id;

    private String name;

    private String email;

}
