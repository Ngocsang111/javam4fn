package BAI2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// in ra thông tin lớp học

		System.out.println("nhập thông tin lớp học");
		Lophoc lophoc = new Lophoc();
		lophoc.nhapthongtin(sc);
		System.out.println(lophoc);

		//System.out.println("nhập thông tin học sinh");
		//Hocsinh hs = new Hocsinh(null, null, null, 0, null, null, null);
		//hs.nhapthongtin(sc);

		System.out.println("nhập thông tin giáo viên");
		Giaovien gv = new Giaovien(null, null, null, 0, null, null, null);
		gv.nhapthongtin(sc);

		//System.out.println("nhập thông tin nhân viên");
		//Nhanvien nv  = new Nhanvien(null, null, null, 0, null, null);
		//nv.nhapthongtin(sc);
		
		///hs.hienthithongtin();
		//hs.hienthithoikhoabieu();
		//hs.hienthithongtinlophoc();
		
		gv.hienthithongtin();
		gv.hienthithoikhoabieu();
		gv.hienthithongtinlophoc();
		
		//nv.hienthithongtin();
		
		
	}

}
