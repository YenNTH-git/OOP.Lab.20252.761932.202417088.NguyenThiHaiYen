package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CartScreenController {
    private final Cart cart;

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

        // Gọi mượt mà hàm lấy danh sách ObservableList vừa được bổ sung bên lớp Cart
        FilteredList<Media> filteredData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);

        // Sử dụng dữ liệu text từ tfFilter để thực hiện tìm kiếm thực tế trên bảng dữ liệu
        tfFilter.textProperty().addListener((observable, oldValue, newValue) ->
                filteredData.setPredicate(media -> {
                    if (newValue == null || newValue.trim().isEmpty()) {
                        return true;
                    }

                    String lowerCaseFilter = newValue.toLowerCase();

                    if (radioBtnFilterTitle.isSelected()) {
                        return media.getTitle().toLowerCase().contains(lowerCaseFilter);
                    } else if (radioBtnFilterId.isSelected()) {
                        return String.valueOf(media.getId()).contains(lowerCaseFilter);
                    }
                    return true;
                })
        );

        tblMedia.setItems(filteredData);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Chuyển toàn bộ bộ lắng nghe Anonymous cũ sang dạng biểu thức Lambda tối giản siêu sạch
        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateButtonBar(newValue);
            } else {
                btnPlay.setVisible(false);
                btnRemove.setVisible(false);
            }
        });

        updateTotalCost();
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Playing");
            alert.setHeaderText(null);
            alert.setContentText("Now playing: " + media.getTitle());
            alert.showAndWait();
        }
    }
}