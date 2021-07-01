package com.unbeaten.wiki.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

public class UserSaveReq implements Serializable {

    /**
     * ID
     */
      private Long id;

    /**
     * 登陆名
     */
    @NotNull(message = "【用户名】不能为空")
    private String loginName;

    /**
     * 昵称
     */
    @NotNull(message = "【昵称】不能为空")
    private String name;

    /**
     * 密码
     */
    @NotNull(message = "【密码】不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】至少包含 数字和英文，长度6-32")
    private String password;


}
