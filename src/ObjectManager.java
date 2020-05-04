import java.util.ArrayList;

public class ObjectManager {
Rocketship rocketship;

ArrayList<Projectile> projectile = new ArrayList<Projectile>();
Alien alien;
ObjectManager(Rocketship hi) {
	rocketship = hi;
} 
void addProjectile(ArrayList<Projectile> proj){
	projectile = proj;

}
}
