package com.unbeaten.wiki.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 分类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CategorySaveReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      private Long id;

    /**
     * 父id
     */
    private Long parent;

    /**
     * 名称
     */
    @NotNull(message = "【名称】不能为空")
    private String name;

    /**
     * 顺序
     */
    @NotNull(message = "【顺序】不能为空")
    private Integer sort;


}
