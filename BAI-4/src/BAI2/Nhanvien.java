package BAI2;

import java.util.Scanner;

import BAI2.Person;

public class Nhanvien extends Person{
	private String phongban;
	private String chucvu;
	
	public Nhanvien(String hoten, String gioitinh, String quequan, int namsinh, String phongban, String chucvu) {
		super(hoten, gioitinh, quequan, namsinh);	
	}
	
	public String getPhongban() {
		return phongban;
	}
	public void setPhongban(String phongban) {
		this.phongban = phongban;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	@Override
	public void nhapthongtin(Scanner scanner) {
		super.nhapthongtin(scanner);

		System.out.print("phòng ban: ");
		phongban = scanner.nextLine();
	
		System.out.print("chức vụ: ");
		chucvu = scanner.nextLine();

	}

	@Override
	public void hienthithongtin() {
		super.hienthithongtin();

	}

}
