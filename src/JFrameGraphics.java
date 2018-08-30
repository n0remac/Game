
import java.awt.Graphics;
import javax.swing.JPanel;

public class JFrameGraphics extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public String printMe;
	
	Board board;
	Tile[][] tiles;

	int tileMod = 50;
	int tileWidth = tileMod;
	int tileHeigth = tileMod;
	int tileSpacing = tileMod;
	
	public JFrameGraphics(Board board){
		this.board=board;
		tiles=this.board.getBoard();
	}

	public void paint(Graphics g){
		super.paint(g);
		for(int i=0;i<board.getC();i++){
			int x=i*tileSpacing;;
			for(int j=0;j<board.getR();j++){
				int y= j*tileSpacing;
				switch(tiles[j][i]){
					case PLAYER:
						g.drawOval(x,y, tileWidth, tileHeigth);
						break;
					case BLANKSPACE:
						g.drawRect(x, y, tileWidth, tileHeigth);
						break;
					case MONSTER:
						g.fillRect(x, y, tileWidth, tileHeigth);
				}
			}
		}

	}
	
	
	
	
}	

