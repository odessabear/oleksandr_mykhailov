package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;

public class BeanB implements ParentBean {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    @Override
    public String toString() {
        return "BeanB{" +
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

    private void otherCustomInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " otherCustomInitMethod()");
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
