package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //服务器：接收客户端上传的文件，上传完毕后给出反馈

        //创建对象并绑定端口
        ServerSocket ss=new ServerSocket(10000);

        //等待客户来连接
        Socket socket=ss.accept();

        //读取数据并保存到本地文件中
        BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("/Users/dwayne/Desktop/CS/Java/CourseHW/Project_HW_05/serverdir/a.txt"));
        int len;
        byte[] bytes=new byte[1024];
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }

        //回写数据
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("Done");
        bw.newLine();
        bw.flush();

        socket.close();

    }
}
