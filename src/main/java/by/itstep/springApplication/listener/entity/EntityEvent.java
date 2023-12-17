package by.itstep.springApplication.listener.entity;

import org.springframework.context.ApplicationEvent;

public class EntityListener extends ApplicationEvent {
    private final AccessType accessType;

    public EntityListener(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
