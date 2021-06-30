package com.unbeaten.wiki.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文档内容
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文档id
     */
      private Long id;

    /**
     * 内容
     */
    private String content;


}
