package com.netcracker.spring.dao;


import java.io.Serializable;

public interface IDAO<Key extends Serializable, E> {

    E create(E entity);

    E read(Key key);

    void update(E entity);

    void delete(E entity);


}
