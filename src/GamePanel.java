import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
Timer alienSpawn;
ObjectManager objectManager;
Rocketship rocketship;
final int MENU = 0;
final int GAME = 1;
final int END = 2;
int currentState = MENU;
  Font titleFont = new Font("Arial", Font.PLAIN, 48);
  Font startFont = new Font("Arial", Font.PLAIN, 24);
  Font instructionFont = new Font("Arial", Font.PLAIN, 24);
  int x = 250;
  int y = 700;
  int width = 50;
  int height = 50;

	GamePanel(){
		Timer frameDraw = new Timer(1000/60,this);
		frameDraw.start();
		rocketship = new Rocketship( x,  y,  width,  height);
		objectManager = new ObjectManager(rocketship);
		if (needImage) {
		    loadImage ("space.png");
		}
		
		
	}
	
	void startGame(){
		alienSpawn = new Timer(1000 , objectManager);
	    alienSpawn.start();
		}

	public void paintComponent(Graphics g) {
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}

	
	

	
	

	void updateMenuState() {
		
	}

	void updateGameState() {
		objectManager.update();
		if(rocketship.isActive==false) {
			currentState = END;
		}
	}

	void updateEndState() {
		
	}

	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.ORANGE);
		g.drawString("LEAGUE INVADERS", 20, 100);
		
		g.setFont(startFont);
		g.setColor(Color.ORANGE);
		g.drawString("Press ENTER to start", 125, 350);
		
		g.setFont(instructionFont);
		g.setColor(Color.ORANGE);
		g.drawString("Press SPACE for instructions", 80, 550);
	}

	void drawGameState(Graphics g) { 
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
		
			
		}
		
objectManager.draw(g);
		
		
	}

	void drawEndState(Graphics g)  {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
		
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 100, 100);
		
		g.setFont(startFont);
		g.setColor(Color.YELLOW);
		g.drawString("You killed "+objectManager.getFinalScore()+" enemies", 125, 350);
		
		g.setFont(instructionFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press enter to play again", 80, 550);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		//System.out.println("action");
		repaint();
	}
	@Override
	
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		       rocketship = new Rocketship(x, y, width, height);
		       objectManager = new ObjectManager(rocketship);
		    } else {
		        currentState++;
		    }
		    if(currentState == GAME) {
		    	startGame();
		    }
		  
		}   
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		    rocketship.up();
		    if(rocketship.y < 0) {
		    rocketship.y=0;
		    
		}
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
		    System.out.println("LEFT");
		    rocketship.left();
		    if (rocketship.x < 0) {
		    	rocketship.x=0;
		    }
		    
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    rocketship.right();
		    if(rocketship.x > 430) {
		    	rocketship.x=430;
		    }
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    rocketship.down();																																																																																																				
		    if(rocketship.y > 710) {
		    	rocketship.y=710;
		    }
		    
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			objectManager.addProjectile(rocketship.getProjectile());
			
		}
		
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
																																											
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
