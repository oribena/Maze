package algorithms.mazeGenerator;

public class SimpleMazeGenerator extends AMazeGenerator{


    @Override
    public Maze generate(int rows, int columns) { //TODO: add a valid path
        int[][] mat = new int[rows][columns];
        for (int i=0; i<rows; i++ ){
            for (int j=0; j<columns; j++){
                mat[i][j] = (int) (Math.random() * (2));
            }
        }
        Position[] startEnd = creatStartEnd(rows, columns);
        Position start = startEnd[0];
        Position end = startEnd[1];
        Maze simpleMaze = new Maze(mat, start, end);
        return simpleMaze;
    }
}
