package id.ac.ui.cs.advprog.eshop.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Function;

public abstract class AbstractRepository<T> {
    protected List<T> data = new ArrayList<>();
    // function to get the id from an entity and setter to assign an id
    protected Function<T, String> getId;
    protected BiConsumer<T, String> setId;

    protected AbstractRepository(Function<T, String> getId, BiConsumer<T, String> setId) {
        this.getId = getId;
        this.setId = setId;
    }

    public T create(T entity) {
        String id = getId.apply(entity);
        if (id == null || id.isEmpty()) {
            setId.accept(entity, UUID.randomUUID().toString());
        }
        data.add(entity);
        return entity;
    }

    public Iterator<T> findAll() {
        return data.iterator();
    }

    public T findById(String id) {
        for (T entity : data) {
            if (getId.apply(entity).equals(id)) {
                return entity;
            }
        }
        return null;
    }

    public T update(String id, T updatedEntity) {
        for (T entity : data) {
            if (getId.apply(entity).equals(id)) {
                updateEntity(entity, updatedEntity);
                return entity;
            }
        }
        return null;
    }

    public void delete(String id) {
        data.removeIf(entity -> getId.apply(entity).equals(id));
    }

    // each concrete repository must define how to update its entity
    protected abstract void updateEntity(T existing, T updatedEntity);
}
