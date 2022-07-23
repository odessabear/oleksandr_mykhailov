package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validator.BeansValidator;
import com.epam.spring.homework2.validator.BeansValidatorImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyCustomBeanPostProcessor implements BeanPostProcessor {
    private final BeansValidator validator = new BeansValidatorImpl();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println(bean.getClass().getSimpleName() + " postProcessBeforeInitialization() method");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass().getSimpleName() + " postProcessAfterInitialization() method");
        if (bean instanceof ParentBean) {
            validator.validateBean((ParentBean) bean);
        }
        return bean;
    }
}
