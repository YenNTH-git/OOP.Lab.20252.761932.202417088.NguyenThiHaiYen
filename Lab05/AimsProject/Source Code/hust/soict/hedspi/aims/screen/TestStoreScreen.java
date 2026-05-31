package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;

public class TestStoreScreen {

    public static void main(String[] args) {
        Store mockStore = new Store();
        Cart mockCart = new Cart();

        // 1. Nạp sản phẩm mẫu vào cửa hàng (Store)
        // DVD: Title, Category, Director, Length, Cost
        mockStore.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f));
        mockStore.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));

        // FIX BOOK: Truyền thêm ID (ví dụ: 1) vào vị trí đầu tiên đúng như Constructor của bạn yêu cầu
        Book javaBook = new Book(1, "Java Programming", "Education", 45.00f);
        mockStore.addMedia(javaBook);

        // CD: Title, Category, Cost, Artist
        CompactDisc thrillerCD = new CompactDisc("Thriller", "Pop", 15.50f, "Michael Jackson");
        mockStore.addMedia(thrillerCD);

        // 2. Nạp sẵn một đĩa phim vào giỏ hàng (Cart) để kiểm tra cơ chế hiển thị danh sách TableView
        mockCart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 88, 19.95f));

        // 3. Khởi chạy màn hình Store tích hợp
        new StoreScreen(mockStore, mockCart);
    }
}