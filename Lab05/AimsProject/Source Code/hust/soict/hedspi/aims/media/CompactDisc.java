package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private final String artist; // Đã thêm final
    private final ArrayList<Track> tracks = new ArrayList<>(); // Đã thêm final

    // --- Constructor mới cho AddCompactDiscToStoreScreen ---
    public CompactDisc(String title, String category, float cost, String artist, String director) {
        super(0, title, category, cost, 0, director);
        this.artist = artist;
    }

    // Constructor cũ (giữ lại để tương thích hệ thống cũ)
    public CompactDisc(int id, String title, String category,
                       float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    @SuppressWarnings("unused")
    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists.");
        }
    }

    @SuppressWarnings("unused")
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track does not exist.");
        }
    }

    @Override
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }

    // --- Cập nhật play() tối ưu ---
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());

            // Gọi trực tiếp track.play() - nếu có lỗi nó tự động throw ra ngoài
            for (Track track : tracks) {
                track.play();
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return String.format("CD - %s - %s - %s - %d min: %.2f $",
                this.getTitle(), this.getCategory(), this.artist, this.getLength(), this.getCost());
    }
}