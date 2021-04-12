package finalGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawBoard extends JPanel{
	private MapSize size;
	private Map map;
	private final int STONE_SIZE=18;
	
	JButton goBackB;//한 수 물리기 버튼
	static JLabel Rtime;
	JLabel user1Nm, user2Nm;
	private timeThread myThread1, myThread2;

	public DrawBoard(MapSize m, Map map) {
		setBackground(new Color(206, 167, 61));
		size=m;
		setLayout(null);
		this.map=map;
		user1Nm=new JLabel(Omok.user[0]);  user1Nm.setBounds(Omok.boardNum*30-150, 80, 100, 30); add(user1Nm);
		user2Nm=new JLabel(Omok.user[1]); user2Nm.setBounds(Omok.boardNum*30-150, 120, 100, 30); add(user2Nm);
		goBackB=new JButton("goBack"); goBackB.setBounds(Omok.boardNum*30-150, 650, 120, 30); add(goBackB); //goBackB.addActionListener(new omP2Listener());
		
		Rtime=new JLabel("시간"); Rtime.setBounds(Omok.boardNum*30-150, 200, 100, 30); add(Rtime);
		myThread1=new timeThread(); 
		myThread1.start();
	}
	
	public timeThread showThread1() {
		timeThread td=myThread1;
		return td;
	}
	
	public void addThread1(timeThread t) {
		myThread1=t;
	}
	
	
	public void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		arg0.setColor(Color.BLACK);
		board(arg0);
		drawStone(arg0);
	}
	
	public void board(Graphics arg0) {
		for(int i=1;i<=size.getSize();i++){
			
			arg0.drawLine(size.getCell(), i*size.getCell(), size.getCell()*size.getSize(), i*size.getCell()); 

			arg0.drawLine(i*size.getCell(), size.getCell(), i*size.getCell() , size.getCell()*size.getSize()); 
		}
	}

	public void drawStone(Graphics arg0) {
		for(int y=0;y<size.getSize();y++){
			for(int x=0;x<size.getSize();x++){
				
				if(map.getXY(y, x)==map.getBlack())
					drawBlack(arg0, x, y);
				else if(map.getXY(y, x)==map.getWhite())
					drawWhite(arg0, x, y);
			}
		}
	}
	public void drawBlack(Graphics arg0,int x,int y){
		
		arg0.setColor(Color.BLACK);
		arg0.fillOval((x+1)*size.getCell()-size.getCell()/2, (y)*size.getCell()+size.getCell()/2, STONE_SIZE, STONE_SIZE);
	}

	public void drawWhite(Graphics arg0,int x,int y){
		
		arg0.setColor(Color.WHITE);
		arg0.fillOval(x*size.getCell()+size.getCell()/2, y*size.getCell()+size.getCell()/2, STONE_SIZE, STONE_SIZE);
	}

}
