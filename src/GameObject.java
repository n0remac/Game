

public abstract class GameObject {
    int r=1;
    int c=1;
    Tile type;
    long lastTime;
    double xVel = .001 ;
    double yVel = .001;

    public void update(Board board){
        long elapsedTime=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();

        double xDistance = xVel * elapsedTime;
        double yDistance = yVel * elapsedTime;

        int newR=(int)Math.round(xDistance)+r;
        int newC=(int)Math.round(yDistance)+c;


        if (!isValidPosition(board,newR, newC)) {}
        else {
            board.changeTile(Tile.BLANKSPACE, r, c);
            board.changeTile(type, newR, newC);
            r=newR;
            c=newC;
        }


    }
    //used to test movement. start acceleration
    public void prime(){
        lastTime=System.currentTimeMillis();
    }


    public boolean isValidPosition(Board board, int r, int c){
        if( r>board.getR()||c>board.getC())
            return false;
        return true;
    }

}
