import java.util.Random;

public class Monster extends GameObject{

	int health=10;
	int targetX;
	int targetY;

	public Monster(int r, int c){
	    Random ran=new Random();
		type = Tile.MONSTER;
		this.r=ran.nextInt(r);
		this.c=ran.nextInt(c);
	}



	public void setTarget(int x, int y){
		targetX=x;
		targetY=y;
	}

	public void setTarget(Player p){
		targetX=p.getC();
		targetY=p.getR();
	}

	//this update will move the object to the target location. It uses the move function and passes in the targets location. The target location can be changed.
	public void update(Board board)
    {
        if(!atLocation())
		    move(board, targetX, targetY);
        else
            removeFromBoardList=true;
	}

	//uses setTarget and update to follow the player around.
	public void followPlayer(Board board, Player p){
		setTarget(p);
		update(board);
	}

	public boolean atLocation(){
	    if(targetY==r&&targetX==c)
	        return true;
	    return false;
    }

	//will eventual be used to find the quickest rout to the target.
	public void findPath(){}
	
}
