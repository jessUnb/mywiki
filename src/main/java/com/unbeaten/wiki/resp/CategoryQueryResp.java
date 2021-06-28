package com.unbeaten.wiki.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 分类
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-28
 */
@Data
public class CategoryQueryResp {


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
    private String name;

    /**
     * 顺序
     */
    private Integer sort;


}
