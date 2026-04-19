import java.util.Scanner;

public class Add_2Matrices {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[m][m];
        int[][] b = new int[m][m];
        System.out.print("a = ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.print("b = ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                b[i][j] = sc.nextInt();
                a[i][j] += b[i][j];
            }
        }
        System.out.print("Sum = ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(a[i][j] +" ");
            }
        }
    }
}
