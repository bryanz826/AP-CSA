package com.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Resource
{
	private final static Map<String, BufferedImage>	map	= new HashMap<String, BufferedImage>();
	private BufferedImage							image;

	private String									fileName;

	public Resource(String fileName)
	{
		this.fileName = fileName;
		BufferedImage resource = map.get(fileName);
		if (resource != null) this.image = resource;
		else {
			try {
				image = ImageIO.read(getClass().getResourceAsStream(Reference.RESOURCE_LOC + fileName));
				map.put(fileName, image);
			} catch (IOException e) {
				System.err.printf("Cannot find " + fileName + "!\n");
				e.printStackTrace();
			}
		}
	}

	public Resource(BufferedImage image)
	{
		this.image = image;
	}

	public Resource(Resource res, int x, int y, int size)
	{
		this(res, x, y, size, size);
	}

	public Resource(Resource res, int x, int y, int width, int height)
	{
		BufferedImage resource = map.get(res.fileName);
		if (resource != null) this.image = resource;
		this.image = res.getImage().getSubimage(x * width - width, y * height - height, width, height);
	}

	public void render(Graphics2D g, double x, double y) {
		g.drawImage(image, (int) x, (int) y, null);
	}

	public void render(Graphics2D g, double x, double y, double width, double height) {
		g.drawImage(image, (int) x, (int) y, (int) width, (int) height, null);
	}

	public BufferedImage getImage() {
		return image;
	}

	public String getFileName() {
		return fileName;
	}

	public String toString() {
		return fileName;
	}
}
