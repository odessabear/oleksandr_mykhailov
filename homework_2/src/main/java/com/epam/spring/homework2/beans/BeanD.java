package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanD implements ParentBean {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanD{" +
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
