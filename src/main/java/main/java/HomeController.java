package main.java;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HomeController {
    @FXML
    private TextField searchbar;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void initialize() {
        System.out.println("Initialize Called");
        JFXTextField jfxSearchbar = new JFXTextField();
        jfxSearchbar.setLayoutX(searchbar.getLayoutX());
        jfxSearchbar.setLayoutY(searchbar.getLayoutY());
        jfxSearchbar.setPromptText(searchbar.getPromptText());

        // Create a new container
        AnchorPane newContainer = new AnchorPane();
        newContainer.getChildren().addAll(anchorPane.getChildren());
        newContainer.getChildren().add(jfxSearchbar);
        newContainer.getChildren().remove(searchbar);

        // Replace the original container with the new one
        anchorPane.getChildren().setAll(newContainer.getChildren());
        searchbar = jfxSearchbar;

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/DrawerContent.fxml"));
                VBox drawerContent = loader.load();
                drawer.setSidePane(drawerContent);

                HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
                burgerTask.setRate(-1);
                hamburger.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> {
                    System.out.println("Hamburger clicked");
                    burgerTask.setRate(burgerTask.getRate() * -1);
                    burgerTask.play();

                    if (drawer.isOpened()) {
                        drawer.close();
                    } else {
                        drawer.open();
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


}
