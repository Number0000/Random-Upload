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
import java.text.DecimalFormat;
import java.util.*;

public class Main {
	
	static Random random = new Random();
	static int flag_count = 0;
	static int consecutive_flag = 0;
	static int flag_consecutive_count = 0;
	static int false_play = 0;
	static int checkError_count = 0;
	
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
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(3);
		
		for(int i = 1; i < 1001; i++){
			int output = randomDouble();
			double output_real = Math.sqrt(output);

			if(digitA(output_real, 4) == false){
				false_play++;
				list_fault.add(output_real);
			}
			double output_sqrt = simplifiedSqrt(output);
			System.out.println(i + "))  " + "[" + output + "]  " +
					df.format(output_sqrt) + "  =>  " + output_real);
		}
		System.out.println("flag_count....." + flag_count);
		System.out.println("false_play....." + false_play);
		System.out.println("checkError....." + checkError_count);
		System.out.println("flag_consecutive_count.." + flag_consecutive_count + "\n");
//		double output_sqrt = simplifiedSqrt(1522);
//		System.out.println(df.format(output_sqrt));

	}
	
	public static int randomDouble(){
		Random random = new Random();
		double input = random.nextDouble() * 100000000;
		if( digitA(input, 8) == false){
			consecutive_flag++;
			flag_count++;
			if(consecutive_flag > 1){
				flag_consecutive_count++;
			}
			System.out.println("Flag..(" + flag_count + ").. " + 
					consecutive_flag + "=>" + input);
			return randomDouble();
		}
		consecutive_flag = 0;
		
		return (int) input;
		
	}
	
	public static boolean digitA(double input, int a){
		int a_input = 1;
		for(int i = 1; i <= a-1; i++) a_input *= 10;
		if(input > a_input && input < (a_input * 10))	return true;
		else return false;
	}
	
	public static double simplifiedSqrt(int input){
		int n = 0;
		int index = 2;
		boolean flag = false;
		int numerator = 0, denominator = 1;
		double results;
		//First part
		for (int i = 2; i <= input/2; i++){
			n = squared(i);
			index = i;
			if (n == input){
				flag = true;
				break;
			}
			if (n > input){
				break;
			}
		}
		//Testing part
//		System.out.println("index = " + (index-1) + " n = " + squared(index-1) + " input = " + input);
//		System.out.println("index = " + index + " n = " + n + " input = " + input);

		//Second part
		if (flag == false){
			numerator = input - squared(index - 1);
			denominator = 2 * (index-1);
			results = (index - 1) + (double) (numerator) / denominator;
		} else {
			numerator = 0;
			denominator = 1;
			results = index;
		}
		
		System.out.println(flag + " " + results + " => " + (index-1) + " " + numerator + " / "  + denominator);
		if(checkError(Math.sqrt(input), results) == false){
			System.out.println("Flag..(" + checkError_count + ").. " + 
					"..real.." + Math.sqrt(input) + " hypothesis " + results);
			checkError_count++;
		}
		return (double) results;
	}
	
	public static int checkLastIndex(int input){
		String s = String.valueOf(input);
		int i = s.length();
		while(i > 0){
			i--;
		}
		return Integer.parseInt(s.substring(i));
	}
	
	public static int squared(int input){
		return input * input;
	}
	
	public static boolean checkError(double d, double results){
		double error_rate = 1.0;
		double floor_error = results - error_rate;
		double ceiling_error = results + error_rate;
		if (d >= floor_error && d <= ceiling_error)	return true;
		else	return false;
	}
	
	

}
