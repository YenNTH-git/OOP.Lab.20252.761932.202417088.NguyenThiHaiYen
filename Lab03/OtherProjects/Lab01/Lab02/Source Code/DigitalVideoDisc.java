package Aims_Project;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Getters
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }

    // Constructor 1
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.category = "";
        this.director = "";
        this.length = 0;
        this.cost = 0.0f;
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
}