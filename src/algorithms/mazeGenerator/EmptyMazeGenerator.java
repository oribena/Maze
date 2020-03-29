package algorithms.mazeGenerator;

public class EmptyMazeGenerator extends  AMazeGenerator{
    @Override
    public Maze generate(int rows, int columns) {
        int[][] mat = new int[rows][columns];
        for (int i=0; i<rows; i++ ){
            for (int j=0; j<columns; j++){
                mat[i][j] = 0;
            }
        }
        Position[] startEnd = creatStartEnd(rows, columns);
        Position start = startEnd[0];
        Position end = startEnd[1];
        Maze emptyMaze = new Maze(mat, start, end);
        return emptyMaze;
    }
}
