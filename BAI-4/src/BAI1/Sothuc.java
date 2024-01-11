package BAI1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sothuc {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		try {
			// Nhập 2 số thực a và b
			System.out.print("Nhập số thực a: ");
			float a = sc.nextFloat();
			System.out.print("Nhập số thực b: ");
			float b = sc.nextFloat();
			
			// goi hàm chia để lấy ra phần nguyên kết quả phép chia a/b
			int quotient = divide(a, b);
			//in kết quả
			System.out.println("kết quả phép chia a/b: " + quotient);
		} catch (InputMismatchException e){
			//bắt ngoại lệ nếu người dùng nhập vào không phải là số
			System.out.println("Lỗi: Bạn đã nhập vào không phải là số!");
		} finally{
			// đóng scanner
			sc.close();
		}
		
	}

	private static int divide(float a, float b) {
		// hàm chia để lấy ra phần nguyên kết quả phép chia a/b
		try {
			if(b == 0) {
				throw new ArithmeticException();
			}
			return(int) (a/b);
		} catch (ArithmeticException e) {
			//nếu số chia bằng 0, ném ngoại lệ lên cho hàm gọi xử lý 
			System.out.println("Lỗi: Phép chia không hợp lệ ( số chia bằng 0)!");
		}
		return 0;
	}

}
