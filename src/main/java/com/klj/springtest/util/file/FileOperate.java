package com.klj.springtest.util.file;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author klj
 * @Title: FileOperate
 * @Description: TODO
 * @date 2018/8/616:56
 */
@Component
public class FileOperate {

    /**
     * @description 以字节为单位读写文件内容
     * @author:klj
     * @date 2018/8/6  16:58
     * @param filePath
     * @return void
     */
    public void readFileByByte(String filePath){
        File file = new File(filePath);

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(file);
            os = new FileOutputStream(newFilePath(filePath,1));

            int len;
           /* while((len = is.read()) != -1){
                os.write(len);
            }*/
            byte[] bytes = new byte[1024];
            while((len = is.read(bytes)) != -1){
                os.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeResource(os,is);
        }

    }

    /**
     * @description 以字符为单位读写文件内容
     * @author:klj
     * @date 2018/8/6  17:03
     * @param filePath
     * @return void
     */
    public void readByCharacter(String filePath){
        File file = new File(filePath);

        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(file);
            fw = new FileWriter(newFilePath(filePath,2));

            char[] chars = new char[1024];
            int temp;
            while((temp = fr.read(chars)) != -1){
                fw.write(chars,0,temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           closeResource(fw,fr);
        }
    }

    /**
     * @description 以行为单位读写文件内容
     * @author:klj
     * @date 2018/8/6  17:03
     * @param filePath
     * @return void
     */
    public void readByLine(String filePath){
        File file = new File(filePath);

        BufferedReader  br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(new File(newFilePath(filePath,3))));

            String temp;
            while((temp = br.readLine()) != null){
                bw.write(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeResource(bw,br);
        }
    }

    public void readByByteBuffer(String filePath){
        File file = new File(filePath);

        FileInputStream in = null;
        FileOutputStream out = null;

        // 获取源文件和目标文件的输入输出流
        try {
            in = new FileInputStream(filePath);
            out = new FileOutputStream(newFilePath(filePath,4));

            FileChannel inChannel = in.getChannel();
            FileChannel outChannel = out.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(true){
                buffer.clear();
                int read = inChannel.read(buffer);
                if(read == -1){
                    break;
                }
                buffer.flip();
                outChannel.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeResource(out,in);
        }
    }

    private void closeResource(OutputStream os,InputStream is){
        if(is != null && os != null){
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeResource(Writer os,Reader is){
        if(is != null && os != null){
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String newFilePath(String fielPath,int i){
        String[] split = fielPath.split("\\.");
        return split[0]+i+"."+split[1];
    }

    //nio与io字节流数据读取并没有多大区别，反而比io字节流要稍微慢一点
}
