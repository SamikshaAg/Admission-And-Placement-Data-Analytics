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
public class BaselineCal extends HttpServlet {
          @Override
          protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String year=request.getParameter("id").toString();
       int yr=Integer.parseInt(year);
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out=response.getWriter();
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cc=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","123");
        CallableStatement cstmt=cc.prepareCall("{call brnchprfm(?,?,?,?,?,?,?)}");
        cstmt.setInt(1,yr);       
        String v[]={"0","0","CE","CSE","EE","EL","ME","IT"};
        cstmt.registerOutParameter(2,Types.FLOAT);
        cstmt.registerOutParameter(3,Types.FLOAT);
        cstmt.registerOutParameter(4,Types.FLOAT);
        cstmt.registerOutParameter(5,Types.FLOAT);
        cstmt.registerOutParameter(6,Types.FLOAT);
        cstmt.registerOutParameter(7,Types.FLOAT);
        cstmt.executeUpdate();
        float a[]=new float[10];
        String r[]=new String[10];
        
        out.print("<html>");
        out.print(" <head>");
       out.println("<link rel='stylesheet' href='style2.css' type='text/css'>");
         out.print("</head><body>");
        out.print("<div id=\"t\">\n" +
"<div id=\"gallery_container\">\n" +
"<div class=\"gallery_box\">\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"right\" />\n" +
"<img src=\"images/BASE.png\" alt=\"01\" align=\"right\" width=\"765px\" height=\"142px\"/>\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"left\" />\n" +
"<div class=\"cleaner\"></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</br></br>");            
         out.println("<table align=center width=80% border=1><tr><th>Branch</th><th>Placement Percentage</th><th>Rating</th></tr> ");
       for(int i=2;i<=7;i++)
        {
         a[i]=cstmt.getFloat(i);
         a[i]=a[i]*100;
                 if(a[i]<20)
	        	 r[i]="Poor";

	         else if(a[i]<40)
	        	 r[i]="Below Average";
	         
	         else if(a[i]<60)
	        	 r[i]="Average";
	         
	         else if(a[i]<80)
	        	 r[i]="Good";
	         
	         else
	        	 r[i]="Excellent";
         
          out.println("<tr><td align=center>"+v[i]+"</td><td align=center>"+a[i]+"</td><td align=center>"+r[i]+"</td></tr>");

        } 
       out.println("</table>");
        cstmt.close();
       cc.close();  
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