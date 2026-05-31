package hust.soict.hedspi.aims.media;

public class Track implements Playable {

    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // ===== GETTER =====
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // ===== equals =====
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Track)) {
            return false;
        }

        Track other = (Track) obj;

        if (title == null) {
            return other.title == null;
        }

        return title.equals(other.title)
                && length == other.length;
    }

    // ===== toString =====
    @Override
    public String toString() {
        return "Track - "
                + title + " - "
                + length;
    }

    // ===== play =====
    @Override
    public void play() {

        if (length <= 0) {
            System.out.println("ERROR: Track length is non-positive");
            return;
        }

        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
    }
}