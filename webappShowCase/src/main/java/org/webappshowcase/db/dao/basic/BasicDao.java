package org.webappshowcase.db.dao.basic;

import java.util.List;

/**
 *
 * @author ivo
 */
public interface BasicDao<E, T> {

  public void begin();

  public void commit();

  public void persist(E e);

  public E findById(T t);

  public List<E> findAll();

  public void delete(E e);
}
