package acc.br.bean.life.cycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringBeanLifecycleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBeanLifecycleApplication.class, args);
        applicationContext.close();
    }
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBeanLifecycleApplication.class, args);
//	}

}
