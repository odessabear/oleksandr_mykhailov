package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@Import(SecondBeansConfig.class)
public class FirstBeansConfig {
    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean(initMethod = "customIntiMethod", destroyMethod = "customDestroyMethod")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "customIntiMethod", destroyMethod = "customDestroyMethod")
    @DependsOn({"beanB", "beanD"})
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean(initMethod = "customIntiMethod", destroyMethod = "customDestroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

    @Bean
    @Lazy
    BeanF beanF() {
        return new BeanF();
    }
}
