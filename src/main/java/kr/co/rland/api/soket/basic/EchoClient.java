package kr.co.rland.api.soket.basic;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket soket = new Socket("192.168.0.28", 8080);// Listening 하고 있는 서버의 주소와 포트

        System.out.printf("connected to %s\n", soket.getInetAddress());

        InputStream ois = soket.getInputStream();
        OutputStream sos = soket.getOutputStream();

        BufferedReader in = new BufferedReader(new InputStreamReader(ois)); //믄자열 단위로
        PrintWriter out = new PrintWriter(sos,true); //믄자열 단위로

        //1. 사용자로부터 메아리를 할 수 있는 메시지 입력 받기
        Scanner sc = new Scanner(System.in);
        String msg;

        while (true){
            System.out.print("msg : ");
            msg= sc.nextLine();


            //2.사용자로부터 입력 받은 msg 전송
            out.println(msg);

            //3.서버로부터 전달된 라인 읽어온다
            String line = in.readLine();

            //4.콘솔에 line을 출력한다
            System.out.println(line);

            if("bye".equals(line))
                break;;

        }
        in.close();
        out.close();
        ois.close();
        sos.close();

        soket.close();
    }
}
