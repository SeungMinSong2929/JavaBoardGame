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
	JPanel 		jp 			=	new JPanel();							//  지뢰판을 설정하기 위한 패널 생성 
 	JPanel 		jp2			=	new JPanel();							//  리셋버튼을 설정하기 위한 패널 생성 
 	JButton 	reset		=	new JButton();							//  리셋 버튼 생성 
 	Random 		rnd 		=	new Random();							//  지뢰 배치를 위한 랜덤함수 생성 
 						 
 	int[][]		gnd			=	new int[Bomb.bombGnd][Bomb.bombGnd];	//Bomb 클래스에서 콤보박스에 의해 설정된 값에 따라, 지뢰 담을 배열 생성
 	
 	JButton 	jbN[][]		=	new JButton[Bomb.bombGnd][Bomb.bombGnd];//	새로 만들어진 지뢰 배열에 쓰일 버튼 생서
 	
 	
 	JMenuBar	 mb 		=	new JMenuBar();							//	메뉴바 생성 
 	JMenu 		menu 		=	new JMenu("파일");						//	메뉴바에 '파일'이라는 항목 생성 
 	 
 	ImageIcon icon0 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine0.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon1 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine1.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon2 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine2.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon3 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine3.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon4 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine4.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon5 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine5.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon6 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine6.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon7 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine7.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon8 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine8.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon9 = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/mine9.png");			//	숫자 표시 할 이미지 설정 
 	ImageIcon icon_mine = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/logoS.png");			//	지뢰 표시 할 이미지 설정 
 	ImageIcon icon_reset = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/smilingFaceS.png");		//  리셋 표시 할 이미지 설정 
 	ImageIcon icon_flag = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/flag.png");			//  깃발 표시 할 이미지 설정 
 	ImageIcon icon_flagx = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/logoXs.png");		//  잘못된 위치에 깃발 설치시 알려줄 이미지 설정 
 	ImageIcon logo = new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/logo.png");				//  파일 로고 변경 할 이미지 설정 
 	ImageIcon question=new ImageIcon("C:/Users/송승민/Desktop/project11/src/images/questionMarkS.png");   //두 번 우클릭시 나타날 물음표 이미지 설정
 
 	int flagCheck; //깃발이 꽂혀있는지 확인하기 위해
 	int frameW=280;
 	int frameH=380;
 	JLabel leftBombL;
 	private JLabel Rtime;
 	MyThread timeTh;
 	static Vector vc=new Vector();
 	JTextField textUser;
 public mine() { 
 	super("지뢰찾기"); 																				// 타이틀 설정 
 	setResizable(true);																				// 프레임 사이즈 조정가능하게 변경 
 																									/*  
 																									 * 다른 난이도에서 다른 난이도로 넘어갈때 
																									 * 프레임 사이즈를 조정하기 위함임 
 																									 */ 
 	this.setIconImage(logo.getImage());																// 실행시 좌측 상단에 파일 아이콘 지뢰 이미지로 설정 
 	
 	
 	
 	
 	if(level == 0) level = 10;																		// 전역변수 레벨이 0(초기값이 0임)일 경우 1로 설정함. 
 	
 	if(level == 10) {																				// 레벨 값이 1(초급단계)일 경우 
 																									// 메뉴바 셋팅 시작 
 		menu.add(new JMenuItem("새로 시작하기")).addActionListener(new ActionListener() { 				// 메뉴바에서 다시하기 클릭시 
 			public void actionPerformed(ActionEvent e) { dispose();	new mine();	} });				// 익명리스너로 처리 
 		
 		menu.addSeparator(); 																		// 메뉴바에 줄긋기 
 		menu.add(new JMenuItem("종료")).addActionListener(new ActionListener() { 						// 메뉴바에서 종료메뉴 선택시 
 			public void actionPerformed(ActionEvent e) {System.exit(0);} });						// 마찬가지로 익명리스너로 처리함. 
 	    																							/* 
 	    																							 * 확실하게 종료할때에는 반드시 
 	    																							 * 이 명령어 (System.exit(0);) 를 사용할 것 
 	    																							 * */ 
 		mb.add(menu); 																				// 메뉴바(mb)에 메뉴(menu)를 추가 
 		this.setJMenuBar(mb);																		// 현재(this) 프레임(JFrame)에 메뉴바를 추가함 
 		this.setLayout(new BorderLayout());															// 현재 프레임의 레이아웃을 설정(BorderLayout) 
 		Rtime=new JLabel(); timeTh=new MyThread(); timeTh.start(); jp2.add(Rtime);
 		add(jp);																					// 지뢰판을 설정하기 위한 패널을 현 프레임에 추가 
 		add(jp2, "North");																			// 리셋 버튼을 담기 위한 패널을 북쪽에 추가함 
 		jp2.add(reset); 																			// 패널에 리셋 버튼 추가 
 		reset.setIcon(icon_reset);																	// 리셋버튼 아이콘 설정 
 		reset.setBorderPainted(false);																// 버튼의 외곽선을 안보이게 설정 
 		reset.setContentAreaFilled(false);															// 버튼의 내부영역 채우기 안보이게 설정(파란색) 
 		reset.setFocusPainted(false);																// 버튼이 포커스(마우스가 올라간 상태)시 생기는 테두리를 안보이게 설정함 
 		reset.addActionListener(new ActionListener() { 												// 리셋버튼을 눌렀을때 
 			public void actionPerformed(ActionEvent e) {											// 익명리스너로 처리함. 코드가 단순하면서 액션리스너가 필요할때는 익명리스너로 처리하는게 편함 
 				JOptionPane.showMessageDialog(null, "'리셋'되었습니다.");								// 리셋 버튼 클릭시 "'리셋'되었습니다."라는 메시지가 담긴 팝업창을 띄움 
 				dispose();																			// 해당 프레임을 닫음. 
 				bmCount=Bomb.bombNum;
 				new mine();																			// 새로 불러줌() 
 			} 
 		});
 		
 		leftBombL=new JLabel(Integer.toString(bmCount));
 		jp2.add(leftBombL);
 		for(; ; ) {																					// 지뢰 배치를 위한 반복문 
 			for(int i, j, count = 0; count < level;) {													// i, j, count 선언 및 초기화 
 				i=rnd.nextInt(level);																	// i값에 0 ~ 9 사이의 값을 대입 
 				j=rnd.nextInt(level);																	// j값에 0 ~ 9 사이의 값을 대입 
 																									// -------------------------------------------------- 
 				if(gnd[i][j] != -1) {																// -mine[i][j] 배열 값이 -1이 아니면 (지뢰가 배치되지 않았으면)	- 
 					gnd[i][j] = -1;																// -mine[i][j] 배열에 -1을 대입							- 
 					count++;																		// -count값을 증가										- 
 				}																					// -중복값을 걸러내기 위함임								- 
 			}																						// -------------------------------------------------- 
 			break;																					// 조건(count가 10보다 작은가?)이 충족되지 않으면 반복문 종료 
 		} 
 
 
 		for(int i = 0; i < level; i++) {																// 버튼 생성을 위한 반복문 
 			for(int j = 0; j < level; j++) {															//  
 				if(gnd[i][j] == 0) { 																// mine배열 i,j의 배열 값이 0일 경우 
 					jbN[i][j] = new JButton();														// jb(JButton)[i][j]를 생성 
 					jbN[i][j].setPreferredSize(new Dimension(20, 20));								// jb[i][j]의 버튼 사이즈를 조정 
 					jbN[i][j].addActionListener(new ButtonListener());								// 일반버튼 클릭에 반응하기 위한 액션리스너(ButtonListener) 생성 
 					jbN[i][j].addMouseListener(new clickListener());									// 깃발을 표시하기 위해 우클릭을 체크할 마우스 리스너(clickListener)생성 
 					jbN[i][j].setBackground(Color.DARK_GRAY); 
 					jp.add(jbN[i][j]);																// jp(JPanel)에 jb[i][j]를 추가 
 				} 
 				else if(gnd[i][j] != 0) { 															// mine배열 i,j의 배열 값이 0이 아닐경우 
 					jbN[i][j] = new JButton();														// jb(JButton)[i][j]를 생성 
 					jbN[i][j].setPreferredSize(new Dimension(20, 20));								// jb[i][j]의 버튼 사이즈를 조정 
 					jbN[i][j].addActionListener(new MineListener());									// 지뢰버튼 클릭에 반응하기 위한 액션리스너(MineListener) 생성 
 					jbN[i][j].addMouseListener(new clickListener());									// 깃발을 표시하기 위해 우클릭을 체크할 마우스 리스너(clickListener)생성 
 					jbN[i][j].setBackground(Color.DARK_GRAY); 
 					jp.add(jbN[i][j]);																// jp(JPanel)에 jb[i][j]를 추가 
 				} 
 			} 
 		} 
 
 
 		for(int i=0; i<level; i++) {																	// 지뢰 주변 칸에 숫자를 채우기 위한 반복문 
 			for(int j=0; j<level; j++) { 
 				int count=0;																		// 숫자를 체크하기 위해 변수 선언 
 				if(gnd[i][j] != -1) {																// mine[i][j] 위치의 배열값이 지뢰값이(-1) 아니면 
 					if(i >= 0 && j >= 0 && i <= (level-1) && j <= (level-1)) {										// 배열의 범위를 벗어남을 막기위해 설정 
 						if(i-1 >= 0 && j-1 >= 0)				// -------------------------------- // 
							if(gnd[i-1][j-1] == -1) count ++;	//				1		2		3--	// 
 						if(i-1 >= 0)							//				0		0		0--	//  
 							if(gnd[i-1][j] == -1) count ++;	//								 -- //  
 						if(i-1 >= 0 && j+1 <= (level-1))		//				4		i,j		5-- // 1~8번 자리에 지뢰가 있는지 체크하고 
 							if(gnd[i-1][j+1] == -1) count ++;	//				0		0		0-- // 지뢰가 있으면 count를 증가 
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
 					gnd[i][j] = count;																// 체크가 끝나면 mine[i][j]에 count를 대입 
 				} 
 				count = 0;																			// 반복하기전에 count를 초기화 
 			} 
 	 		ending = false;																				// 엔딩 값을 거짓으로 바꿈 
 		setVisible(true); 																			// 프레임 보이기 
 		setSize(frameW, frameH); 																			// 프레임 사이즈 설정 윈도우 
 		setResizable(false);																		// 프레임 사이즈를 유저가 설정하지 못하게 잠금 
 		this.setLocationRelativeTo(null);															// 화면 중앙에 띄우기 
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);												// X버튼 누르면 닫기 
 																									// 설정 안하면 프로세스에(백그라운드에) 남아있음 
 		} 
 	 
 	}
 
 		/* 아래 20*20~50*50까지는  
 		 * 초기 조건 level값의 비교와 
 		 * 버튼과 지뢰배열의 사이즈등 기본값만 다를뿐 
 		 * 모든 구조는 같음 
 		 */ 
 	if(level != 10) { 
 		setResizable(true); 
 		JMenuBar mb = new JMenuBar(); 
 		JMenu menu = new JMenu("파일"); 
 		
 
 		menu.add(new JMenuItem("새로 시작하기")).addActionListener(new ActionListener() { 
 			public void actionPerformed(ActionEvent e) { 
 				dispose(); 
 				new mine(); 
 			} 
 		}); 

 		menu.addSeparator(); 
 	 
 		menu.add(new JMenuItem("종료")).addActionListener(new ActionListener() { 
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
 				JOptionPane.showMessageDialog(null, "'리셋'되었습니다."); 
 				dispose(); 
 				bmCount=Bomb.bombNum;//다시 리셋
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
 
 
 private class ButtonListener implements ActionListener  { 											// 지뢰가 아닌 버튼 클릭했을때 실행되는 액션리스너 
 	public void actionPerformed(ActionEvent e) {													 
 			for(int i = 0; i < level; i++) {															// 해당 버튼의 배열값을 찾기 위한 반복문 
 				for(int j = 0; j < level; j++) { 
 					if(e.getSource() == jbN[i][j] && jbN[i][j].getBackground() == Color.DARK_GRAY) {	// 넘어온 e 값과 jb[i][j]의 값이 같고 백그라운드컬러가 DARK_GRAY면 
						check(i, j);																// check에 (i,j)값을 넘겨줌 
 					} 
 				} 
 			} 
 } 
 }
public static Vector getVec() {
	return vc;
}
 private class MineListener implements ActionListener  { 												// 지뢰인 버튼을 클릭했을때 실행되는 액션리스너 
 	public void actionPerformed(ActionEvent e) { 
 		if(ending == false) {
 			timeTh.stop();
 			JOptionPane.showMessageDialog(null, "아쉽습니다. 지뢰를 클릭했습니다.");								// 엔딩값이 false인 경우 "아쉽습니다. 지뢰를 클릭했습니다."라는 메시지가 담긴 팝업창을 띄움 
 			JOptionPane.showMessageDialog(null, "사용자 이름을 입력하세요");
 			textUser=new JTextField(); 
 			vc.add(Bomb.bombGnd+" "+textUser.getText()+" "+timeTh.getTime());
 			
 		}
 		 
 																									// 지뢰로 설정된 모든 버튼의 위치를 나타내기 위한 반복문 
 			for(int i = 0; i <level; i++) { 
 				for(int j = 0; j < level; j++) { 
 					if(gnd[i][j] == -1) {																// 해당 i, j의 위치에 있는 버튼이 지뢰일 경우 
 							jbN[i][j].setBackground(Color.DARK_GRAY);									// 백그라운드컬러를 기본으로 바꿈 
 							jbN[i][j].setIcon(icon_mine);												// 아이콘에 지뢰 이미지를 설정 
 							ending=true;																// 전역변수 ending을 true로 바꿈 || 게임이 끝난 후 다른 지뢰 및 버튼 눌렀을때 반응 없게 하기 위함임 
 						} 
 						else if (gnd[i][j] != -1 && jbN[i][j].getBackground() != Color.DARK_GRAY) {		// 해당 i, j의 위치에 있는 버튼이 지뢰가 아니면서 기본색이 아닐경우 (깃발을 꽂은경우) 
 							jbN[i][j].setBorderPainted(false);											// BorderPainted 값을 false로 바꿈 
 							jbN[i][j].setBackground(Color.DARK_GRAY);									// 백그라운드컬러를 기본으로 바꿈 
 							jbN[i][j].setIcon(icon_flagx);												// 깃발에 x 표시된 아이콘을 설정 
 						} 
 						else 
 							jbN[i][j].setBorderPainted(false);											// 그 외의 경우(지뢰가 아니면서 깃발도 안꽂은경우) 
 						 
 					jbN[i][j].setBorderPainted(false);													// 지뢰버튼이 아닌 경우 버튼을 클릭해도 반응이 없게 설정하기 위해 false값을 설정 
 					jbN[i][j].setBackground(Color.DARK_GRAY);											// 백그라운드컬러를 기본으로 설정 
 				} 
 			}  
 	} 
 } 
 
 
 
 
 private class clickListener implements MouseListener{ 																						// 깃발을 세우기 위한 마우스 리스너 
 	 
 	/* 
 	 * 마우스리스너를 사용할때 기본적으로 제공되는 함수들은 
 	 * 사용하지 않더라도 있어야함. 
 	 */ 
 	public void mouseClicked(MouseEvent e) { 
 		 
 	} 
 
 
 	public void mousePressed(MouseEvent e) { 
			if(e.getModifiersEx() == InputEvent.BUTTON3_DOWN_MASK) {																		// 클릭한 버튼이 마우스 우클릭임을 비교 
 				for(int i = 0; i<level; i++) {																									// 우클릭한 버튼을 찾기위한 비교문 
 					for(int j = 0; j<level; j++) { 
 						if(e.getSource() == jbN[i][j] && jbN[i][j].isBorderPainted()==true && jbN[i][j].getBackground() == Color.DARK_GRAY) {	// 우클릭된 버튼이 기본 상태면 
 							jbN[i][j].setIcon(icon_flag);																					// 깃발을 꽂음 
 							jbN[i][j].setBackground(Color.GRAY);																				// 깃발을 확인하기 위해 백그라운드 컬러를 변경 
 							flagCheck=1;
 							bmCount--;
 							leftBombL.setText(Integer.toString(bmCount));
 					 	//	jp2.add(leftBombL);
 						} 
 						else if(e.getSource() == jbN[i][j] && jbN[i][j].isBorderPainted()==true && jbN[i][j].getBackground() == Color.GRAY) {	// 깃발을 꽂은 버튼이면 
 							if(flagCheck==1) {
 								jbN[i][j].setIcon(question);																							// 2번 우클릭 식 물음표 이미지로 변경 
 								jbN[i][j].setBackground(Color.GRAY);																					// 다시 원래 배경으로 돌아가기 위해 배경색을 GRAY로 지정
 								flagCheck=2;
 								bmCount++;
 								leftBombL.setText(Integer.toString(bmCount));
 						// 		jp2.add(leftBombL);
 							}
 							else if(flagCheck==2) {
 								jbN[i][j].setIcon(null);																							// 해당 버튼의 아이콘을 지우고 
 								jbN[i][j].setBackground(Color.DARK_GRAY);																		// 기본배경으로 변경 
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
 
 
 private void check(int i, int j) {																	// 비교하기 위한 함수 
																				
 		try {																						// 배열의 범위를 벗어남을 처리하기 위한 try~catch문 
			if(gnd[i][j] == 0 && jbN[i][j].isBorderPainted() == true) {								// 해당 mine[i][j]값이 0의 값을 가지면서 버튼이 활성화된 상태에 있을경우 
 				jbN[i][j].setIcon(icon0);															// 숫자0을 뜻하기 위한 이미지를 설정 
 				jbN[i][j].setBorderPainted(false);													// 버튼의 외곽선을 안보이게 설정 
 				jbN[i][j].setContentAreaFilled(false);												// 버튼의 내부영역 채우기 안보이게 설정(파란색) 
 				jbN[i][j].setFocusPainted(false);													// 버튼이 포커스(마우스가 올라간 상태)시 생기는 테두리를 안보이게 설정함 
 				check(i+1, j);																		// 주변에 0이 있는지 확인하기 위함 
 				check(i-1, j); 
				check(i, j+1); 
 				check(i, j-1); 
				check(i+1, j+1); 
 				check(i-1, j-1); 
 				check(i-1, j+1); 
 				check(i+1, j-1); 
 			} 
			else {																					// 그외의 경우 
 				if(jbN[i][j].isBorderPainted() == true) {											// 해당 mine[i][j]의 값이 0이 아닌경우임 
 																									// 이 함수가 불러지는 경우 자체가 지뢰가 아닌경우이기 때문에 
 																									// 지뢰일 경우를 체크할 필요는 없음 
 					switch(gnd[i][j]) {															// 스위치 케이스문 
 					case 1:																			// 1~9의 경우 각 숫자에 맞는 이미지를 설정함 
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
 			victory();																				// 승리 조건을 확인하기 위해 호출함 
 		} 
 		catch(java.lang.ArrayIndexOutOfBoundsException e){ 
 			 
 		}  
 } 
 
 
 private void victory() {																			// 승리 조건을 확인  
 		int count = 0; 
 		for(int i=0; i<level; i++) { 
 			for(int j=0; j<level; j++) { 
 				if(this.gnd[i][j] != -1 && this.jbN[i][j].isBorderPainted() == false) {				// 해당 i,j가 지뢰가 아니면서 BorderPainted가 false인 경우 
 					count++;																		// 즉 지뢰가 아니면서 클릭된 경우를 비교함 
 				} 
 			} 
 		} 
 		if(count >= 90*(level/10)*(level/10)) {																			// 지뢰가 아니면서 클릭된 경우가 90이상인 경우 
 			for(int i=0; i<level; i++) { 
 				for(int j=0; j<level; j++) { 
 					if(jbN[i][j].isBorderPainted() == true) {										// BorderPainted가 true인 경우가 있다면 
 						jbN[i][j].setBorderPainted(false);											// false로 변경 
 						if(gnd[i][j] == -1)														// 지뢰면 
 							jbN[i][j].setIcon(icon_mine);											// 지뢰 이미지로 아이콘 변경 
 					} 
 				} 
 			} 
 			if(ending==false) {																		// 엔딩값이 거짓일 경우 
 				JOptionPane.showMessageDialog(null, level+" 축하합니다. 승리했습니다!");							// 승리 메시지 출력 
 				ending = true;																		// 엔딩값을 참으로 설정 
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
	            Rtime.setText("시간: "+i);
	            TIME=i;
	         }
	      }
	    public int getTime() {
	    	return TIME;
	    }
	 }
 
 
 
 
// public static void main(String[] args) { 
// 	// TODO Auto-generated method stub 
// 	new mine();																						// 프로그램 실행시 프레임 불러오기 
// 	}
 static int level = Bomb.bombGnd; static boolean ending = false;											// 전역변수 level 선언 및 Bomb.bombGnd로 Bomb에서 설정한 지뢰 밭 종류 받기, ending 선언 및 false로 초기화 
 static int bmCount=Bomb.bombNum;//Bomb.bombNum에서 지뢰 갯수 받아오기

} 

