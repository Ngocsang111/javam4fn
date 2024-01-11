package Bai4;
import java.util.Scanner;

public class chondapandung {
	public static void main(String[] args){
		char result = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Gói nào trong java chứ lớp Scanner dùng để nhập dữ liệu từ bàn phím" + "trong 4 đáp án sau? ");
		System.out.println("A. java.net");
		System.out.println("B. java.io");
		System.out.println("C. java.util");
		System.out.println("D. java.awt");
		
		System.out.println("Câu trả lời của bạn: ");
		String input = sc.nextLine();
		input = input.trim();
		input = input.toUpperCase();	
		switch  (input){
		case "A":
		case "B":
		case "D":
			System.out.println("Câu trả lời không chính xác!");
			break;
		case "C":
			System.out.println("Xin chúc mừng bạn! ");
			break;
		default:
			System.out.println("Đáp án không hợp lệ! ");
		}
	}

}
