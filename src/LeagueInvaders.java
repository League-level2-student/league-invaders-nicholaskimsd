import javax.swing.JFrame;

public class LeagueInvaders {
	final static int WIDTH = 500;
	final static int HEIGHT = 800;
	JFrame frame;
	GamePanel panel = new GamePanel();
	LeagueInvaders(){
		 frame = new JFrame();
		 frame.addKeyListener(panel);
			
	}
	
public static void main(String[] args) {


		LeagueInvaders league = new LeagueInvaders();
		league.setup();
		

	
}
void setup(){
	frame.add(panel);
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
}

}

