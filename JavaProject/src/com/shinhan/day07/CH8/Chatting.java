package com.shinhan.day07.CH8;

class OtherClass {
	void method1() {
		Chatting.Chat aa = new Chatting().new Chat();
	}
}


public class Chatting {

	class Chat {
		void start() {}
		void sendMessage(String message) {}
	}
	
	void method1() {
		Chat aa = new Chat();
	}
	
	void startChat(String chatId) {
		String nickName = null;
		//nickName = chatId;
		
		
		//익명구현 class, local inner class는 지역변수를 참조하는 경우 무조건 지역변수는 final이다.
		Chat chat = new Chat() {
			@Override
			public void start() {
				while(true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "]" + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}
	
}
