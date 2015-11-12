import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

class ImagenNegra{

	public BufferedImage imgTemporal;
	
	public ImagenNegra(BufferedImage imgTemporal){
			this.imgTemporal = imgTemporal;	

	}
	public ImagenNegra(int ancho,int largo,int tipoImagen){
		this.imgTemporal = new BufferedImage(ancho,largo,tipoImagen);	
	}
	public Graphics2D genera(){
		Graphics2D g = imgTemporal.createGraphics();		
        g.setColor(Color.black);
        g.fillRect(0, 0, imgTemporal.getHeight(),imgTemporal.getWidth());
        return g;
	}
	public ImagenNegra clone(){
	ImagenNegra copia = new ImagenNegra(imgTemporal.getWidth(),imgTemporal.getHeight(),1);
	int  rgb = 0;
	for(int i=0;i<copia.imgTemporal.getWidth();i++)
		for(int j=0;j<copia.imgTemporal.getHeight();j++){
			rgb = imgTemporal.getRGB(j,i);
			copia.imgTemporal.setRGB(j,i,rgb);
		}

	return copia;
	}

}