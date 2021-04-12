package finalGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Omok extends JFrame{
	public omP1 omPL1;
	static int status=0;
	public JTextField [] userTF; 
	public JButton coinB, gameStart;
	public String [] userName;
	static int boardNum=20;//������ �� ������ �ڵ����� 20*20�� �⺻���� �ǵ��� ����
	static JLabel starterL;
	static String [] user= {"user 1", "user 2"};
	static int face;//�����ϴ� �ڸ� ��Ÿ���� ����
	static int faceN;//�������� �ʴ� ����� ��Ÿ���� ����. MouseEventHandler Ŭ�������� showPopUp�Լ��� ���� ����.
	public Omok(){
		setTitle("���� ���� ����");
		setSize(400, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setLayout(null);
		omPL1=new omP1();
		omPL1.setBounds(0, 0, 400, 600);
		//add(omPL1);
		setContentPane(omPL1);
	}
	static int getBoardNum() {
		return boardNum;
	}

	class omP1 extends JPanel{
		JLabel user1Lb; JLabel user2Lb;
		JLabel orderLabel, frontLb, backLb, decidedbackLb, startL, selectGndL;
		JComboBox selectUserCombo, gameKindCombo;

		String [] gameKind= {"20*20", "30*30", "40*40", "50*50"};
		int index;
		public GUI omPL2;
		
		public omP1(){
			setLayout(null);
			user1Lb=new JLabel(user[0]+" �̸�: "); user2Lb=new JLabel(user[1]+" �̸�: "); 
			userTF=new JTextField[2];
			userTF[0]=new JTextField(30); userTF[1]=new JTextField(30); 

			orderLabel=new JLabel("���� ������� ���� ����");
			frontLb=new JLabel("��"); backLb=new JLabel("��: ");
			selectUserCombo=new JComboBox(user); decidedbackLb=new JLabel();
			coinB=new JButton("���� ������");
			startL=new JLabel("����: "); starterL=new JLabel();
			selectGndL=new JLabel("������ ����"); 
			gameKindCombo=new JComboBox(gameKind);
			gameStart=new JButton("���� ����");
			gameStart.addActionListener(new omP1Listener());
			coinB.addActionListener(new omP1Listener());
			selectUserCombo.addActionListener(new omP1Listener());

			user1Lb.setBounds(50, 30, 100, 30); add(user1Lb); userTF[0].setBounds(150, 30, 130, 30); add(userTF[0]);
			user2Lb.setBounds(50, 60, 100, 30); add(user2Lb); userTF[1].setBounds(150, 60, 130, 30); add(userTF[1]);
			
			orderLabel.setBounds(50, 110, 150, 30); add(orderLabel);
			frontLb.setBounds(50, 140, 20, 30); add(frontLb); selectUserCombo.setBounds(70, 140, 100, 30); add(selectUserCombo); backLb.setBounds(200, 140, 30, 30); add(backLb); decidedbackLb.setBounds(230, 140, 100, 30); add(decidedbackLb); 
			coinB.setBounds(50, 190, 130, 30); add(coinB); startL.setBounds(200, 190, 60, 30); add(startL); starterL.setBounds(260, 190, 130, 30); add(starterL);
			
			selectGndL.setBounds(50, 260, 100, 30); add(selectGndL); gameKindCombo.setBounds(160, 260, 100, 30); add(gameKindCombo); gameKindCombo.addActionListener(new omP1Listener2());
			gameStart.setBounds(250, 350, 100, 30); add(gameStart); 
		}
		
		class omP1Listener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==coinB) {
					Random rand=new Random();
					face=rand.nextInt(2);
					if(face==0) {
						starterL.setText(user[1]);
						faceN=1;
					}
					else {
						starterL.setText(user[0]);
						faceN=0;
					}
				}
				else if(e.getSource()==gameStart) {
					dispose();
				//	setContentPane(omPL2);
					omPL2=new GUI("����");
					System.out.println("omPL2 !");
				}
				else {
					JComboBox jcb=(JComboBox)e.getSource();
					index=jcb.getSelectedIndex();
					if(index==0)
						decidedbackLb.setText(user[1]);
					else if(index==1)
						decidedbackLb.setText(user[0]);
				}
			}
		}
		int boardInd;
		class omP1Listener2 implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JComboBox jcb=(JComboBox)e.getSource();
				//gameKindCombo
				boardInd=jcb.getSelectedIndex();
				if(boardInd==0)
					boardNum=20;
				else if(boardInd==1)
					boardNum=30;
				else if(boardInd==2)
					boardNum=40;
				else if(boardInd==3)
					boardNum=50;
			}
		}
	}
}
