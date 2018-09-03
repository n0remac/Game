import java.util.Scanner;

public class Player extends GameObject{
	int health=10;
	
	public Player(){
		type=Tile.PLAYER;
	}

	public Player(int r, int c){
		setR(r);
		setC(c);
		type=Tile.PLAYER;
	}
	
	public void update(Board board){ //this is where the players movements are input
		String key=getKey(board);
		board.changeTile(Tile.BLANKSPACE, r,c);

		
		if (key.compareTo("w")==0)
			this.r--;
		else if (key.compareTo("a")==0)
			this.c--;
		else if (key.compareTo("s")==0)
			this.r++;
		else if (key.compareTo("d")==0)
			this.c++;

		board.changeTile(type, r,c);

	}
	
	private boolean positionIsValid(String direction, Board B){
		
		if (direction.compareTo("w")==0){//r--
			int x=r-1;
			if (x<0)
				return false;
		}
		else if (direction.compareTo("a")==0){//c--
			int x=c-1;
			if (x<0)
				return false;			
		}
		else if (direction.compareTo("s")==0){//r++
			int x=r+1;
			if (x>=B.getR())
				return false;
		}
			
		else if (direction.compareTo("d")==0){//c++
			int x=c+1;
			if (x>=B.getR())
				return false;
		}
		return true;
	}
	
	private String getKey(Board B){
		Scanner kb=new Scanner(System.in);
		Boolean isValid=false;
		String input="";
		
		while (!isValid){

			input=kb.next();
			
			if (input.compareTo("w")==0){
				if (positionIsValid("w", B))
					isValid=true;
			}
			else if (input.compareTo("a")==0){
				if (positionIsValid("a", B))
					isValid=true;
			}
			else if (input.compareTo("s")==0){
				if (positionIsValid("s", B))
					isValid=true;
			}
			else if (input.compareTo("d")==0){
				if (positionIsValid("d", B))
					isValid=true;
			}
			
			
		}
		return input;
	}
	
	public void update(){
		//callBack function for death
		if(health == 0){
			
		}
		
	}

}