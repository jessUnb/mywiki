package com.unbeaten.wiki.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
public class DocSaveReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      private Long id;

    /**
     * 电子书id
     */
    @NotNull(message = "【电子书】不能为空")
    private Long ebookId;

    /**
     * 父id
     */
    @NotNull(message = "【父文档】不能为空")
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

    /**
     * 阅读数
     */
    private Integer viewCount;

    /**
     * 点赞数
     */
    private Integer voteCount;


}
