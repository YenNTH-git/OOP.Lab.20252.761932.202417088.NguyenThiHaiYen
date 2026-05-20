package Aims_Project.hust.soict.hedspi.aims.media;
import java.util.Comparator;

public class mediaComparatorByTitleCost implements Comparator<media> {
    @Override
    public int compare(media m1, media m2) {
        int titleCmp = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleCmp != 0) {
            return titleCmp;
        }
        return Float.compare(m2.getCost(), m1.getCost());
    }
}