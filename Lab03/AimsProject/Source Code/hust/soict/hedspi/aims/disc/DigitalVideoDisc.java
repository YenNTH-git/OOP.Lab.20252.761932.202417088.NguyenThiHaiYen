package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Class (static)
    private static int nbDigitalVideoDiscs = 0;

    // Instance
    private int id;

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

    // ===== GETTER =====
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    public int getId() { return id; }

    // ===== SETTER =====
    public void setTitle(String title) {
        this.title = title;
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "DVD - " + title + " - "
                + (category != null ? category : "N/A") + " - "
                + (director != null ? director : "N/A") + " - "
                + length + ": " + cost + " $";
    }

    // ===== MATCH TITLE =====
    public boolean isMatch(String title) {
        if (title == null || this.title == null) return false;
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}