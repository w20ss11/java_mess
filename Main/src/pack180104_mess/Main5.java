package pack180104_mess;

import java.util.Scanner;
import java.util.Stack;

public class Main5 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();//(+ (* 2 3) (+ 3 2))(add (mul 2 3) (add 3 2))
		string = string.replace("+", "add");
		string = string.replace("*", "mul");
		string = string.replace("^", "mya");
//		System.out.println(string);
				

		StringBuffer inputString = new StringBuffer(string);

		Stack<Integer> numberBuffer = new Stack<Integer>();
		Stack<String> operationBuffer = new Stack<String>();
		int mark = 0;
		int ParameterOne = 0;
		int ParameterTwe = 0;

		for(int index = 0;index<inputString.length();index++) {
			if('(' == inputString.charAt(index)) {
				operationBuffer.push(inputString.substring(index+1, index+4));
				index+=4;
				mark = index+1;
			}else if (')' == inputString.charAt(index)) {
				if(mark<index) {
					numberBuffer.push(Integer.parseInt(inputString.substring(mark, index)));
					index++;
					mark = index+1;
				}
				ParameterTwe = numberBuffer.pop();
				ParameterOne = numberBuffer.pop();

				switch(operationBuffer.pop()) {
				case "add":
					numberBuffer.push(ParameterOne + ParameterTwe);
					break;
				case "mya":
					numberBuffer.push(ParameterOne - ParameterTwe);
					break;
				case "mul":
					numberBuffer.push(ParameterOne * ParameterTwe);
					break;
				}

			}else {
				if(' ' == inputString.charAt(index)) {
					if(mark<index) {
						numberBuffer.push(Integer.parseInt(inputString.substring(mark, index)));
						//index++;
						mark = index+1;
					}
				}
			}
		}

		while(!operationBuffer.isEmpty()) {
			ParameterTwe = numberBuffer.pop();
			ParameterOne = numberBuffer.pop();

			switch(operationBuffer.pop()) {
			case "add":
				numberBuffer.push(ParameterOne + ParameterTwe);
				break;
			case "mya":
				numberBuffer.push(ParameterOne - ParameterTwe);
				break;
			case "mul":
				numberBuffer.push(ParameterOne * ParameterTwe);
				break;
			}

		}

		System.out.println(numberBuffer.pop().toString());//这里改成标准输出
		return;
	}

}
