package com.klj.springtest.model;

import lombok.Data;

@Data
public class JsonResult<T> {

    private boolean status = true;

    private String msg;

    private T result;
}
