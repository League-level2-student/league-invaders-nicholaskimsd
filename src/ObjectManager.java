import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ObjectManager implements ActionListener {
Rocketship rocketship;

ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();


ObjectManager(Rocketship hi) {
	rocketship = hi;
} 
void addProjectile(Projectile projectile){
	projectiles.add(projectile);
}
void addAlien(Alien alien) {
	aliens.add(alien);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addAlien(null);
}
}
