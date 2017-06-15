package data;
import java.awt.*;
public class GameSettings {
	//window resolution
	private int widthChars;
	private int heightChars;
	private int fontSize = 16;
	//some font
	private Font  font;
	public GameSettings(int width,int height)
	{
		setWidth(width);
		setHeight(height);
	}
	
	public int getWidth() {
		return widthChars;
	}
	public void setWidth(int width) {
		this.widthChars = width;
	}
	public int getHeight() {
		return heightChars;
	}
	public void setHeight(int height) {
		this.heightChars = height;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
}
