package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanC implements ParentBean {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    private void customIntiMethod() {
        System.out.println(this.getClass().getSimpleName() + " customIntiMethod()");
    }

    private void customDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " customDestroyMethod");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
