package finalGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class mine extends JFrame{
	JPanel 		jp 			=	new JPanel();							//  �������� �����ϱ� ���� �г� ���� 
 	JPanel 		jp2			=	new JPanel();							//  ���¹�ư�� �����ϱ� ���� �г� ���� 
 	JButton 	reset		=	new JButton();							//  ���� ��ư ���� 
 	Random 		rnd 		=	new Random();							//  ���� ��ġ�� ���� �����Լ� ���� 
 						 
 	int[][]		gnd			=	new int[Bomb.bombGnd][Bomb.bombGnd];	//Bomb Ŭ�������� �޺��ڽ��� ���� ������ ���� ����, ���� ���� �迭 ����
 	
 	JButton 	jbN[][]		=	new JButton[Bomb.bombGnd][Bomb.bombGnd];//	���� ������� ���� �迭�� ���� ��ư ����
 	
 	
 	JMenuBar	 mb 		=	new JMenuBar();							//	�޴��� ���� 
 	JMenu 		menu 		=	new JMenu("����");						//	�޴��ٿ� '����'�̶�� �׸� ���� 
 	 
 	ImageIcon icon0 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine0.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon1 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine1.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon2 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine2.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon3 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine3.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon4 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine4.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon5 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine5.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon6 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine6.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon7 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine7.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon8 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine8.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon9 = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/mine9.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon_mine = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/logoS.png");			//	���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon_reset = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/smilingFaceS.png");		//  ���� ǥ�� �� �̹��� ���� 
 	ImageIcon icon_flag = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/flag.png");			//  ��� ǥ�� �� �̹��� ���� 
 	ImageIcon icon_flagx = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/logoXs.png");		//  �߸��� ��ġ�� ��� ��ġ�� �˷��� �̹��� ���� 
 	ImageIcon logo = new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/logo.png");				//  ���� �ΰ� ���� �� �̹��� ���� 
 	ImageIcon question=new ImageIcon("C:/Users/�۽¹�/Desktop/project11/src/images/questionMarkS.png");   //�� �� ��Ŭ���� ��Ÿ�� ����ǥ �̹��� ����
 
 	int flagCheck; //����� �����ִ��� Ȯ���ϱ� ����
 	int frameW=280;
 	int frameH=380;
 	JLabel leftBombL;
 	private JLabel Rtime;
 	MyThread timeTh;
 	static Vector vc=new Vector();
 	JTextField textUser;
 public mine() { 
 	super("����ã��"); 																				// Ÿ��Ʋ ���� 
 	setResizable(true);																				// ������ ������ ���������ϰ� ���� 
 																									/*  
 																									 * �ٸ� ���̵����� �ٸ� ���̵��� �Ѿ�� 
																									 * ������ ����� �����ϱ� ������ 
 																									 */ 
 	this.setIconImage(logo.getImage());																// ����� ���� ��ܿ� ���� ������ ���� �̹����� ���� 
 	
 	
 	
 	
 	if(level == 0) level = 10;																		// �������� ������ 0(�ʱⰪ�� 0��)�� ��� 1�� ������. 
 	
 	if(level == 10) {																				// ���� ���� 1(�ʱ޴ܰ�)�� ��� 
 																									// �޴��� ���� ���� 
 		menu.add(new JMenuItem("���� �����ϱ�")).addActionListener(new ActionListener() { 				// �޴��ٿ��� �ٽ��ϱ� Ŭ���� 
 			public void actionPerformed(ActionEvent e) { dispose();	new mine();	} });				// �͸����ʷ� ó�� 
 		
 		menu.addSeparator(); 																		// �޴��ٿ� �ٱ߱� 
 		menu.add(new JMenuItem("����")).addActionListener(new ActionListener() { 						// �޴��ٿ��� ����޴� ���ý� 
 			public void actionPerformed(ActionEvent e) {System.exit(0);} });						// ���������� �͸����ʷ� ó����. 
 	    																							/* 
 	    																							 * Ȯ���ϰ� �����Ҷ����� �ݵ�� 
 	    																							 * �� ��ɾ� (System.exit(0);) �� ����� �� 
 	    																							 * */ 
 		mb.add(menu); 																				// �޴���(mb)�� �޴�(menu)�� �߰� 
 		this.setJMenuBar(mb);																		// ����(this) ������(JFrame)�� �޴��ٸ� �߰��� 
 		this.setLayout(new BorderLayout());															// ���� �������� ���̾ƿ��� ����(BorderLayout) 
 		Rtime=new JLabel(); timeTh=new MyThread(); timeTh.start(); jp2.add(Rtime);
 		add(jp);																					// �������� �����ϱ� ���� �г��� �� �����ӿ� �߰� 
 		add(jp2, "North");																			// ���� ��ư�� ��� ���� �г��� ���ʿ� �߰��� 
 		jp2.add(reset); 																			// �гο� ���� ��ư �߰� 
 		reset.setIcon(icon_reset);																	// ���¹�ư ������ ���� 
 		reset.setBorderPainted(false);																// ��ư�� �ܰ����� �Ⱥ��̰� ���� 
 		reset.setContentAreaFilled(false);															// ��ư�� ���ο��� ä��� �Ⱥ��̰� ����(�Ķ���) 
 		reset.setFocusPainted(false);																// ��ư�� ��Ŀ��(���콺�� �ö� ����)�� ����� �׵θ��� �Ⱥ��̰� ������ 
 		reset.addActionListener(new ActionListener() { 												// ���¹�ư�� �������� 
 			public void actionPerformed(ActionEvent e) {											// �͸����ʷ� ó����. �ڵ尡 �ܼ��ϸ鼭 �׼Ǹ����ʰ� �ʿ��Ҷ��� �͸����ʷ� ó���ϴ°� ���� 
 				JOptionPane.showMessageDialog(null, "'����'�Ǿ����ϴ�.");								// ���� ��ư Ŭ���� "'����'�Ǿ����ϴ�."��� �޽����� ��� �˾�â�� ��� 
 				dispose();																			// �ش� �������� ����. 
 				bmCount=Bomb.bombNum;
 				new mine();																			// ���� �ҷ���() 
 			} 
 		});
 		
 		leftBombL=new JLabel(Integer.toString(bmCount));
 		jp2.add(leftBombL);
 		for(; ; ) {																					// ���� ��ġ�� ���� �ݺ��� 
 			for(int i, j, count = 0; count < level;) {													// i, j, count ���� �� �ʱ�ȭ 
 				i=rnd.nextInt(level);																	// i���� 0 ~ 9 ������ ���� ���� 
 				j=rnd.nextInt(level);																	// j���� 0 ~ 9 ������ ���� ���� 
 																									// -------------------------------------------------- 
 				if(gnd[i][j] != -1) {																// -mine[i][j] �迭 ���� -1�� �ƴϸ� (���ڰ� ��ġ���� �ʾ�����)	- 
 					gnd[i][j] = -1;																// -mine[i][j] �迭�� -1�� ����							- 
 					count++;																		// -count���� ����										- 
 				}																					// -�ߺ����� �ɷ����� ������								- 
 			}																						// -------------------------------------------------- 
 			break;																					// ����(count�� 10���� ������?)�� �������� ������ �ݺ��� ���� 
 		} 
 
 
 		for(int i = 0; i < level; i++) {																// ��ư ������ ���� �ݺ��� 
 			for(int j = 0; j < level; j++) {															//  
 				if(gnd[i][j] == 0) { 																// mine�迭 i,j�� �迭 ���� 0�� ��� 
 					jbN[i][j] = new JButton();														// jb(JButton)[i][j]�� ���� 
 					jbN[i][j].setPreferredSize(new Dimension(20, 20));								// jb[i][j]�� ��ư ����� ���� 
 					jbN[i][j].addActionListener(new ButtonListener());								// �Ϲݹ�ư Ŭ���� �����ϱ� ���� �׼Ǹ�����(ButtonListener) ���� 
 					jbN[i][j].addMouseListener(new clickListener());									// ����� ǥ���ϱ� ���� ��Ŭ���� üũ�� ���콺 ������(clickListener)���� 
 					jbN[i][j].setBackground(Color.DARK_GRAY); 
 					jp.add(jbN[i][j]);																// jp(JPanel)�� jb[i][j]�� �߰� 
 				} 
 				else if(gnd[i][j] != 0) { 															// mine�迭 i,j�� �迭 ���� 0�� �ƴҰ�� 
 					jbN[i][j] = new JButton();														// jb(JButton)[i][j]�� ���� 
 					jbN[i][j].setPreferredSize(new Dimension(20, 20));								// jb[i][j]�� ��ư ����� ���� 
 					jbN[i][j].addActionListener(new MineListener());									// ���ڹ�ư Ŭ���� �����ϱ� ���� �׼Ǹ�����(MineListener) ���� 
 					jbN[i][j].addMouseListener(new clickListener());									// ����� ǥ���ϱ� ���� ��Ŭ���� üũ�� ���콺 ������(clickListener)���� 
 					jbN[i][j].setBackground(Color.DARK_GRAY); 
 					jp.add(jbN[i][j]);																// jp(JPanel)�� jb[i][j]�� �߰� 
 				} 
 			} 
 		} 
 
 
 		for(int i=0; i<level; i++) {																	// ���� �ֺ� ĭ�� ���ڸ� ä��� ���� �ݺ��� 
 			for(int j=0; j<level; j++) { 
 				int count=0;																		// ���ڸ� üũ�ϱ� ���� ���� ���� 
 				if(gnd[i][j] != -1) {																// mine[i][j] ��ġ�� �迭���� ���ڰ���(-1) �ƴϸ� 
 					if(i >= 0 && j >= 0 && i <= (level-1) && j <= (level-1)) {										// �迭�� ������ ����� �������� ���� 
 						if(i-1 >= 0 && j-1 >= 0)				// -------------------------------- // 
							if(gnd[i-1][j-1] == -1) count ++;	//				1		2		3--	// 
 						if(i-1 >= 0)							//				0		0		0--	//  
 							if(gnd[i-1][j] == -1) count ++;	//								 -- //  
 						if(i-1 >= 0 && j+1 <= (level-1))		//				4		i,j		5-- // 1~8�� �ڸ��� ���ڰ� �ִ��� üũ�ϰ� 
 							if(gnd[i-1][j+1] == -1) count ++;	//				0		0		0-- // ���ڰ� ������ count�� ���� 
 						if(j-1 >= 0)							//								 -- //  
 							if(gnd[i][j-1] == -1) count ++;	//				6		7		8-- //  
 						if(j+1 <= (level-1))					//				0		0		0-- //  
 							if(gnd[i][j+1] == -1) count ++;	// -------------------------------- //  
 						if(i+1 <= (level-1) && j-1 >= 0) 
 							if(gnd[i+1][j-1] == -1) count ++; 
 						if(i+1 <= (level-1)) 
 							if(gnd[i+1][j] == -1) count ++; 
 						if(i+1 <= (level-1) && j+1 <= (level-1)) 
 							if(gnd[i+1][j+1] == -1) count ++; 
 					}											 
 					gnd[i][j] = count;																// üũ�� ������ mine[i][j]�� count�� ���� 
 				} 
 				count = 0;																			// �ݺ��ϱ����� count�� �ʱ�ȭ 
 			} 
 	 		ending = false;																				// ���� ���� �������� �ٲ� 
 		setVisible(true); 																			// ������ ���̱� 
 		setSize(frameW, frameH); 																			// ������ ������ ���� ������ 
 		setResizable(false);																		// ������ ����� ������ �������� ���ϰ� ��� 
 		this.setLocationRelativeTo(null);															// ȭ�� �߾ӿ� ���� 
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);												// X��ư ������ �ݱ� 
 																									// ���� ���ϸ� ���μ�����(��׶��忡) �������� 
 		} 
 	 
 	}
 
 		/* �Ʒ� 20*20~50*50������  
 		 * �ʱ� ���� level���� �񱳿� 
 		 * ��ư�� ���ڹ迭�� ������� �⺻���� �ٸ��� 
 		 * ��� ������ ���� 
 		 */ 
 	if(level != 10) { 
 		setResizable(true); 
 		JMenuBar mb = new JMenuBar(); 
 		JMenu menu = new JMenu("����"); 
 		
 
 		menu.add(new JMenuItem("���� �����ϱ�")).addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) { 
 				dispose(); 
 				new mine(); 
 			} 
 		}); 

 		menu.addSeparator(); 
 	 
 		menu.add(new JMenuItem("����")).addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) { 
 				System.exit(0); 
 			} 
 		}); 
 		mb.add(menu); 
 	 
 		this.setJMenuBar(mb); 
 	 
 		this.setLayout(new BorderLayout()); 
 		add(jp); 
		add(jp2, "North"); 
 		jp2.add(reset); 
 		
 		Rtime=new JLabel(); timeTh=new MyThread(); timeTh.start(); jp2.add(Rtime);
 		leftBombL=new JLabel(Integer.toString(bmCount));
 		jp2.add(leftBombL);
 		
 		reset.setIcon(icon_reset); 
 		reset.setBorderPainted(false); 
 		reset.setContentAreaFilled(false); 
 		reset.setFocusPainted(false); 
 		reset.addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) { 
 				JOptionPane.showMessageDialog(null, "'����'�Ǿ����ϴ�."); 
 				dispose(); 
 				bmCount=Bomb.bombNum;//�ٽ� ����
 				new mine(); 
 			} 
 		}); 
 
 
 		for(; ; ) { 
 			for(int i, j, count = 0; count < level*2;) { 
 				i=rnd.nextInt(level); 
 				j=rnd.nextInt(level); 
 				if(gnd[i][j] != -1) { 
 					gnd[i][j] = -1; 
 					count++; 
 				} 
 			} 
 			break; 
 		} 
 	 
 		for(int i = 0; i < level; i++) { 
 			for(int j = 0; j < level; j++) { 
 			if(gnd[i][j] == 0) { 
 				jbN[i][j] = new JButton(); 
 				jbN[i][j].setPreferredSize(new Dimension(20,20)); 
 				jbN[i][j].addActionListener(new ButtonListener()); 
 				jbN[i][j].addMouseListener(new clickListener()); 
 				jbN[i][j].setBackground(Color.DARK_GRAY); 
     	 
 				jp.add(jbN[i][j]); 
 			} 
 			else if(gnd[i][j] != 0) { 
 				jbN[i][j] = new JButton(); 
 				jbN[i][j].setPreferredSize(new Dimension(20,20)); 
 				jbN[i][j].addActionListener(new MineListener()); 
 				jbN[i][j].addMouseListener(new clickListener()); 
 				jbN[i][j].setBackground(Color.DARK_GRAY); 
 				jp.add(jbN[i][j]); 
 			} 
 			} 
 		} 
 		for(int i=0; i<level; i++) { 
 			for(int j=0; j<level; j++) { 
 				int count=0; 
 				if(gnd[i][j] != -1) { 
 					if(i >= 0 && j >= 0 && i <= (level-1) && j <= (level-1)) { 
 						if(i-1 >= 0 && j-1 >= 0) 
							if(gnd[i-1][j-1] == -1) count ++; 
 						if(i-1 >= 0) 
 							if(gnd[i-1][j] == -1) count ++; 
 						if(i-1 >= 0 && j+1 <= (level-1)) 
 							if(gnd[i-1][j+1] == -1) count ++; 
 						if(j-1 >= 0) 
 							if(gnd[i][j-1] == -1) count ++; 
 						if(j+1 <= (level-1)) 
 							if(gnd[i][j+1] == -1) count ++; 
 						if(i+1 <= (level-1) && j-1 >= 0) 
 							if(gnd[i+1][j-1] == -1) count ++; 
 						if(i+1 <= (level-1)) 
 							if(gnd[i+1][j] == -1) count ++; 
 						if(i+1 <= (level-1) && j+1 <= (level-1)) 
 							if(gnd[i+1][j+1] == -1) count ++; 
 					} 
 					gnd[i][j] = count; 
 				} 
 				count = 0; 
 			} 
 		} 
 		 
 		ending = false; 
 		setVisible(true); 
 		setSize(frameW*(level/10), frameH*(level/10)); 
 		setResizable(false); 
 		this.setLocationRelativeTo(null);  
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 	} 
 }
 
 
 private class ButtonListener implements ActionListener  { 											// ���ڰ� �ƴ� ��ư Ŭ�������� ����Ǵ� �׼Ǹ����� 
 	public void actionPerformed(ActionEvent e) {													 
 			for(int i = 0; i < level; i++) {															// �ش� ��ư�� �迭���� ã�� ���� �ݺ��� 
 				for(int j = 0; j < level; j++) { 
 					if(e.getSource() == jbN[i][j] && jbN[i][j].getBackground() == Color.DARK_GRAY) {	// �Ѿ�� e ���� jb[i][j]�� ���� ���� ��׶����÷��� DARK_GRAY�� 
						check(i, j);																// check�� (i,j)���� �Ѱ��� 
 					} 
 				} 
 			} 
 } 
 }
public static Vector getVec() {
	return vc;
}
 private class MineListener implements ActionListener  { 												// ������ ��ư�� Ŭ�������� ����Ǵ� �׼Ǹ����� 
 	public void actionPerformed(ActionEvent e) { 
 		if(ending == false) {
 			timeTh.stop();
 			JOptionPane.showMessageDialog(null, "�ƽ����ϴ�. ���ڸ� Ŭ���߽��ϴ�.");								// �������� false�� ��� "�ƽ����ϴ�. ���ڸ� Ŭ���߽��ϴ�."��� �޽����� ��� �˾�â�� ��� 
 			JOptionPane.showMessageDialog(null, "����� �̸��� �Է��ϼ���");
 			textUser=new JTextField(); 
 			vc.add(Bomb.bombGnd+" "+textUser.getText()+" "+timeTh.getTime());
 			
 		}
 		 
 																									// ���ڷ� ������ ��� ��ư�� ��ġ�� ��Ÿ���� ���� �ݺ��� 
 			for(int i = 0; i <level; i++) { 
 				for(int j = 0; j < level; j++) { 
 					if(gnd[i][j] == -1) {																// �ش� i, j�� ��ġ�� �ִ� ��ư�� ������ ��� 
 							jbN[i][j].setBackground(Color.DARK_GRAY);									// ��׶����÷��� �⺻���� �ٲ� 
 							jbN[i][j].setIcon(icon_mine);												// �����ܿ� ���� �̹����� ���� 
 							ending=true;																// �������� ending�� true�� �ٲ� || ������ ���� �� �ٸ� ���� �� ��ư �������� ���� ���� �ϱ� ������ 
 						} 
 						else if (gnd[i][j] != -1 && jbN[i][j].getBackground() != Color.DARK_GRAY) {		// �ش� i, j�� ��ġ�� �ִ� ��ư�� ���ڰ� �ƴϸ鼭 �⺻���� �ƴҰ�� (����� �������) 
 							jbN[i][j].setBorderPainted(false);											// BorderPainted ���� false�� �ٲ� 
 							jbN[i][j].setBackground(Color.DARK_GRAY);									// ��׶����÷��� �⺻���� �ٲ� 
 							jbN[i][j].setIcon(icon_flagx);												// ��߿� x ǥ�õ� �������� ���� 
 						} 
 						else 
 							jbN[i][j].setBorderPainted(false);											// �� ���� ���(���ڰ� �ƴϸ鼭 ��ߵ� �Ȳ������) 
 						 
 					jbN[i][j].setBorderPainted(false);													// ���ڹ�ư�� �ƴ� ��� ��ư�� Ŭ���ص� ������ ���� �����ϱ� ���� false���� ���� 
 					jbN[i][j].setBackground(Color.DARK_GRAY);											// ��׶����÷��� �⺻���� ���� 
 				} 
 			}  
 	} 
 } 
 
 
 
 
 private class clickListener implements MouseListener{ 																						// ����� ����� ���� ���콺 ������ 
 	 
 	/* 
 	 * ���콺�����ʸ� ����Ҷ� �⺻������ �����Ǵ� �Լ����� 
 	 * ������� �ʴ��� �־����. 
 	 */ 
 	public void mouseClicked(MouseEvent e) { 
 		 
 	} 
 
 
 	public void mousePressed(MouseEvent e) { 
			if(e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {																		// Ŭ���� ��ư�� ���콺 ��Ŭ������ �� 
 				for(int i = 0; i<level; i++) {																									// ��Ŭ���� ��ư�� ã������ �񱳹� 
 					for(int j = 0; j<level; j++) { 
 						if(e.getSource() == jbN[i][j] && jbN[i][j].isBorderPainted()==true && jbN[i][j].getBackground() == Color.DARK_GRAY) {	// ��Ŭ���� ��ư�� �⺻ ���¸� 
 							jbN[i][j].setIcon(icon_flag);																					// ����� ���� 
 							jbN[i][j].setBackground(Color.GRAY);																				// ����� Ȯ���ϱ� ���� ��׶��� �÷��� ���� 
 							flagCheck=1;
 							bmCount--;
 							leftBombL.setText(Integer.toString(bmCount));
 					 	//	jp2.add(leftBombL);
 						} 
 						else if(e.getSource() == jbN[i][j] && jbN[i][j].isBorderPainted()==true && jbN[i][j].getBackground() == Color.GRAY) {	// ����� ���� ��ư�̸� 
 							if(flagCheck==1) {
 								jbN[i][j].setIcon(question);																							// 2�� ��Ŭ�� �� ����ǥ �̹����� ���� 
 								jbN[i][j].setBackground(Color.GRAY);																					// �ٽ� ���� ������� ���ư��� ���� ������ GRAY�� ����
 								flagCheck=2;
 								bmCount++;
 								leftBombL.setText(Integer.toString(bmCount));
 						// 		jp2.add(leftBombL);
 							}
 							else if(flagCheck==2) {
 								jbN[i][j].setIcon(null);																							// �ش� ��ư�� �������� ����� 
 								jbN[i][j].setBackground(Color.DARK_GRAY);																		// �⺻������� ���� 
 								leftBombL.setText(Integer.toString(bmCount));
 						 	//	jp2.add(leftBombL);
 							}
 						}																													

 					} 
 				} 
 			} 
	
 	} 
 
 
 	public void mouseReleased(MouseEvent e) { 
 		// TODO Auto-generated method stub 
 		
 	} 
 
 	public void mouseEntered(MouseEvent e) { 
 		// TODO Auto-generated method stub 
 		
 	} 
 
 	public void mouseExited(MouseEvent e) { 
		// TODO Auto-generated method stub 	 
 		
 	} 
 } 
 
 
 private void check(int i, int j) {																	// ���ϱ� ���� �Լ� 
																				
 		try {																						// �迭�� ������ ����� ó���ϱ� ���� try~catch�� 
			if(gnd[i][j] == 0 && jbN[i][j].isBorderPainted() == true) {								// �ش� mine[i][j]���� 0�� ���� �����鼭 ��ư�� Ȱ��ȭ�� ���¿� ������� 
 				jbN[i][j].setIcon(icon0);															// ����0�� ���ϱ� ���� �̹����� ���� 
 				jbN[i][j].setBorderPainted(false);													// ��ư�� �ܰ����� �Ⱥ��̰� ���� 
 				jbN[i][j].setContentAreaFilled(false);												// ��ư�� ���ο��� ä��� �Ⱥ��̰� ����(�Ķ���) 
 				jbN[i][j].setFocusPainted(false);													// ��ư�� ��Ŀ��(���콺�� �ö� ����)�� ����� �׵θ��� �Ⱥ��̰� ������ 
 				check(i+1, j);																		// �ֺ��� 0�� �ִ��� Ȯ���ϱ� ���� 
 				check(i-1, j); 
				check(i, j+1); 
 				check(i, j-1); 
				check(i+1, j+1); 
 				check(i-1, j-1); 
 				check(i-1, j+1); 
 				check(i+1, j-1); 
 			} 
			else {																					// �׿��� ��� 
 				if(jbN[i][j].isBorderPainted() == true) {											// �ش� mine[i][j]�� ���� 0�� �ƴѰ���� 
 																									// �� �Լ��� �ҷ����� ��� ��ü�� ���ڰ� �ƴѰ���̱� ������ 
 																									// ������ ��츦 üũ�� �ʿ�� ���� 
 					switch(gnd[i][j]) {															// ����ġ ���̽��� 
 					case 1:																			// 1~9�� ��� �� ���ڿ� �´� �̹����� ������ 
 						jbN[i][j].setIcon(icon1); 
 						jbN[i][j].setBorderPainted(false); 
 						jbN[i][j].setContentAreaFilled(false); 
 						jbN[i][j].setFocusPainted(false); 
 						break; 
 					case 2: 
 						jbN[i][j].setIcon(icon2); 
 						jbN[i][j].setBorderPainted(false); 
 						jbN[i][j].setContentAreaFilled(false); 
 						jbN[i][j].setFocusPainted(false); 
 						break; 
 					case 3: 
 						jbN[i][j].setIcon(icon3); 
 						jbN[i][j].setBorderPainted(false); 
 						jbN[i][j].setContentAreaFilled(false); 
 						jbN[i][j].setFocusPainted(false); 
 						break; 
 					case 4: 
 						jbN[i][j].setIcon(icon4); 
 						jbN[i][j].setBorderPainted(false); 
 						jbN[i][j].setContentAreaFilled(false); 
 						jbN[i][j].setFocusPainted(false); 
 						break; 
 					case 5: 
 						jbN[i][j].setIcon(icon5); 
 						jbN[i][j].setBorderPainted(false); 
 						jbN[i][j].setContentAreaFilled(false); 
 						jbN[i][j].setFocusPainted(false); 
 						break; 
 					case 6: 
 						jbN[i][j].setIcon(icon6); 
 						jbN[i][j].setBorderPainted(false); 
						jbN[i][j].setContentAreaFilled(false); 
 						jbN[i][j].setFocusPainted(false); 
 						break; 
 					case 7: 
 						jbN[i][j].setIcon(icon7); 
 						jbN[i][j].setBorderPainted(false); 
 						jbN[i][j].setContentAreaFilled(false); 
 						jbN[i][j].setFocusPainted(false); 
 						break; 
 					case 8: 
 						jbN[i][j].setIcon(icon8); 
 						jbN[i][j].setBorderPainted(false); 
 						jbN[i][j].setContentAreaFilled(false); 
 						jbN[i][j].setFocusPainted(false); 
 						break; 
					case 9: 
 						jbN[i][j].setIcon(icon9); 
 						jbN[i][j].setBorderPainted(false); 
 						jbN[i][j].setContentAreaFilled(false); 
 						jbN[i][j].setFocusPainted(false); 
 						break; 
 					} 
 				} 
 			} 
 			victory();																				// �¸� ������ Ȯ���ϱ� ���� ȣ���� 
 		} 
 		catch(java.lang.ArrayIndexOutOfBoundsException e){ 
 			 
 		}  
 } 
 
 
 private void victory() {																			// �¸� ������ Ȯ��  
 		int count = 0; 
 		for(int i=0; i<level; i++) { 
 			for(int j=0; j<level; j++) { 
 				if(this.gnd[i][j] != -1 && this.jbN[i][j].isBorderPainted() == false) {				// �ش� i,j�� ���ڰ� �ƴϸ鼭 BorderPainted�� false�� ��� 
 					count++;																		// �� ���ڰ� �ƴϸ鼭 Ŭ���� ��츦 ���� 
 				} 
 			} 
 		} 
 		if(count >= 90*(level/10)*(level/10)) {																			// ���ڰ� �ƴϸ鼭 Ŭ���� ��찡 90�̻��� ��� 
 			for(int i=0; i<level; i++) { 
 				for(int j=0; j<level; j++) { 
 					if(jbN[i][j].isBorderPainted() == true) {										// BorderPainted�� true�� ��찡 �ִٸ� 
 						jbN[i][j].setBorderPainted(false);											// false�� ���� 
 						if(gnd[i][j] == -1)														// ���ڸ� 
 							jbN[i][j].setIcon(icon_mine);											// ���� �̹����� ������ ���� 
 					} 
 				} 
 			} 
 			if(ending==false) {																		// �������� ������ ��� 
 				JOptionPane.showMessageDialog(null, level+" �����մϴ�. �¸��߽��ϴ�!");							// �¸� �޽��� ��� 
 				ending = true;																		// �������� ������ ���� 
 			} 
 		} 
 } 
 class MyThread extends Thread{
	 private int TIME=0;
	    public void run() {
	    	
	        for(int i=0;i<=20000;i++) {
	            try {
	            	Thread.sleep(1100);
	            }catch(InterruptedException e) {
	            	e.printStackTrace();
	            }
	            Rtime.setText("�ð�: "+i);
	            TIME=i;
	         }
	      }
	    public int getTime() {
	    	return TIME;
	    }
	 }
 
 
 
 
// public static void main(String[] args) { 
// 	// TODO Auto-generated method stub 
// 	new mine();																						// ���α׷� ����� ������ �ҷ����� 
// 	}
 static int level = Bomb.bombGnd; static boolean ending = false;											// �������� level ���� �� Bomb.bombGnd�� Bomb���� ������ ���� �� ���� �ޱ�, ending ���� �� false�� �ʱ�ȭ 
 static int bmCount=Bomb.bombNum;//Bomb.bombNum���� ���� ���� �޾ƿ���

} 

