package Aims_Project.hust.soict.hedspi.aims.media;

public class Track implements Playable {

    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    // ===== IMPORTANT FIX: equals =====
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;

        Track other = (Track) obj;

        if (this.title == null) return other.title == null;
        return this.title.equals(other.title) && this.length == other.length;
    }

    // ===== DEBUG SUPPORT =====
    @Override
    public String toString() {
        return "Track - " + title + " - " + length;
    }

    @Override
    public void play() {
        if (this.length > 0) {
            System.out.println("Đang phát Track: " + this.getTitle());
            System.out.println("Thời lượng Track: " + this.getLength());
        } else {
            System.out.println("Lỗi: Track này không thể phát được (thời lượng <= 0).");
        }
    }
}