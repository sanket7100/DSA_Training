package com.sanket.string;

public class MyStringTest {

	public static void main(String[] args) {
		MyString s1 = new MyString("sanket");
		 MyString s2 = new MyString("SHIVAM");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.toUpperCase());
		System.out.println(s2.toLowerCase());
		s1.toCharAt(3);
		System.out.println(s2.substr(2, 4));
	}
}

class MyString{
	char[] myString;

	public MyString(String s) {
		super();
		myString = new char[s.length()];
		for(int i=0;i<s.length();i++) {
			this.myString[i] = s.charAt(i);			
		}
	}
	
	public MyString() {
		super();
	}
	
	public String toUpperCase() {
		String str = "";
		for(int i=0;i<myString.length;i++) {
			if(myString[i]>='a' && myString[i]<='z') {
				str+= (char)(myString[i]-32);
			}else {
				str+=myString[i];
			}
		}
		return str;
	}
	
	public void toCharAt(int n) {
		char c = ' ';
		if(myString.length<n) System.out.println("Not valid position");
		else {
			c = myString[n-1];
		}
		System.out.println(c);
	}
	
	public String toLowerCase() {
		String str = "";
		for(int i=0;i<myString.length;i++) {
			if(myString[i]>='A' && myString[i]<='Z') {
				str+=(char)(myString[i]+32);
			}else {
				str+=myString[i];
			}
		}
		return str;
	}
	
	public String substr(int start,int end) {
		String str = "";
		if(end>myString.length) return null;
		for(int i=start;i<=end;i++) {
			str += myString[i];
		}
		return str;
	}

	@Override
	public String toString() {
		String s = "";
		for(char i : myString) {
			s+=i;
		}
		return s;
	}
	
	
	
}
