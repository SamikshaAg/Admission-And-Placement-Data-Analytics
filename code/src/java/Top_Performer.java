import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleTypes;

public class Top_Performer extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String year=request.getParameter("id").toString();
       int yr=Integer.parseInt(year);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             int count = 0;
            Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","123");
        CallableStatement cstmt=c.prepareCall("{call top_performer(?,?)}");
        cstmt.setInt(1,yr); 
         cstmt.registerOutParameter(2,OracleTypes.CURSOR);
               cstmt.executeUpdate();
                 out.print("<html>");
        out.print(" <head>");
 out.print("<link rel='stylesheet' href='style2.css' type='text/css'>");
               out.print("</head><body>");
        out.print("<div id=\"t\">\n" +
"<div id=\"gallery_container\">\n" +
"<div class=\"gallery_box\">\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"right\" />\n" +
"<img src=\"images/TOP.png\" alt=\"01\" align=\"right\" width=\"750px\" height=\"142px\"/>\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"left\" />\n" +
"<div class=\"cleaner\"></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</br></br>");            
      
               out.print("<table align=center width=80% border=1><tr><th>Name</th><th>Branch</th><th>Company</th><th>Package</th></tr> ");
                 ResultSet rs=(ResultSet)cstmt.getObject(2);
                 while(rs.next()){
                    if(count<=10)
                    {
                      String q1="select name, branch from student where rollno="+rs.getInt("roll");
                       String q2="select cname from company where cid="+rs.getInt("id");                     
                       Statement st=c.createStatement();
                       ResultSet rs1=(ResultSet)st.executeQuery(q1);
      
                         while(rs1.next())
                       {
                           out.print("<tr><td align=center>"+rs1.getString(1)+"</td><td align=center>"+rs1.getString(2)+"</td>");
                         
                        }
                        ResultSet rs2=(ResultSet)st.executeQuery(q2);
                       while(rs2.next())
                        {
                            out.print("<td align=center>"+rs2.getString(1)+"</td>");
                        }
                         out.print("<td align=center>"+rs.getFloat(3)+"</td></tr>");
                     
                            count++;}}
                 out.print("</table>");
        }
         catch(Exception e)
                {out.println(e);}   
        finally {
            out.close();
        }
    }

  

}
