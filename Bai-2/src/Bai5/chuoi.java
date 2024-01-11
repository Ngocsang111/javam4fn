package Bai5;

public class chuoi {
	public static void main(String[] args) {
	// sử dụng class Scanner để nhập dữ liệu từ bàn phím.
		String input = "xinchao";
		input = input.toUpperCase();
		String chuoi1 = input.substring(0,3).toUpperCase();
		String chuoi2 = input.substring(3 );
		System.out.println("Substring chuoi1: " + chuoi1);
		System.out.println("Substring chuoi2: " + chuoi2);
		String result = chuoi1 + chuoi2;
		System.out.println(result);
		
	}

}
