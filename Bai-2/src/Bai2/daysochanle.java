package Bai2;
import java.util.Scanner;

public class daysochanle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Tong = 0;
		int N;
		
		do {
			System.out.print("Nhập vào số nguyên N = ");
			N = sc.nextInt();
			Tong = Tong + N;
		} while (Tong <= 100);
		System.out.println("Tong = " + Tong );
		
		if(N % 2 == 0) {
			System.out.println("Dãy số chẵn giảm dần: ");
			while (N > 0){
				System.out.print(N + " ");
				N = N - 2;
			}
		} else {
			System.out.println("Dãy số lẻ giảm dần: ");
			while (N > 0) {
				System.out.print(N + " ");
				N = N -2;
			}
		}
		
	}

}

