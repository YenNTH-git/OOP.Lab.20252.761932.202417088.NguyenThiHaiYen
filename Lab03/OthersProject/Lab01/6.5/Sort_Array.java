import java.util.Scanner;

public class Sort_Array {
    static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int sum=0;
        for(int i=0; i<n; i++){
            A[i] = sc.nextInt();
            sum += A[i];
        }
        int visit =0;
        for(int i=0; i<n-1; i++){
            int min= A[i];
            for(int j=i; j<n; j++){
                if(min> A[j]){
                    min=A[j];
                    visit=j;
                }
            }
            int tmp=A[i];
            A[i] = A[visit];
            A[visit] = tmp;
        }
        System.out.println("sum = " + sum);
        System.out.println("arg = " + sum/n);
        System.out.print("sort string: ");
        for(int i=0; i<n; i++){
            System.out.print(A[i] +" ");
        }
    }
}
