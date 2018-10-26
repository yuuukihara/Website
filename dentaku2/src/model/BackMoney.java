package model;

public class BackMoney {
	public String backmoney(String[] keisan){

		int first = 0;
		int itemPrice = 0;
		int payPrice = 0;
		int oturi = 0;
		String msg = "";

		for(String money:keisan){
			if(first == 0){
				int moneyb = Integer.parseInt(money);
				itemPrice = moneyb;
				first++;
			}else{
				int moneyc = Integer.parseInt(money);
				payPrice = moneyc;
			}
		}
		oturi = payPrice - itemPrice;
		String Oturi = Integer.toString(oturi);
		msg = Oturi+"円";
		return msg;
	}

}
