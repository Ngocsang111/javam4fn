package com.basic.bai1;

import java.util.Scanner;

public class MyMainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số thứ nhất x = ");
		double x = sc.nextDouble();
		System.out.print("Nhập số thứ nhất y = ");
		double y = sc.nextDouble();
		System.out.print("Nhập lệnh ACTION = ");
		String action = sc.next().toUpperCase().trim();
		double result = 0;
		
		switch (action) {
		case "CONG":
			result = CalculateUtils.tinhCong(x, y);
			break;
		case "TRU":
			result = CalculateUtils.tinhTru(x, y);
			break;
		case "NHAN":
			result = CalculateUtils.tinhNhan(x, y);
			break;
		case "CHIA":
			result = CalculateUtils.tinhChia(x, y);
			break;
		default:
			System.out.println("Giá trị ACTION không hợp lệ");
		}
		System.out.println("Kết quả: " + result);
				
	}

}
