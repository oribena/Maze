package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {
    private Position pos;
    private int val;

//    public MazeState() {
//        super();
//    }

    public MazeState(Position pos, int val) {
        this.pos = pos;
        this.val = val;
    }

    public Position getPos() {
        return pos;
    }

    public int getVal() {
        return val;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MazeState state1 = (MazeState)obj;
        if (this.getPos().toString().equals(state1.getPos().toString()))
            return true;
        return false;
        }
    }
