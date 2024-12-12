package acc.br.bean.life.cycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Weapon implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
    private String name;
    private int accuracy;
    private Double weight;
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public Weapon(String string) {
        System.out.println("1. Instantiation: A new weapon has been created.");
        this.name = "Default";
        this.accuracy = 0;
        this.weight = 0.0;
    }

    public String getName() {
        return name;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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
        System.out.println("7. Initialization: " + getName() + " is being configured with accuracy " + getAccuracy() + " and weight " + getWeight() + ".");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. DisposableBean: " + getName() + " with accuracy " + getAccuracy() + " is being dismantled.");
        clearData();
    }

    public void customInit() {
        System.out.println("8. Custom Initialization: Setting up custom configuration for " + getName());
    }

    public void customDestroy() {
        System.out.println("13. Custom Destruction: Finalizing resources for " + getName() + " with weight " + getWeight());
    }

    private void clearData() {
        System.out.println("12. Clearing data for " + getName() + " with accuracy " + getAccuracy());
    }

    @PostConstruct
    public void init() {
        System.out.println("6. @PostConstruct: Preparing " + getName() + " with weight " + getWeight() + " for initialization.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("10. @PreDestroy: Preparing " + getName() + " with accuracy " + getAccuracy() + " for destruction.");
    }
}