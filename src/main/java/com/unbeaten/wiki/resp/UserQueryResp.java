package com.unbeaten.wiki.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
@EqualsAndHashCode(callSuper = false)
public class UserQueryResp implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 密码
     */
    private String password;


}
