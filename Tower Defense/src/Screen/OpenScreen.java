package Screen;

import javax.swing.JFrame;


public class OpenScreen {
	public OpenScreen(){
		JFrame f = new JFrame("Title");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setSize(800, 600);
		f.setVisible(true);
	}
}
