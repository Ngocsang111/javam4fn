package Bai3;
import java.util.Scanner;

public class songuyento {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String songuyento = "";
		System.out.println("Nhập n: " );
		int n = sc.nextInt();
		for(int i = 1; i <= n; i ++) {
			int dem = 0;
			for(int j = i; j >= 1; j--) {
				if(i % j == 0) {
					dem ++;
				}
			}
			if(dem == 2) {
				songuyento = songuyento + i + " ";
			}
		}
		System.out.println("Tất cả các số nguyên tố từ 1 đến "+ n +" là: \n" + songuyento);
	}
}
