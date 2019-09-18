package com.klj.springtest.controller.base;

import com.klj.springtest.model.JsonResult;

import java.util.function.Function;

public class BaseController {

    protected <U,VO> JsonResult<U> simpleJsonResult(VO vo, Function<VO, U> processor){
        U apply = processor.apply(vo);
        JsonResult<U> jsonResult = new JsonResult<U>();
        jsonResult.setMsg("sucess");
        jsonResult.setResult(apply);
        return jsonResult;
    }
}
