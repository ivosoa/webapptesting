package org.webappshowcase.db.dao;

import org.webappshowcase.db.dao.basic.BasicDaoImpl;
import org.webappshowcase.db.entities.User;

/**
 *
 * @author ivo
 */
public class UserDaoImpl extends BasicDaoImpl<User, Long> implements UserDao{

  public UserDaoImpl() {
    super(User.class);
  }
  
}
