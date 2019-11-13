package com.cvc.springboot;

public class Test {
	public static void main(String[] args) {
		int result = run(run(run(1,2,"+"),run(run(5,6,"*"),7,"-"),"+"),run(3,4,"/"),"+");
		System.out.println(result);
	}
	public static int run(int r,int l,String o){
		switch (o) {
		case "+":
			return r+l;
		case "-":
			return r-l;
		case "*":
			return r*l;
		case "/":
			return r/l;
		default:
			return 0;
		}
	}
}
