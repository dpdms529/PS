package bucketplace2022;

import java.util.*;

public class p3 {
	public static boolean isVariable(String var,String[][] variables) {
		for(String[] s : variables) {
			if(var.equals(s[0])) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasVariable(String tstring, String[][] variables) {
		boolean check = false;
		StringBuilder variable = new StringBuilder();
		for(int i = 0;i<tstring.length();i++) {
			char c = tstring.charAt(i);
			if(c == '{') {
				check = true;
				continue;
			}
			if(c == '}') {
				check = false;
				String var = variable.toString();
				if(isVariable(var, variables)) {
					return true;
				}
				variable = new StringBuilder();
				continue;
			}
			if(check) {
				variable.append(c);
			}
		}
		return false;
	}
	
	
	public static String solution(String tstring, String[][] variables) {
		String answer = tstring;
		while(hasVariable(answer, variables)) {
			StringBuilder sb = new StringBuilder();
			StringBuilder variable = new StringBuilder();
			boolean check = false;
			for(int i = 0;i<answer.length();i++) {
				char c = answer.charAt(i);
				if(c == '{') {
					check = true;
					continue;
				}
				if(c == '}') {
					check = false;
					String var = variable.toString();
					if(isVariable(var, variables)) {
						String value = "";
						for(String[] s : variables) {
							if(var.equals(s[0])) {
								value = s[1];
							}
						}
						sb.append(value);
					}else {
						sb.append("{" + var + "}");
					}
					variable = new StringBuilder();
					continue;
				}
				if(check) {
					variable.append(c);
				}else {
					sb.append(c);
				}
				
			}
			answer = sb.toString();
			System.out.println(answer);
		}
		return answer;
	}

	public static void main(String[] args) {
//		String tstring = "this is {template} {template} is {state}";
//		String[][] variables = {{"template","string"},{"state","changed"}};
		String tstring = "{a} {b} {c} {d} {i}";
		String[][] variables = {{"b","{c}"},{"a","{b}"},{"e","{f}"},{"h","i"},{"d","{e}"},{"f","{d}"},{"c","d"}};
		String result = solution(tstring, variables);
		System.out.println(result);

	}

}
