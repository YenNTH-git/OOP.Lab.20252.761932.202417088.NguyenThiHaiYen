package Aims_Project;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc[] items_ordered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qty_ordered = 0;

    // Add DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qty_ordered < MAX_NUMBERS_ORDERED) {
            items_ordered[qty_ordered] = disc;
            qty_ordered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    // Remove DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;

        for (int i = 0; i < qty_ordered; i++) {
            if (items_ordered[i] == disc) {
                found = true;

                for (int j = i; j < qty_ordered - 1; j++) {
                    items_ordered[j] = items_ordered[j + 1];
                }

                items_ordered[qty_ordered - 1] = null;
                qty_ordered--;

                System.out.println("The disc has been removed");
                break;
            }
        }

        if (!found) {
            System.out.println("The disc was not found");
        }
    }

    // Total cost
    public float totalCost() {
        float total = 0;

        for (int i = 0; i < qty_ordered; i++) {
            total += items_ordered[i].getCost();
        }

        return total;
    }
}