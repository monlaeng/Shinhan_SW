package com.shinhan.day07;

public class Speaker implements Volume {
	int volLevel;

	@Override
	public void volumeUP(int vol) {
		//VolLevel을 주어진 level 만큼 증가, 메시지 출력, 100보다 크면 100으로 설정
		volLevel += vol; 
		if(volLevel > 100) volLevel = 100;
		
		System.out.println(getClass().getSimpleName()+" 볼륨 올립니다." + volLevel);
	}
	@Override
	public void volumeDown(int vol) {
		//VolLevel을 주어진 level 만큼 감소, 메시지 출력, 0보다 작으면 0으로 설정
		volLevel -= vol;
		if(volLevel < 0) volLevel = 0;
		
		System.out.println(getClass().getSimpleName()+" 볼륨 내립니다." + volLevel);

	}
}
