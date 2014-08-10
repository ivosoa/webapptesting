/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
