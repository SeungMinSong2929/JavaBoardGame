package finalGame;

import java.awt.Container;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI extends JFrame{
	private Container c;//??
	MapSize size=new MapSize();
	static Vector vcGUI=new Vector();
	public GUI(String title) {
		System.out.println("GUI");
		setBounds(0, 0, Omok.boardNum*30, Omok.boardNum*40);
		setLayout(null);
		Map map=new Map(size);
		DrawBoard d=new DrawBoard(size, map);
		System.out.println("DrawBoard");
		add(d); d.setBounds(0, 0, 1000, 1000);
		addMouseListener(new MouseEventHandler(map, size, d, this));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void showPopUp(String message) {
		JOptionPane.showMessageDialog(this, message,"",JOptionPane.INFORMATION_MESSAGE);
		//vcGUI.add();
		System.exit(0);
	}
}
