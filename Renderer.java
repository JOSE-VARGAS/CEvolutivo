import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class Renderer {

	//Render a Drawing
	public static void Render(DnaDrawing drawing, Graphics g, int scale)
	{
		for (DnaPolygon polygon : drawing.polygons)
			render(polygon, g, scale);
	}

	private static void render(DnaPolygon polygon, Graphics g, int scale)
	{
		Polygon np = new Polygon();
		for (DnaPoint p : polygon.points)
			np.addPoint(p.x * scale, p.y * scale);

		g.setColor(new Color(polygon.brush.red, polygon.brush.green, polygon.brush.blue, polygon.brush.alpha));
		g.drawPolygon(np);
	}
}
