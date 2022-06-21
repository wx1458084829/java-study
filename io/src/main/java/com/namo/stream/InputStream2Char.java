package com.namo.stream;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

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

    /**
     * 使用Apache的IO工具包转换
     * @throws IOException
     */
    @Test
    public void useIOUtils() throws IOException {
        InputStream inputStream = this.readInputStream();
        // 利用IOUtils工具将字节输入流（InputStream）转到字符输出流（Writer）
//        Writer writer = new StringWriter();
//        IOUtils.copy(inputStream,writer, StandardCharsets.UTF_8);
//        System.out.println(writer.toString());

        // 输入流转成字符数组，然后使用String类将char[]转为String
//        char[] chars = IOUtils.toCharArray(inputStream, StandardCharsets.UTF_8);
//        System.out.println(new String(chars));

        //  输入流转成字节数组，然后使用String类将byte[]转为String
        byte[] bytes = IOUtils.toByteArray(inputStream);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

}
