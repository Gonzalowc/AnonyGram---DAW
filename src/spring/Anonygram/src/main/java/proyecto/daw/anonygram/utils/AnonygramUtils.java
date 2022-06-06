package proyecto.daw.anonygram.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

/**
 * The Class AnonygramUtils.
 */
public class AnonygramUtils {

    /**
     * Gets the random index.
     *
     * @param length
     *            the length
     * @return the random index
     */
    public static int getRandomIndex(int length) {
        Random random = new Random();
        int max = length;
        int min = 0;
        return random.nextInt(max - min) + min;
    }

    /**
     * Convert to local date.
     *
     * @param date
     *            the date
     * @return the local date
     */
    public static LocalDate convertToLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Es misma fecha.
     *
     * @param fecha1
     *            the fecha 1
     * @param fecha2
     *            the fecha 2
     * @return true, if successful
     */
    public static boolean esMismaFecha(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1.getDayOfMonth() == fecha2.getDayOfMonth() && fecha1.getMonthValue() == fecha2.getMonthValue()
            && fecha1.getYear() == fecha2.getYear()) {
            return true;
        }
        return false;
    }

    /**
     * Es anterior fecha.
     *
     * @param fecha1
     *            the fecha 1
     * @param fecha2
     *            the fecha 2
     * @return true, if successful
     */
    public static boolean esAnteriorFecha(LocalDate fecha1, LocalDate fecha2) {
        if (fecha1.getDayOfMonth() <= fecha2.getDayOfMonth() && fecha1.getMonthValue() <= fecha2.getMonthValue()
            && fecha1.getYear() <= fecha2.getYear()) {
            return true;
        }
        return false;
    }
}
