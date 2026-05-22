package Aims_Project.hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String author) {

        if (!authors.contains(author)) {

            authors.add(author);

            System.out.println(author + " has been added.");

        } else {

            System.out.println(author + " already exists.");
        }
    }

    public void removeAuthor(String author) {

        if (authors.contains(author)) {

            authors.remove(author);

            System.out.println(author + " has been removed.");

        } else {

            System.out.println(author + " does not exist.");
        }
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {

        return "Book - "
                + getTitle()
                + " - "
                + getCategory()
                + " - "
                + getCost();
    }
}