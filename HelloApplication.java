import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private HelloController controller = new MovieSearchController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));
        Parent root = loader.load();

        TextField searchField = (TextField) root.lookup("#searchField");
        TextArea movieDetailsArea = (TextArea) root.lookup("#movieDetailsArea");
        Button searchButton = (Button) root.lookup("#searchButton");

        searchButton.setOnAction(e -> {
            String movieName = searchField.getText();
            Movie movie = controller.fetchMovieDetails(movieName);
            if (movie != null) {
                movieDetailsArea.setText(movie.toString());
            } else {
                movieDetailsArea.setText("Movie not found or an error occurred.");
            }
        });

        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add("styles.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Movie Search App");
        primaryStage.show();
    }
}
