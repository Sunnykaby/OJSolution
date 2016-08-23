package com.kami.concurrent;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


import com.kami.concurrent.ThreadPool;

public class SimpleHttpServer {
	
	private static ThreadPool<HttpRequestHandle> threadPool = new DefultThreadPool<SimpleHttpServer.HttpRequestHandle>();
	//服务用的socket
	static ServerSocket serverSocket;
	//服务用的port，监听端口号
	static int port;
	//文件路径
	static String basePath;
	
	public static  void  setPort(int port) {
		if (port > 0) {
			SimpleHttpServer.port = port;
		}
	}
	
	public static boolean  setBasePath(String basePath){
		//要么这个文件存在，要么是个路径名，总是是合理的
		if (basePath!=null&&new File(basePath).exists()&&new File(basePath).isDirectory()) {
			SimpleHttpServer.basePath = basePath;
			return true;
		}
		return false;
	}
	//启动server
	public static void start() throws Exception{
		serverSocket = new ServerSocket(port);//会抛出异常
		//针对每个客户端连接创建独个socket来进行相应
		Socket socket = null;
		while((socket = serverSocket.accept())!=null){
			threadPool.excute(new HttpRequestHandle(socket));
		}
	}
	
	//一个内部类，实现Job的功能，处理HTTP请求
	static class HttpRequestHandle implements Runnable{
		private Socket socket = null;
		public HttpRequestHandle(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket = socket;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String line = null;
			//用来读Socket
			BufferedReader readerSocket = null;
			//用来读文件
			BufferedReader readerFile = null;
			//用来读流文件，主要是图片
			InputStream in = null;
			//用来向socket写
			PrintWriter out = null;
			
			try {
				readerSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String header = readerSocket.readLine();
				//这里只是写了一个例子，真正的访问资源解析就可以体现在这里。这里用该是用的get方法来请求的
				String filePath = basePath + header.split(" ")[1];
				//如果资源是图片，则读取并输出
				if (filePath.endsWith("jpg")) {
					in = new FileInputStream(filePath);
					//建立一个输出流，保存文件输出信息
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					int i = 0;
					//文件读，-1为读到eof
					while((i=in.read())!=-1){
						baos.write(i);
					}
					//http中需要byte数组，所以要进行转化
					byte[] source = baos.toByteArray();
					//http输出流,response content
					out.println("HTTP/1.1 200 OK");
					out.println("Server: Kami");
					out.println("Content-Type: image/jpeg");
					out.println("Content-Length: "+source.length);
					out.println("");
					socket.getOutputStream().write(source,0,source.length);
					
				}
				else{
					out = new PrintWriter(socket.getOutputStream());
					readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
					out.println("HTTP/1.1 200 OK");
					out.println("Server: Kami");
					out.println("Content-Type: text/html;charset=UTF-8");
					while((line = readerFile.readLine())!=null){
						out.println(line);
					}
					out.flush();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				out.println("HTTP/1.1 500");
				out.println("");
				out.flush();
			}
			finally{
				close(in,out,readerFile,readerSocket);
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		private static void close(Closeable... Closeables){
			if (Closeables!=null) {
				for (Closeable closeable : Closeables) {
					try {
						closeable.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	public static void main(String[] args){
		SimpleHttpServer.setPort(8080);
		SimpleHttpServer.setBasePath("/image/");
		try {
			SimpleHttpServer.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
