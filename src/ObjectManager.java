import java.awt.Graphics;
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

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		addAlien();
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y > LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y > LeagueInvaders.HEIGHT) {
				projectiles.get(i).isActive = false;
			}

		}

	}

	void draw(Graphics g) {
		rocketship.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}

	}

void purgeObject(){
	for(int i = 0; i< aliens.size(); i++) {
		if(aliens.get(i).isActive == false) {
			aliens.remove(i);
		}
		}
	for(int i = 0; i< projectiles.size(); i++) {
		if(projectiles.get(i).isActive == false) {
			projectiles.remove(i);
		}
		}
}
}
