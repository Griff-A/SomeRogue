package Engine.Systems;

import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Engine.Entity;
import Engine.Components.InputComponent;
import Engine.Components.Player;
import Engine.Input.KeyIntentTraslator;
import abstraction.IEntity;
import abstraction.ISystem;
import abstraction.IWorldProvider;
import shell.Game;

public class InputSystem implements ISystem {

	List<KeyEvent> pressedKeys;
	
	public InputSystem() {
		pressedKeys = new ArrayList<>();
	}
	@Override
	public void Update(Time gameTime, Game game) {
		for (IEntity entity : game.GetEntities()) {
			InputComponent inputComponent = entity.GetComponentOfType(InputComponent.class);
			Player player = entity.GetComponentOfType(Player.class);
			if(player!=null && inputComponent!=null){
				inputComponent.Intents.clear();
				for (KeyEvent keyEvent : pressedKeys) {
					inputComponent.Intents.addAll(KeyIntentTraslator.Translate(keyEvent.getKeyCode()));
				}
			}
		}	
	}		

	public void keyPressed(KeyEvent e) {
		pressedKeys = new ArrayList<>();
		pressedKeys.add(e);		
	}

	public void keyReleased(KeyEvent e) {
		Optional<KeyEvent> key = pressedKeys.stream().filter(x->x.getKeyCode()==e.getKeyCode()).findFirst();
		if(key.isPresent())
		{
			pressedKeys.remove(key.get());
		}
	}

}
