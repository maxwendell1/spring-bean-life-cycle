package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Item implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private Double price;
    private String type;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Item() {
        System.out.println("1. Instantiation: A new item has been created.");
        this.name = "Default";
        this.price = 0.0;
        this.type = "Unknown";
    }

    public Item(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. ApplicationContextAware: Setting application context.");
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("3. BeanFactoryAware: Setting bean factory for " + getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7. Initialization: " + getName() + " is being configured with price " + getPrice() + " and type " + getType() + ".");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: " + getName() + " of type " + getType() + " is being stored.");
        clearData();
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Setting up custom configuration for " + getName());
    }

    public void customDestroy() {
        System.out.println("13. Custom Destruction: Finalizing resources for " + getName() + " of type " + getType());
    }

    private void clearData() {
        System.out.println("12. Clearing data for " + getName() + " of type " + getType());
    }

    @PostConstruct
    public void init() {
        System.out.println("6. @PostConstruct: Preparing " + getName() + " of type " + getType() + " for initialization.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy: Preparing " + getName() + " of type " + getType() + " for destruction.");
    }
}