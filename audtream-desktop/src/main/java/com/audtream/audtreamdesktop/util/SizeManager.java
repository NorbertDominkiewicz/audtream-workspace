package com.audtream.audtreamdesktop.util;

import java.awt.Toolkit;

public class SizeManager {
    public static double getScreenWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    }

    public static double getScreenHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }

    public static double getThreeQuartersOfScreenWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 3/4;
    }

    public static double getThreeQuartersOfScreenHeight() {
        return Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 3/4;
    }

    public static double getFourFifthOfScreenWidth() {
        return Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 4/5;
    }
}
