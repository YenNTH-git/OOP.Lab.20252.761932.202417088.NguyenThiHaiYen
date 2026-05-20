package Aims_Project.hust.soict.hedspi.test.store;

import Aims_Project.hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import Aims_Project.hust.soict.hedspi.aims.store.Store;

public class TestStore {

    public static void main(String[] args) {

        Store store = new Store();

        DigitalVideoDisc dvd1 =
                new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 87, "Roger Allers");

        DigitalVideoDisc dvd2 =
                new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, 124, "George Lucas");

        DigitalVideoDisc dvd3 =
                new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f, 90, "Unknown");

        // ADD (FIX METHOD NAME)
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        store.printStore();

        // REMOVE
        store.removeMedia(dvd2);

        store.printStore();
    }
}