package number;

import java.util.ArrayList;

public class NumberString {

	
	public static String numberName (int n) {
		if(n==0) {
			return "zero";
		}
		String nString = Integer.toString(n);
		int currentHundred=0;
		String str="";
		for(int i=0;i<=nString.length();i++) {
			//System.out.println(i + "/" + (nString.length()-1));
			if((i!=0&&i%3==0)||i==nString.length()) {
				//System.out.println("printhere");
				//System.out.println(i);
				if(i<=3) {
					str = hundredMethod(currentHundred);
				}else if(currentHundred!=0){
					int mag = (int)Math.floor(((float)i-1)/3);
					//System.out.println("i " + i + " " + "Mag: " + mag);
					if(str!="") {
						str = hundredMethod(currentHundred) +" " + magnitudeName(mag) + " " +  str;
					}else {
						str = hundredMethod(currentHundred) +" " + magnitudeName(mag);
					}
				}
				currentHundred=0;
				
			}
			if(nString.length()==i) {
				break;
			}
			currentHundred+=Math.pow(10,i%3)*Integer.parseInt(""+nString.charAt(nString.length()-1-i));
			//System.out.println("\""+currentHundred+"\"");
		}
			
			
			
			
		/*
		if(n==0) {
			return "zero";
		}
		int pos=1;
		int count=1;
		while(n>=pos) {
			pos*=10;
			count++;
		}
		pos/=10;
		count--;
		int[] digits= new int[count];
		for(int i=0;i<count;i++) {
			digits[i]=n%(10*pos)-n%(pos);
			pos/=10;
		}
		
		ArrayList<Integer> hundredSplits = new ArrayList<Integer>();
		ArrayList<String> hundredsNames = new ArrayList<String>();
		Integer currentHundred=0;
		for(int i=count-1;i>=-1;i--) {
			System.out.println("\""+currentHundred+"\"");
			if((count-i-1)%3==0 || (count-i-1)==-1) {
				if((count-i-1)!=0) {
					hundredSplits.add(currentHundred);
				}
				currentHundred=0;
			}
			if(i==-1) {
				break;
			}
			currentHundred+=(int)(Math.round(digits[i]/Math.pow(1000, hundredSplits.size())));
			//System.out.println("Size: " + hundredSplits.size() + " - Add " + (int)(Math.round(digits[i]/Math.pow(1000, hundredSplits.size()))));
			//System.out.println(currentHundred);
		}
		String str="";
		for(int i=0;i<hundredSplits.size();i++) {
			System.out.println("\""+hundredSplits.get(i)+"\"");
			if(i==0) {
				str = hundredMethod(hundredSplits.get(i));
			}else {
				str = hundredMethod(hundredSplits.get(i)) +" " + magnitudeName(i) + " " +  str;
			}
		}*/
		return str;
	}
	
	public static String hundredMethod(int n) {
		//System.out.println(n);
		int tens = n%100;
		int hundreds = n%1000-tens;
		String hundredStr = valueName(hundreds/100);
		String tenStr = tensMethod(tens);
		String out="";
		if(hundredStr!="") {
			out += hundredStr + " hundred";
		}
		if(hundredStr!="" && tenStr!="") {
			out+=" and ";
		}
		if(tenStr!="") {
			out+=tenStr;
		}
		
		
		return out;
		
		
	}
	
	public static String tensMethod(int n) {
		//System.out.println(n);
		//System.out.println(valueName(n));
		return valueName(n);
	}
	
	
	public static String magnitudeName(int power) {
		switch(power) {
		case 1:
			return "thousand";
		case 2:
			return "million";
		case 3:
			return "billion";
		case 4:
			return "trillion";
		case 5:
			return "quadrillion";
		case 6:
			return "quintillion";
		case 7:
			return "sextillion";
		case 8:
			return "septillion";
		case 9:
			return "octillion";
		case 10:
			return "nonillion";
		case 11:
			return "decillion";
		case 12:
			return "undecillion";
		case 13:
			return "duodecillion";
		case 14:
			return "tredecillion";
		case 15:
			return "quattuordecillion";
		case 16:
			return "quindecillion";
		case 17:
			return "sexdecillion";
		case 18:
			return "septendecillion";
		case 19:
			return "octodecillion";
		case 20:
			return "novemdecillion";
		case 21:
			return "vigintillion";
		}
		if(power>21) {
			return "No name for this high number";
		}
		return "";
	}
	

	public static String valueName(int n) {
		switch(n) {
		case 0:
			return "";
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
		case 4: 
			return "four";
		case 5:
			return "five";
		case 6: 
			return "six";
		case 7:
			return "seven";
		case 8:
			return "eight";
		case 9:
			return "nine";
		case 10:
			return "ten";
		case 11:
			return "eleven";
		case 12:
			return "twelve";
		case 13:
			return "thirteen";
		case 15:
			return "fifteen";
		case 18:
			return "eighteen";
		case 20:
			return "twenty";
		case 30:
			return "thirty";
		case 40:
			return "fourty";
		case 50:
			return "fifty";
		case 60:
			return "sixty";
		case 70:
			return "seventy";
		case 80:
			return "eighty";
		case 90:
			return "ninety";
		}
		
		if(n>10&&n<20) {
			return valueName(n%10)+"teen";
		}
		if(n<100) {
			return valueName(n%100-n%10)+" " +  valueName(n%10);
		}
		
		return "";
	}
	
	public static String turnNumToPlace(String number) {
		ArrayList<Pair<String,String>> convert = new ArrayList<Pair<String,String>>();
		convert.add(new Pair<String, String>("one","first"));
		convert.add(new Pair<String, String>("two","second"));
		convert.add(new Pair<String, String>("three","third"));
		convert.add(new Pair<String, String>("five","fifth"));
		convert.add(new Pair<String, String>("eight","eighth"));
		convert.add(new Pair<String, String>("twenty","twentieth"));
		convert.add(new Pair<String, String>("thirty","thirtieth"));
		convert.add(new Pair<String, String>("fourty","fourtieth"));
		convert.add(new Pair<String, String>("fifty","fiftieth"));
		convert.add(new Pair<String, String>("sixty","sixtieth"));
		convert.add(new Pair<String, String>("seventy","seventieth"));
		convert.add(new Pair<String, String>("eighty","eightieth"));
		convert.add(new Pair<String, String>("ninety","ninetieth"));
		for(int i=0;i<convert.size();i++) {
			if(isStringAtEnd(number,convert.get(i).getL())) {
				number = number.substring(0,number.length()-convert.get(i).getL().length()) + convert.get(i).getR();
				return number;
			}
		}
		number= number + "th";
		return number;
	}
	
	public static boolean isStringAtEnd(String str, String check) {
		if(str.length()<check.length()) {
			return false;
		}
		for(int i=0;i<check.length();i++) {
			if(str.charAt(str.length()-1-i)!=check.charAt(check.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
}
