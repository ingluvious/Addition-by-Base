import java.lang.*;
import java.util.*;

public class Addition{
	
	public static void main(String args[]){
		
		int base = 0;
		String number1 = "";
		String number2 = "";
		
		
		Scanner input = new Scanner(System.in);
		
		//Input is Base - Number1 - Number2
		while(input.hasNext()) {
			if(input.hasNextInt()){
				base = input.nextInt();
				if(input.hasNext()){
					number1 = input.next();
					if(input.hasNext()){
						number2 = input.next();
					}
				}
			}
			
			if (number1.length() >= number2.length()) {
				calculateNumbers(base, number1, number2);
			} else {
				calculateNumbers(base, number2, number1);
			}
		}
	}
	
	
	public static void calculateNumbers(int baseToUse, String number1,
										String number2){
		int b = baseToUse;
		int carry = 0;
		int diff = number1.length() - number2.length();
		
		int calculatedNumber = 0;
		StringBuilder result = new StringBuilder("");
		
		
		for(int i = number1.length()-1; i >= 0; i--){
			if ((i-diff) >= 0) {
				calculatedNumber = (number1.charAt(i) + number2.charAt(i-diff))-96;
			} else {
				calculatedNumber = number1.charAt(i) - 48;
			}
			calculatedNumber += carry;
			
			carry = (calculatedNumber-baseToUse);
			
			if(carry < 0){
				carry = 0;
			} else {
				carry = 1;
			}
			result.insert(0,calculatedNumber%baseToUse);
			
		}
		if (carry == 1) {
			result.insert(0,carry);
		}
		carry = 0;
		
		System.out.println(result);
		divideNumbers(baseToUse, result.toString());
	}
	
	public static void divideNumbers(int baseToUse, String calculatedNumber){
		
		int result = 0;
		int value = 0;
		int carry = 0;
		String divideThisNumber = calculatedNumber;
		int remainderDuringCalc = 0;
		
		StringBuilder stringResult = new StringBuilder();
		
		
		
		for(int i = 0; i < divideThisNumber.length(); i++){
			if(carry == 1){
				value = (divideThisNumber.charAt(i)-48) + baseToUse;
			}
			else{
				value = (divideThisNumber.charAt(i)-48);
			}
			result = value/2;
			carry = value%2;
			stringResult.insert(i, result);
		}
		if(stringResult.charAt(0) == '0'){
			System.out.println(stringResult.substring(1, stringResult.length()));
		}
		else{
			System.out.println(stringResult);
		}
		System.out.println(carry);
		carry = 0;
	}
}
