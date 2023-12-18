package by.itstep.springApplication.listener.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EntityListener {
    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'")
    @Order(Integer.MIN_VALUE)
    public void acceptEntityRead(EntityEvent event) {
        log.info("Entity: " + event);
    }
}
