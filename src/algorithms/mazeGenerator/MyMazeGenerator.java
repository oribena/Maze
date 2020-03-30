package algorithms.mazeGenerator;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns) {
        int[][] mat = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat[i][j] = 1;
            }
        }

        LinkedList<Position[]> neighbors = new LinkedList<>();
        int x = (int) (Math.random() * (rows));
        int y = (int) (Math.random() * (columns));
        Position pos = new Position(x, y);
//        System.out.print(pos);
        neighbors.add(new Position[]{pos, pos});

        while (!neighbors.isEmpty()) {
            Position[] n = neighbors.remove((int) (Math.random() * (neighbors.size())));
            Position Pos2 = n[1];
//            System.out.print(Pos2);
            int x2 = Pos2.getRowIndex();
            int y2 = Pos2.getColumnIndex();
            Position Pos1 = n[0];
//            System.out.print(Pos1);
            int x1 = Pos1.getRowIndex();
            int y1 = Pos1.getColumnIndex();

            Position tempPos1;
            Position tempPos2;

            if (mat[x2][y2] == 1) {
                mat[x1][y1] = mat[x2][y2] = 0;
                if (x2 >= 2 && mat[x2 - 2][y2] == 1) {
                    tempPos1 = new Position(x2 - 1, y2);
                    tempPos2 = new Position(x2 - 2, y2);
//                    System.out.print(tempPos1);
//                    System.out.print(tempPos2);
                    neighbors.add(new Position[]{tempPos1, tempPos2});
                }
                if (y2 >= 2 && mat[x2][y2 - 2] == 1) {
                    tempPos1 = new Position(x2, y2 - 1);
                    tempPos2 = new Position(x2, y2 - 2);
//                    System.out.print(tempPos1);
//                    System.out.print(tempPos2);
                    neighbors.add(new Position[]{tempPos1, tempPos2});
                }
                if (x2 < rows - 2 && mat[x2 + 2][y2] == 1) {
                    tempPos1 = new Position(x2 + 1, y2);
                    tempPos2 = new Position(x2 + 2, y2);
//                    System.out.print(tempPos1);
//                    System.out.print(tempPos2);
                    neighbors.add(new Position[]{tempPos1, tempPos2});
                }
                if (y2 < columns - 2 && mat[x2][y2 + 2] == 1) {
                    tempPos1 = new Position(x2, y2 + 1);
                    tempPos2 = new Position(x2, y2 + 2);
//                    System.out.print(tempPos1);
//                    System.out.print(tempPos2);
                    neighbors.add(new Position[]{tempPos1, tempPos2});
                }
            }
        }
        Position[] startEnd = creatStartEnd(rows, columns); //TODO: start and end meet
        Position start = startEnd[0];
        Position end = startEnd[1];
        while (mat[start.getRowIndex()][start.getColumnIndex()] !=0 || mat[end.getRowIndex()][end.getColumnIndex()] !=0){
            startEnd = creatStartEnd(rows, columns);
            start = startEnd[0];
            end = startEnd[1];
        }

        Maze newMaze = new Maze(mat, start, end);
        return newMaze;
    }
}

//        Position[] startEnd = creatStartEnd(rows, columns);
//        Position start = startEnd[0];
//        Position end = startEnd[1];
//        mat[start.getRowIndex()][start.getColumnIndex()] = 0;
//        ArrayList<Position> wallList = new ArrayList<Position>();
//
//        if (start.getRowIndex()+1 < rows){
//            Position pos = new Position(start.getRowIndex()+1,start.getColumnIndex());
//            wallList.add(pos);
//        }
//        if (start.getRowIndex()-1 >= 0){
//            Position pos = new Position(start.getRowIndex(),start.getColumnIndex()+1);
//            wallList.add(pos);
//        }
//        if (start.getColumnIndex()+1 < columns){
//            Position pos = new Position(start.getRowIndex()-1,start.getColumnIndex());
//            wallList.add(pos);
//        }
//        if (start.getColumnIndex()-1 >=0){
//            Position pos = new Position(start.getRowIndex(),start.getColumnIndex()-1);
//            wallList.add(pos);
//        }
//        while (!wallList.isEmpty()){
//            //1
//            int rand = (int) (Math.random() * (wallList.size()));
//            wallList.remove(wallList.get(rand));
//            //2
//
//
//            mat[wallList.get(rand).getRowIndex()][wallList.get(rand).getColumnIndex()] = 0;
//            }

//        }


