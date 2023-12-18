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
public class AuditingBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Class<?>> auditBeans = new HashMap<>();
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Auditing.class)) {
            auditBeans.put(beanName, bean.getClass());
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = auditBeans.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(),
                    (o, method, objects) -> {
                        log.info("Audit method: " + method.getName());
                        long l = System.nanoTime();
                        try {
                            return method.invoke(bean, objects);
                        } finally {
                            log.info("Execution time: " + (System.nanoTime() - l));
                        }
                    });
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
