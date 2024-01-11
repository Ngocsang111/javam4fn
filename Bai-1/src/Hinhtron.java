import java.util.Scanner;

public class Hinhtron {
																						/* CÁCH 1
																						 
	 public static void main(String[] args) {
		System.out.print("Mời bạn nhập vào bán kính R: ");
		double R = new Scanner(System.in).nextDouble();
		float C = (float)(2*Math.PI*R);
		float S = (float)(Math.PI*Math.pow(R,2));
		
	System.out.println("Chu vi của hình tròn: " + C);
	System.out.println("Diện tích của hình tròn: " + S);
		
	}
}*/
																						//CÁCH 2
	
	private float R;
	private static final float pi=3.14f;
	
	public Hinhtron(float r){
		this.R=r;
	}
	
	public float chuVi() {
		return this.R * 2 * pi;
	}
	
	public float dienTich() {
		return this.R * this.R * pi;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ban kinh: ");
		float bankinh=scanner.nextFloat();
		
		Hinhtron c = new Hinhtron(bankinh);
		
		float cv = c.chuVi();
		float dt = c.dienTich();
		
		System.out.println("chu vi la " + cv);
		System.out.println("dien tich la " + dt);
	}
}
