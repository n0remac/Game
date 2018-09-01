

public abstract class GameObject {
    int r=1;
    int c=1;
    Tile type;
    long lastTime;
    double xVel = .001 ;
    double yVel = .001;
    double speed = 1000;


    //this should be a real time movement method. After the elapsed time the velocity is used to calculate the distance used.
    public void update(Board board) {
        long elapsedTime = System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        double xDistance = xVel * elapsedTime;
        double yDistance = yVel * elapsedTime;

        int newR = (int) Math.round(xDistance) + r;
        int newC = (int) Math.round(yDistance) + c;


        if (!isValidPosition(board, newR, newC)) {
        } else {
            board.changeTile(Tile.BLANKSPACE, r, c);
            board.changeTile(type, newR, newC);
            r = newR;
            c = newC;
        }
    }

    //this movement method will move the object one square after a set amount of time.
    public void move(Board board, int x, int y){
        long elapsedTime=System.currentTimeMillis()-lastTime;

        if (elapsedTime>speed){
            lastTime=System.currentTimeMillis();
            updateDirection(board, x, y);
        }

    }

    public int getR(){
        return this.r;
    }

    public int getC(){
        return this.c;
    }

    //this will move the object one square in the direction of t he x y coordinates.
    private void updateDirection(Board board, int x, int y){
        if (isValidPosition(board, x, y)) {
            board.changeTile(Tile.BLANKSPACE,r,c);
            if (x > c) {
                c += 1;
            }
            else if (x < c) {
                c -= 1;
            }
            if (y > r) {
                r += 1;
            }
            else if (y < r) {
                r -= 1;
            }
            board.changeTile(type,r,c);
        }
    }

    //gets the locaarion of the first player in the board list.
    public int[] findPlayer(Board board){
        Player p = (Player) board.getPlayer();
        int y=p.getR();
        int x=p.getC();
        return new int[] {r,c};
    }

    public Tile getType(){
        return this.type;
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
