package compoment.util;

import java.util.Random;

public class RandomGenerator {

    private static String range = "0123456789abcefghijkmnopqrstuvwxyz";

    public static synchronized String getRandonString() {

        Random random = new Random();

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < 8; i++) {

            result.append(range.charAt(random.nextInt(range.length())));
        }

        return result.toString();
    }

    /**
     * 获取随机颜色
     *
     * @param colorb
     * @param colorc
     * @return
     * @throws Exception
     */
    public static String randColor(int colorb, int colorc) throws Exception {

        Random random = new Random();

        if (colorb > 255) {

            colorb = 255;
        }

        if (colorc > 255) {

            colorc = 255;
        }

        int r = colorb + random.nextInt(colorc - colorb);
        int g = colorb + random.nextInt(colorc - colorb);
        int b = colorb + random.nextInt(colorc - colorb);

        StringBuilder builder = new StringBuilder();

        builder.append(r);
        builder.append(",");
        builder.append(g);
        builder.append(",");
        builder.append(b);
        return builder.toString();
    }
}
