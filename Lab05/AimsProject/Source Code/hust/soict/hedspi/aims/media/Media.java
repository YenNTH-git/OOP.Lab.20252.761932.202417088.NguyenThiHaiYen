package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {

    private static int nextId = 1;

    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media() {
    }

    public Media(int id, String title, String category, float cost) {

        if (id <= 0) {
            this.id = nextId++;
        } else {
            this.id = id;
        }

        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format(
                "Media - %s - %s - %.2f $",
                title,
                category,
                cost
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Media)) {
            return false;
        }

        Media other = (Media) obj;

        if (title == null) {
            return other.title == null;
        }

        return title.equals(other.title);
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new mediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new mediaComparatorByCostTitle();

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