package cn.bdqn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器
 */
public class Server {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        try{
            //创建服务器并指定端口号
            ServerSocket serverSocket=new ServerSocket(8888);
            System.out.println("服务器开始工作了。。。。。。。。。。。");
            Socket socket=serverSocket.accept();
            //获取IO流对象
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();
            //获取客户端的信息
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            PrintWriter printWriter=new PrintWriter(os,true);

            while (true){
                String line=br.readLine();
                System.out.println("客户端说：");
                System.out.println(line);
                //向客户端回复
                System.out.println("服务器说：");
                String reply=input.next();
                printWriter.println(reply);
                if(reply.equals("bye")){
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
