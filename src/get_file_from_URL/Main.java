package get_file_from_URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url=new URL("http://www.hfut.edu.cn/xxgk1/gdjj1.htm");
        URLConnection uc=url.openConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String line=null;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }

        br.close();
    }
}
