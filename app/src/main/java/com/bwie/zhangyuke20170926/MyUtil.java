package com.bwie.zhangyuke20170926;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 作者：张玉轲
 * 时间：2017/9/26
 */

public class MyUtil {
    public static String getStr(InputStream is){
        try {
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            int len;
            byte[] arr=new byte[1024];
            while((len=is.read(arr))!=-1){
                baos.write(arr,0,len);
            }
            return baos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
