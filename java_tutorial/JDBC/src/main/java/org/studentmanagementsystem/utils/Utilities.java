package org.studentmanagementsystem.utils;

import java.math.BigDecimal;

public class Utilities {

    public static String CalculateGradeLetter(BigDecimal score) {
        if (score.compareTo(new BigDecimal("70")) >= 0) {
            return "A";
        } else if (score.compareTo(new BigDecimal("60")) >= 0) {
            return "B";
        } else if (score.compareTo(new BigDecimal("50")) >= 0) {
            return "C";
        } else if (score.compareTo(new BigDecimal("40")) >= 0) {
            return "D";
        } else {
            return "F";
        }
    }
}
