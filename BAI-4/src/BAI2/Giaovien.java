package BAI2;

import java.util.Scanner;

public class Giaovien extends Person {
	private static String lopdangchunhiem;
	private static String tenbomon;
	private static String lichday;

	public Giaovien(String hoten, String gioitinh, String quequan, int namsinh, String lopdangchunhiem, String tenbomon,
			String lichday) {
		super(hoten, gioitinh, quequan, namsinh);
		this.lopdangchunhiem = lopdangchunhiem;
		this.tenbomon = tenbomon;
		this.lichday = lichday;

	}

	public String getLopdangchunhiem() {
		return lopdangchunhiem;
	}

	public void setLopdangchunhiem(String lopdangchunhiem) {
		this.lopdangchunhiem = lopdangchunhiem;
	}

	public String getTenbomon() {
		return tenbomon;
	}

	public void setTenbomon(String tenbomon) {
		this.tenbomon = tenbomon;
	}

	public String getLichday() {
		return lichday;
	}

	public void setLichday(String lichday) {
		this.lichday = lichday;
	}

	// in ra thời khoá biểu
	public static void hienthithoikhoabieu() {
		System.out.println("Lịch dạy:" + lichday);
	}

	// in ra thông tin lớp học
	public static void hienthithongtinlophoc() {
		System.out.println("tên bộ môn: " + tenbomon);
		System.out.println("lớp đang chủ nhiệm : " + lopdangchunhiem);

	}

	@Override
	public void nhapthongtin(Scanner scanner) {
		super.nhapthongtin(scanner);

		System.out.print("Lop dang chu nhiem: ");
		lopdangchunhiem = scanner.nextLine();
	
		System.out.print("Ten bo mon: ");
		tenbomon = scanner.nextLine();

		System.out.print("Lich day: ");
		lichday = scanner.nextLine();

	}

	@Override
	public void hienthithongtin() {
		super.hienthithongtin();

	}

}
