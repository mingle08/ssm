package com.ssmstudy.entity.iocDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1.实例化bean
 * 2.保存bean
 * 3.提供bean
 * 4.每一个bean要产生一个唯一的id与之对应
 *
 */
public class IoCContainer {

    // 1. 保存bean
    private Map<String, Object> beans = new ConcurrentHashMap<>();

    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    /**
     * 委托IoC容器创建一个bean
     * @param clazz  要创建的bean的class
     * @param beanId 要创建的bean在IoC容器中的id
     * @param paramBeanIds 要创建的bean的class的构造方法中的入参对应的beanId
     */
    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds) {
        // 1. 组装构造方法所需的参数（比如Person的构造函数中参数有Car）
        Object[] params = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            params[i] = beans.get(paramBeanIds[i]);
        }
        // 2. 调用构造方法实例化bean
        Object bean = null;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(params);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (bean == null) {
            throw new RuntimeException("找不到合适的构造方法");
        }

        // 3. 将实例化的bean放入beans
        beans.put(beanId, bean);
    }
}
