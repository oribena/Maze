package algorithms.search;

public abstract class AState {
    private String state;////////////////////// TODO: delete
    private double cost;
    private AState cameFrom;
    private boolean Visited;

    public AState() {
        this.cost = 0;
        this.cameFrom = null;
        Visited = false;
    }

    public double getCost() {
        return cost;
    }

    public AState getCameFrom() {
        return cameFrom;
    }

    public boolean isVisited() {
        return Visited;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCameFrom(AState cameFrom) {
        this.cameFrom = cameFrom;
    }

    public void setVisited(boolean visited) {
        Visited = visited;
    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }

    @Override // TODO: check if can delete
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AState state1 = (AState)obj;
        return  state != null ? state.equals(state1.state) : state1.state == null;
    }
}
