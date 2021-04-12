package finalGame;

public class timeThread extends Thread{
	private int setting;
	 public void run() {
	    	
	      for( int i=15;i>=0;i--) {
	          try {
	           	Thread.sleep(1200);
	           }catch(InterruptedException e) {
	           	e.printStackTrace();
	           }
	           DrawBoard.Rtime.setText(i+"");
	      }
	 

	 
	}
}
