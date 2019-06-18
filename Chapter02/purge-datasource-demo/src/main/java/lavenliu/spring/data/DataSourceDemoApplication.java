package lavenliu.spring.data;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceDemoApplication {
    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        ApplicatinContext applicatinContext = new ClassPathXmlApplicationContext("applicationContext*.xml");

    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws Exception {

    }
}