package Aims_Project.hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;

public class book extends media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();
    public book() {
        super();
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Tác giả " + authorName + " đã tồn tại.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Không tìm thấy tác giả: " + authorName);
        }
    }
}