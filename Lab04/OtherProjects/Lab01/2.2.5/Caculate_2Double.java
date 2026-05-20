import java.util.Scanner;

public class Caculate_2Double {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double num1 = sc.nextDouble();
        Double num2 = sc.nextDouble();
        System.out.println("Tong = " + (num1 + num2));
        System.out.println("Hieu = " + (num1 - num2));
        System.out.println("Tich = " + num1 * num2);
        if (num2 != 0) {
            double thuong = num1 / num2;
            System.out.println("Thuong = " + thuong);
        } else {
            System.out.println("Khong the chia cho 0!");
        }
    }
}
