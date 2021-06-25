package com.unbeaten.wiki.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * demo
 * </p>
 *
 * @author unbeaten
 * @since 2021-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Demo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      private Long id;

    /**
     * 名称
     */
    private String name;


}
