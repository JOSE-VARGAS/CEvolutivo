
public class DnaPoint {

	public int x;
	public int y;

	public DnaPoint() {
		this.x = 0;
		this.y = 0;
	}

	public DnaPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void init()
	{
		this.x = Tools.getRandomNumber(0, Tools.MAX_WIDTH);
		this.y = Tools.getRandomNumber(0, Tools.MAX_HEIGHT);
	}

	public DnaPoint clone() {
		return new DnaPoint(this.x, this.y);
	}

	public void mutate(DnaDrawing drawing)
	{
		if (Tools.willMutate(Settings.ActiveMovePointMaxMutationRate))
		{
			this.x = Tools.getRandomNumber(0, Tools.MAX_WIDTH);
			this.y = Tools.getRandomNumber(0, Tools.MAX_HEIGHT);
			drawing.setDirty();
		}

		if (Tools.willMutate(Settings.ActiveMovePointMidMutationRate))
		{
			this.x = Math.min(Math.max(0, this.x + Tools.getRandomNumber(-Settings.ActiveMovePointRangeMid, Settings.ActiveMovePointRangeMid)), Tools.MAX_WIDTH);
			this.y = Math.min(Math.max(0, this.y + Tools.getRandomNumber(-Settings.ActiveMovePointRangeMid, Settings.ActiveMovePointRangeMid)), Tools.MAX_HEIGHT);
			drawing.setDirty();
		}

		if (Tools.willMutate(Settings.ActiveMovePointMinMutationRate))
		{
			this.x = Math.min(Math.max(0, this.x + Tools.getRandomNumber(-Settings.ActiveMovePointRangeMin, Settings.ActiveMovePointRangeMin)), Tools.MAX_WIDTH);
			this.y = Math.min(Math.max(0, this.y + Tools.getRandomNumber(-Settings.ActiveMovePointRangeMin, Settings.ActiveMovePointRangeMin)), Tools.MAX_HEIGHT);
			drawing.setDirty();
		}
	}	
}
