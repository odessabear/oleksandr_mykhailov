package com.epam.spring.homework2.validator;

import com.epam.spring.homework2.beans.ParentBean;

public class BeansValidatorImpl implements BeansValidator {
    @Override
    public void validateBean(ParentBean bean) {
        String validatedBean = bean.getClass().getSimpleName();
        if (bean.getName() == null) {
            System.out.println(validatedBean + " is not valid because its field name = null!");
        } else if (bean.getValue() < 0) {
            System.out.println(validatedBean + " is not valid because has value " + bean.getValue() + " < 0");
        } else {
            System.out.println(validatedBean + " with values of field name = " + bean.getName()
                    + " and field value = " + bean.getValue() + " complies with requirements");
        }
    }
}
