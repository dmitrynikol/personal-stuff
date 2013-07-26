package main.java.org.app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * Application that compares two images and shows the differences visually 
 * in new generated output image "result.png". 
 * Pixels of new generated image will marks only in case if difference 
 * between them more than 10% in RGB.
 * 
 * @author Dmitry Nikolaenko
 * 
 */
public class ApplicationEntryPoint {

	public static final int DIFFERENCE_PERCENTSAGE = 10;

	private static BufferedImage image1;
	private static BufferedImage image2;
	private static BufferedImage result;

	public static void main(String[] args) {
		loadImage();

		// create the new image, canvas size is the max of both image sizes
		int width = Math.max(image1.getWidth(), image2.getWidth());
		int height = Math.max(image1.getHeight(), image2.getHeight());
		result = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		// paint both images, preserving the alpha channels
		Graphics g = result.getGraphics();
		g.drawImage(image1, 0, 0, null);
		g.drawImage(image2, 0, 0, null);
		
		List<Point> points = new ArrayList<Point>();

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int pixel1 = image1.getRGB(i, j);
				int pixel2 = image2.getRGB(i, j);

				float colorDifference = colorDifferencePercentage(getColor(pixel1), getColor(pixel2));
				if (colorDifference > DIFFERENCE_PERCENTSAGE) {
					Point point = new Point(i, j);
					points.add(point);
					// if we want to paint each pixel
					//g.setColor(Color.RED);
					//g.drawRect(i, j, 2, 2);
					//System.out.println("Position: " + point);
				}
			}
		}
		
		// drawing rectangles in place where we found the images differences
		if (!points.isEmpty()) {
			g.setColor(Color.RED);
			Point start = points.get(0);
			Point end = new Point(0, 0);
			
			for (int i = 0; i < points.size(); i++) {
				if (Math.abs(start.getX() - points.get(i).getX()) > 10) {
					end = points.get(i-1);
					int widthRect = end.getX() - start.getX() + 2;
					int heightRect = end.getY() - start.getY() + 10;
					g.drawRect(start.getX(), start.getY() - 5, widthRect, heightRect);
					//System.out.println("widthRect: " + widthRect);
					//System.out.println("heightRect: " + heightRect);
					start = points.get(i);
				}
			}
		}

		saveImage(result, "result.png");
	}
	
	/**
	 * Load source images.
	 */
	private static void loadImage() {
		try {
			image1 = ImageIO.read(new File("resources/image1.png"));
			image2 = ImageIO.read(new File("resources/image2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method for saving image.
	 * 
	 * @param image that would be saved
	 * @param path the directory that will contained new saved image
	 */
	private static void saveImage(BufferedImage image, String path) {
		try {
			ImageIO.write(image, "PNG", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Compare RGB value of colors and return difference in percentage.
	 * 
	 * @param color1 first color
	 * @param color2 second color
	 * @return difference in percentage
	 */
	private static float colorDifferencePercentage(Color color1, Color color2) {
		int diffRed = Math.abs(color1.getRed() - color2.getRed());
		int diffGreen = Math.abs(color1.getGreen() - color2.getGreen());
		int diffBlue = Math.abs(color1.getBlue() - color2.getBlue());

		float pctDiffRed = (float) diffRed / 255;
		float pctDiffGreen = (float) diffGreen / 255;
		float pctDiffBlue = (float) diffBlue / 255;

		return (pctDiffRed + pctDiffGreen + pctDiffBlue) / 3 * 100;
	}

	/**
	 * Create Color object from rgb value.
	 * 
	 * @param rgb value of the color
	 * @return the <code>Color</code> converted from the rgb
	 */
	private static Color getColor(int rgb) {
		int red = (rgb >> 16) & 0xff;
		int green = (rgb >> 8) & 0xff;
		int blue = (rgb) & 0xff;

		return new Color(red, green, blue);
	}
	
	private static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		
		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}
}