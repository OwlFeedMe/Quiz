package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Obra_de_Arte;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Isabel-Fabian
 * @since 12/08/2015
 * @version 2
 * Clase que permite la gestion de la tabla Depto en la base de datos.
 * 
 * CREATE TABLE Depto(
 *     id_depto integer,
 *     nom_depto varchar(40),
 *     PRIMARY KEY(id_depto)
 * );
 */
 

public class Obras_de_ArteDAO implements IBaseDatos<Obra_de_Arte> {

    @Override
    public List<Obra_de_Arte> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Obra_de_Arte t) {
        boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(Obras_de_ArteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into Obra_de_Arte (Nombre,Descripcion,Estilo,Valor)"  + " values (?,?,?,?)";
        PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString (1, t.getNombre());
                        preparedStmt.setString (2, t.getDescripcion());
                        preparedStmt.setString (3, t.getEstilo());
			preparedStmt.setInt(4, t.getValor());
                        result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
   }

    @Override
    public boolean update(Obra_de_Arte t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Obra_de_Arte t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
//    public  List  Consulta1(){
//         List con1 =new LinkedList(); 
//         String query = "select nom_proy, count(*) as total from  proyecto left join recurso using (id_proyecto) group by nom_proy";
//         Connection connection = null;
//         try {
//                connection = Conexion.getConnection();
//            } catch (URISyntaxException ex) {
//                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//	    try {
//	    Statement st = connection.createStatement();
//	    ResultSet rs = st.executeQuery(query);
//	    String nom_proy ="";
//            int total =0;
//	    while (rs.next()){
//	      
//	        
//	         nom_proy = rs.getString("nom_proy");
//	         total = rs.getInt("total");
//	        
//	        con1.add(nom_proy);
//	        con1.add(total);
//	    }
//	    st.close();
//	    
//	    } catch (SQLException e) {
//			System.out.println("Problemas al realizar la consulta ");
//			e.printStackTrace();
//		}
//	    
//        return con1;
//    }
//    
//   
//    
//    
//    
//    public  List Consulta2(){
//         List  con2 =new LinkedList(); 
//         String query = "select nom_depto,count(*) as Num from ((Depto natural join Proyecto) natural join DeptoProyecto )group by nom_depto";
//         Connection connection = null;
//         try {
//                connection = Conexion.getConnection();
//            } catch (URISyntaxException ex) {
//                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//	    try {
//	    Statement st = connection.createStatement();
//	    ResultSet rs = st.executeQuery(query);
//	     String nom_depto =" ";
//             int Num=0;
//	    while (rs.next()){
//	      
//	        
//	        nom_depto = rs.getString("nom_depto");
//	         Num = rs.getInt("Num");
//	        
//	        con2.add(nom_depto);
//	        con2.add(Num);
//	    }
//	    st.close();
//	    
//	    } catch (SQLException e) {
//			System.out.println("Problemas al realizar la consulta");
//			e.printStackTrace();
//		}
//	    
//                
//        return con2;
//    }
//    
//    public LinkedList<consulta3> consulta3(){
//       
//        LinkedList<consulta3> c3 = new LinkedList<consulta3>();
//        
//        String query = "select nom_depto, tipo_contrato, count(*) as total from Depto join Empleado using (id_depto) group by nom_depto, tipo_contrato having count(*)>1";
//        Connection connection = null;
//            try {
//                connection = Conexion.getConnection();
//            } catch (URISyntaxException ex) {
//                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//	    try {
//	    Statement st = connection.createStatement();
//	    ResultSet rs = st.executeQuery(query);
//	    String nom_dep = null;
//	    String tipodeco = null;
//	    int total=0;
//	    while (rs.next()){
//	    	
//	      
//	        
//	        nom_dep = rs.getString("nom_depto");
//	        
//	        
//	        tipodeco = rs.getString("tipo_contrato");
//	        
//                total=rs.getInt("total");
//                
//	        consulta3 registro= new consulta3(nom_dep, tipodeco, total);
//	      c3.add(registro);
//	    }
//	    st.close();
//	    
//	    } catch (SQLException e) {
//			System.out.println("Problemas al obtener la lista de Departamentos");
//			e.printStackTrace();
//		}
//	    
//	    return c3;
//    
//    
//    }
//    
//    
//	/**
//	 * Funcion que permite obtener una lista de los departamentos existentes en la base de datos
//	 * @return List<Departamento> Retorna la lista de Departamentos existentes en la base de datos
//	 */
//    
//	public List<Departamento> findAll() {
//		List<Departamento> departamentos= null;
//	    String query = "SELECT * FROM Depto";
//	    Connection connection = null;
//            try {
//                connection = Conexion.getConnection();
//            } catch (URISyntaxException ex) {
//                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//	    try {
//	    Statement st = connection.createStatement();
//	    ResultSet rs = st.executeQuery(query);
//	    int id =0;
//	    String nombre = null;
//	
//	    while (rs.next()){
//	    	if(departamentos == null){
//	    		departamentos= new ArrayList<Departamento>();
//	    	}
//	      
//	        Departamento registro= new Departamento();
//	        id = rs.getInt("id_depto");
//	        registro.setId_departamento(id);
//	        
//	        nombre = rs.getString("nom_depto");
//	        registro.setNom_departamento(nombre) ;
//	        
//	        departamentos.add(registro);
//	    }
//	    st.close();
//	    
//	    } catch (SQLException e) {
//			System.out.println("Problemas al obtener la lista de Departamentos");
//			e.printStackTrace();
//		}
//	    
//	    return departamentos;
//	}
//
//	
//	/**
//	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Departamento
//	 * @param Departamento recibe un objeto de tipo Departamento 
//	 * @return boolean retorna true si la operacion de insercion es exitosa.
//	 */
//	public boolean insert(Departamento t) {
//		boolean result=false;
//		Connection connection=null;
//            try {
//                connection = Conexion.getConnection();
//            } catch (URISyntaxException ex) {
//                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//	    String query = " insert into Depto (id_depto,nom_depto)"  + " values (?,?)";
//        PreparedStatement preparedStmt=null;
//	    try {
//			preparedStmt = connection.prepareStatement(query);
//			preparedStmt.setInt (1, t.getId_departamento());
//                        preparedStmt.setString (2, t.getNom_departamento());
//			result= preparedStmt.execute();
//	    } catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	/**
//	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Departamento
//	 * @param Departamento recibe un objeto de tipo Departamento 
//	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
//	 */
//	public boolean update(Departamento t) {
//		boolean result=false;
//		Connection connection= null;
//            try {
//                connection = Conexion.getConnection();
//            } catch (URISyntaxException ex) {
//                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//		String query = "update Depto set nom_depto = ? where id_depto = ?";
//		PreparedStatement preparedStmt=null;
//		try {
//		    preparedStmt = connection.prepareStatement(query);
//		    preparedStmt.setString(1, t.getNom_departamento());
//                    preparedStmt.setInt   (2, t.getId_departamento());
//		    if (preparedStmt.executeUpdate() > 0){
//		    	result=true;
//		    }
//			    
//		} catch (SQLException e) {
//				e.printStackTrace();
//		}
//			
//		return result;
//	}
//
//	/**
//	 * Funcion que permite realizar la eliminario de registro en la tabla Departamento
//	 * @param Departamento recibe un objeto de tipo Departamento 
//	 * @return boolean retorna true si la operacion de borrado es exitosa.
//	 */
//	public boolean delete(Departamento t) {
//	   boolean result=false;
//	   Connection connection = null;
//            try {
//                connection = Conexion.getConnection();
//            } catch (URISyntaxException ex) {
//                Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//	   String query = "delete from Depto where id_depto = ?";
//	   PreparedStatement preparedStmt=null;
//	   try {
//		     preparedStmt = connection.prepareStatement(query);
//		     preparedStmt.setInt(1, t.getId_departamento());
//		    result= preparedStmt.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	   
//	   return result;
//	}

    
}
