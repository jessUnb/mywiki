package com.unbeaten.wiki.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "【页码】不能为空")
    private int page;

    /**
     * size
     */

    @NotNull(message = "【每页条数】不能为空")
    @Max(value = 1000,message = "【每页条数】不能超过1000")
    private int size;

}
