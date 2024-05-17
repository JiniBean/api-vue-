package kr.co.rland.api.soket.basic;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class WebClient {
    public static void main(String[] args) throws IOException {
        Socket soket = new Socket("192.168.0.28", 80);// Listening 하고 있는 서버의 주소와 포트

        System.out.printf("connected to %s\n", soket.getInetAddress());

        InputStream ois = soket.getInputStream();
        OutputStream sos = soket.getOutputStream();

        BufferedReader in = new BufferedReader(new InputStreamReader(ois)); //믄자열 단위로
        PrintWriter out = new PrintWriter(sos,true); //믄자열 단위로

//        Scanner sc = new Scanner(System.in);
//        String msg;

        String requestLine = "GET /index HTTP/1.1\r\n";
        String requestHeader = "Host: 127.0.0.1\r\n\r\n";
        String req = requestLine+requestHeader;

        //서버에 요청(브라우저가 요청하는 것처럼)
        out.println(req);

        //서버에서 보내준 문서 읽기
        String res = in.readLine();
        System.out.println(res);

        res = in.readLine();
        System.out.println(res);
        res = in.readLine();
        System.out.println(res);
        res = in.readLine();
        System.out.println(res);

        in.close();
        out.close();
        ois.close();
        sos.close();

        soket.close();
    }
}
