import java.util.Scanner;

public class triangle_height_star {
     public static void main(String[] args) {
         Scanner nhap = new Scanner(System.in);
         System.out.print("n=");
         int n = nhap.nextInt();
         int a=n;
         for (int i=1; i<=n; i++) {
             a=a-1;
             int soSao = 2*i -1;
             for(int j=0; j<=a; j++){
                 System.out.print(" ");
             }
             for (int j=1; j<=soSao; j++) {
                 System.out.print("*");
             }
             for(int j=0; j<=a; j++){
                 System.out.print(" ");
             }
             System.out.println();
         }
     }
}
