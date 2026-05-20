package Aims_Project.hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class media {

    // ===== FIELDS (phải protected để class con dùng được) =====
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    // ===== CONSTRUCTORS =====
    public media() {
    }

    public media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // ===== toString =====
    @Override
    public String toString() {
        return String.format("Media - %s - %s - %.2f $",
                title, category, cost);
    }

    // ===== equals (so sánh theo title) =====
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof media)) return false;

        media other = (media) obj;

        if (this.title == null) return other.title == null;
        return this.title.equals(other.title);
    }

    // ===== Comparator (GIỮ NGUYÊN Ý MÀY) =====
    public static final Comparator<media> COMPARE_BY_TITLE_COST =
            new mediaComparatorByTitleCost();

    public static final Comparator<media> COMPARE_BY_COST_TITLE =
            new mediaComparatorByCostTitle();

    // ===== GETTER / SETTER =====
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}