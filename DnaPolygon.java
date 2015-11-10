import java.util.LinkedList;

public class DnaPolygon {

	public DnaBrush brush;
	public LinkedList<DnaPoint> points;

	public void init()
	{
		this.points = new LinkedList<DnaPoint>();

		DnaPoint origin = new DnaPoint();
		origin.init();

		for (int i = 0; i < Settings.ActivePointsPerPolygonMin; i++)
		{
			DnaPoint point = new DnaPoint();
			point.x = Math.min(Math.max(0, origin.x + Tools.getRandomNumber(-3, 3)), Tools.MAX_WIDTH);
			point.y = Math.min(Math.max(0, origin.y + Tools.getRandomNumber(-3, 3)), Tools.MAX_HEIGHT);

			this.points.add(point);
		}

		this.brush = new DnaBrush();
	}

	public DnaPolygon clone()
	{
		DnaPolygon newPolygon = new DnaPolygon();
		newPolygon.points = new LinkedList<DnaPoint>();
		newPolygon.brush = brush.clone();

		for (DnaPoint point : this.points)
			newPolygon.points.add(point.clone());

		return newPolygon;
	}

	public void mutate(DnaDrawing drawing)
	{
		if (Tools.willMutate(Settings.ActiveAddPointMutationRate))
			addPoint(drawing);

		if (Tools.willMutate(Settings.ActiveRemovePointMutationRate))
			removePoint(drawing);

		this.brush.mutate(drawing);
		for (DnaPoint p : this.points)
			p.mutate(drawing);
	}

	private void removePoint(DnaDrawing drawing)
	{
		if (this.points.size() > Settings.ActivePointsPerPolygonMin)
		{
			if (drawing.pointCount() > Settings.ActivePointsMin)
			{
				int index = Tools.getRandomNumber(0, this.points.size());
				this.points.remove(index);

				drawing.setDirty();
			}
		}
	}

	private void addPoint(DnaDrawing drawing)
	{
		if (this.points.size() < Settings.ActivePointsPerPolygonMax)
		{
			if (drawing.pointCount() < Settings.ActivePointsMax)
			{
				DnaPoint prev = this.points.get(index - 1);
				DnaPoint next = this.points.get(index);

				DnaPoint newPoint = new DnaPoint((prev.x + next.x) / 2, (prev.y + next.y) / 2);
			
				int index = Tools.getRandomNumber(1, this.points.size() - 1);
				this.points.add(index, newPoint);

				drawing.setDirty();
			}
		}
	}	
}
