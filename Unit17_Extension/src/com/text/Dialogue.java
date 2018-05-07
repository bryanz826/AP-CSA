package com.text;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.utils.Keys;
import com.utils.Reference;
import com.utils.Resource;

public class Dialogue
{
	private static final Map<String, ArrayList<ArrayList<String>>>	map	= new HashMap<String, ArrayList<ArrayList<String>>>();

	private Resource												playerBack;
	private Resource												playerIcon;
	private Resource												otherBack;
	private Resource												otherIcon;

	private Text													text;
	private ArrayList<ArrayList<String>>							list;
	private int														index;
	private int														tick;

	public Dialogue()
	{
		if (!map.isEmpty()) {
			playerBack = new Resource("");
			playerIcon = new Resource("");
			otherBack = new Resource("");
			otherIcon = new Resource("");
		} else {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(
						new File(getClass().getResource(Reference.RESOURCE_LOC + "dialogue.txt").getFile())));
				String line;
				ArrayList<ArrayList<String>> list;
				while ((line = br.readLine()) != null) {
					String key = line;
					list = new ArrayList<ArrayList<String>>();
					while ((line = br.readLine()).length() != 0) {
						list.add(wrapString(line, 20));
					}
					map.put(key, list);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			for (String name : map.keySet()) {
				String key = name.toString();
				String value = map.get(name).toString();
				System.out.println(key + " | " + value);
			}
		}
	}

	private ArrayList<String> wrapString(String speech, int maxWidth) {
		String speaker = speech.substring(0, 4);
		ArrayList<String> a = new ArrayList<String>();
		int prevIndex = 0, currIndex = 0;
		speech = speech.substring(3);
		do {
			prevIndex = currIndex;
			for (int i = 0; i < maxWidth; i++) {
				currIndex++;
				if (currIndex == speech.length()) {
					currIndex--;
					break;
				}
			}
			while (!(speech.charAt(currIndex) == ' ' || speech.charAt(currIndex) == '.'
					|| speech.charAt(currIndex) == '!' || speech.charAt(currIndex) == '?'))
			{
				currIndex--;
			}
			if (currIndex == speech.length() - 1) a.add(speech.substring(prevIndex + 1, currIndex + 1));
			else a.add(speech.substring(prevIndex + 1, currIndex));
		} while (currIndex < speech.length() - 1);
		a.set(0, speaker + a.get(0));
		return a;
	}

	public void tutorial(Graphics2D g) {
		if (tick == 0) {} else {

		}
	}

	private void writeLine(Graphics2D g) {
		if (text.drawStringAtInterval(g, tick, 5)) text.setWritingLine(false); // TODO
	}

	public void processInput() {
		if (Keys.wasPressed(Keys.ENTER)) {
			if (text.isWritingLine()) /* finish line */;
			else /* go to next line */;
		}
	}

	public void update() {
		tick++;
	}

	public void render(Graphics2D g) {
		tutorial(g);
	}
}
