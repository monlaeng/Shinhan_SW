
class Prob3_Fin {
	public static void main(String args[]){
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}

class PhoneCharge{	
	//구현하시오.
	private String user;
	private int call;
	private int sms;
	private int data;
	private int total;
	
	public PhoneCharge(String user, int call, int sms, int data) {
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}
	
	public int calcCharge() {
		int callFee = 10;	//200분 이상이면 2배
		int smsFee = 20;	//300건 이상이면 4배
		int dataFee = 1000;	//7GB 이상이면 2배
		callFee = (call>=200) ? (callFee * 2 * call) : (callFee * call);
		smsFee = (sms >= 300) ? (smsFee * 4 * sms) : (smsFee * sms);
		dataFee = (data >= 7) ? (dataFee * 2 * data) : (dataFee * data);
		
		return callFee+smsFee+dataFee;

	
	}
	public void printCharge() {
		this.total = calcCharge();
		System.out.printf("%s 사용자는 이번달에 사용하신 전화요금이 %d 원입니다. \n", user, total);
	}
}
 