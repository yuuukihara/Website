package model;

public class OturiLogic {
	public String oturi(String[] keisan){

		int itemPrice = 0;
		int payPrice = 0;
		int first = 0;
		String msg = "";

		for(String moneya:keisan){
			if(first == 0){
				itemPrice = Integer.parseInt(moneya);
				first++;
			}else{
				payPrice = Integer.parseInt(moneya);
			}
			int oturi = payPrice - itemPrice;


			int[] moneyA = {0,0,0,0,0,0,0,0,0};
		    int[] moneyB = {10000,5000,1000,500,100,50,10,5,1};
		    for(int i=0;i<9;i++){
		     	for(int y=0;y<100;y++){
		       		if(oturi>=moneyB[i]){
	        			moneyA[i] += 1;
	        			oturi -= moneyB[i];
	        		}
		        }
		    }

		    String[] moneyC = {"itiman1","gosen1","sen1","ghyaku1","hyaku1","goju1","ju1","go1","iti1"};
		    for(int x=0;x<9;x++){
		    	moneyC[x] = Integer.toString(moneyA[x]);
		    }


				msg = "1万円:"+moneyC[0]+"枚/"+
				"5千円:"+moneyC[1]+"枚/"+
						"1000円:"+moneyC[2]+"枚/"+"500円:"+moneyC[3]+"枚/"+"100円:"+moneyC[4]+"枚/"+"50円:"+moneyC[5]+"枚/"+"10円:"+moneyC[6]+"枚/"+"5円:"+moneyC[7]+"枚/"+"1円:"+moneyC[8]+"枚";
		}

		return msg;

	}

}
