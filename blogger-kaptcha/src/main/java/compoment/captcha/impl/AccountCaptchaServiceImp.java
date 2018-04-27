package compoment.captcha.impl;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import compoment.captcha.AccountCaptchaService;
import compoment.util.RandomGenerator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;

public class AccountCaptchaServiceImp implements AccountCaptchaService {

    private DefaultKaptcha producer;

    private Map<String, String> captchaMap = new HashMap<String, String>();

    private List<String> preDefinedTexts;

    private int textCount = 0;

    public AccountCaptchaServiceImp() throws Exception {

        producer = new DefaultKaptcha();

        // 生成验证码的颜色
        String fontColor = RandomGenerator.randColor(0, 50);

        // 生成背景色
        String backColor = RandomGenerator.randColor(240, 250);

        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("kaptcha.properties");

        Properties properties = new Properties();

        properties.load(stream);

        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", fontColor);

        // 背景颜色
        properties.setProperty("kaptcha.background.clear.from", backColor);

        // 背景颜色
        properties.setProperty("kaptcha.background.clear.to", backColor);

        producer.setConfig(new Config(properties));
    }

    @Override
    public String generateCaptchaKey() throws Exception {

        String key = RandomGenerator.getRandonString();

        String value = getCaptchaText();

        captchaMap.put(key, value);

        return key;
    }

    private String getCaptchaText() {

        if (preDefinedTexts != null && preDefinedTexts.isEmpty()) {

            String text = preDefinedTexts.get(textCount);

            textCount = (textCount + 1) % preDefinedTexts.size();

            return text;
        } else {

            return producer.createText();
        }
    }

    @Override
    public byte[] generateCaptchaImage(String captchaKey) throws Exception {

        String text = this.captchaMap.get(captchaKey);

        if (text == null) {

            throw new Exception("captch key" + captchaKey + "not found");
        }

        BufferedImage image = producer.createImage(text);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ImageIO.write(image, "jpg", outputStream);

        return outputStream.toByteArray();
    }

    @Override
    public void setPreDefinedTexts(List<String> preDefinedTexts) {

    }

    public Map<String, String> getCaptchaMap() {
        return captchaMap;
    }

    public void setCaptchaMap(Map<String, String> captchaMap) {
        this.captchaMap = captchaMap;
    }

    public List<String> getPreDefinedTexts() {
        return preDefinedTexts;
    }

    public int getTextCount() {
        return textCount;
    }

    public void setTextCount(int textCount) {
        this.textCount = textCount;
    }
}
