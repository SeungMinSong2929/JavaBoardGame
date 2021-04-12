package finalGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bomb extends JFrame{
	public bmP1 bmPL1;
	public JButton bmGameStart;
	static int bombGnd=10;
	static int bombNum=20;
	static String [] gameKind= {"10*10", "20*20", "30*30", "40*40", "50*50"};
	static String [] bomb= {"20", "30", "40", "50", "60", "70", "80"};
	public Bomb(){
		setTitle("Bomb Game");
		setSize(400, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bmPL1=new bmP1();
		bmPL1.setBounds(0, 0, 400, 600);
		
		setContentPane(bmPL1);
	}
	class bmP1 extends JPanel{
		JLabel bombNumL, bmGameL;
		JComboBox selectBmGameCombo, selectBombCombo;
	//	String [] gameKind= {"10*10", "20*20", "30*30", "40*40", "50*50"};
	//	String [] bomb= {"20", "30", "40", "50", "60", "70", "80"};
		
		public bmP1(){
			setLayout(null);
			bombNumL=new JLabel("Bomb num: "); bombNumL.setBounds(50, 30, 100, 30); add(bombNumL);
			selectBombCombo=new JComboBox(bomb); selectBombCombo.setBounds(180, 30, 100, 30); selectBombCombo.addActionListener(new bmP1Listener2()); add(selectBombCombo); 
			
			bmGameL=new JLabel("Choose Game"); bmGameL.setBounds(50, 250, 110, 30); add(bmGameL);
			selectBmGameCombo=new JComboBox(gameKind); selectBmGameCombo.setBounds(180, 250, 100, 30); selectBmGameCombo.addActionListener(new bmP1Listener()); add(selectBmGameCombo);
			
			bmGameStart=new JButton("game start"); bmGameStart.setBounds(230, 350, 100, 30); add(bmGameStart);
			bmGameStart.addActionListener(new bmP1Listener());
			
		}
		
		int ind;
		class bmP1Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bmGameStart) {
					dispose();
					new mine();
					System.out.println("bm2 !");
				}
				else {
					JComboBox jcb=(JComboBox)e.getSource();
					ind=jcb.getSelectedIndex();
					if(ind==0) 
						bombGnd=10;
					else if(ind==1) 
						bombGnd=20;
					else if(ind==2) 
						bombGnd=30;
					else if(ind==3) 
						bombGnd=40;
					else if(ind==4) 
						bombGnd=50;
				}
			}
		}
		
		class bmP1Listener2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb=(JComboBox)e.getSource();
				ind=jcb.getSelectedIndex();
				if(ind==0)
					bombNum=20;
				else if(ind==1) 
					bombNum=30;
				else if(ind==2) 
					bombNum=40;
				else if(ind==3) 
					bombNum=50;
				else if(ind==4) 
					bombNum=60;
				else if(ind==5)
					bombNum=70;
				else if(ind==6)
					bombNum=80;
			}
		}
	}
}
