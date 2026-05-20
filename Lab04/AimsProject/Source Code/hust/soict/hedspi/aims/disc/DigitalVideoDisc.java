package Aims_Project.hust.soict.hedspi.aims.disc;

import Aims_Project.hust.soict.hedspi.aims.media.Disc;

public class DigitalVideoDisc extends Disc {

    public DigitalVideoDisc() {
        super();
    }

    public DigitalVideoDisc(int id, String title, String category,
                            float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - "
                + getDirector() + " - " + getLength() + " min - " + getCost() + " $";
    }
}