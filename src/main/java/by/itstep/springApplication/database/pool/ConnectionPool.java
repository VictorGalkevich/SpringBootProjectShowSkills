package by.itstep.database.pool;

import by.itstep.bpp.Auditing;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("pool1")
public class ConnectionPool {
    private final String username;
    private final Integer poolSize;
    /*private List<Object> args;
    private Map<String, Object> metadata;*/
    public ConnectionPool(@Value("${db.username}") String username, @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        System.out.println("Initialize connection pool");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clear connection pool");
    }
}
