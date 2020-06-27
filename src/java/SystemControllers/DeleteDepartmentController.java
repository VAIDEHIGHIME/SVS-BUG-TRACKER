
package SystemControllers;

import DAO.DeleteDepartmentDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteDepartmentController extends HttpServlet
{  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException 
    {
       response.setContentType("text/html;charset=UTF-8");
       
        try (PrintWriter out = response.getWriter())
        {
        
            
            String Mang_ID = request.getParameter("Mang_ID");
            String Dept_ID = request.getParameter("Dept_ID");
            
            DeleteDepartmentDao dao=new DeleteDepartmentDao();
            
            try
            {
                
                if(dao.check( Mang_ID,Dept_ID))
                {
                    System.out.print("returned true");
                    response.sendRedirect("ManagerDashboard.jsp");
                }
                else
                {
                    System.out.print("in else");
                    response.sendRedirect("error.jsp");
                    
                }  
            }
            catch(IOException ex)
            {
                out.println("Exception:"+ex);
                
            }
            
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    { 
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    { 
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public String getServletInfo()
    {
        return "DeleteProjectController Servlet";
    }
    
}