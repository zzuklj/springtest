package com.klj.springtest.controller;

import com.klj.springtest.enums.ReturnMessageEnum;
import com.klj.springtest.util.poi.WordDocUtils;
import com.klj.springtest.util.poi.WordUtils;
import com.klj.springtest.util.xml.WordKit;
import com.klj.springtest.vo.UserVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

@RestController
public class RequestController {

  /*  @Value("${urls}")
    private String urls;*/

    @GetMapping("/hello")
    public String index(UserVo user){

        int index = user.getId();
        String s = "2";
        System.out.println(s);
        String message = ReturnMessageEnum.getMessageByIndex(index);
        System.out.println(message);
        return message;
    }




}
