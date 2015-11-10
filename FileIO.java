import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.*;

public class FileIO {

    public static BufferedImage readImage(String filename) { 
		BufferedImage inputImage = null;
		try {
			inputImage = ImageIO.read(new File(filename));
		}
		catch(Exception e) {
			System.out.println("!! " +e.getMessage());
		}

		return inputImage;
    }

    public static int saveImage(String filename,  
            BufferedImage image){ 
        int status = 0;
        File file = new File(filename); 
        try { 
            ImageIO.write(image, "png", file); 
        } catch (Exception e) { 
            System.out.println(e.toString()+" Image '"+filename 
                                +"' saving failed."); 
            status = 1;
        } 
        return status;
    }
}
