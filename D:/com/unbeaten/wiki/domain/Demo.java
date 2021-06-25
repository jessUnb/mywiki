package com.unbeaten.wiki.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * demo
 * </p>
 *
 * @author yshexiaobai
 * @since 2021-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("demo")
public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;


}
