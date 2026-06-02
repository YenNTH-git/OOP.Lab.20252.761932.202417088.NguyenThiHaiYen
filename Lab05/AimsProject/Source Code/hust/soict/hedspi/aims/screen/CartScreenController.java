package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private final Cart cart;
    private FilteredList<Media> filteredData;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private Label lblTotalCost;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredData =
                new FilteredList<>(cart.getItemsOrdered(), p -> true);

        tfFilter.textProperty().addListener((obs, oldVal, newVal) -> {

            filteredData.setPredicate(media -> {

                if (newVal == null || newVal.isEmpty()) return true;

                String key = newVal.toLowerCase();

                if (radioBtnFilterTitle.isSelected()) {
                    return media.getTitle().toLowerCase().contains(key);
                } else {
                    return String.valueOf(media.getId()).contains(key);
                }
            });
        });

        tblMedia.setItems(filteredData);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldSel, newSel) -> {
                    if (newSel != null) {
                        btnRemove.setVisible(true);
                        btnPlay.setVisible(newSel instanceof Playable);
                    }
                });

        updateTotalCost();
    }

    // ================= REMOVE =================
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();

            tblMedia.refresh();
        }
    }

    // ================= PLAY =================
    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Playing");
            alert.setContentText("Now playing: " + media.getTitle());
            alert.show();
        }
    }

    // ================= SORT TITLE =================
    @FXML
    void btnSortTitlePressed(ActionEvent event) {
        cart.sortByTitle();

        tblMedia.refresh();

        updateTotalCost();
    }

    // ================= SORT COST =================
    @FXML
    void btnSortCostPressed(ActionEvent event) {
        cart.sortByCost();

        tblMedia.refresh();

        updateTotalCost();
    }

    // ================= PLACE ORDER (NEW) =================
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {

        if (cart.getItemsOrdered().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cart is empty");
            alert.setContentText("Please add items before placing order!");
            alert.showAndWait();

            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Order placed");
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();

        cart.clear(); // clear cart

        tblMedia.getItems().clear(); // clear UI
        updateTotalCost();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tfFilter.clear();
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }
}