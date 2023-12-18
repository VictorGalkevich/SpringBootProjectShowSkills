package by.itstep.springApplication.database.repository;

import java.util.Optional;

public interface CrudRepository<K, E> {
    Optional<E> finById(K id);
    void delete(E entity);
}
