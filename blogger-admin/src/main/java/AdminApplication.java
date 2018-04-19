import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-10 22:04
 * @desc
 * @since 1.8
 */

@Configuration
@SpringBootApplication(scanBasePackages = {"com.user"})
public class AdminApplication {

    public static void main(String[] args){

        SpringApplication.run(AdminApplication.class, args);
    }
}
