import compoment.captcha.AccountCaptchaService;
import compoment.captcha.impl.AccountCaptchaServiceImp;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 类备注：
 *
 * @author Administrator
 * @version 1.0
 * @date 2018-04-27 17:10
 * @desc
 * @since 1.8
 */
public class Captcha {

    @Test
    public void captchaTest() throws Exception{

        AccountCaptchaService accountCaptchaService = new AccountCaptchaServiceImp();

        String key = accountCaptchaService.generateCaptchaKey();

        byte[] resultByte = accountCaptchaService.generateCaptchaImage(key);

        File file = new File("D:\\拼版\\chekcCode.jpg");

        OutputStream out = null;

        try {

            // 根据字节流写入文件中
            out = new FileOutputStream(file);

            out.write(resultByte);

            out.flush();

            out.close();
        }catch (Exception e){

            if(out != null){

                out.close();
            }
        }
    }
}
