
public class Game {
	boolean isRunning;
	Player P1=creatPlayer();
	Monster M1=new Monster();
	Renderer renderer;
	Board board=new Board();
	
	public Game (){
		
		renderer= new Renderer(board);
		
	}
	
	public void runGame(){
		isRunning = true;
		renderer.start();
		M1.prime();

		while(isRunning){
			update();
			
		}
	}

	private void update(){
		P1.update(board);

		M1.followPlayer(board, P1);
	}
	
	public void stopGame(){
		isRunning = false;
	}
	

	
	private Player creatPlayer(){
		Player P=new Player();
		return P;
	}
	


}
