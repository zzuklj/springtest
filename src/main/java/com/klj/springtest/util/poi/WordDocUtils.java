package com.klj.springtest.util.poi;


import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * @description poi的doc格式文档处理工具，目前只支持简单的模板文字替换
 * @author:klj
 * @date 2018/8/6  9:35
 * @param
 * @return
 */
public class WordDocUtils {

    /**
     * @description
     * @author:klj
     * @date 2018/7/25 15:42
     * @param [tmpFile, contentMap, fileName, response]
     * @return void
     */
    public static void build(File tmpFile, Map<String, String> contentMap, String fileName, HttpServletResponse response) throws Exception {
        FileInputStream fis = new FileInputStream(tmpFile);
        HWPFDocument hwpfDocument = new HWPFDocument(fis);
        //读取文本内容
        Range range = hwpfDocument.getRange();
        //替换内容
        for (Map.Entry<String,String> entry:contentMap.entrySet()){
            range.replaceText("${"+entry.getKey()+"}",entry.getValue());
        }

        //浏览器下载
        response.setContentType("multipart/form-data");
        response.addHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("gb2312"), "ISO8859-1"));
        hwpfDocument.write(response.getOutputStream());
    }


}
