package Aims_Project;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Class member (static)
    private static int nbDigitalVideoDiscs = 0;

    // Instance member
    private int id;

    // Getter
    public String getTitle() { return title; }
    public float getCost() { return cost; }
    public int getId() { return id; }

    // Setter (dùng cho bài passing parameter)
    public void setTitle(String title) {
        this.title = title;
    }

    // Constructor 1
    public DigitalVideoDisc(String title) {
        this.title = title;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 2
    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    // Constructor 3
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.director = director;
    }

    // Constructor 4
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        this.length = length;
    }

    // Override toString (dùng cho printCart)
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - "
                + director + " - " + length + ": " + cost + " $";
    }

    // Match title (search)
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}