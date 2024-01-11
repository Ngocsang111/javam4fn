package Bai1;

import java.util.Scanner;

public class namnhuan {
	public static void main(String[] args) {
		System.out.print("Mời bạn nhập năm tương ứng: ");
		int year = new Scanner(System.in).nextInt();
		if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			System.out.println("Năm: " + year + " là năm nhuận");
		}else {
			System.out.println("Năm: " + year + " không phải là năm nhuận");
		}
	}

}
