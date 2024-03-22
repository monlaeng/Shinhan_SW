package com.shinhan.day09;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.URL;

public class ObjectTest4 {
	public static void main(String[] args) throws IOException{
		f2();
	}

	private static void f2() throws IOException {
		//new FileReader("src/com/shinhan/day09/ComputerVO.java");
		Class<?> cls = ObjectTest4.class;
		URL url = cls.getResource("우리반.png");
		
		System.out.println(url.getPath());
		
		
	   InputStream fis = cls.getResourceAsStream("oracleInfo.properties");
	   InputStreamReader isr = new InputStreamReader(fis);	//한글이 안깨지도록 2byte씩 읽어준다.
	   
	   int i;
	   while((i=isr.read()) != -1) {
		   System.out.print((char)i);
	   }
	}

	private static void f1() {
		//리플렉션
		Class<ComputerVO> cls = ComputerVO.class;
		Constructor<?>[] cons = cls.getDeclaredConstructors();
		for(Constructor<?> cc: cons) {
			System.out.println(cc.getName());
			System.out.println(cc.getParameterCount());
			for(Parameter param :cc.getParameters()) {
				System.out.println(param);
			};
			
			System.out.println("-----------------------");
		}
	}
}
