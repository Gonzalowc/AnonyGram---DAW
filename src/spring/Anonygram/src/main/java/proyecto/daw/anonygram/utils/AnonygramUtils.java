package proyecto.daw.anonygram.utils;

import java.util.Random;

public class AnonygramUtils {

    public static int getRandomIndex(int length) {
        Random random = new Random();
        int max = length;
        int min = 0;
        return random.nextInt(max - min) + min;
    }
}
