package cn.nju.algorithm.hiho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/**
 * @author zzf <tiaozhanzhe668@163.com>
 * @date 2017.11.17 
 * @description judge whether data satisfy giving regular.
 */
public class ValidateRegulation {
	
	public void process() {
		Scanner scan = new Scanner(System.in);
		int regularCount = scan.nextInt();
		scan.nextLine();
		String[] regulars = new String[regularCount];
		for(int i = 0; i < regulars.length;i++) {
			regulars[i] = scan.nextLine();
		}
		int variableCount = getVariable(regulars);
		Map<String,String> relation = new HashMap<String,String>();
		getRelation(relation,regulars);
		
		int testCaseCount = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < testCaseCount;i++) {
			String[] strs = new String[variableCount];
			for(int j = 0; j < strs.length;j++) {
				strs[j] = scan.nextLine();
			}
			boolean res = satisfy(relation,strs);
			System.out.println((res?"Yes":"No"));
		}
		
		scan.close();
	}
	
	
	private boolean satisfy(Map<String, String> relation, String[] strs) {
		Map<String,Integer> variableMap = new HashMap<String,Integer>();
		for(String str:strs) {
			String[] ss = str.split("\\s+");
			variableMap.put(ss[0], Integer.valueOf(ss[1]));
		}
		
		for(String key:relation.keySet()) {
			String[] temp = key.split("#");
			String leftStr = temp[0];
			String rightStr = temp[1];
			int left = variableMap.containsKey(leftStr)? variableMap.get(leftStr):Integer.valueOf(leftStr);
			int right = variableMap.containsKey(rightStr)? variableMap.get(rightStr):Integer.valueOf(rightStr);
			String operator = relation.get(key);
			int diff = left - right;
			if(operator.equals("<") && !(diff<0)) {
				return false;
			}
			else if(operator.equals("<=") && !(diff<=0)) {
				return false;
			}
			
		}
		
		return true;
	}


	private void getRelation(Map<String, String> relation, String[] regulars) {
		for(String regular:regulars) {
			String[] strs = regular.split("(?=\\<\\=|\\>\\=|\\<|\\>)|"
					+ "(?<=\\<\\=|\\>\\=|\\<|\\>)");
			List<String> array = new ArrayList<String>();
			for(String str:strs) {
				if(str.equals("=")) {
					String last = array.remove(array.size()-1);
					array.add(last+"=");
				}
				else {
					array.add(str);
				}
			}
			String left = array.get(0);
			String operator = array.get(1);
			String right = array.get(2);
			relation.put(left+"#"+right, operator);
			for(int i = 4; i < array.size();i+=2) {
				left = right;
				operator = array.get(i-1);
				right = array.get(i);
				relation.put(left+"#"+right, operator);
			}
		}
	}


	private int getVariable(String[] regulars) {
		Set<Character> set = new HashSet<Character>();
		for(String regular:regulars) {
			for(char ch:regular.toCharArray()) {
				if(ch>='A' && ch<='Z') {
					set.add(ch);
				}
			}
		}
		return set.size();
	}

	public void test(String str) {
		String[] strs = str.split("(?=\\<\\=|\\>\\=|\\<|\\>)|"
				+ "(?<=\\<\\=|\\>\\=|\\<|\\>)");
		System.out.println(strs);
	}
	
	public static void main(String[] args) {
		ValidateRegulation m = new ValidateRegulation();
//		String str = "A<B<=E";
//		m.test(str);
		m.process();
	}
}
