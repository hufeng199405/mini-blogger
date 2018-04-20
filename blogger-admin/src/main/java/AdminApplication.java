import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 类备注：
 *
 * @author hufeng
 * @version 1.0
 * @date 2018-04-10 22:04
 * @desc
 * @since 1.8
 */

@SpringBootApplication
@Configuration
@ComponentScan("com")
@MapperScan("com.*.mapper")
@ServletComponentScan
public class AdminApplication extends SpringBootServletInitializer{

    @Autowired
    private Environment env;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(AdminApplication.class);
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){

        DruidDataSource dataSource = new DruidDataSource();

        // 连接池初始化大小
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        //用户名
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        //密码
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        //初始化时建立物理连接的个数
        dataSource.setInitialSize(2);
        //最大连接池数量
        dataSource.setMaxActive(20);
        //最小连接池数量
        dataSource.setMinIdle(0);
        //获取连接时最大等待时间，单位毫秒。
        dataSource.setMaxWait(6000);
        //用来检测连接是否有效的sql
        dataSource.setValidationQuery("SELECT 1");
        //申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestOnBorrow(false);
        //建议配置为true，不影响性能，并且保证安全性。
        dataSource.setTestWhileIdle(true);
        //是否缓存preparedStatement，也就是PSCache
        dataSource.setPoolPreparedStatements(false);

        return dataSource;
    }

    public static void main(String[] args){

        SpringApplication.run(AdminApplication.class, args);
    }
}
