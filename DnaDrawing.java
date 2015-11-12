import java.util.LinkedList;

public class DnaDrawing {

	public LinkedList<DnaPolygon> polygons;
	private boolean isDirty;

	public void init()
	{
		this.polygons = new LinkedList<DnaPolygon>();

		for (int i = 0; i < Settings.ActivePolygonsMin; i++)
			addPolygon();

		setDirty();
	}

	public DnaDrawing clone()
	{
		DnaDrawing drawing = new DnaDrawing();
		drawing.polygons = new LinkedList<DnaPolygon>();
		for (DnaPolygon polygon : this.polygons)
			drawing.polygons.add(polygon.clone());

		return drawing;
	}


	public void mutate()
	{
		if (Tools.willMutate(Settings.ActiveAddPolygonMutationRate))
			addPolygon();

		if (Tools.willMutate(Settings.ActiveRemovePolygonMutationRate))
			removePolygon();

		if (Tools.willMutate(Settings.ActiveMovePolygonMutationRate))
			movePolygon();

		for (DnaPolygon polygon : this.polygons)
			polygon.mutate(this);
	}

	public void movePolygon()
	{
		if (this.polygons.size() < 1)
			return;

		int index = Tools.getRandomNumber(0, this.polygons.size());
		DnaPolygon poly = this.polygons.get(index);
		this.polygons.remove(index);
		index = Tools.getRandomNumber(0, this.polygons.size());
		this.polygons.add(index, poly);
		setDirty();
	}

	public void removePolygon()
	{
		if (this.polygons.size() > Settings.ActivePolygonsMin)
		{
			int index = Tools.getRandomNumber(0, polygons.size());
			this.polygons.remove(index);
			setDirty();
		}
	}

	public void addPolygon()
	{
		if (this.polygons.size() < Settings.ActivePolygonsMax)
		{
			DnaPolygon newPolygon = new DnaPolygon();
			newPolygon.init();
            int index = 0;
            if(this.polygons.size()>0)
			index = Tools.getRandomNumber(0, this.polygons.size()+1); //Se le hizo un cambio 

			this.polygons.add(index, newPolygon);
			setDirty();
		}
	}	
	
	public int pointCount() {
		int pointCount = 0;
		for (DnaPolygon polygon : this.polygons)
			pointCount += polygon.points.size();

		return pointCount;
	}
	
	public void setDirty() {
		this.isDirty = true;
	}
}
