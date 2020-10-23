
package com.mycompany.m1_sabrinatortelli;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sabrina
 */
public class servletM1 extends HttpServlet {
    
    protected void login (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Login lg = new Login();
        lg.setLogin(request.getParameter("login"));
        lg.setSenha(request.getParameter("senha"));
        String conectado = request.getParameter("conectado");
        
        if(lg.getLogin().equals("admin") && lg.getSenha().equals("123456")){
            if(conectado!=null){
                request.getSession().setAttribute("login", lg.getLogin());
                request.getSession().setAttribute("senha", lg.getSenha());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/restrito.jsp");
            dispatcher.forward(request, response);
        }else{
            request.getSession().setAttribute("msg", "Login ou senha incorretos!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }       
    }
    
    protected void logout (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String encerrar = request.getParameter("encerrar");
        Login lg = new Login();
        lg.setLogin(null);
        lg.setSenha(null);
        if(encerrar!=null){
        
            request.getSession().setAttribute("login", lg.getLogin());
            request.getSession().setAttribute("senha", lg.getSenha());
          
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        }      
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        switch(request.getParameter("m1")){

            case "1":login(request, response);break;

            case "2":logout(request, response);break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }




}
