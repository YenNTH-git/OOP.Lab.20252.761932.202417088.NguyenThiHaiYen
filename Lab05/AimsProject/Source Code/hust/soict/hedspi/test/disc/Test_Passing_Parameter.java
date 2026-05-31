package hust.soict.hedspi.test.disc;

// SỬA LỖI: Import lớp DigitalVideoDisc từ package media để hết gạch đỏ hoàn toàn
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Test_Passing_Parameter {

    public static void main(String[] args) {

        // Gọi đúng Constructor 6 tham số trùng khớp với file DigitalVideoDisc.java hiện tại của bạn
        DigitalVideoDisc jungleDVD =
                new DigitalVideoDisc(
                        1,
                        "Jungle",
                        "Adventure",
                        10.0f,
                        90,
                        "Unknown"
                );

        DigitalVideoDisc cinderellaDVD =
                new DigitalVideoDisc(
                        2,
                        "Cinderella",
                        "Animation",
                        12.0f,
                        80,
                        "Disney"
                );

        // ===== BEFORE =====
        System.out.println("Before swap:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        // ===== SWAP =====
        swap(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter swap:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        // ===== CHANGE TITLE =====
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("\nAfter changeTitle:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
    }

    // ===== SWAP =====
    // Cơ chế Pass-by-value của Java (Hàm này thực tế sẽ không đổi chỗ tiêu đề gốc)
    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        DigitalVideoDisc tmp = d1;
        d1 = d2;
        d2 = tmp;
    }

    // ===== CHANGE TITLE =====
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);

        // SỬA LỖI: Gọi đúng thứ tự tham số Constructor 6 của bạn: (id, title, category, cost, length, director)
        dvd = new DigitalVideoDisc(
                3,
                oldTitle,
                "Temp",
                0.0f,
                0,
                "None"
        );
    }
}