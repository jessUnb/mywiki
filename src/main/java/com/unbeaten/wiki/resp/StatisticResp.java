package com.unbeaten.wiki.resp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 电子书快照表
 * </p>
 *
 * @author unbeaten
 * @since 2021-07-04
 */
@Data
public class StatisticResp {

    @JsonFormat(pattern = "MM-dd",timezone = "GMT+8")
    private Date date;

    /**
     * 阅读数
     */
    private int viewCount;

    /**
     * 点赞数
     */
    private int voteCount;

    /**
     * 阅读增长
     */
    private int viewIncrease;

    /**
     * 点赞增长
     */
    private int voteIncrease;


}
