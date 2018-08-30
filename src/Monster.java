
public class Monster extends GameObject{

	int health=10;

	public Monster(){
		type = Tile.MONSTER;
	}

	private void move(){
		r+=1;
		c+=1;
	}


	
	public void findPath(){}
	
}
