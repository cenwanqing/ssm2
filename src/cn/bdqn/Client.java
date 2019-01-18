package cn.bdqn;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        try{
            //创建客户端并指定IP和端口号
            Socket socket=new Socket("localhost",8888);
            //获取IO流对象
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(os,true);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));


            while (true){
                System.out.println("客户端说：");
                String info=input.next();
                printWriter.println(info);
                String line=br.readLine();
                System.out.println("服务器 的回复："+line);
                if(info.equals("bye")){
                    break;
                }
            }


            is.close();
            os.close();
            br.close();
            printWriter.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
