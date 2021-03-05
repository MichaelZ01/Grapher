import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    Graph graph = new Graph();

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        graph = new Graph();

        root.setCenter(graph.getScrollPane());


        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        Button addButton = new Button();
        addButton.setText("Add Node");
        addButton.setTranslateX(20);
        addButton.setPrefSize(100, 30);

        root.setTop(addButton);

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

        model.addEdge("Cell A", "Cell B");
        model.addEdge("Cell B", "Cell A");
        model.addEdge("Cell B", "Cell C");
        model.addEdge("Cell C", "Cell D");
        model.addEdge("Cell B", "Cell E");
        model.addEdge("Cell D", "Cell F");
        model.addEdge("Cell D", "Cell G");
        graph.endUpdate();

        Layout layout = new RandomLayout(graph);
        layout.execute();


        addButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                graph.beginUpdate();
                model.addCell("A new Cell", CellType.TRIANGLE);
                graph.endUpdate();
            };
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}