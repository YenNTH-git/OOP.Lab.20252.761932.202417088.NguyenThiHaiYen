package Aims_Project;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Static (classifier member)
    private static int nbDigitalVideoDiscs = 0;

    // Instance member
    private int id;

    // ===== GETTER =====
    public String getTitle() { return title; }
    public float getCost() { return cost; }
    public int getId() { return id; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }

    // ===== SETTER (dùng cho bài passing parameter) =====
    public void setTitle(String title) {
        this.title = title;
    }

    // ===== CONSTRUCTOR =====
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        this.length = length;
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - "
                + director + " - " + length + ": " + cost + " $";
    }

    // ===== MATCH TITLE =====
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}