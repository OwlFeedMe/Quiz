package com.crunchify.jsp.servlet;
 
import edu.co.sergio.mundo.dao.Obras_de_ArteDAO;
import edu.co.sergio.mundo.vo.Obra_de_Arte;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
 
/**
 * @author Crunchify.com
 */
 
public class HelloCrunchify extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("Descripcon");
        String estilo = request.getParameter("estilo");
        int valor = Integer.valueOf(request.getParameter("valor"));

        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        Obras_de_ArteDAO c=new Obras_de_ArteDAO();
        
        Obra_de_Arte ob = new Obra_de_Arte(nombre, descripcion, estilo, 0);
        c.insert(ob);
        
        
        //Listando la informacion  
//        List<Departamento> departamentos =  dao.findAll();
//        request.setAttribute("departamentos", departamentos);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        }
}
