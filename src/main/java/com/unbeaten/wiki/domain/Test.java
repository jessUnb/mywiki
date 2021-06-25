package com.unbeaten.wiki.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 测试
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;


}
