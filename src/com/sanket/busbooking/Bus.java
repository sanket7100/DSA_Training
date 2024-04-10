package com.sanket.busbooking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bus {

	private static Map<Integer, Integer> map;

	private static int availableTickets = 3;

	static {
		map = new HashMap<>();
		map.put(1,0);//"Mumbai-Surat"
		map.put(2,0);//Surat-Rajasthan
		map.put(3,0);//Mumbai-Rajasthan
		map.put(4,0);//Rajasthan-Delhi
		map.put(5,0);//Surat-Delhi
		map.put(6,0);//Mumbai-Delhi
	}

	static void book(Integer route) {
		switch (route) {
		case 1:{
			if(availableTickets>0) {
				int count=map.get(1);
				map.put(1, count+1);
				availableTickets--;
				System.out.println("Booking Available");
				System.out.println("---------------------");
				break;
			}else {
				System.out.println("Seat Not Available");
				System.out.println("---------------------");
				break;
			}
		}
		case 2:{
			availableTickets+=map.get(1);
			if(availableTickets>0) {
				int count=map.get(2);
				map.put(2, count+1);
				availableTickets--;
				System.out.println("Booking Available");
				System.out.println("---------------------");
			}else {
				System.out.println("Seat Not Available");
				System.out.println("---------------------");
			}
			availableTickets-=map.get(1);
			break;
		}
		
		case 3:{
			int tickets=map.get(1)+map.get(2);
			availableTickets+=tickets;
			if(availableTickets>0) {
				int count=map.get(3);
				map.put(3, count+1);
				availableTickets--;
				System.out.println("Booking Available");
				System.out.println("---------------------");
			}else {
				System.out.println("Seat Not Available");
				System.out.println("---------------------");
			}
			availableTickets-=tickets;
			break;
		}
		
		case 4:{
			int tickets=map.get(1)+map.get(2)+map.get(3);
			availableTickets+=tickets;
			if(availableTickets>0) {
				int count=map.get(4);
				map.put(4, count+1);
				availableTickets--;
				System.out.println("Booking Available");
				System.out.println("---------------------");
			}else {
				System.out.println("Seat Not Available");
				System.out.println("---------------------");
			}
			availableTickets-=tickets;
			break;
		}
		
		case 5:{
			int tickets=map.get(1);
			availableTickets+=tickets;
			if(availableTickets>0) {
				int count=map.get(5);
				map.put(5, count+1);
				availableTickets--;
				System.out.println("Booking Available");
				System.out.println("---------------------");
			}else {
				System.out.println("Seat Not Available");
				System.out.println("---------------------");
			}
			availableTickets-=tickets;
			break;
		}
		
		case 6:{
			if(availableTickets>0) {
				int count=map.get(6);
				map.put(6, count+1);
				availableTickets--;
				System.out.println("Booking Available");
				System.out.println("---------------------");
				break;
			}else {
				System.out.println("Seat Not Available");
				System.out.println("---------------------");
				break;
			}
		}
		default:{
			System.out.println("Select Valid Route");
			System.out.println("---------------------");
			break;
		}
		
		}
	}

	public static void main(String[] args) {
		
		boolean wantToBook=true;
		Scanner s = new Scanner(System.in);
		
		while(wantToBook) {
			System.out.println("Where Do You Want To Go And From Where");
			System.out.println("1)Mumbai-Surat");
			System.out.println("2)Surat-Rajasthan");
			System.out.println("3)Mumbai-Rajasthan");
			System.out.println("4)Rajasthan-Delhi");
			System.out.println("5)Surat-Delhi");
			System.out.println("6)Mumbai-Delhi");
			System.out.println("-----------------------------------------------------");
			System.out.println("Select From 1 to 6");
			int route = s.nextInt();
			book(route);
			System.out.println("Do You Want To Book Y/N Another Trip");
			String choice=s.next();
			if(choice.equalsIgnoreCase("N")) {
				wantToBook=false;
			}
			
		}
		
	}
}
