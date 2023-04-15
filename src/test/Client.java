package test;

import org.omg.CORBA.StringHolder;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //客户端：将本地文件上传到服务器。接收服务器的反馈

        //创建socket对象，连接服务器
        Socket socket = new Socket("127.0.0.1",10000);

        //读取本地文件中的数据，并写入到服务器中
        BufferedInputStream bis=new BufferedInputStream( new FileInputStream("/Users/dwayne/Desktop/CS/Java/CourseHW/Project_HW_05/clientdir/a.txt"));
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
//        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("/Users/dwayne/Desktop/CS/Java/CourseHW/Project_HW_05/serverdir/a.txt"));
        byte[] bytes=new byte[1024];
        int len;
        while((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }

        //往服务器写结束标记
        socket.shutdownOutput();

        //接收服务器的回写数据
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));//socket.getInputStream()获取连接通道里的输入流
        String line=br.readLine();
        System.out.println(line);

        socket.close();

    }
}


