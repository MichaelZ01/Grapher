import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ToolBar {
    
    private Graph graph;
    private HBox nav;

    public ToolBar(Graph graph) {
        this.graph = graph;

        Button addButton = new Button();
        addButton.setText("Add Node");
        addButton.setPrefSize(100, 30);

        this.nav = new HBox();
        nav.setPrefHeight(50);

        nav.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        nav.getChildren().add(addButton);
        HBox.setMargin(addButton, new Insets(10, 10, 0, 10));

        addButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                graph.beginUpdate();
                Model model = graph.getModel();
                model.addCell("A new Cell", CellType.TRIANGLE);
                graph.endUpdate();
            };
        });
    }


    public HBox getNav() {
        return nav;
    }

}
