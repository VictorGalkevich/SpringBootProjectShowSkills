package by.itstep.springApplication.bpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TransactionBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Class<?>> transactionBeans = new HashMap<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Transaction.class)) {
            transactionBeans.put(beanName, bean.getClass());
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = transactionBeans.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    (o, method, objects) -> {
                        log.info("Open transaction");
                        try {
                            return method.invoke(bean, objects);
                        } catch (Exception exception) {
                            log.error("Rollback exception");
                            throw exception;
                        } finally {
                            log.info("Close transaction");
                        }
                    });
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
