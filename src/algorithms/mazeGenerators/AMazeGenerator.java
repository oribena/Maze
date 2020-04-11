package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    public long measureAlgorithmTimeMillis(int rows, int columns){
        //check input TODO: ask if ok
        if (rows<6)
            rows =6;
        if (columns<6)
            columns=6;
        //measureAlgorithmTimeMillis = with maze - without maze
        long firstTime = System.currentTimeMillis();
        generate(rows, columns);
        long secondTime = System.currentTimeMillis();
        return secondTime-firstTime;
    }

    public abstract Maze generate(int rows, int columns);


    public Position[] creatStartEnd(int rows, int columns){ //TODO: check if it works
        Position startPos;
        Position endPos;

        int randStart = (int) (Math.random() * (4));
        int randEnd = (int) (Math.random() * (4));
        // if start and end are both on the same edge
        while (randStart==randEnd){
            randEnd = (int) (Math.random() * (4));
        }

        //create start position
        if (randStart==0){
            int row = (int) (Math.random() * (rows));
            while (row == rows-1 || row == 0)
                row = (int) (Math.random() * (rows));
            startPos = new Position(row, 0);
        }
        else if (randStart==1){
            int col = (int) (Math.random() * (columns));
            while (col==columns-1 || col==0)
                col = (int) (Math.random() * (columns));
            startPos = new Position(0, col);
        }
        else if (randStart==2){
            int row = (int) (Math.random() * (rows));
            while (row == rows-1 || row == 0)
                row = (int) (Math.random() * (rows));
            startPos = new Position(row, columns-1);
        }
        else {
            int col = (int) (Math.random() * (columns));
            while (col==columns-1 || col==0)
                col = (int) (Math.random() * (columns));
            startPos = new Position(rows-1, col);
        }

        //create end position
        if (randEnd==0){
            int row = (int) (Math.random() * (rows));
            while (row == rows-1 || row == 0)
                row = (int) (Math.random() * (rows));
            endPos = new Position(row, 0);
        }
        else if (randEnd==1){
            int col = (int) (Math.random() * (columns));
            while (col==columns-1 || col==0)
                col = (int) (Math.random() * (columns));
            endPos = new Position(0, col);
        }
        else if (randEnd==2){
            int row = (int) (Math.random() * (rows));
            while (row == rows-1 || row == 0)
                row = (int) (Math.random() * (rows));
            endPos = new Position(row, columns-1);
        }
        else {
            int col = (int) (Math.random() * (columns));
            while (col==columns-1 || col==0)
                col = (int) (Math.random() * (columns));
            endPos = new Position(rows-1, col);
        }
        Position[] startEnd = new Position[2];
        startEnd[0] = startPos;
        startEnd[1] = endPos;
        return startEnd;
    }

}
