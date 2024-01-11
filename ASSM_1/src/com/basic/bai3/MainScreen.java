package com.basic.bai3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainScreen {
	static boolean ans = true;
	static String dob, yes;
	static float grade;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[]args) {
		//sử sụng vòng lặp do-while để nhập thông tin student từ bàn phím
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<Student>();
		String choice = "";
		do {
			Student student = new Student();
			System.out.print("Nhập họ tên: ");
			student.setFullName(sc.nextLine().trim().toUpperCase());
			
			System.out.print("Nhập địa chỉ: ");
			student.setAddress(sc.nextLine().trim().toUpperCase());
			
			do {
				System.out.print("BirthDate: ");
				dob = sc.nextLine();
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				try {
					df.parse(dob);
					ans = true;
				}catch (Exception e) {
					System.out.println("Nhập sai thông tin DoB (dd/MM/yyyy)");
					ans = false;
				}
				
				if(ans) {
					student.setDob(dob);
					ans = false;
					break;
				}
				
			}while(!ans);
			
			System.out.print("Nhập giới tính: ");
			student.setGender(sc.nextLine().trim());
			
			
			do{
				try {
					System.out.print("FinalGrade: ");
					grade = Float.parseFloat(sc.nextLine());
					if(grade >= 0 && grade <= 10) {
						student.setFinalGrade(grade);
						ans = true;
						break;
					}else {
						System.out.println("Nhập sai số liệu");
						ans = false;
					}
				}catch(Exception ex) {
					System.out.println("Nhập sai định dạng");
					ans = false;
				}
			}while(!ans);
			
			sc.nextLine();
			students.add(student);
			
			System.out.println("Do you want to continue (Y/N)? ");
			choice = sc.nextLine();
		
		}while (choice.equalsIgnoreCase("Y"));
		
		//In ra tất cả Student trong danh sách theo định dạng
		for(int i = 0; i <students.size(); i++) {
			System.out.print("\nStudent " + (i + 1) + ": ");
			System.out.print("\nFullname: " + students.get(i).getFullName());
			
			System.out.print("\nAddress: " + students.get(i).getAddress());
			
			System.out.print("\nDOB: " + students.get(i).getDob());
			
			System.out.print("\nGender: " + students.get(i).getGender());
			
			System.out.print("\nFinalGrade: " + students.get(i).getFinalGrade());
		}
		
	System.out.println("\nDanh sách tất cả Student");
	
			// in ta tất cả Student vừa nhập
		for(int i = 0; i < students.size(); i ++) {
			System.out.println("Học sinh " + students.get(i).getFullName() + " " + checkGrade(students.get(i).getFinalGrade()));
		}
		System.out.println("Danh sách tất cả Student vừa nhập");
		float total = 0;
		for(int i = 0; i < students.size(); i ++) {
			total += students.get(i).getFinalGrade();
		}
		System.out.println("tổng kết trung bình: " + total/students.size());	
	}
	
	public static String checkGrade(Float finalGrade) {
		if(finalGrade < 4.0) {
			return "học lực kém";
		}
		if(finalGrade >= 4.0 && finalGrade < 5.0) {
			return "học lực yếu";
		}
		if(finalGrade >= 5.0 && finalGrade < 5.5) {
			return "học lực trung bình yếu";
		}
		if(finalGrade >= 5.5 && finalGrade < 6.5) {
			return "học lực trung bình";
		}
		if(finalGrade >= 6.5 && finalGrade < 7.0) {
			return "học lực trung bình khá";
		}
		if(finalGrade >= 7.0 && finalGrade < 8.0) {
			return "học lực khá";
		}
		if(finalGrade >= 8.0 && finalGrade < 8.5) {
			return "học lực khá giỏi";
		}
		return "học lực giỏi";
		
	}
}
