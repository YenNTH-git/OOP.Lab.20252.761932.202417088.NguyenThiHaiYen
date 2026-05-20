package Aims_Project.hust.soict.hedspi.test.disc;

import Aims_Project.hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Test_Passing_Parameter {

    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD =
                new DigitalVideoDisc(1, "Jungle", "Adventure", 10.0f, 90, "Unknown");

        DigitalVideoDisc cinderellaDVD =
                new DigitalVideoDisc(2, "Cinderella", "Animation", 12.0f, 80, "Disney");

        // before
        System.out.println("Before swap:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        // swap
        swap(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter swap:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

        // changeTitle
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("\nAfter changeTitle:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
    }

    // swap (KHÔNG ĐỔI THẬT - Java pass by value)
    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        DigitalVideoDisc tmp = d1;
        d1 = d2;
        d2 = tmp;
    }

    // change title
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(3, oldTitle, "Temp", 0.0f, 0, "None");
    }
}