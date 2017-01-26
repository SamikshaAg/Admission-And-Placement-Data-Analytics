import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleTypes;
public class T_Company extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         String year=request.getParameter("id").toString();
       int yr=Integer.parseInt(year);

        try {
                 Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","123");
       CallableStatement cstmt=c.prepareCall("{call top_company(?,?)}");
               cstmt.setInt(1,yr);
                cstmt.registerOutParameter(2,OracleTypes.CURSOR);
               cstmt.executeUpdate();
                 ResultSet rs=(ResultSet)cstmt.getObject(2);
                 
                   out.print("<html>");
        out.print(" <head>");
       out.println("<link rel='stylesheet' href='style2.css' type='text/css'>");
       out.print("</head><body>");
        out.print("<div id=\"t\">\n" +
"<div id=\"gallery_container\">\n" +
"<div class=\"gallery_box\">\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"right\" />\n" +
"<img src=\"images/TOP C.png\" alt=\"01\" align=\"right\" width=\"765px\" height=\"142px\"/>\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"left\" />\n" +
"<div class=\"cleaner\"></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</br></br>");            
      
                   out.print("<table align=center width=80% border=1><tr><th>Company Name</th><th>Average Package Offered</th></tr>");
                      
                    while(rs.next()) {
                        String query="select cname from company where cid="+rs.getInt(1);
                        Statement st=c.createStatement();
                        ResultSet rs1=(ResultSet)st.executeQuery(query);
                        while(rs1.next())
                        {
                            out.print("<tr><td align=center>"+rs1.getString(1)+"</td>");
                        }
                            out.print("<td align=center>"+rs.getFloat(2)+"</td></tr>");
                           
                    }  
                   out.print("</table>");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
finally {
            out.close();
        }
    }
}
