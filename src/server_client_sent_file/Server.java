package server_client_sent_file;

import sun.util.resources.cldr.uk.CurrencyNames_uk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //用服务器发送文件到客户端

        //创建对象并绑定端口
        ServerSocket ss=new ServerSocket(10000);

        //等待客户来连接
        System.out.println("connecting...");
        Socket socket=ss.accept();
        System.out.println("connected!");

        //读取文件并发送到客户端
        File f =new File("/Users/dwayne/Desktop/CS/Java/CourseHW/Project_HW_05/serverdir/pic1.png");
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(f));

        OutputStream os=socket.getOutputStream();
        byte[] contents;
        long fileLen=f.length();
        long current=0;

        while (current!=fileLen){
            int size=10000;
            if (fileLen-current>=size){
                current+=size;
            }else {
                size = (int)(fileLen- current);
                current=fileLen;
            }
            contents=new byte[size];
            bis.read(contents,0,size);
            os.write(contents);
        }

        os.flush();
        socket.close();
        ss.close();

        System.out.println("sent!");
    }
}
