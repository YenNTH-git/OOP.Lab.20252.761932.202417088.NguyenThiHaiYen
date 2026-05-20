package Aims_Project.hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    // ===== CONSTRUCTOR 1 (GIỮ NGUYÊN NHƯ MÀY) =====
    public CompactDisc(String title, String category, float cost, String artist) {
        super(0, title, category, cost, 0, "unknown");
        this.artist = artist;
    }

    // ===== CONSTRUCTOR FULL (FIX LỖI 7 ARGS) =====
    public CompactDisc(int id, String title, String category,
                       float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    // ===== TRACKS =====
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track " + track.getTitle() + " đã có trong CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track không tồn tại trong CD.");
        }
    }

    // ===== LENGTH =====
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // ===== PLAY =====
    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Đang phát CD: " + this.getTitle()
                    + " của nghệ sĩ: " + artist);

            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("Lỗi: CD này không thể phát được.");
        }
    }
}