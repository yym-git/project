package com.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ym.y
 * @description
 *  cmd +  telnet 127.0.0.1 6666 连接服务
 *  ctrl + ] 进入等待发送状态
 *  send 发送内容
 * @package com.bio
 * @updateUser
 * @date 21:17 2021/3/10
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        System.out.println("服务器启动了");
        while (true) {
            //监听，等待客户端的连接
            System.out.println("线程信息："+Thread.currentThread().getName());
            final Socket socket = serverSocket.accept();
            System.out.println("监听到了一个客户端已经连接......");
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    public static void handler(Socket socket) {

        try {
            System.out.println("handler线程信息："+Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while(true){
                System.out.println("循环类线程信息："+Thread.currentThread().getName());
                //如果没有读取到数据将会阻塞在该代码上
                System.out.println("等待读取数据。。。。");
                int len = inputStream.read(bytes);
                System.out.println("已经读取数据。。。。");
                if(len != -1){
                    System.out.println("输出客户端发送的数据："+new String(bytes,0,len));
                }else{
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("关闭连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
