package compoment.captcha;

import java.util.List;

public interface AccountCaptchaService {

    /**
     * 生成验证码主键
     *
     * @return
     * @throws Exception
     */
    String generateCaptchaKey() throws Exception;

    /**
     * 获取验证码文字
     *
     * @param key
     * @return
     * @throws Exception
     */
    String getCaptchaText(String key) throws Exception;

    /**
     * 生成验证码图片
     *
     * @param captchaKey
     * @return
     * @throws Exception
     */
    byte[] generateCaptchaImage(String captchaKey) throws Exception;

    /**
     * 根据文字生成验证码
     */
    void setPreDefinedTexts(List<String> preDefinedTexts);
}
