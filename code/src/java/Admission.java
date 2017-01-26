import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Admission extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String year=request.getParameter("id").toString();
        int ag=Integer.parseInt(year);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cc=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","123");
        CallableStatement cstmt=cc.prepareCall("{call admission(?,?,?,?,?,?,?)}");
        cstmt.setInt(1,ag);
        cstmt.registerOutParameter(2,Types.INTEGER);
        cstmt.registerOutParameter(3,Types.INTEGER);
        cstmt.registerOutParameter(4,Types.INTEGER);
        cstmt.registerOutParameter(5,Types.INTEGER);
        cstmt.registerOutParameter(6,Types.INTEGER);
        cstmt.registerOutParameter(7,Types.INTEGER);
        cstmt.executeUpdate();
        int a[]=new int[10];
        
       out.print("<html>");
        out.print(" <head>");
          out.println("<link rel='stylesheet' href='style2.css' type='text/css'>");
        out.print("</head><body>");
        out.print("<div id=\"t\">\n" +
"<div id=\"gallery_container\">\n" +
"<div class=\"gallery_box\">\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"right\" />\n" +
"<img src=\"images/admsn.png\" alt=\"01\" align=\"right\" width=\"765px\" height=\"142px\"/>\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"left\" />\n" +
"<div class=\"cleaner\"></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</br></br>");    
    String v[]={"0","0","CE","CSE","EE","EL","ME","IT"};
        out.println("<table align=center width=80% border=1><tr><th>Branch</th><th>No. of students admitted</th></tr> ");
        
        for(int i=2;i<=7;i++)
        {
         a[i]=cstmt.getInt(i);
         out.println("<tr><td align=center>"+v[i]+"</td><td align=center>"+a[i]+"</td></tr>");
        
        }    
        out.println("</table>");
        cstmt.close();
       cc.close();
       out.print("</html>");
    }
    catch(Exception e)
    {
        out.println(e);
    }
         finally {
            out.close();
        }
    }
}