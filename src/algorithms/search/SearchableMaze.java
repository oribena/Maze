package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    private Maze m_maze;
    private MazeState[][] stateMat;

    public SearchableMaze(Maze m_maze) {
        this.m_maze = m_maze;
        this.stateMat = new MazeState[m_maze.getNumOfRows()][m_maze.getNumOfColumns()];
        for (int i = 0; i < stateMat.length; i++) {
            for (int j = 0; j < stateMat[0].length; j++) {
                Position currPos = new Position(i, j);
                int currVal = m_maze.getMat()[i][j];
                stateMat[i][j] = new MazeState(currPos, currVal);
            }

        }
    }

    public MazeState[][] getStateMat() {
        return stateMat;
    }

    @Override
    public MazeState getStartState() {
        return new MazeState(m_maze.getStartPosition(), 0);
    }

    @Override
    public MazeState getGoalState() {
        return new MazeState(m_maze.getGoalPosition(), 0);
    }

    @Override
    public ArrayList<AState> getAllPossibleStates(AState s, String algName) {
        int row = ((MazeState) s).getPos().getRowIndex();
        int col = ((MazeState) s).getPos().getColumnIndex();
        ArrayList<AState> res = new ArrayList<AState>();
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                // if the state is valid
                if (i >= 0 && i < m_maze.getNumOfRows() && j >= 0 && j < m_maze.getNumOfColumns()) {
                    // if this is a neighbor with a pass
                    if (!(i == row && j == col) && stateMat[i][j].getVal() == 0) {
                        res.add(stateMat[i][j]);
                        if (algName == "Best First Search") {
                            if (row - i == 0 || col - j == 0)
                                stateMat[i][j].setPriority(10);
                            stateMat[i][j].setPriority(15);
                        }
                        else // if bfs or dfs
                            stateMat[i][j].setPriority(1);
                    }
                }
            }
        }
        return res;
    }

    @Override
    public void ClearVisited() {
        for (int i = 0; i < stateMat.length; i++) {
            for (int j = 0; j < stateMat[0].length; j++) {
                this.stateMat[i][j].setVisited(false);
            }
        }
    }

}
