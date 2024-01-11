package Bai1;

import java.util.Scanner;

public class giaiPTbac2 {
	public static void main(String[] args) {
		System.out.print("Mời bạn nhập vào hệ số a: ");
		float a = new Scanner(System.in).nextFloat();
		System.out.print("Mời bạn nhập vào hệ số b: ");
		float b = new Scanner(System.in).nextFloat();
		System.out.print("Mời bạn nhập vào hệ số c: ");
		float c = new Scanner(System.in).nextFloat();
		
		float Delta = (float)Math.pow(b,2) - (4*a*c);

		if(Delta > 0) {
			float x1  = (float)(-b + Math.sqrt(Delta))/(2*a);
			float x2 = (float) (-b -Math.sqrt(Delta))/(2*a);
			System.out.println("Phương trình có hai nghiệm phân biệt: ");
			System.out.println("X1 = " + x1);
			System.out.println("X2 = " + x2);
		}else if(Delta == 0) {
			float x1 = (float) (-b/(2*a));
			System.out.print("Phương trình có nghiệm kép X1=X2 = " + x1 );
			
		}else{
			System.out.print("Phương trình vô nghiệm " );
		}

	}

}
