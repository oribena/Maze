package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends  AMazeGenerator{
    @Override
    public Maze generate(int rows, int columns) {
        //check input TODO: ask if ok
        if (rows<0)
            rows =0;
        if (columns<0)
            columns=0;
        // put 0
        int[][] mat = new int[rows][columns];
        for (int i=0; i<rows; i++ ){
            for (int j=0; j<columns; j++){
                mat[i][j] = 0;
            }
        }
        //create start and end
        Position[] startEnd = creatStartEnd(rows, columns);
        Position start = startEnd[0];
        Position end = startEnd[1];
        Maze emptyMaze = new Maze(mat, start, end);
        return emptyMaze;
    }
}
