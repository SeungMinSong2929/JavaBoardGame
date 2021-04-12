package finalGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MouseEventHandler extends MouseAdapter{
	private Map map;
	private MapSize ms;
	private DrawBoard d;
	private GUI main;
	static int total=0;// 총 수 나타내기 위함
	public MouseEventHandler(Map m, MapSize ms, DrawBoard d, GUI main) {
		map=m;
		this.ms=ms;
		this.d=d;
		this.main=main;
	}
	
	public void mousePressed(MouseEvent arg0) {
		super.mousePressed(arg0);
		
		int x=(int) Math.round(arg0.getX()/(double)ms.getCell())-1;
		int y=(int) Math.round(arg0.getY()/(double)ms.getCell())-2;
		if(x<0||x>(ms.getSize()-1)||y<0||y>(ms.getSize()-1)) //벽에 닿은 경우
			return ;
		
		if(map.getXY(y, x)==map.getBlack()||map.getXY(y, x)==map.getWhite()) 
			//이미 돌이 있는 경우
			return;
		System.out.println(x+" "+y);
		total++;
		map.setMap(y, x);
		
		timeThread t1=d.showThread1();
		t1.stop();
		d.addThread1(new timeThread());
		t1=d.showThread1();
		t1.start();
		
		map.changeCheck();
		d.repaint();
		if(map.winCheck(x, y)) {
			if(map.getCheck()==true) {
				main.showPopUp(Omok.user[Omok.faceN]+" 총 "+total+"수로 백돌 우승");
			}
			else {
				main.showPopUp(Omok.starterL.getText()+" 총 "+total+"수로 흑돌 우승");
			}
		}
	}
}
