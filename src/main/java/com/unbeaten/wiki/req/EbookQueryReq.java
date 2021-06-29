package com.unbeaten.wiki.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 电子书
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EbookQueryReq extends PageReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      private Long id;

    /**
     * cid2
     */
      private Long categoryId2;

    /**
     * 名称
     */
    private String name;

}
