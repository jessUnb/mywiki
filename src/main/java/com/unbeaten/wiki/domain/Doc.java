package com.unbeaten.wiki.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文档
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Doc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      private Long id;

    /**
     * 电子书id
     */
    private Long ebookId;

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

    /**
     * 阅读数
     */
    private Integer viewCount;

    /**
     * 点赞数
     */
    private Integer voteCount;


}
