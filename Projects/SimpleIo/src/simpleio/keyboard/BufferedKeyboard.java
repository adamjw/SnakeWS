package simpleio.keyboard;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

public class BufferedKeyboard {

	private int[] keysToListen;
	private List<Integer> keyEvents;
	
	
	public BufferedKeyboard(int[] keysToListen){
		this.keysToListen = keysToListen;
		keyEvents = new ArrayList<Integer>();
	}
	
	public void poll(){
		Keyboard.poll();
		
		while(Keyboard.next()){
			if(Keyboard.isRepeatEvent()){
				continue;				
			}
			
			int eventKey = Keyboard.getEventKey();

			if(!Keyboard.isKeyDown(eventKey)){
				continue;
			}
			
			for(int i = 0; i < keysToListen.length; i++){
				if(keysToListen[i] == eventKey){
					keyEvents.add(eventKey);
				}
			}
		}		
	}
	
	/**
	 * Returns the list of keys that have been pressed. The list is sorted from the oldest key press to newest ones.
	 * 
	 * @return
	 */
	public List<Integer> getKeyEvents(){
		return keyEvents;
	}
	
	public void clear(){
		keyEvents.clear();
	}
	
	
}
