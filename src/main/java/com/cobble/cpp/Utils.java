package com.cobble.cpp;

import java.util.Random;

public class Utils {
	// chooses one of the given ints at random
	public static int randomChoise(int... val) {
		Random random = new Random();
		return val[random.nextInt(val.length)];
	}
}
