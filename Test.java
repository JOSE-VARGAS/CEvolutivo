import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

public class Test {

	public static void main(String [] args) {
		BufferedImage img = FileIO.readImage("data/ml.bmp");
		Graphics2D g = img.createGraphics();		

        g.setColor(Color.white);
        g.fillRect(100, 100, 400, 400);

		FileIO.saveImage("data/salida.png", img);
	}
}
