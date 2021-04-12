package finalGame;

public class MapSize {
	private final int CELL=20;//한 칸의 크기
//	private final int CELL=30;//한 칸의 크기
//	private final int SIZE=20;//판의 종류
	private final int SIZE=Omok.getBoardNum();//판의 종류
	
	public int getCell() {
		return CELL;
	}
	public int getSize() {
		return SIZE;
	}

}
