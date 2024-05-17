package kr.co.rland.api.soket.basic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WebServer {
    public static void main(String[] args) throws IOException {

        //C에서는 바인드를 해줘야 했는데 자바는 ServerSocket 하면 자동 바인드 해줌
        // 다른애가 안쓸 포트로, 포트 정하는 순간 입출력 버퍼 두개 만들어짐
        ServerSocket serverSocket = new ServerSocket(80);
        System.out.println("Listening at port 80");

        List<Socket> clients = new ArrayList<>();

        Boolean run = true;
        while (run){
           Socket socket = serverSocket.accept(); // 손님 없으면 blocking
           clients.add(socket);
//           new Thread(()->{
               System.out.printf("connected from %s\n", socket.getInetAddress());

               try (
                       InputStream ois = socket.getInputStream();
                       OutputStream sos = socket.getOutputStream();
                       BufferedReader in = new BufferedReader(new InputStreamReader(ois));
                       PrintWriter out = new PrintWriter(sos,true);
               ) {
//                   while (true){
                       String line = in.readLine(); // data 언제와~ blocking///
                       System.out.printf("%s: %s\n", socket.getInetAddress(), line);

                       String payload = "<!DOCTYPE html>\n" +
                               "<html lang=\"en\">\n" +
                               "<head>\n" +
                               "    <meta charset=\"UTF-8\">\n" +
                               "    <title>Title</title>\n" +
                               "</head>\n" +
                               "<body>\n" +
                               "<main>hi jini</main>\n" +
                               "</body>\n" +
                               "</html>";

                       StringBuilder builder = new StringBuilder();
                       builder.append("HTTP/1.1 200 OK \r\n");
                       builder.append("Server: jini");
                       builder.append("Content-Type: text/html");
                       builder.append("Content-Length: "+payload.length());
                       builder.append("Date: "+ new Date().toString());

                       out.println(builder.toString());
                       out.println("\r\n");
                       out.println(payload);

                       if("bye".equals(line))
                           break;;
//                   }
               } catch (IOException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
               }

//           }).start();

           socket.close();
       }
        serverSocket.close();
//        Scanner sc ;
//        BufferedInputStream bis;
//        PrintStream out;
    }
}
