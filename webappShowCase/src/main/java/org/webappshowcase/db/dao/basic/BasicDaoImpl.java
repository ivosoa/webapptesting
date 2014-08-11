package org.webappshowcase.db.dao.basic;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.webappshowcase.db.dao.util.ManagerUtil;

/**
 *
 * @author ivo
 */
public class BasicDaoImpl<E, T> implements BasicDao<E, T> {

  protected EntityManager em;
  protected Class<E> entity;

  protected Class<E> getEntity() {
    return entity;
  }

  public BasicDaoImpl(Class<E> entity) {
    this.em = ManagerUtil.getEntityManager();
    this.entity = entity;
  }

  @Override
  public void begin() {
    em.getTransaction().begin();
  }

  @Override
  public void commit() {
    em.getTransaction().commit();
  }

  @Override
  public void persist(E e) {
    em.persist(e);
  }

  @Override
  public E findById(T t) {
    return em.find(getEntity(), t);
  }

  @Override
  public List<E> findAll() {
    Session session = em.unwrap(Session.class);
    List<E> result = session.createCriteria(getEntity()).list();
    return result;
  }

  @Override
  public void delete(E e) {
    em.remove(e);
  }
}
