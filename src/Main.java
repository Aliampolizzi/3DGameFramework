import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;


public class Main implements Runnable{	
	public static final int WINDOWWIDTH= 500,
				 			WINDOWHEIGHT = 500;
	public static final String WINDOWTITLE= "";
	public static boolean running=false;
	private Graphics graphics;
	private Game game;
	
	
	public static void main(String[] args) {
		new Thread(new Main()).start();
	}
	
	
	
	@Override
	public void run() {	
		running=true;
		try {
				graphics = new Graphics();
				game = new Game();


				while(running){
					glfwPollEvents();
					input(KeyboardInput.downKeys);
					game.update();
					graphics.render();
					running = !glfwWindowShouldClose(graphics.getWindow());
				}
				
			
		} finally { 
			System.out.println("Shutting Down...");
			exit(); 
		}
		
	}



	private void input(boolean[] keys) {
		
		if(keys[GLFW_KEY_ESCAPE]) glfwSetWindowShouldClose(graphics.getWindow(), true);
		
	}



	private void exit() {
		System.out.println("Exiting Graphics...");
		graphics.exit();
		System.out.println("Exiting Game...");
		game.exit();
		System.out.println("Exiting");
	}
}
