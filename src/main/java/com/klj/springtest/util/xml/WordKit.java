package com.klj.springtest.util.xml;

import ch.qos.logback.core.util.TimeUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * @author klj
 * @Title: 基于freemarker的word导出工具，对图片和文字，表格都有很好的支持
 * @Description: TODO
 * @date 2018/7/31 18:42
 */
public class WordKit {

    private Configuration configuration = null;

    public WordKit() {
        configuration = new Configuration(new Version("2.3.28"));
        configuration.setDefaultEncoding("UTF-8");
    }


    /**
     * 传入数据 可直接本地生成word
     * @param dataMap
     */
    public void createDoc(Map<String, Object> dataMap) {
        configuration.setClassForTemplateLoading(this.getClass(), "/static/template");

        Template t = null;
        try {
            t = configuration.getTemplate("temp.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 输出文档路径及名称
        File outFile = new File("d:/'" + Math.random()*10000 + "'t2_img.doc");
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        try {
            t.process(dataMap, out);
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    /**
     * @description 根据文件磁盘路径获取图片字符串
     * @author:klj
     * @date 2018/8/6  9:38
     * @param imgFile
     * @return java.lang.String
     */
    public static String getImageStr(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * 根据网络url地址获取图片
     * @param strUrl 网络连接地址
     * @return
     */
    public static String getImageFromNetByUrl(String strUrl) throws Exception {
        String imgStr = null;
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] bytes = readInputStream(inStream);
            BASE64Encoder encoder = new BASE64Encoder();
            imgStr = encoder.encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgStr;
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }


    public String uploadDoc(Map<String, Object> dataMap)throws Exception {
        configuration.setClassForTemplateLoading(this.getClass(), "/static/template");

        Template t = null;
        try {
            t = configuration.getTemplate("template_pic.ftl");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(bos);
        t.process(dataMap, osw);
        InputStream is = new ByteArrayInputStream(bos.toByteArray());
        String key = "活动记录_"+ new Date().toString()+".doc";
        //AliOssUtil.uploadLocalFileToCloud(is,key);
        bos.flush();
        osw.flush();
        return key;

    }

    public static void main(String[] args) {
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
        datas.put("speaker", "shuo的");
        datas.put("noter", "记录的");
        datas.put("otherName", "会议");
        datas.put("leader", "领导");
        datas.put("leader", "领导");
        datas.put("count", "5");
        datas.put("attendance", "A");
        datas.put("absentee", "B");
        String c = "<p>\n" +
                "    <span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; font-weight: bold; font-size: 14px; box-sizing: border-box; color: rgb(48, 49, 51); font-family: &quot;Microsoft YaHei&quot;, &quot;PingFang SC&quot;, STHeitiSC-Light, Helvetica-Light, arial, sans-serif; background-color: rgb(255, 255, 255);\">&nbsp; &nbsp; &nbsp;<span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; font-weight: 400; font-size: xx-large; box-sizing: border-box; color: rgb(194, 79, 74);\">政治核心作用</span></span>\n" +
                "</p>\n" +
                "<p style=\"padding: 0px; border: 0px; margin-top: 10px; margin-bottom: 10px; vertical-align: baseline; font-size: 14px; box-sizing: border-box; line-height: 1.5; color: rgb(48, 49, 51); font-family: &quot;Microsoft YaHei&quot;, &quot;PingFang SC&quot;, STHeitiSC-Light, Helvetica-Light, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\">\n" +
                "    &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; font-size: large; box-sizing: border-box;\">&nbsp;<span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; font-weight: bold; font-size: 18px; box-sizing: border-box; font-family: Arial;\">持续推进“党建+”工作。按照“1+3+X”的模式，没有结合各单位的实际推行“党建+”具体措施，没有明确加的内容、抓手、牵头负责人、达到的目标，扣4分；开展的活动效果不明显，扣1-3分。2、大力开展党建课题攻关活动，未申报扣4分，申报后未实施、实施效果不明显扣1-3分。3、未定期对职工思想动态进行分折，或没有针对企业热点难点问题采取有力措施，扣2分。</span></span>\n" +
                "</p>\n" +
                "<p style=\"padding: 0px; border: 0px; margin-top: 10px; margin-bottom: 10px; vertical-align: baseline; font-size: 14px; box-sizing: border-box; line-height: 1.5; color: rgb(48, 49, 51); font-family: &quot;Microsoft YaHei&quot;, &quot;PingFang SC&quot;, STHeitiSC-Light, Helvetica-Light, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\">\n" +
                "    &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; box-sizing: border-box; color: rgb(123, 91, 161);\">在新成立基层企业的同时，未及时成立党的基层组织，在调整经营管理机构的同时，未及时调整优化党组织设置，扣2分。2、建立党组织时未按照党章规定由党员大会（党员代表大会）选举产生,未严格按照组织程序操作，扣2分。3、“两委”任期届满，没有按期进行换届选举，扣2分。4、未做好党建工作依法进入公司章程的工作，未明确党组织在企业决策、执行、监督各环节的权责和工作方式以及与其他治理主体的关系的，扣2分。</span>\n" +
                "</p>\n" +
                "<p style=\"padding: 0px; border: 0px; margin-top: 10px; margin-bottom: 10px; vertical-align: baseline; font-size: 14px; box-sizing: border-box; line-height: 1.5; color: rgb(48, 49, 51); font-family: &quot;Microsoft YaHei&quot;, &quot;PingFang SC&quot;, STHeitiSC-Light, Helvetica-Light, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\">\n" +
                "    &nbsp; &nbsp; &nbsp; &nbsp;<span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; box-sizing: border-box; color: rgb(70, 172, 200);\">在新成立基层企业的同时，未及时成立党的基层<span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; box-sizing: border-box; text-decoration-line: line-through;\">组织，在调整经营管理机构的同时，未及时调整优化党组织设置，扣2</span>分。2、建立党组织时未按照党章规定由党员大会（党员代表大会）选举产生,未严格按照组织程序操作，扣2分。3、“两委”任期届满，没有按期进行换届选举，扣2分。4、未做好党建工作依法进入公司章程的工作，未明确党组织在企业决策、执行、监督各环节的权责和工作方式以及与其他治理主体的关系的，扣2分。</span>\n" +
                "</p>\n" +
                "<p style=\"padding: 0px; border: 0px; margin-top: 10px; margin-bottom: 10px; vertical-align: baseline; font-size: 14px; box-sizing: border-box; line-height: 1.5; color: rgb(48, 49, 51); font-family: &quot;Microsoft YaHei&quot;, &quot;PingFang SC&quot;, STHeitiSC-Light, Helvetica-Light, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\">\n" +
                "    <span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; box-sizing: border-box;\">&nbsp; &nbsp; &nbsp; &nbsp;</span><span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; box-sizing: border-box; text-decoration-line: underline; background-color: rgb(139, 170, 74);\">在新成立基层企业的同时，未及时成立党的基层组织，在调整经营管理机构的同时，未及时调整优化党组织设置，扣2分。2、建立党组织时未按照党章规定由党员大会（党员代表大会）选举产生,未严格按照组织程序操作，扣2分。3、“两委”任期届满，没有按期进行换届选举，扣2分。4、未做好党建工作依法进入公司章程的工作，未明确党组织在企业决策、执行、监督各环节的权责和工作方式以及与其他治理主体的关系的，扣2分。</span>\n" +
                "</p>\n" +
                "<p style=\"padding: 0px; border: 0px; margin-top: 10px; margin-bottom: 10px; vertical-align: baseline; font-size: 14px; box-sizing: border-box; line-height: 1.5; color: rgb(48, 49, 51); font-family: &quot;Microsoft YaHei&quot;, &quot;PingFang SC&quot;, STHeitiSC-Light, Helvetica-Light, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\">\n" +
                "    <a href=\"http://whrdd.f3322.net:8889/index.html\" target=\"_blank\" style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; text-decoration-line: none; backface-visibility: hidden; box-sizing: border-box;\">党建</a><span style=\"padding: 0px; border: 0px; margin: 0px; vertical-align: baseline; box-sizing: border-box; text-decoration-line: underline; background-color: rgb(139, 170, 74);\"><br/></span>\n" +
                "</p>\n" +
                "<p style=\"padding: 0px; border: 0px; margin-top: 10px; margin-bottom: 10px; vertical-align: baseline; font-size: 14px; box-sizing: border-box; line-height: 1.5; color: rgb(48, 49, 51); font-family: &quot;Microsoft YaHei&quot;, &quot;PingFang SC&quot;, STHeitiSC-Light, Helvetica-Light, arial, sans-serif; white-space: normal; background-color: rgb(255, 255, 255);\">\n" +
                "    <br/>\n" +
                "</p>\n" +
                "<p>\n" +
                "    <br/>\n" +
                "</p>";

      /*  StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body>");
        sb.append(c);
        sb.append("</body>");
        sb.append("</html>");
        Document doc = Jsoup.parse(sb.toString());
        String body = doc.getElementsByTag("body").html();
        body = body.replace("=3D", "=").replace("=", "=3D");
        doc.body()*/
        c = c.replace("=3D", "=").replace("=", "=3D");
        datas.put("content", c);
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        for(int i =0; i < 3; i++){
            HashMap<String, String> map = new HashMap<>();
            String imageStr = WordKit.getImageStr("D:/c.jpg");
            map.put("srcStr",imageStr);
            map.put("name",i+"");
            list.add(map);
        }
        //datas.put("pic",WordKit.getImageStr("D:/c.jpg"));
        datas.put("imgList",list);

        wordKit.createDoc(datas);
    }



}
