package com.klj.springtest.extend.tool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @author klj
 * @Title: JsoupHandle
 * @Description: TODO
 * @date 2019/3/298:54
 */
public class JsoupHandle {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFile(){
        try {
            Document doc = Jsoup.parse(new File("D:\\error.html"), "utf-8");
            Elements rows = doc.select("table").get(0).select("tr");
            for(Element e : rows){
                StringBuilder sb = new StringBuilder();
                Elements td = e.select("td");
                if(td == null || td.size() == 0){
                    continue;
                }
                String code = td.get(0).text();
                String originMsg = td.get(1).text();
                sb.append(code).append("(\"").append(code).append("\", ").
                        append("\"").append(originMsg).append("!\", ").
                        append("\"").append(originMsg).append("!\"), ");
                System.out.println(sb.toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
