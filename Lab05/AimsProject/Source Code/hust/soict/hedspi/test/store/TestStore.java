package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.store.Store;
// SỬA LỖI: Import lớp DigitalVideoDisc từ package media để hết gạch đỏ
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestStore {

    public static void main(String[] args) {

        Store store = new Store();

        // SỬA LỖI: Đảo vị trí cost (float) lên trước length (int) để khớp 100% constructor 6 tham số của bạn
        DigitalVideoDisc dvd1 =
                new DigitalVideoDisc(
                        1,
                        "The Lion King",
                        "Animation",
                        19.95f,
                        87,
                        "Roger Allers"
                );

        DigitalVideoDisc dvd2 =
                new DigitalVideoDisc(
                        2,
                        "Star Wars",
                        "Science Fiction",
                        24.95f,
                        124,
                        "George Lucas"
                );

        DigitalVideoDisc dvd3 =
                new DigitalVideoDisc(
                        3,
                        "Aladdin",
                        "Animation",
                        18.99f,
                        90,
                        "Unknown"
                );

        // ===== ADD =====
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // ===== PRINT =====
        store.printStore();

        // ===== REMOVE =====
        store.removeMedia(dvd2);

        // ===== PRINT AGAIN =====
        store.printStore();
    }
}