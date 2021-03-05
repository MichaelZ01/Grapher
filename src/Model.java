import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {

    private Cell graphParent;

    private List<Cell> allCells;
    private List<Cell> addedCells;
    private List<Cell> removedCells;

    private List<Edge> allEdges;
    private List<Edge> addedEdges;
    private List<Edge> removedEdges;

    private Map<String,Cell> cellMap; 

    public Model() {
         graphParent = new Cell( "_ROOT_");
         clear();
    }

    // Clear Graph model
    public void clear() {

        allCells = new ArrayList<>();
        addedCells = new ArrayList<>();
        removedCells = new ArrayList<>();

        allEdges = new ArrayList<>();
        addedEdges = new ArrayList<>();
        removedEdges = new ArrayList<>();

        cellMap = new HashMap<>(); 
    }

    // Add a new cell to the graph
    public void addCell(String id, CellType type) {

        switch (type) {

        case RECTANGLE:
            RectangleCell rectangleCell = new RectangleCell(id);
            addCell(rectangleCell);
            break;

        case TRIANGLE:
            TriangleCell circleCell = new TriangleCell(id);
            addCell(circleCell);
            break;

        default:
            throw new UnsupportedOperationException("Unsupported type: " + type);
        }
    }

    private void addCell(Cell cell) {
        addedCells.add(cell);
        cellMap.put(cell.getCellId(), cell);
    }

    // Add a new edge to the graph
    public void addEdge(String sourceId, String targetId) {

        Cell sourceCell = cellMap.get(sourceId);
        Cell targetCell = cellMap.get(targetId);

        Edge edge = new Edge(sourceCell, targetCell);

        addedEdges.add(edge);
    }

    // Attaching cells to root cell
    public void attachOrphansToGraphParent(List<Cell> cellList) {
        for(Cell cell: cellList) {
            if(cell.getCellInBound().size() == 0) {
                graphParent.addCellOutBound(cell);
            }
        }

    }

    public void disconnectFromGraphParent(List<Cell> cellList) {
        for(Cell cell: cellList) {
            graphParent.removeCellOutBound(cell);
        }
    }

    // Update graph cells and edges
    public void merge() {
        allCells.addAll(addedCells);
        allCells.removeAll(removedCells);
        allEdges.addAll(addedEdges);
        allEdges.removeAll(removedEdges);

        addedCells.clear();
        removedCells.clear();
        addedEdges.clear();
        removedEdges.clear();
    }

    // Getters and Setters
    public List<Cell> getAddedCells() {
        return addedCells;
    }

    public List<Cell> getRemovedCells() {
        return removedCells;
    }

    public List<Cell> getAllCells() {
        return allCells;
    }

    public List<Edge> getAddedEdges() {
        return addedEdges;
    }

    public List<Edge> getRemovedEdges() {
        return removedEdges;
    }

    public List<Edge> getAllEdges() {
        return allEdges;
    }
}