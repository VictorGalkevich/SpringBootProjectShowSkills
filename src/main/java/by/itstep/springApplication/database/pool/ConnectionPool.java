package by.itstep.springApplication.database.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pool1")
@RequiredArgsConstructor
@Slf4j
public class ConnectionPool {
    @Value("${db.username}")
    private final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;
    /*private List<Object> args;
    private Map<String, Object> metadata;*/

    @PostConstruct
    private void init() {
        log.info("Initialize connection pool");
    }

    @PreDestroy
    private void destroy() {
        log.info("Clear connection pool");
    }
}
