package server_client_sent_file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //连接到服务器并接收文件

        Socket socket=new Socket("127.0.0.1",10000);

        byte[] contents=new byte[10000];

        InputStream is=socket.getInputStream();
        File f=new File("/Users/dwayne/Desktop/CS/Java/CourseHW/Project_HW_05/clientdir/pic1.png");
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(f));

        int bytesRead=0;

        while ((bytesRead= is.read(contents))!=-1){
            bos.write(contents,0,bytesRead);
        }

        bos.flush();
        socket.close();

        System.out.println("received!");
    }
}
