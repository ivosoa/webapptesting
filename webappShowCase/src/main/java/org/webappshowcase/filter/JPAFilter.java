package org.webappshowcase.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.webappshowcase.db.dao.util.ManagerUtil;

/**
 *
 * @author Ivo
 */
@WebFilter(filterName = "JPAFilter", urlPatterns = {"/*"})
public class JPAFilter implements Filter {
  
  public JPAFilter() {
  }  
  
  /**
   *
   * @param request The servlet request we are processing
   * @param response The servlet response we are creating
   * @param chain The filter chain we are processing
   *
   * @exception IOException if an input/output error occurs
   * @exception ServletException if a servlet error occurs
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {
    
    try {
      chain.doFilter(request, response);
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
  /**
   * Destroy method for this filter
   */
  @Override
  public void destroy() {    
    ManagerUtil.close();
  }

  /**
   * Init method for this filter
   * @param filterConfig
   */
  @Override
  public void init(FilterConfig filterConfig) {    
    ManagerUtil.initEntityManager();
  }
}
