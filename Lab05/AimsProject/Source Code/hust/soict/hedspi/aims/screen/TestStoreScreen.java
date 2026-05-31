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

        // DVD: Sử dụng constructor mới khớp với yêu cầu Lab
        // Thứ tự: Title, Category, Cost, Director, Length
        mockStore.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 88));
        mockStore.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, "George Lucas", 124));

        // BOOK: Sử dụng constructor mới (Title, Category, Cost, Authors)
        mockStore.addMedia(new Book("Java Programming", "Education", 45.00f, "Author Name"));

        // CD: Sử dụng constructor mới (Title, Category, Cost, Artist, Director)
        mockStore.addMedia(new CompactDisc("Thriller", "Pop", 15.50f, "Michael Jackson", "Director Name"));

        // 2. Nạp sẵn một đĩa phim vào giỏ hàng (Cart)
        mockCart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers", 88));

        // 3. Khởi chạy màn hình Store tích hợp
        new StoreScreen(mockStore, mockCart);
    }
}