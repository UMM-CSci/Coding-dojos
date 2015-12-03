public class Plants {

	public static void main(String[] args) {

	}

	public static int localSunlightFunction(int leftPlant, int myHeight,
			int rightPlant, int sunlight) {
		int shade = 0;
		if (leftPlant > myHeight) {
			shade += leftPlant - myHeight;

		}
		if (rightPlant > myHeight) {
			shade += rightPlant - myHeight;

		}
		int localSunlight = sunlight - shade;
		if (localSunlight < 0) {
			localSunlight = 0;
		}

		return localSunlight;
	}

	public static int growthFunction(int localSunlight, int myHeight) {
		if (myHeight == 0) {
			return 0;
		} else if (myHeight >= 40 && localSunlight >= 70) {
			return 0;
		} else {
			return ((localSunlight / 25) * ((50 - myHeight) / 10)) + myHeight;
		}
	}

	public static void doDay(int[] garden, int globalSun) {
		int[] prevDay = new int[garden.length + 2];
		int[] sunArray = new int[garden.length + 2];
		System.arraycopy(garden, 0, prevDay, 1, garden.length);

		for (int i = 1; i < prevDay.length - 1; i++) {
			sunArray[i] = localSunlightFunction(prevDay[i - 1], prevDay[i],
					prevDay[i + 1], globalSun);
		}

		for (int i = 1; i < prevDay.length - 1; i++) {
			System.out.println("Got here");
			garden[i - 1] = growthFunction(sunArray[i], prevDay[i]);
			if (seedFunction(sunArray, prevDay, i)) {
				garden[i - 1] = 1;
			}
		}
	}

	private static boolean seedFunction(int[] sunArray, int[] prevDay, int i) {
		// If it's zero, and there's a seeding plant on either side.
		if ((prevDay[i] == 0)
				&& ((prevDay[i - 1] >= 40 && sunArray[i - 1] < 50) || (prevDay[i + 1] >= 40 && sunArray[i + 1] < 50))) {
			return true;
		}
		return false; // If it's not seeded, just be the old value.
	}
}