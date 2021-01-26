package com.example.demo.service.impl;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class Start implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
//        File file = new File("src/main/resources/test.txt");
        File file = getFileFromClassPath("test.txt");
        InputStream fis =null;
 try {
fis = new FileInputStream(file);
byte[] buf = new byte[1024]; //数据中转站 临时缓冲区
int length = 0;
//循环读取文件内容，输入流中将最多buf.length个字节的数据读入一个buf数组中,返回类型是读取到的字节数。
//当文件读取到结尾时返回 -1,循环结束。
while((length = fis.read(buf)) != -1){
System.out.println(new String(buf, 0, length));
}
} catch (Exception e) {
e.printStackTrace();
}finally{
try {
fis.close();//强制关闭输入流
} catch (IOException e) {
e.printStackTrace();
}
}
    }

    public static File getFileFromClassPath(String path) {
        File targetFile = new File(path);
        if (!targetFile.exists()) {
            if (targetFile.getParent() != null) {
                File parent = new File(targetFile.getParent());
                if (!parent.exists()) {
                    parent.mkdirs();
                }
            }
            InputStream initialStream = null;
            OutputStream outStream = null;
            try {
                Resource resource = new ClassPathResource(path);
                //注意通过getInputStream，不能用getFile
                initialStream = resource.getInputStream();
                byte[] buffer = new byte[initialStream.available()];
                initialStream.read(buffer);
                outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
            } catch (IOException e) {
            } finally {
                if (initialStream != null) {
                    try {
                        initialStream.close(); // 关闭流
                    } catch (IOException e) {
                    }
                }
                if (outStream != null) {
                    try {
                        outStream.close(); // 关闭流
                    } catch (IOException e) {
                    }
                }
            }
        }
        return targetFile;
    }

}

