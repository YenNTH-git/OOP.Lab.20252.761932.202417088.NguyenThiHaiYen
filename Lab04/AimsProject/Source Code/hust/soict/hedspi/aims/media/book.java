package Aims_Project.hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class book extends Media {

    private ArrayList<String> authors = new ArrayList<>();

    public book() {
        super();
    }

    public book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String author) {
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - " + getCost();
    }
}