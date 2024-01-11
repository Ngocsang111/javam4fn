package BAI2;

import java.util.Scanner;

public class Person implements hienthi {
	protected static String hoten;
	protected static String gioitinh;
	protected static String quequan;
	protected static int namsinh;

	public Person(String hoten, String gioitinh, String quequan, int namsinh) {
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.quequan = quequan;
		this.namsinh = namsinh;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getQuequan() {
		return quequan;
	}

	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	// IN ra thông tin cơ bản

	public void hienthithongtin() {
		System.out.println("Hoten: " + hoten);
		System.out.println("Gioitinh: " + gioitinh);
		System.out.println("Quequan: " + quequan);
		System.out.println("Namsinh: " + namsinh);
	}

	// Nhập thông tin từ bàn phím
	public void nhapthongtin(Scanner scanner) {
		System.out.print("Nhap ho ten: ");
		hoten = scanner.nextLine();

		System.out.print("Nhap gioi tinh: ");
		gioitinh = scanner.nextLine();

		System.out.print("Nhap que quan: ");
		quequan = scanner.nextLine();

		System.out.print("Nhap nam sinh: ");
		namsinh = Integer.parseInt(scanner.nextLine());
	}

}
