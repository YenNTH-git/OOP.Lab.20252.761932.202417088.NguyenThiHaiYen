package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    // Constructor 5 tham số để khớp với yêu cầu khởi tạo mới
    // Thứ tự: Title, Category, Cost, Director, Length
    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        super(0, title, category, cost, length, director);
    }

    // Constructor gốc (giữ lại nếu cần cho các phần khác trong project)
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            // Ném ngoại lệ theo yêu cầu bài Lab (phần 13.2)
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return String.format("DVD - %s - %s - %s - %d min: %.2f $",
                this.getTitle(), this.getCategory(), this.getDirector(), this.getLength(), this.getCost());
    }
}