
package com.mycompany.m1_sabrinatortelli;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sabrina
 */
public class FilterM1 implements Filter {
    
      public void init(FilterConfig config) throws ServletException {


      }
    
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpSession session = ((HttpServletRequest)request).getSession();
        Login login = (Login)session.getAttribute("login");
        Login senha = (Login)session.getAttribute("senha");
        if(login==null || senha==null){

            session.setAttribute("msg","Você não está logado no sistema!");

            ((HttpServletResponse)response).sendRedirect("../index.jsp");

        }else{

            chain.doFilter(request, response);

        } 
        
    }
    
    public void destroy() {


      }

   
}
