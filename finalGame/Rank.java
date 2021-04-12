package finalGame;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rank extends JFrame {
	private Vector omVc, bmVc;
	MyPanel p;
	Rank(){
		setLayout(null);
		p=new MyPanel(); p.setBounds(0, 0, 400, 600);
		add(p);
		setTitle("게임 순위 ");
		setSize(400,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class MyPanel extends JPanel{
		public MyPanel() {
			omVc=new Vector();
			bmVc=new Vector();
			omVc=mine.getVec();
		}
	}
}
