package com.stream;

import org.junit.Before;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.*;

/**
 * 输入流转String
 *
 * @author namo
 * @date 2022/6/8-14:24
 */
public class InputStream2Char {

    public InputStream readInputStream() {
        return this.getClass().getResourceAsStream("/test-file/test1.txt");
    }

    /**
     * 使用ByteArrayOutputStream转String（效率较高）
     *
     * @throws IOException
     */
    @Test
    public void useByteArrayTest() throws IOException {
        InputStream inputStream = this.readInputStream();
        //初始化字节数组输出流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            //写入到字节数组输出流
            byteArrayOutputStream.write(read);
        }
        String outString = byteArrayOutputStream.toString("UTF-8");
        System.out.println(outString);
    }

}
