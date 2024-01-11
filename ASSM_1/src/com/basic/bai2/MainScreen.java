package com.basic.bai2;

import java.util.Scanner;

public class MainScreen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào một số nguyên bất kỳ: ");
		int n = sc.nextInt();
		
		//Tính tổng các số chẵn và tổng các số lẻ từ 0 đến N
		if(n>0) {
			int sumEven = 0;
			int sumOdd = 0;
		for(int i = 0; i <= n; i++) {
			if(i % 2 == 0) {
				sumEven += i;
			}else {
				sumOdd += i;
			}
		}
		System.out.println("Tổng các số chẵn từ 0 đến "+ n + " là: " + sumEven);
		System.out.println("Tổng các số lẻ từ 0 đến "+ n + " là: " + sumOdd);
		
		//đếm xem từ 0 đến n có bao nhiêu số  % 3 = 0 && % 2 != 0
		int count = 0;
		for (int i = 0; i <= n; i ++) {
			if(i % 3 == 0 && i % 2 != 0) {
			count++;
			}
		}
		System.out.println("Số lượng các số chia hết cho 3 nhưng không chia hết cho 2 từ 0 đến " + n + " là: " + count);
		}else {
			System.out.println("Vui lòng nhập số nguyên dương lớn hơn 0.");
		}
	}
}
