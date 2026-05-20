package Aims_Project.hust.soict.hedspi.aims.media;

public class Disc extends media {
    private int length;
    private String director;

    public Disc() {
        super();
    }

    // Getter cho các thuộc tính bổ sung
    public int getLength() { return length; }
    public String getDirector() { return director; }

    // Bạn có thể thêm Constructor đầy đủ để các lớp con sử dụng super()
    public Disc(int id, String title, String category, float cost, int length, String director) {
        // Gọi constructor của lớp cha Media
        // (Giả sử bạn đã thêm constructor tương ứng ở lớp Media)
    }
}
