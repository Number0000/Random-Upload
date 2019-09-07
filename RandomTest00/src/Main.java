/*
 * First part: inheritance
 * Person.java -> Student _. Book
 * Book extend Student and use super to pass on object(student)
 * Student also contain Person
 * 
 * Second part: Checking random with sqrt digit
 * For example => an 8 digits number sqrt will become 4 digits numbers ?
 * 					6 digits for 3 digits
 * 					4 digits for 2 digits
 * 					...etc.
 * 
 */
import java.util.*;

public class Main {
	
	static Random random = new Random();
	static int flag_count = 0;
	static int consecutive_flag = 0;
	static int flag_consecutive_count = 0;
	static int false_play = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("printing");
//		
//		Person pn = new Person("NorthPole");
//		Student stu = new Student("Ash", pn);
//		Book book = new Book("Harry Potter and you", "Ash", pn);
//		System.out.print(book.toString());
//		System.out.println("\n\nended");		
		
		random = new Random();
		ArrayList<Double> list_fault = new ArrayList<Double>();
		
		Dictionary checking_list = new Hashtable();
		checking_list.put("1", "1");
		checking_list.put("2", "4");
		checking_list.put("3", "9");
		checking_list.put("4", "16");
		checking_list.put("5", "25");
		checking_list.put("6", "36");
		checking_list.put("7", "49");
		checking_list.put("8", "64");
		checking_list.put("9", "81");
		
		for(int i = 1; i < 1001; i++){
			int output = random_double();
			double output_sqrt = Math.sqrt(output);

			if(digit_a(output_sqrt, 4) == false){
				false_play++;
				list_fault.add(output_sqrt);
			}
			System.out.println(i + "))  " + "[" + output + "]  "+ output_sqrt);
		}
		System.out.println("flag_count....." + flag_count);
		System.out.println("false_play....." + false_play);
		System.out.println("flag_consecutive_count.." + flag_consecutive_count);
	}
	
	public static int random_double(){
		Random random = new Random();
		double input = random.nextDouble() * 100000000;
		if( digit_a(input, 8) == false){
			consecutive_flag++;
			flag_count++;
			if(consecutive_flag > 1){
				flag_consecutive_count++;
			}
			System.out.println("Flag..(" + flag_count + ").. " + 
					consecutive_flag + "=>" + input);
			return random_double();
		}
		consecutive_flag = 0;
		
		return (int) input;
		
	}
	
	public static boolean digit_a(double input, int a){
		int a_input = 1;
		for(int i = 1; i <= a-1; i++) a_input *= 10;
		if(input > a_input && input < (a_input * 10))	return true;
		else return false;
	}
	
	public static int simplified_sqrt(int input, Dictionary checking_list){
		int n = checking_list.size();
		//First part
		for (int i = 1; i < n; i++){
			
		}
		//Second part
		
		return (int) output;
	}
	
	public static int check_last_index(int input){
		String s = String.valueOf(input);
		int i = s.length();
		while(i > 0){
			i--;
		}
		return Integer.parseInt(s.substring(i));
	}
	
	
	

}
