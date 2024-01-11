package POI;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class danhsachnhanvien {
	private static final Scanner scanner = null;
	private int STT;
	private String MaNhanVien;
	private String Hoten;
	private String Gioitinh;
	private String Namsinh;
	private String Quequan;
	private String Tenphongban;
	private float Luong;

public danhsachnhanvien(int STT, String MaNhanVien, String Hoten, String Gioitinh, String Namsinh, String Quequan, String Tenphongban, float Luong) {
	this.MaNhanVien = MaNhanVien;
	this.Hoten = Hoten;
	this.Gioitinh = Gioitinh;
	this.Namsinh = Namsinh;
	this.Quequan = Quequan;
	this.Tenphongban = Tenphongban;
	this.Luong = Luong;
	}
	
	public int getSTT() {
		return STT;
	}
	public void setSTT(int sTT) {
		STT = sTT;
	}
	public String getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getHoten() {
		return Hoten;
	}
	public void setHoten(String hoten) {
		Hoten = hoten;
	}
	public String isGioitinh() {
		return Gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		Gioitinh = gioitinh;
	}
	public String getNamsinh() {
		return Namsinh;
	}
	public void setNamsinh(String namsinh) {
		Namsinh = namsinh;
	}
	public String getQuequan() {
		return Quequan;
	}
	public void setQuequan(String quequan) {
		Quequan = quequan;
	}
	public String getTenphongban() {
		return Tenphongban;
	}
	public void setTenphongban(String tenphongban) {
		Tenphongban = tenphongban;
	}
	public float getLuong() {
		return Luong;
	}
	public void setLuong(float luong) {
		Luong = luong;
	}


@SuppressWarnings("resource")
public static void writeToExcelFile(ArrayList<danhsachnhanvien> data) {
	
	// khởi tạo workbook cho tệp
	XSSFWorkbook workbook = new XSSFWorkbook();
	// khởi tạo 1 worksheet mới từ workbook
	XSSFSheet sheet = workbook.createSheet("User Details");
	
	// Create title ID/FIRSTNAME/LASTNAME
	XSSFRow titleRow = sheet.createRow(0);
	XSSFCell cell = titleRow.createCell(0);
	cell = titleRow.createCell(0);
	cell.setCellValue("STT");
	cell = titleRow.createCell(1);
	cell.setCellValue("MaNhanVien");
	cell = titleRow.createCell(2);
	cell.setCellValue("Hoten");
	cell = titleRow.createCell(3);
	cell.setCellValue("Gioitinh");
	cell = titleRow.createCell(4);
	cell.setCellValue("Namsinh");
	cell = titleRow.createCell(5);
	cell.setCellValue("Quequan");
	cell = titleRow.createCell(6);
	cell.setCellValue("Tenphongban");
	cell = titleRow.createCell(7);
	cell.setCellValue("Luong");
	
	// Create data
	for (int i = 0; i < data.size();i ++) {
		danhsachnhanvien u = data.get(i);
		XSSFRow localRow = sheet.createRow(i+1);  //row 0 for title;
		XSSFCell localCell = localRow.createCell(0);
		localCell.setCellValue(String.valueOf(u.getSTT()));
		localCell = localRow.createCell(1);
		localCell.setCellValue(u.getMaNhanVien());
		localCell = localRow.createCell(2);
		localCell.setCellValue(u.getHoten());
		localCell = localRow.createCell(3);
		localCell.setCellValue(u.isGioitinh());
		localCell = localRow.createCell(4);
		localCell.setCellValue(u.getNamsinh());
		localCell = localRow.createCell(5);
		localCell.setCellValue(u.getQuequan());
		localCell = localRow.createCell(6);
		localCell.setCellValue(u.getTenphongban());
		localCell = localRow.createCell(7);
		localCell.setCellValue(u.getLuong());
	}
	try {
		// ghi dữ liệu xuống file

		FileOutputStream out = new FileOutputStream(new String("Drive của tôi\\Tester\\MÔN 4\\Book1.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("data.xlsx write successfully on disk.");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void main (String[] args) {
	@SuppressWarnings("resource")
	Scanner sc = new Scanner (System.in);
	System.out.print("Nhập vào SL: ");
	int N = Integer.parseInt(sc.nextLine());
	
	// Tạo arrayList để lưu data
	
	ArrayList<danhsachnhanvien> data = new ArrayList<danhsachnhanvien>();
	
	//Nhập danh sách user
	
	String MaNhanvien;
	String Hoten;
	String Gioitinh;
	String Namsinh;
	String Quequan;
	String Tenphongban;
	Float Luong;
	
	for(int i = 0; i < N; i ++) {
		System.out.print("Mã nhân viên: ");
		MaNhanvien = sc.nextLine();
		System.out.print("Họ tên: ");
		Hoten = sc.nextLine();
		System.out.print("Giới tính: ");
		Gioitinh = sc.nextLine();
		System.out.print("Năm sinh: ");
		Namsinh = sc.nextLine();
		System.out.print("Quê quán: ");
		Quequan = sc.nextLine();
		System.out.print("Tên phòng ban: ");
		Tenphongban = sc.nextLine();
		System.out.print("Lương: ");
		Luong = Float.parseFloat(sc.nextLine());
		
		
		danhsachnhanvien u = new danhsachnhanvien( i + 1, MaNhanvien, Hoten, Gioitinh, Namsinh, Quequan, Tenphongban, Luong);
		data.add(u);
	}

	// ghi excel file
	
	writeToExcelFile(data);
}}

