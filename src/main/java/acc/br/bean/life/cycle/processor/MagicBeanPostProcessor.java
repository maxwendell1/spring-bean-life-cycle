package acc.br.bean.life.cycle.processor;

import org.springframework.beans.factory.config.BeanPostProcessor;

import acc.br.bean.life.cycle.beans.Character;

public class MagicBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (bean instanceof Character) {
            System.out.println("5. BeanPostProcessor: Adding a touch of magic to " + ((Character) bean).getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof Character) {
            System.out.println("9. BeanPostProcessor: Magic continues for " + ((Character) bean).getName());
        }
        return bean;
    }
}
