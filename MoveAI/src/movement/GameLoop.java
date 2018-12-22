package movement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameLoop implements Runnable{
        // save game state
	private boolean isRunning;
        // 
	private Demo demo;
        
        // save all characters will create in game
	private List<Character> characters;
        
        // save all kinematic wanderings respectively character
	private List<KinematicWandering> kinematicWanderings;
        private List<KinematicSeek> kinematicSeeks;
        private List<KinematicFlee> kinematicFlees;
        // Constructer
	public GameLoop(boolean isRunning, Demo demo) {
		super();
		this.isRunning = isRunning;
		this.demo = demo;
		// character 1
		Character c1 = new Character(new Vector2D(400, 300), 0, new Vector2D(0, 0), 0, Color.RED);
		// character 2
                Character c2 = new Character(new Vector2D(50, 100), 0, new Vector2D(0, 0), 0, Color.GREEN);
                // character 3
                Character c3 = new Character(new Vector2D(100, 300), 0, new Vector2D(0, 0), 0, Color.YELLOW);
		// Create list
		this.characters = new ArrayList<Character>();
		this.kinematicWanderings = new ArrayList<KinematicWandering>();
		this.kinematicSeeks = new ArrayList<KinematicSeek>();
                this.kinematicFlees = new ArrayList<KinematicFlee>();
                // Create character
		this.characters.add(c1);
		this.characters.add(c2);
                this.characters.add(c3);
                
                // add AI for each characters
                this.kinematicWanderings.add(new KinematicWandering(c1,1,1));
                // c2 move to c3
                this.kinematicSeeks.add(new KinematicSeek(c2,c3,1));
                // c3 flee c2
                this.kinematicFlees.add(new KinematicFlee(c3,c2,1));
//		for (Character c: this.characters) {
//			//this.kinematicWandering = new KinematicWandering(c, 5, 1);
//			this.kinematicWanderings.add(new KinematicWandering(c, 6, 2));
//		}
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

	@Override
	public void run() { // run auto
                //Bullet bl = new Bullet(new Vector2D(10,10),0,0,Color.BLACK);
		while (true) {
                        // clear Scene game
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
                        // reference c1
                        characters.get(0).update(this.kinematicWanderings.get(0).generateKinematicOutput(), 20);
                        characters.get(0).render(this.demo.getGraphics());
                        
                        characters.get(1).update(this.kinematicSeeks.get(0).generateKinematicOutput(), 2);
                        characters.get(1).applyNewOrientation();
                        characters.get(1).render(this.demo.getGraphics());
                        
                        characters.get(2).update(this.kinematicFlees.get(0).generateKinematicOutput(), 2);
                        characters.get(2).applyNewOrientation();
                        characters.get(2).render(this.demo.getGraphics());
//			for (Character c: this.characters) {
//				c.update(this.kinematicWanderings.get(this.characters.indexOf(c)).generateKinematicOutput(), 2);
//				c.render(this.demo.getGraphics());
//			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
