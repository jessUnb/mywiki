package com.unbeaten.wiki.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
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

public class UserLoginReq implements Serializable {

    /**
     * 登陆名
     */
    @NotEmpty(message = "【用户名】不能为空")
    private String loginName;

    /**
     * 密码
     */
    @NotEmpty(message = "【密码】不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】规则不正确")
    private String password;


}
