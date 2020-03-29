package algorithms.mazeGenerator;

import java.util.Arrays;

public class Maze {

    private int[][] mat;
    private Position start;
    private Position end;

    public Maze(int[][] mat, Position start, Position end) {
        this.mat = mat;
        this.start = start;
        this.end = end;
    }

    public Position getStartPosition() {
        return start;
    }

    public Position getGoalPosition() {
        return end;
    }

    public void print(){ //TODO: Print or print
        if (mat == null)
            System.out.print("null"); //TODO: check

        int iMax = mat.length - 1;
        if (iMax == -1)
            System.out.print(""); //TODO: check

        //StringBuilder b = new StringBuilder();
        //System.out.print('[');
        for (int i = 0; i<mat.length ; i++) {
            for (int j=0; j<mat[0].length; j++){
                if (i==start.getRowIndex() && j==start.getColumnIndex()){
                    System.out.print('S');
                }
                else if (i==end.getRowIndex() && j==end.getColumnIndex()){
                    System.out.print('E');
                }
                //if it's the end of a row
                else System.out.print(mat[i][j]);
                if (j==mat[0].length-1){
                    System.out.print('\n');
                }
            }
        }
//            b.append(String.valueOf(mat[i]));
//            if (i == iMax)
//                return b.append(']').toString();
//            b.append(", ");
    }

    @Override
    public String toString() {
        return "Maze{" +
                "mat=" + Arrays.toString(mat) +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
