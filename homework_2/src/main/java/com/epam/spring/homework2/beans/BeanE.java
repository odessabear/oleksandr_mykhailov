package com.epam.spring.homework2.beans;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE implements ParentBean {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass().getSimpleName() + " postConstruct() method");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(this.getClass().getSimpleName() + " preDestroy() method");
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
