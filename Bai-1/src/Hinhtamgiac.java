import java.util.Scanner;

public class Hinhtamgiac {
	/*
	public static  void main (String[] args) {
		System.out.print("Mời bạn nhập vào cạnh a: ");
		int a = new Scanner(System.in).nextInt();
		System.out.print("Mời bạn nhập vào cạnh b: ");
		int b = new Scanner(System.in).nextInt();
		System.out.print("Mời bạn nhập vào cạnh c: ");
		int c = new Scanner(System.in).nextInt();
	
		int C = (a+b+c);
		float P = (float)(C/2);
		float S = (float)Math.sqrt(P*(P-a)*(P-b)*(P-c));
	
		System.out.println("Chu vi hình tam giác: " + C);
		System.out.println("Nửa chu vi tam giác: " +  P);
		System.out.println("Diện tích tam giác: " + S);
	
	}
}*/

	public double a;
    public double b;
    public double c;

    public double tinhChuVi() {
        return a + b + c;
    }

    public double tinhDienTich() {
        double p = tinhChuVi() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hinhtamgiac hinhtamgiac = new Hinhtamgiac();

        System.out.print("Nhập vào cạnh a: ");
        hinhtamgiac.a = scanner.nextDouble();

        System.out.print("Nhập vào cạnh b: ");
        hinhtamgiac.b = scanner.nextDouble();

        System.out.print("Nhập vào cạnh c: ");
        hinhtamgiac.c = scanner.nextDouble();

        double chuvi = hinhtamgiac.tinhChuVi();
        double dientich = hinhtamgiac.tinhDienTich();

        System.out.println("Chu vi tam giác = " + chuvi);
        System.out.println("Diện tích tam giác = " + dientich);
    }
}
