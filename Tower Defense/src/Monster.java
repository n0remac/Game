
public class Monster extends GameObject{

	int health=10;
	int targetX;
	int targetY;

	public Monster(){
		type = Tile.MONSTER;
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
	public void update(Board board){
		move(board, targetX, targetY);
	}

	//uses setTarget and update to follow the player around.
	public void followPlayer(Board board, Player p){
		setTarget(p);
		update(board);
	}

	//will eventual be used to find the quickest rout to the target.
	public void findPath(){}
	
}
