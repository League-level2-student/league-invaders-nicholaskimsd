import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
Rocketship rocketship;
Random random = new Random();

ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();

ObjectManager(Rocketship hi) {
	rocketship = hi;
} 
void addProjectile(Projectile projectile){
	projectiles.add(projectile);
}
void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addAlien();
}
void update(){
	for(int i = 0; i> alien.y; i++) {
		
	}
	void purgeObjects() {
		
	}
	void draw(g) {
		loadImage(imageFile);
	}
}
}
 