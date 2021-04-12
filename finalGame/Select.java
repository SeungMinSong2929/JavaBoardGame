package finalGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Select extends JFrame{

	public static int selN=0;
	public JButton[] selBut;
	public Omok omokPL; public Bomb bmPL; public Rank rankPL;
	public Select(){
		selBut=new JButton[4];
		selBut[0]=new JButton("오목");
		selBut[1]=new JButton("지뢰 찾기");
		selBut[2]=new JButton("점수/ 순위");
		selBut[3]=new JButton("종료");
		setLayout(null);
		for(int i=0;i<4;i++) {
			selBut[i].setBounds(90, 50+120*i, 200, 80);
			add(selBut[i]);
			selBut[i].addActionListener(new butListener());
		}
			
			setTitle("게임 설정");
			setSize(400,600);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		class butListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==selBut[0]) {
					selN=10; 
					dispose();
					System.out.println(selN);
					omokPL=new Omok(); 
				}
				else if(e.getSource()==selBut[1]) {
					selN=20; 	
					dispose();
					System.out.println(selN);
					bmPL=new Bomb();
				}
				else if(e.getSource()==selBut[2]) {
					selN=30; 
					dispose();
					System.out.println(selN);
					rankPL=new Rank();
				}
				else if(e.getSource()==selBut[3]) {
					System.exit(0);
				}
			}
		}

	}


