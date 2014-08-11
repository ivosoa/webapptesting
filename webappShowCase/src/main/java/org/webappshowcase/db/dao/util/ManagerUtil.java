package org.webappshowcase.db.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ivo
 */
public class ManagerUtil {

  private static EntityManager em;
  private static EntityManagerFactory emf;
  private static ThreadLocal<EntityManager> threadLocal;

  static {
    emf = Persistence.createEntityManagerFactory("sample");
    threadLocal = new ThreadLocal<EntityManager>();
  }

  public static EntityManager getEntityManager() {
    initEntityManager();
    return em;
  }

  public static void close() {
    em.close();
    emf.close();
  }

  public static synchronized void initEntityManager() {
    em = threadLocal.get();
    if (em == null || !em.isOpen()) {
      em = emf.createEntityManager();
      threadLocal.set(em);
    }
  }

}
