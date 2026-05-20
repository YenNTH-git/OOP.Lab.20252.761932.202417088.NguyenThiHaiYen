package Aims_Project.hust.soict.hedspi.aims.media;

public class Disc extends media {
    private int length;
    private String director;

    public Disc() {
        super();
    }

    // Getter
    public int getLength() { return length; }
    public String getDirector() { return director; }

    // Constructor đầy đủ
    public Disc(int id, String title, String category, float cost,
                int length, String director) {

        super(id, title, category, cost); // 🔥 FIX QUAN TRỌNG NHẤT

        this.length = length;
        this.director = director;
    }
}