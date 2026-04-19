import java.util.Scanner;

public class Days_of_month {
    static String[] tenThangDayDu = { "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December" };
    static String[] vietTat = { "Jan.", "Feb.", "Mar.", "Apr.", "May", "June",
            "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec." };
    static String[] baChuCai = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    static int[] ngay = { 31,28,31,30,31,30,31,31,30,31,30,31 };

    public static int nhapThang(Scanner sc) {
        int chiSoThang = -1;
        while (chiSoThang == -1) {
            String nhapThang = sc.next();
            try {
                int soThang = Integer.parseInt(nhapThang);
                if (soThang >= 1 && soThang <= 12) {
                    chiSoThang = soThang - 1;
                    continue;
                }
            } catch (NumberFormatException e) {
            }

            for (int i = 0; i < tenThangDayDu.length; i++) {
                if (nhapThang.equalsIgnoreCase(tenThangDayDu[i]) ||
                        nhapThang.equalsIgnoreCase(vietTat[i]) ||
                        nhapThang.equalsIgnoreCase(baChuCai[i])) {
                    chiSoThang = i;
                    break;
                }
            }

            if (chiSoThang == -1) {
                System.out.println("Tháng không hợp lệ. Nhập lại.");
            }
        }
        return chiSoThang;
    }

    public static int nhapNam(Scanner sc) {
        int nam = -1;
        while (nam < 0) {
            String nhapNam = sc.next();
            try {
                nam = Integer.parseInt(nhapNam);
                if (nam < 0) {
                    System.out.println("Năm phải là số không âm. Nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Năm không hợp lệ. Nhập lại.");
            }
        }
        return nam;
    }

    public static boolean kiemTraNamNhuan(int nam) {
        return (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
    }

    public static int tinhSoNgay(int chiSoThang, boolean namNhuan) {
        if (chiSoThang == 1 && namNhuan)
            return 29;
        return ngay[chiSoThang];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int chiSoThang = nhapThang(sc);
        int nam = nhapNam(sc);

        boolean namNhuan = kiemTraNamNhuan(nam);
        int soNgay = tinhSoNgay(chiSoThang, namNhuan);

        System.out.println(tenThangDayDu[chiSoThang] + " " + nam + " có " + soNgay + " ngày.");
        sc.close();
    }
}
