import java.util.Scanner;

public class Hinhchunhat {
	public static void main(String[] args) {
		System.out.print("Mời bạn nhập vào chiều dài a: ");
		int a = new Scanner(System.in).nextInt();
		System.out.print("Mời bạn nhập vào chiều rộng b: ");
		int b = new Scanner(System.in).nextInt();
		int C = ((a+b)*2);
		int S = (a*b);
		System.out.println("Chu vi hình chữ nhật: " + C);
		System.out.println("Diện tích hình chữ nhật: " + S);
	}
}
	/*public static class HinhChuNhat {
        public int dai;
        public int rong;

        public int tinhChuvi() {
            int chuvi = (this.dai + this.rong) * 2;
            return chuvi; 
        }
        
        public int tinhDienTich() {
            int dientich = this.dai * this.rong;
            return dientich;
        }
    }

    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào chiều dài: ");
        int chieudai = scanner.nextInt(); 
        hcn.dai = chieudai; 

        System.out.print("Nhập vào chiều rộng: ");
        int chieurong = scanner.nextInt();
        hcn.rong = chieurong; 

        int chuvi = hcn.tinhChuvi();
        int dientich = hcn.tinhDienTich();

        System.out.println("Chu vi hình chữ nhật = " + chuvi);
        System.out.println("Diện tích hình chữ nhật = " + dientich);

        
    }
}*/
