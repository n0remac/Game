
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Renderer extends TimerTask{
	Board board;
	Timer timer;
	JFrame frame;
	JFrameGraphics JFrame;
	
	public Renderer(Board board){
		this.board=board;
		frame= new JFrame("Game");
		JFrame = new JFrameGraphics(board);
		frame.getContentPane().add(JFrame);
		frame.setSize(600, 600);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		
	}
	public void start(){// might have to debug multiple starts
		timer = new Timer();
		timer.schedule(this, 0, (long)66.6);
	}

	public void stop(){
		timer.cancel();
	}
	
	@Override
	public void run(){
		draw();
	}
	
	private void draw(){
		JFrame.repaint();
	}
	
	
	
	
	
	

	

	
}
