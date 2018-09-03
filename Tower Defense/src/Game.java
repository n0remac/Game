import java.util.*;

public class Game {
	boolean isRunning;
	Player P1;
	Renderer renderer;
	Board board=new Board();
    Stack<Monster> monsters =new Stack<Monster>();


	
	public Game (){
		
		renderer= new Renderer(board);

	}
	
	public void runGame(){

	    P1=createPlayer();

	    isRunning = true;
		renderer.start();

		while(isRunning){
			update();
			
		}
	}


	private void update(){

	    P1.update(board);
	    Stack<Monster> save=new Stack<Monster>();

	    while(!monsters.empty()){
	       Monster m=monsters.pop();
	       m.update(board);
	       if(m.removeFromBoardList) {
               board.changeTile(Tile.BLANKSPACE,m.getR(),m.getC());
           }
	       else
	           save.push(m);

        }

        monsters=save;
        monsters.push(createAsteroid());

	}
	
	public void stopGame(){
		isRunning = false;
	}


	//this creates a monster that moves towards the players initial location.
	private Monster createAsteroid(){
        Monster monster = new Monster(board.getR(), board.getC());
        monster.setTarget(P1.getC(), P1.getR());
        return monster;
	}
	
	private Player createPlayer(){
	    int r=board.getR()/2;
	    int c=board.getC()/2;
	    Player p=new Player(r,c);
	    board.setGameObject(p);
		return p;
	}
	


}
