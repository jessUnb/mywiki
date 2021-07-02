package com.unbeaten.wiki.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author unbeaten
 * @since 2021-07-01
 */
@Data

public class UserLoginResp {

    /**
     * ID
     */
      private Long id;

    /**
     * 登陆名
     */
    private String loginName;

    /**
     * 昵称
     */
    private String name;

    /**
     * token
     */
    private String token;



}
