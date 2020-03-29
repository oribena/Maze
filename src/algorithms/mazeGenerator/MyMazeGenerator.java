package algorithms.mazeGenerator;

import java.util.ArrayList;

public class MyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int rows, int columns) {
        int[][] mat = new int[rows][columns];
        for (int i=0; i<rows; i++ ){
            for (int j=0; j<columns; j++){
                mat[i][j] = 1;
            }
        }
        Position[] startEnd = creatStartEnd(rows, columns);
        Position start = startEnd[0];
        Position end = startEnd[1];
        mat[start.getRowIndex()][start.getColumnIndex()] = 0;
        ArrayList<Position> wallList = new ArrayList<Position>();

        if (start.getRowIndex()+1 < rows){
            Position pos = new Position(start.getRowIndex()+1,start.getColumnIndex());
            wallList.add(pos);
        }
        if (start.getRowIndex()-1 >= 0){
            Position pos = new Position(start.getRowIndex(),start.getColumnIndex()+1);
            wallList.add(pos);
        }
        if (start.getColumnIndex()+1 < columns){
            Position pos = new Position(start.getRowIndex()-1,start.getColumnIndex());
            wallList.add(pos);
        }
        if (start.getColumnIndex()-1 >=0){
            Position pos = new Position(start.getRowIndex(),start.getColumnIndex()-1);
            wallList.add(pos);
        }
        while (!wallList.isEmpty()){
            //1
            int rand = (int) (Math.random() * (wallList.size()));
            wallList.remove(wallList.get(rand));
            //2


            mat[wallList.get(rand).getRowIndex()][wallList.get(rand).getColumnIndex()] = 0;
            }


        }





        Maze emptyMaze = new Maze(mat, start, end);
        return emptyMaze;
    }
}
