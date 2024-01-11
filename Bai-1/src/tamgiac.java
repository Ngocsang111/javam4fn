// 

//ĐỀ BÀI HÃY VIẾT CHƯƠNG TRÌNH NHẬP VÀO 3 CẠNH CỦA TAM GIÁC VÀ DÙNG ĐÚNG / TRY - CATCH ĐỂ BẮT NGOẠI LỆ CỦA NGƯỜI DÙNG NHẬP KHI NHẬP VÀO, SAU ĐÓ TÍNH RA CHU VI VÀ DIỆN TÍCH CỦA TAM GIÁC ĐÓ.										***CÁCH 1*** ĐÃ CHẠY THỬ OKI

/*import java.util.Scanner;

public class tamgiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;

        a = nhapCanh(scanner, "a");
        b = nhapCanh(scanner, "b");
        c = nhapCanh(scanner, "c");

        double chuVi = a + b + c;
        double nuaChuVi = chuVi / 2;
        double dienTich = Math.sqrt(nuaChuVi * (nuaChuVi - a) * (nuaChuVi - b) * (nuaChuVi - c));

        System.out.println("Chu vi của tam giác là: " + chuVi);
        System.out.println("Diện tích của tam giác là: " + dienTich);
    }

    public static double nhapCanh(Scanner scanner, String tenCanh) {
        while (true) {
            try {
                System.out.print("Nhập độ dài cạnh " + tenCanh + ": ");
                double canh = Double.parseDouble(scanner.nextLine());
                if (canh <= 0) {
                    throw new IllegalArgumentException("Cạnh " + tenCanh + " phải là số dương");
                }
                return canh; // Trả về giá trị nếu nhập thành công và hợp lệ
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng chỉ nhập số");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}*/

//										 *** CÁCH 2*** ĐÃ CHẠY THỬ OKI


import java.util.Scanner;

public class tamgiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        
        do {
            try {
                System.out.print("Nhập độ dài cạnh a: ");
                a = Double.parseDouble(scanner.nextLine());
                
                if (a <= 0) {
                    throw new IllegalArgumentException("Cạnh tam giác phải là số dương!");
                }
                
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        
        do {
            try {
                System.out.print("Nhập độ dài cạnh b: ");
                b = Double.parseDouble(scanner.nextLine());
                
                if (b <= 0) {
                    throw new IllegalArgumentException("Cạnh tam giác phải là số dương!");
                }
                
               break;
           } catch (NumberFormatException e) { 
               System.out.println("Vui lòng nhập số!");
           } catch (IllegalArgumentException e) { 
               System.out.println(e.getMessage());
           }
       } while(true);

       do{
           try{
               System.out.print("Nhập độ dài cạnh c: ");
               c = Double.parseDouble(scanner.nextLine());

               if(c<=0){
                   throw new IllegalArgumentException(("Cạnh tam giác phải là số dương!"));
               }

               break;
           } catch (NumberFormatException e){
               System.out.println("Vui lòng nhập số!");
           } catch (IllegalArgumentException e){
               System.out.println(e.getMessage());
           }
       } while(true);

       // Tính chu vi và diện tích tam giác
       double CV = a + b + c;
       double p = CV / 2; // Nửa chu vi
       double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));

       System.out.println("Chu vi của tam giác là: " + CV);
       System.out.println("Diện tích của tam giác là: " + S);
   }
}


 /*                                                *** CÁCH 3***  ĐÃ CHẠY THỬ OKI
  
  

import java.util.Scanner;

public class tamgiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;

        while (true) {
            try {
                System.out.print("Nhập độ dài cạnh a: ");
                a = Double.parseDouble(scanner.nextLine());
                if (a <= 0) {
                    throw new IllegalArgumentException("Cạnh a phải là số dương");
                }

                System.out.print("Nhập độ dài cạnh b: ");
                while (true) {
                    try {
                        b = Double.parseDouble(scanner.nextLine());
                        if (b <= 0) {
                            throw new IllegalArgumentException("Cạnh b phải là số dương");
                        }
                        break; // Thoát khỏi vòng lặp khi nhập thành công và hợp lệ
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng chỉ nhập số");
                        System.out.print("Nhập độ dài cạnh b: ");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.print("Nhập độ dài cạnh b: ");
                    }
                }

                System.out.print("Nhập độ dài cạnh c: ");
                while (true) {
                    try {
                        c = Double.parseDouble(scanner.nextLine());
                        if (c <= 0) {
                            throw new IllegalArgumentException("Cạnh c phải là số dương");
                        }
                        break; // Thoát khỏi vòng lặp khi nhập thành công và hợp lệ
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng chỉ nhập số");
                        System.out.print("Nhập độ dài cạnh c: ");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.print("Nhập độ dài cạnh c: ");
                    }
                }

                break; // Thoát khỏi vòng lặp nếu nhập thành công và hợp lệ
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng chỉ nhập số");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

     // Tính chu vi và diện tích tam giác
        double CV = a + b + c;
        double p = CV / 2; // Nửa chu vi
        double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println("Chu vi của tam giác là: " + CV);
        System.out.println("Diện tích của tam giác là: " + S);
    }
}*/

