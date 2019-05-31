package race;
import number.NumberString;
public class Race {

	public static String dogCompetitionEnglish(int place) {
		
		String str="";
		for(int i=1;i<101;i++) {
			if(i!=place) {
				//str+= i + suffix(i) + ", "; 
				str += NumberString.turnNumToPlace(NumberString.numberName(i)) + ", " ;
			}
		}
		str=str.substring(0,str.length()-2);
		
		return str;
	}
	public static String dogCompetition(int place) {

		String str="";
		for(int i=1;i<101;i++) {
			if(i!=place) {
				str+= i + suffix(i) + ", "; 
			}
		}
		str=str.substring(0,str.length()-2);
		
		return str;
	}
	
	
	public static String suffix(int place) {
		int ones=place%10;
		int tens=place%100-ones;
		if(tens==10) {
			return "th";
		}
		if(ones==1) {
			return "st";
		}else if(ones==2) {
			return "nd";
		}else if(ones==3) {
			return "rd";
		}else {
			return "th";
		}
	}
}
