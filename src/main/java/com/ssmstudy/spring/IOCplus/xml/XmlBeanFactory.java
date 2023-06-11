package com.ssmstudy.spring.IOCplus.xml;

import com.ssmstudy.spring.IOCplus.BeanDefinition;
import com.ssmstudy.spring.IOCplus.CustomBeanPostProcessor;
import com.ssmstudy.spring.IOCplus.BeanReference;
import com.ssmstudy.spring.IOCplus.PropertyValue;
import com.ssmstudy.spring.IOCplus.factory.BeanFactory;
import com.ssmstudy.spring.IOCplus.factory.BeanFactoryAware;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    private List<String> beanDefinitionNames = new ArrayList<>();

    private List<CustomBeanPostProcessor> customBeanPostProcessors = new ArrayList<CustomBeanPostProcessor>();

    private MyXmlBeanDefinitionReader beanDefinitionReader;


    public XmlBeanFactory(String location) throws Exception {
        beanDefinitionReader = new MyXmlBeanDefinitionReader();
        loadBeanDefinitions(location);
    }

    @Override
    public Object getBean(String id) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(id);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("no this bean with name " + id);
        }

        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = createBean(beanDefinition);
            bean = initializeBean(bean, id);
            beanDefinition.setBean(bean);
        }

        return bean;
    }

    private Object createBean(BeanDefinition bd) throws Exception {
        Object bean = bd.getBeanClass().newInstance();
        applyPropertyValues(bean, bd);

        return bean;
    }

    private void applyPropertyValues(Object bean, BeanDefinition bd) throws Exception {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : bd.getPropertyValues().getPvList()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }

    private Object initializeBean(Object bean, String name) throws Exception {
        for (CustomBeanPostProcessor customBeanPostProcessor : customBeanPostProcessors) {
            bean = customBeanPostProcessor.postProcessBeforeInitialization(bean, name);
        }

        for (CustomBeanPostProcessor customBeanPostProcessor : customBeanPostProcessors) {
            bean = customBeanPostProcessor.postProcessAfterInitialization(bean, name);
        }

        return bean;
    }

    private void loadBeanDefinitions(String location) throws Exception {
        beanDefinitionReader.loadBeanDefinitions(location);
        registerBeanDefinition();
        registerBeanPostProcessor();
    }

    private void registerBeanDefinition() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionReader.getRegistry().entrySet()) {
            String name = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            beanDefinitionMap.put(name, beanDefinition);
            beanDefinitionNames.add(name);
        }
    }

    public void registerBeanPostProcessor() throws Exception {
        List beans = getBeansForType(CustomBeanPostProcessor.class);
        for (Object bean : beans) {
            addBeanPostProcessor((CustomBeanPostProcessor) bean);
        }
    }

    public void addBeanPostProcessor(CustomBeanPostProcessor customBeanPostProcessor) {
        customBeanPostProcessors.add(customBeanPostProcessor);
    }

    public List getBeansForType(Class type) throws Exception {
        List beans = new ArrayList<>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }
}
