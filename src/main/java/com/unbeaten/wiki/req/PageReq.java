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
public class PageReq implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * page
     */
    private int page;

    /**\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\774\\\\\\\\\\
     * size
     */
    private int size;

}
