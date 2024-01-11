package Bai2;
import java.util.ArrayList;
import java.util.Scanner;
public class animails {
	String name;
	double weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	public static void main(String[] args) throws Exception {
		
		/*Tạo list chứa dữ liệu*/
		ArrayList<animails> animal = new ArrayList<animails>();
		
		/* vòng lặp nhập và lưu dữ liệu vào list*/
		do {
			Scanner sc = new Scanner(System.in);
			animails b2 = new animails();
			System.out.print("Tên loài động vậy: ");
			b2.setName(sc.nextLine());
			System.out.print("Cân nặng: ");
			b2.setWeight(sc.nextDouble());
			
			animal.add(b2);
		}while(animal.size() < 5);
	
		/* in thông tin đã nhập */
		for( int i = 0; i < animal.size(); i++) {
			System.out.println("Thông tin animal thứ " + (i+1) + ": ");
			System.out.println("Tên: " + animal.get(i).getName() + "\n" +"Cân nặng: " + animal.get(i).getWeight());
		}
		// tìm giá trị lớn nhất
		double maxweightAnimal = animal.get(0).getWeight();
			for(int i=1; i < animal.size(); i++) {
				if(animal.get(i).getWeight() > maxweightAnimal) {
					maxweightAnimal = animal.get(i).getWeight();
				}
			}
			
				// in ra thông tin Animal có weight lớn nhất
			for(int i = 0; i < animal.size(); i++) {
				if(maxweightAnimal == animal.get(i).getWeight()) {
					System.out.println(animal.get(i).getName()+ " is " + animal.get(i).getWeight());			
					}
			}		
	}
}