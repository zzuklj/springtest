package com.klj.springtest.controller;

import com.klj.springtest.util.poi.WordDocUtils;
import com.klj.springtest.util.poi.WordUtils;
import com.klj.springtest.util.xml.WordKit;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

@RestController
public class ExportController {

    @GetMapping("/export")
    public void testExportWord(HttpServletResponse response) throws Exception {
        File tmpFile = null;
        try {
            tmpFile = ResourceUtils.getFile("classpath:static/template/template.doc");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String expFile = "test.doc";
        Map<String, String> datas = new HashMap<String, String>();
        datas.put("title", "标题部份");
        datas.put("theme", "主题");
        datas.put("p1", "主持的");
        datas.put("time", new Date().toString());
        datas.put("place", "未知");
        datas.put("p2", "记录的");
        datas.put("present", "A");
        datas.put("unpresent", "B");
        datas.put("content", "这里是内容，测试使用POI导出到Word的内容！");
        datas.put("pic", "这里是内容，测试使用POI导出到Word的内容！");

        try {
            WordDocUtils.build(tmpFile, datas, expFile,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/export2")
    public void testExportWord2(HttpServletResponse response) throws Exception {

        File picFile = null;
        try {
            picFile = ResourceUtils.getFile("classpath:static/template/c.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        WordUtils wordUtil=new WordUtils();
        Map<String, Object> datas = new HashMap<String, Object>();
        datas.put("title", "标题部份");
        datas.put("theme", "主题");
        datas.put("hoster", "主持的");
        datas.put("time", new Date().toString());
        datas.put("place", "未知");
        datas.put("speaker", "记录的");
        datas.put("speaker", "记录的");
        datas.put("leader", "领导");
        datas.put("count", "5");
        datas.put("attendance", "A");
        datas.put("absentee", "B");
        datas.put("content", "这里是内容，测试使用POI导出到Word的内容！");
        //datas.put("pic", "这里是内容，测试使用POI导出到Word的内容！");


        try{
            Map<String,Object> pic = new HashMap<String, Object>();
            pic.put("width", 100);
            pic.put("height", 150);
            pic.put("type", "jpg");
            pic.put("content", WordUtils.inputStream2ByteArray(new FileInputStream(picFile), true));
            List<Map<String, Object>> maps = Arrays.asList(pic, pic);
            datas.put("${pic}",maps);
           /* Map<String,Object> header2 = new HashMap<String, Object>();
            header2.put("width", 100);
            header2.put("height", 150);
            header2.put("type", "jpg");
            header2.put("content", WordUtils.inputStream2ByteArray(new FileInputStream(picFile), true));
            datas.put("${header2}",header2);*/
            List<String[]> tableList = new ArrayList<String[]>();
            tableList.add(new String[]{"1","1AA","1BB","1CC"});
            tableList.add(new String[]{"2","2AA","2BB","2CC"});
            tableList.add(new String[]{"3","3AA","3BB","3CC"});
            tableList.add(new String[]{"4","4AA","4BB","4CC"});
            String path="classpath:static/template/template.docx";  //模板文件位置
            String fileName= new String("测试文档.docx".getBytes("UTF-8"),"iso-8859-1");    //生成word文件的文件名
            wordUtil.getWord(path,datas,tableList,fileName,response);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @GetMapping("/export3")
    public void testExportWord3(HttpServletRequest request, HttpServletResponse response) throws Exception {

        WordKit wordKit = new WordKit();
        Map<String, Object> datas = new HashMap<String, Object>();
        /*datas.put("title", "标题部份");
        datas.put("theme", "主题");
        datas.put("p1", "主持的");
        datas.put("time", new Date().toString());
        datas.put("place", "未知");
        datas.put("p2", "记录的");
        datas.put("present", "这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！");
        datas.put("unpresent", "这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！");
        datas.put("content", "这里是内容，测试使用POI导出到Word的内容！这里是内容，" +
                "这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！" +
                "这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！" +
                "这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！" +
                "这里是内容，测试使用POI导出到Word的内容！" +
                "测试使用POI导出到Word的内容！这里是内容，测试使用POI导出到Word的内容！");*/

        datas.put("title", "标题部份");
        datas.put("theme", "主题");
        datas.put("hoster", "主持的");
        datas.put("time", new Date().toString());
        datas.put("place", "未知");
        datas.put("speaker", "记录的");
        datas.put("speaker", "记录的");
        datas.put("leader", "领导");
        datas.put("count", "5");
        datas.put("attendance", "A");
        datas.put("absentee", "B");
        datas.put("content", "这里是内容，测试使用POI导出到Word的内容！");
        datas.put("pic",WordKit.getImageStr("D:/c.jpg"));

        wordKit.createDoc(datas);

    }


}
