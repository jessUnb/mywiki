package com.unbeaten.wiki.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 电子书快照表
 * </p>
 *
 * @author unbeaten
 * @since 2021-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EbookSnapshot implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 电子书id
     */
    private Long ebookId;

    /**
     * 快照日期
     */
    private LocalDate date;

    /**
     * 阅读数
     */
    private Integer viewCount;

    /**
     * 点赞数
     */
    private Integer voteCount;

    /**
     * 阅读增长
     */
    private Integer viewIncrease;

    /**
     * 点赞增长
     */
    private Integer voteIncrease;


}
