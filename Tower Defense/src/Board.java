
public class Board {
	int r;
	int c;
	Tile [][] board;
	
	Tile tile;
	
	public Board(){
		r=10;
		c=10;
		board=new Tile[r][c];
		board=setBoard( board, r, c);
	}
	
	public int getR(){
		return this.r;
	}
	
	public int getC(){
		return this.c;
	}

	public void changeTile(Tile type, int r, int c){
	    if(r<this.r&&c<this.c)
		board[r][c]=type;
	}
	
	public Tile[][] getBoard(){
		return this.board;
	}
	
	private Tile[][] setBoard(Tile[][] board, int r, int c){
		for (int y=0; y<r; y++){
			for (int x=0; x<c; x++){
				board[y][x]=Tile.BLANKSPACE;//(char)32;
			}
		}
		return board;
	}
	
	@Override
	public String toString(){
		String ret="";
		for (int y=0; y<r; y++){
			for (int x=0; x<c; x++){
				ret+=board[y][x];
			}
			ret+="\n";
		}
		return ret;
	}


	
	
}
