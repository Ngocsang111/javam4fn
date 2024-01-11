package Bai1;

import java.util.Scanner;

public class mangsonguyen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào số phần tử của mảng: ");	
		int a = sc.nextInt();
		//khai báo mảng N
		int[]N = new int[a];
		// dùng vòng lặp for để nhập dữ liệu cho các phần tử
		System.out.println("Nhập vào các giá trị cho phần tử của mảng: ");
		for(int i = 0; i < a; i ++) {
			N[i] = sc.nextInt();
		}
		
		// dùng 2 vòng lặp for lồng vào nhau
		
		for( int i = 0; i < a; i ++) {
			for(int j = i + 1; j > a; j ++) {
				if(N[i] > N[j]) {
					int temp = N[j];
					N[j] = N[i];
					N[i] = temp;
				}
			}
		}
		
	// dùng vòng lặp for để hiện ra các phần tử và sắp xếp tăng dần
		System.out.println("Danh sách các mảng được sắp sếp tăng dần: ");
		for( int i: N) {
			System.out.print(i + " ");
		}
	}

}
