import java.awt.Image;

public class MonsterDex {
	
	private Image[] Encountered;
	private Image[] Pikmin = new Image[6];
	
	

	public MonsterDex() {
		populateDex();
	}
	

	private void populateDex() {
		Pikmin = new Image[6];
		for(int i = 0;i < 6;i++){
			// Pikmin[i] = getImage(MonsterSprites/c(i+1).gif );
		}
	}
	
	

}
