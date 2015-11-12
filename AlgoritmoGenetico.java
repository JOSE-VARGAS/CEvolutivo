import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

public class AlgoritmoGenetico{

	String imagen;
	public BufferedImage img; //Imagen Original
	public BufferedImage imgTemporal; //Una copia de la original solo para tamaño
	ImagenNegra actual;        //Esta es la inicial con una imagen negra
	int iteraciones;
	int scale;
	int distanciaActual;

	public AlgoritmoGenetico(String ruta,int iteraciones,int scale){
		
		img = FileIO.readImage(ruta);
		imgTemporal = FileIO.readImage(ruta);
		actual = new ImagenNegra(imgTemporal);
		this.iteraciones = iteraciones;
		this.scale = scale;
		distanciaActual = -1;
	}

	public void init(){

		ImagenNegra temporal = actual.clone();
		Graphics2D actualGrafico = temporal.genera();	//Maya Negra	
		int tem = 0;
		DnaDrawing drawing = new DnaDrawing();
		drawing.init();
        distanciaActual = eval(img,temporal.imgTemporal);
        Canvas x  = new Canvas(temporal.imgTemporal);   //Pintamos la imagen Negra
        
		for(int i=0;i<iteraciones;i++){
		//try {
          //  Thread.sleep(100);
        //} catch (InterruptedException ex) {
        //}
        Renderer.Render(drawing,actualGrafico,scale);
		
		tem = eval(img,temporal.imgTemporal);
		if(tem<distanciaActual){
		distanciaActual = tem;
		actual = temporal.clone();
		System.out.println("Error : "+distanciaActual+ " iteracion "+i);
		x.repaint();
        }
        drawing.mutate();
        
		
		
		}
	}
	/*
	Funcion de evaluacion Tomamos la distancia euclidiana 
	de las imagenes;
	*/
	public int eval(BufferedImage objetivo,BufferedImage compara){
		int alto = objetivo.getHeight();
	    int ancho = objetivo.getWidth();
	    int rgbO = 0;
	    int rgbC = 0;
	    Color o;
	    Color c;
	    int distancia = 0;
	    for(int i=0;i<ancho;i++)
	    	for(int j=0;j<alto;j++){
				rgbO = objetivo.getRGB(j,i); 
				rgbC = compara.getRGB(j,i); 
				o = new Color(rgbO);
				c = new Color(rgbC);
				distancia += Math.abs((o.getRed()-c.getRed())+(o.getGreen()-c.getGreen())+(o.getBlue()-c.getBlue()));
	    	}
	    	return distancia;
	}

	}

	
