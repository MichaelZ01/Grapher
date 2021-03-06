import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {


    Graph graph;
    ToolBar toolBar;

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        this.graph = new Graph();
        this.toolBar = new ToolBar(graph);

        root.setCenter(graph.getScrollPane());
        root.setTop(toolBar.getNav());

        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();

        Model model = graph.getModel();

        graph.beginUpdate();
        model.addCell("Cell A", CellType.RECTANGLE);
        model.addCell("Cell B", CellType.RECTANGLE);
        model.addCell("Cell C", CellType.RECTANGLE);
        model.addCell("Cell D", CellType.RECTANGLE);
        model.addCell("Cell E", CellType.RECTANGLE);
        model.addCell("Cell F", CellType.RECTANGLE);
        model.addCell("Cell G", CellType.TRIANGLE);

        model.addEdge(0, 1);
        model.addEdge(1, 0);
        model.addEdge(1, 2);
        model.addEdge(2, 3);
        model.addEdge(2, 5);
        model.addEdge(4, 6);
        model.addEdge(4, 1);
        graph.endUpdate();

        Layout layout = new RandomLayout(graph);
        layout.execute();

    }

    public static void main(String[] args) {
        launch(args);
    }
}