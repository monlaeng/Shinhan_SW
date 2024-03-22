package com.shinhan.day07;

public class Radio implements Volume {
	int volLevel;

	@Override
	public void volumeUP(int vol) {
		//VolLevel을 주어진 level 만큼 증가, 메시지 출력, 100보다 크면 100으로 설정
		volLevel += vol; 
		
		System.out.println(getClass().getSimpleName()+" 볼륨 올립니다." + volLevel);
	}
	@Override
	public void volumeDown(int vol) {
		volLevel -= vol;
		
		System.out.println(getClass().getSimpleName()+" 볼륨 내립니다." + volLevel);

	}
}
