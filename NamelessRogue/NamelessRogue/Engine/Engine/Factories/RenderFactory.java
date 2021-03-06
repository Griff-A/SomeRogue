package Engine.Factories;

import com.jogamp.nativewindow.util.Point;

import Engine.Entity;
import Engine.Components.ConsoleCamera;
import Engine.Components.Rendering.Screen;
import data.GameSettings;

public class RenderFactory {
	
	public static Entity CreateViewport(GameSettings settings)
	{
		Entity viewport = new Entity();
		ConsoleCamera camera = new ConsoleCamera(new Point(0,0));
		Screen screen = new Screen(settings.getWidth(),settings.getHeight());
		viewport.AddComponent("viewport");
		viewport.AddComponent(camera);
		viewport.AddComponent(screen);
		return viewport;
		
	}
}
