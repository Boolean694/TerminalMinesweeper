
public class Tile {
	private boolean Open; //Was this tile accessed?
	private boolean Flagged; //Was this tile flagged?
	private boolean Cleared; //Was this tile cleared?
	private boolean Mine; //Is this tile a mine?
	private int RowPos; //Row this tile is in
	private int ColPos; //Column this tile this in
	private int TileNum; //Number of mines around this tile in a 3x3 radius (including corners) (-1 for mines)

	public Tile(boolean m, int rp, int cp) {
		Mine = m;
		RowPos = rp;
		ColPos = cp;
		Open = false;
		Cleared = false;
		Flagged = false;
	}
	public Tile(int rp, int cp) {
		Mine = false;
		RowPos = rp;
		ColPos = cp;
		Open = false;
		Cleared = false;
		Flagged = false;
	}
	public int getX(){
		return ColPos;
	}
	public int getY(){
		return RowPos;
	}
	public boolean isMine() {
		return Mine;
	}
	public boolean isFlagged() {
		return Flagged;
	}
	public void setOpen(){
		Open = true;
	}
	public boolean isOpen(){
		return Open;
	}
	public void setMine() {
	    Mine = true;
	}
	public void setTileNum(int n) {
		if(Mine) {TileNum = -1;}
		else {TileNum = n;}
	}
	public int getTileNum() {
		return TileNum;
	}
	public boolean clear() {
		Open = true;
		Cleared = true;
		if(Mine) {return false;}
		return true;
	}
	// clearspread deletes flags when flagging then unflagging and flagging but when u just do one flag it works...
	public void flag() {
		if (Open == false){
			Flagged = true;
		}
	}
	public boolean unMine() {
		boolean bool = Mine;
		Mine = false;
		return bool;
	}
	public boolean isCleared() {
		return Cleared;
	}
	public void unflag() {
		Flagged = false;
	}

	public String toString() {
		if(!Open) {
			if(Flagged){
				return ">"; //> = flag
			}
			return "_";
		}
		if(Mine) {return "@";} //@ = mine
		if(TileNum == 0) {return " ";}
		return "" + TileNum;
	}
}
