
public class DnaBrush {

	public int red;
	public int green;
	public int blue;
	public int alpha;

	public DnaBrush(int red, int green, int blue, int alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	public DnaBrush() {
		init();
	}

	private void init()
	{
		this.red = Tools.getRandomNumber(0, 255);
		this.green = Tools.getRandomNumber(0, 255);
		this.blue = Tools.getRandomNumber(0, 255);
		this.alpha = Tools.getRandomNumber(10, 60);
	}

	public DnaBrush clone()
	{
		return new DnaBrush(this.red, this.green, this.blue, this.alpha);
	}

	public void mutate(DnaDrawing drawing)
	{
		if (Tools.willMutate(Settings.ActiveRedMutationRate))
		{
			this.red = Tools.getRandomNumber(Settings.ActiveRedRangeMin, Settings.ActiveRedRangeMax);
			drawing.setDirty();
		}

		if (Tools.willMutate(Settings.ActiveGreenMutationRate))
		{
			this.green = Tools.getRandomNumber(Settings.ActiveGreenRangeMin, Settings.ActiveGreenRangeMax);
			drawing.setDirty();
		}

		if (Tools.willMutate(Settings.ActiveBlueMutationRate))
		{
			this.blue = Tools.getRandomNumber(Settings.ActiveBlueRangeMin, Settings.ActiveBlueRangeMax);
			drawing.setDirty();
		}

		if (Tools.willMutate(Settings.ActiveAlphaMutationRate))
		{
			this.alpha = Tools.getRandomNumber(Settings.ActiveAlphaRangeMin, Settings.ActiveAlphaRangeMax);
			drawing.setDirty();
		}
	}
}
