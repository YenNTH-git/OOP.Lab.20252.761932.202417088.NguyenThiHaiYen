package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // Constructor đơn giản
    public CompactDisc(String title, String category, float cost, String artist) {
        super(0, title, category, cost, 0, "unknown");
        this.artist = artist;
    }

    // Constructor đầy đủ
    public CompactDisc(int id, String title, String category,
                       float cost, int length,
                       String director, String artist) {

        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    // Getter
    public String getArtist() {
        return artist;
    }

    // Add track
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added.");
        } else {
            System.out.println("Track already exists.");
        }
    }

    // Remove track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed.");
        } else {
            System.out.println("Track does not exist.");
        }
    }

    // CD length = tổng length các track
    @Override
    public int getLength() {
        int total = 0;

        for (Track track : tracks) {
            total += track.getLength();
        }

        return total;
    }

    // Play CD
    @Override
    public void play() {

        if (getLength() <= 0) {
            System.out.println("ERROR: CD length is non-positive");
            return;
        }

        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());

        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - "
                + getTitle() + " - "
                + getCategory() + " - "
                + artist + " - "
                + getLength() + " - "
                + getCost();
    }
}