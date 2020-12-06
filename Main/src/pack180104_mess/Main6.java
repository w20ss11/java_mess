package pack180104_mess;

import java.util.Scanner;
import java.util.Stack;

public class Main6 {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {
			String string = scanner.nextLine();
			string = string.replace("+", "add");
			string = string.replace("*", "mul");
			string = string.replace("^", "mya");

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
					

					switch(operationBuffer.pop()) {
					case "add":
						ParameterTwe = numberBuffer.pop();
						ParameterOne = numberBuffer.pop();
						numberBuffer.push(ParameterOne + ParameterTwe);
						break;
					case "mya":
						ParameterTwe = numberBuffer.pop();
						numberBuffer.push(1 + ParameterTwe);
						break;
					case "mul":
						ParameterTwe = numberBuffer.pop();
						ParameterOne = numberBuffer.pop();
						numberBuffer.push(ParameterOne * ParameterTwe);
						break;
					}

				}else {
					if(' ' == inputString.charAt(index)) {
						if(mark<index) {
							numberBuffer.push(Integer.parseInt(inputString.substring(mark, index)));
							mark = index+1;
						}
					}
				}
			}

			while(!operationBuffer.isEmpty()) {

				switch(operationBuffer.pop()) {
				case "mya":
					ParameterTwe = numberBuffer.pop();
					numberBuffer.push(ParameterTwe + 1);
					break;
				case "add":
					ParameterTwe = numberBuffer.pop();
					ParameterOne = numberBuffer.pop();
					numberBuffer.push(ParameterOne + ParameterTwe);
					break;
				case "mul":
					ParameterTwe = numberBuffer.pop();
					ParameterOne = numberBuffer.pop();
					numberBuffer.push(ParameterOne * ParameterTwe);
					break;
				}

			}

			System.out.println(numberBuffer.pop().toString());//这里改成标准输出
		} catch (Exception e) {
			System.out.println("-1");
		}
		return;
	}

}
