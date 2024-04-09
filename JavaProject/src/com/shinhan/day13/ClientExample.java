package com.shinhan.day13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {
	public static void main(String[] args) {
		try {
			//Socket 생성과 동시에 localhost의 50001 Port로 연결 요청;
			Socket socket = new Socket("192.168.0.39", 50001);
			
			System.out.println("[클라이언트] 연결 성공");
			
			
			//네터워크에서 들어온 문자를 보내기
			String message = "나는 자바가 좋아~~~~?????";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(message);
			dos.flush();
			System.out.println("[클라이언트] message를 보냄");
			
			//네트워크에서 들어온 문자를 읽기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String reciveMessage = dis.readUTF();
			System.out.println("클라이언트가 메시지를 받음: " + reciveMessage);	
			
			//Socket 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		} catch (UnknownHostException e) {
			//IP 표기 방법이 잘못되었을 경우
		} catch (IOException e) {
			//해당 포트의 서버에 연결할 수 없는 경우
		}
	
	}
}
