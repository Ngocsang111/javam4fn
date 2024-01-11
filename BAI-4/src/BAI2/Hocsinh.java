package BAI2;

import java.util.List;
import java.util.Scanner;

import javax.management.remote.SubjectDelegationPermission;

public class Hocsinh extends Person{
	private static String lichhoc;
	private static String tenGVCN;
	private static String lophoc;

	
	public Hocsinh(String hoten, String gioitinh, String quequan, int namsinh, String lichhoc, String tenGVCN, String lophoc) {
		super(hoten, gioitinh, quequan, namsinh);
		this.lichhoc = lichhoc;
		this.tenGVCN = tenGVCN;
		this.lophoc = lophoc;
	}
	public String getLichhoc() {
		return lichhoc;
	}
	public void setLichhoc(String lichhoc) {
		this.lichhoc = lichhoc;
	}
	public String getTenGVCN() {
		return tenGVCN;
	}
	public void setTenGVCN(String tenGVCN) {
		this.tenGVCN = tenGVCN;
	}
	public String getLophoc() {
		return lophoc;
	}
	public void setLophoc(String lophoc) {
		this.lophoc = lophoc;
	}
	// in ra thời khoá biểu
	public static void hienthithoikhoabieu() {
		System.out.println("thời khoá biểu: " + lichhoc);
	}
	//in ra thông tin lớp học
	public static void hienthithongtinlophoc() {
		System.out.println("lớp đang học : " + lophoc);
		System.out.println("giáo viên chủ nhiệm : " + tenGVCN);
	}
	@Override
	public void nhapthongtin(Scanner scanner) {
		super.nhapthongtin(scanner);
		
		System.out.print("Lich hoc: ");
		lichhoc = scanner.nextLine();
		
		System.out.print("Ten GVCN: ");
		tenGVCN = scanner.nextLine();
		
		System.out.print("Lop hoc: ");
		lophoc = scanner.nextLine();
	}
	@Override
	public void hienthithongtin() {
		super.hienthithongtin();
	}
}
