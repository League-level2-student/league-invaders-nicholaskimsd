import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ObjectManager implements ActionListener {
Rocketship rocketship;

ArrayList<Projectile> projectile = new ArrayList<Projectile>();
Alien alien;
ObjectManager(Rocketship hi) {
	rocketship = hi;
} 
void addProjectile(ArrayList<Projectile> proj){
	projectile = proj;

}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
