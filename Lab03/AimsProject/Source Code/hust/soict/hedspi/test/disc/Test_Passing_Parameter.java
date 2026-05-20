package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Test_Passing_Parameter {

    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // before
        System.out.println("Before swap:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        // swap
        swap(jungleDVD, cinderellaDVD);

        // after swap
        System.out.println("\nAfter swap:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        // changeTitle
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        // after change
        System.out.println("\nAfter changeTitle:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
    }

    //swap
    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        DigitalVideoDisc tmp = d1;
        d1 = d2;
        d2 = tmp;
    }

    //đổi tittle
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}