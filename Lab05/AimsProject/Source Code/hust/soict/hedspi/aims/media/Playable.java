package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public interface Playable {
    // Chỉ giữ lại duy nhất 1 phương thức này
    public void play() throws PlayerException;
}