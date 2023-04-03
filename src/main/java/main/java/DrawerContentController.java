package main.java;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DrawerContentController {

    @FXML
    private VBox drawerContent;

    @FXML
    private Button productListing, shoppingCart, wishlist, userAccount;

    // Add the rest of your controller code here

    @FXML
    private void loadProductListing() {
        loadUIComponent("ProductListing.fxml");
    }

    @FXML
    private void loadShoppingCart() {
        loadUIComponent("ShoppingCart.fxml");
    }

    @FXML
    private void loadWishlist() {
        loadUIComponent("Wishlist.fxml");
    }

    @FXML
    private void loadUserAccount() {
        loadUIComponent("UserAccount.fxml");
    }

    // Add other loading methods for other menu items

    private void loadUIComponent(String componentFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(componentFXML));
            Node component = loader.load();

            AnchorPane root = (AnchorPane) drawerContent.getScene().lookup("#anchorPane");
            root.getChildren().setAll(component);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
