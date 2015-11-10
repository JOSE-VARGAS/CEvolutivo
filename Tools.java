import java.util.Random;

public class Tools {

	public static int MAX_WIDTH = 200;
	public static int MAX_HEIGHT = 200;

	public static int MAX_POLYGONS = 250;

	private static Random random = new Random();

	public static int getRandomNumber(int min, int max)
	{
		return min + random.nextInt(max);
	}

	public static boolean willMutate(int mutationRate)
	{
		if (getRandomNumber(0, mutationRate) == 1)
			return true;

		return false;
	}
}
