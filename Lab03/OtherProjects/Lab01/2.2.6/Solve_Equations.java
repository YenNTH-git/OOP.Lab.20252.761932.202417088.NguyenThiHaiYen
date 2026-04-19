import java.util.Scanner;

public class Solve_Equations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("0 - Giai PT bac 1");
        System.out.println("1 - Giai he PT 2 an");
        System.out.println("2 - Giai PT bac 2");
        int choice = sc.nextInt();

        switch (choice) {
            case 0:
                System.out.print("a = ");
                double a = sc.nextDouble();
                System.out.print("b = ");
                double b = sc.nextDouble();

                if (a == 0) {
                    if (b == 0) {
                        System.out.println("Vo so nghiem");
                    } else {
                        System.out.println("Vo nghiem");
                    }
                } else {
                    double x = -b / a;
                    System.out.println("Nghiem x = " + x);
                }
                break;

            case 1:
                System.out.print("a11 = ");
                double a11 = sc.nextDouble();
                System.out.print("a12 = ");
                double a12 = sc.nextDouble();
                System.out.print("b1 = ");
                double b1 = sc.nextDouble();

                System.out.print("a21 = ");
                double a21 = sc.nextDouble();
                System.out.print("a22 = ");
                double a22 = sc.nextDouble();
                System.out.print("b2 = ");
                double b2 = sc.nextDouble();

                double D = a11 * a22 - a21 * a12;
                double D1 = b1 * a22 - b2 * a12;
                double D2 = a11 * b2 - a21 * b1;

                if (D == 0) {
                    if (D1 == 0 && D2 == 0) {
                        System.out.println("He vo so nghiem");
                    } else {
                        System.out.println("He vo nghiem");
                    }
                } else {
                    double x1 = D1 / D;
                    double x2 = D2 / D;
                    System.out.println("x1 = " + x1 + ", x2 = " + x2);
                }
                break;

            case 2:
                System.out.print("a = ");
                double aa = sc.nextDouble();
                System.out.print("b = ");
                double bb = sc.nextDouble();
                System.out.print("c = ");
                double cc = sc.nextDouble();

                if (aa == 0) {
                    if (bb == 0) {
                        if (cc == 0) {
                            System.out.println("Vo so nghiem");
                        } else {
                            System.out.println("Vo nghiem");
                        }
                    } else {
                        double x = -cc / bb;
                        System.out.println("Nghiem x = " + x);
                    }
                } else {
                    double delta = bb * bb - 4 * aa * cc;

                    if (delta < 0) {
                        System.out.println("Vo nghiem");
                    } else if (delta == 0) {
                        double x = -bb / (2 * aa);
                        System.out.println("Nghiem kep x = " + x);
                    } else {
                        double x1 = (-bb + Math.sqrt(delta)) / (2 * aa);
                        double x2 = (-bb - Math.sqrt(delta)) / (2 * aa);
                        System.out.println("x1 = " + x1 + ", x2 = " + x2);
                    }
                }
                break;

            default:
                System.out.println("Lua chon khong hop le!");
        }
    }
}
