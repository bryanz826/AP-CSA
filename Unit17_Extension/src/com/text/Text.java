package com.text;

import java.awt.Graphics2D;

import com.utils.Reference;
import com.utils.Resource;

public class Text
{
	private static final int		NUM_CHARS		= 44;

	private static final Resource[]	characterList	= new Resource[NUM_CHARS];
	private Resource				characters;

	private final int				width			= 50;
	private final int				height			= 61;

	private String					str;
	private int						index;
	private boolean					writingLine;
	private double					x, y;
	private double					newWidth, newHeight;

	public Text(String str, double x, double y)
	{
		this(str, x, y, 1);
	}

	public Text(String str, double x, double y, double ratio)
	{
		characters = new Resource(Reference.FONT_LOC + "live_retro_gray_50x61.png");
		this.str = str.toUpperCase();
		this.x = x;
		this.y = y;
		newWidth = width * ratio;
		newHeight = height * ratio;
		buildFont();
	}

	public void buildFont() {
		for (int i = 0; i < NUM_CHARS; i++) {
			characterList[i] = new Resource(characters, i + 1, 1, 50, 61);
		}
	}

	public void drawString(Graphics2D g) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 65 && c <= 90) c -= 65; // letters
			else if (c >= 48 && c <= 57) c -= 22; // numbers
			else if (c == 39) c = 36; // apostrophe
			else if (c == 58) c = 37; // colon
			else if (c == 44) c = 38; // comma
			else if (c == 45) c = 39; // dash
			else if (c == 33) c = 40; // exclamation
			else if (c == 46) c = 41; // period
			else if (c == 63) c = 42; // question
			else if (c == 32) c = 43; // space
			characterList[c].render(g, x + newWidth * i, y, newWidth, newHeight);
		}
	}

	public void drawStringFixed(Graphics2D g, int digitDistance, String placeHolder) {
		int length = str.length();
		for (int i = 0; i < digitDistance - length; i++) {
			str = placeHolder + str;
		}
		drawString(g);
	}

	public boolean drawStringAtInterval(Graphics2D g, int timer, int interval) {
		if (timer % interval == 0 && writingLine) {
			char c = str.charAt(index);
			if (c >= 65 && c <= 90) c -= 65; // letters
			else if (c >= 48 && c <= 57) c -= 22; // numbers
			else if (c == 39) c = 36; // apostrophe
			else if (c == 58) c = 37; // colon
			else if (c == 44) c = 38; // comma
			else if (c == 45) c = 39; // dash
			else if (c == 33) c = 40; // exclamation
			else if (c == 46) c = 41; // period
			else if (c == 63) c = 42; // question
			else if (c == 32) c = 43; // space
			characterList[c].render(g, x + newWidth * index, y, newWidth, newHeight);
			if (++index == str.length()) return true;
		}
		return false;
	}
	
	public void setString(String str) {
		this.str = str;
	}
	
	public void setWritingLine(boolean writingLine) {
		this.writingLine = writingLine;
	}

	public int getStringWidth() {
		return (int) (str.length() * newWidth);
	}

	public int getStringHeight() {
		return (int) newHeight;
	}
	
	public boolean isWritingLine() {
		return writingLine;
	}
}
