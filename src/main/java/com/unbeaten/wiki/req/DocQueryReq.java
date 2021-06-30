package com.unbeaten.wiki.req;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class DocQueryReq extends PageReq {

    private String name;

    @NotNull(message = "【电子书ID】不能为空")
    private Long ebookId;

}
