package model;

public class Logic {

	//足し算
	public double tasu(String[] tasu){
		int total = 0;
		for(String result:tasu){
			int a = Integer.parseInt(result);
			total += a;
		}
		return total;
	}

	//引き算

	public double hiku(String[] hiku){
		double total = 0;
		for(String result:hiku){
			if(total == 0){
				double a = Integer.parseInt(result);
				total += a;
			}else{
				double b = Integer.parseInt(result);
				total -= b;
			}
		}
		return total;
	}

	//掛け算

	public double kakeru(String[] kakeru){
		int total = 0;
		for(String result:kakeru){
			if(total == 0){
				int a = Integer.parseInt(result);
				total += a;
			}else{
				int b = Integer.parseInt(result);
				total *= b;
			}
		}
		return total;
	}

	public double waru(String[] a){
		double first = 0;
		for(String aa:a){
			double math = Integer.parseInt(aa);
			if(first == 0){
				first += math;
			}else{
				first /= math;
			}
		}
		return first;
	}



	//平均

	public double heikin(String[] waru){

	    int total = 0;
		int count = 0;
		for(String result:waru){
				double a = Integer.parseInt(result);
				total += a;
				count ++;
		}
		double ans = total/count;
		return ans;

	}

	//円の面積

	public double en(String hankei){
		int b = Integer.parseInt(hankei);
		return b * b *3.141592;
	}

	//乱数取得
	public double ran(String ran){
		int b = Integer.parseInt(ran);
		int a = new java.util.Random().nextInt(b+1);
		return a;

	}

}
