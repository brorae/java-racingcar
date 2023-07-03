package utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int RANDOM_UPPER_BOUND = 10;
    private static final Random RANDOM = new Random();

    @Override
    public int generate() {
        return RANDOM.nextInt(RANDOM_UPPER_BOUND);
    }
}
