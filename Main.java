import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

public class Main {

	public static void main(String [] args) {
		
		String ruta = "data/ml.bmp";
		AlgoritmoGenetico tem = new AlgoritmoGenetico(ruta,10000,1);
		tem.init();
		tem.eval(tem.img,tem.imgTemporal);
		
		/*
		BufferedImage img = FileIO.readImage("data/ml.bmp");
		BufferedImage imgTemporal = FileIO.readImage("data/ml.bmp");
		ImagenNegra imgNegra = new ImagenNegra(imgTemporal);
		Graphics2D actual = imgNegra.genera();		

		DnaDrawing drawing = new DnaDrawing();
		drawing.init();

		int scale = 1;
		Canvas x  = new Canvas(imgTemporal);
		for(int i=0;i<1000;i++){
		try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            
        }
		Renderer.Render(drawing,actual,scale);

		x.repaint();
		}
        */
	}
}
