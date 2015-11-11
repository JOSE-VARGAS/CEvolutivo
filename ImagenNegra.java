import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

class ImagenNegra{

	BufferedImage imgTemporal;
	
	public ImagenNegra(BufferedImage imgTemporal){
			this.imgTemporal = imgTemporal;	

	}
	public Graphics2D genera(){
		Graphics2D g = imgTemporal.createGraphics();		
        g.setColor(Color.black);
        g.fillRect(0, 0, imgTemporal.getHeight(),imgTemporal.getWidth());
        return g;
	}
}