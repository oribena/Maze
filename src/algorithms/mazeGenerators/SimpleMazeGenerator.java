package algorithms.mazeGenerators;

public class SimpleMazeGenerator extends AMazeGenerator{


    @Override
    public Maze generate(int rows, int columns) { //TODO: add a valid path
        //check input TODO: ask if ok
        if (rows<6)
            rows =6;
        if (columns<6)
            columns=6;
        int[][] mat = new int[rows][columns];
        for (int i=0; i<rows; i++ ){
            for (int j=0; j<columns; j++){
                int rand = (int) (Math.random() * (10));
                // put walls in 10% of the cases
                if (rand==9)
                    mat[i][j] = 1;
                    // put pass in the rest
                else
                    mat[i][j] = 0;
            }
        }
        Position[] startEnd = creatStartEnd(rows, columns);
        Position start = startEnd[0];
        Position end = startEnd[1];

        // make sure start and end are 0 (there is a path between start and end)
        while (mat[start.getRowIndex()][start.getColumnIndex()] !=0 || mat[end.getRowIndex()][end.getColumnIndex()] !=0){
            startEnd = creatStartEnd(rows, columns);
            start = startEnd[0];
            end = startEnd[1];
        }

        Maze simpleMaze = new Maze(mat, start, end);
        return simpleMaze;
    }
}
