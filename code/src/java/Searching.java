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
public class Searching extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
//            out.print("<html>");
//        out.print(" <head><style>");
//          out.println("<link rel='stylesheet' href='style2.css' type='text/css'>");
//        out.print("</head><body>");
//        out.print("<div id=\"t\">\n" +
//"<div id=\"gallery_container\">\n" +
//"<div class=\"gallery_box\">\n" +
//"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"right\" />\n" +
//"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"left\" />\n" +
//"<div class=\"cleaner\"></div>\n" +
//"</div>\n" +
//"</div>\n" +
//"</div>\n" +
//"</br></br>");    
        
             Class.forName("oracle.jdbc.driver.OracleDriver");
              Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","123");
              CallableStatement cstmt=c.prepareCall("{call search(?,?,?)}");
              String s=request.getParameter("search_name");
              cstmt.setString(1,s);
              cstmt.registerOutParameter(2,OracleTypes.CURSOR);
              cstmt.registerOutParameter(3,OracleTypes.CURSOR);
              cstmt.executeUpdate();
                out.print("<html>");
        out.print(" <head>");
      
        
               
          out.println("<link rel='stylesheet' href='style2.css' type='text/css'>");
       
       out.print("</head><body>");
        out.print("<div id=\"t\">\n" +
"<div id=\"gallery_container\">\n" +
"<div class=\"gallery_box\">\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"right\" />\n" +
"<img src=\"images/SEAR.png\" alt=\"01\" align=\"right\" width=\"750px\" height=\"142px\"/>\n" +
"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"left\" />\n" +
"<div class=\"cleaner\"></div>\n" +
"</div>\n" +
"</div>\n" +
"</div>\n" +
"</br></br>");            
      
               ResultSet rs0=(ResultSet)cstmt.getObject(2);
                 ResultSet rs=(ResultSet)cstmt.getObject(3);
                 while(rs0.next())
                 {
                 int z=rs0.getInt(1);
                    CallableStatement stmt=c.prepareCall("{call searchc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                    stmt.setInt(1,z);
                    for(int i=2;i<=19;i++)
                    stmt.registerOutParameter(i,OracleTypes.NUMBER);
                    stmt.executeUpdate();
                    String b[]={"CE","CSE","EE","EL","ME","IT"};
                   out.print("<h1 align=center>2016</h1>");
                   out.print("<table align=center width=80% border=1><tr><th>Branch</th><th>Total students placed</th></tr>");
                    for(int i=1;i<=6;i++){   
                    out.print("<tr><td align=center>"+b[i-1]+"</td><td align=center>"+stmt.getInt(i+1)+"</td></tr>");}
                    out.print("</table>");
                    out.print("</br>");
                     out.print("<h1 align=center>2017</h1>");
                     out.print("<table align=center width=80% border=1><tr><th>Branch</th><th>Total students placed</th></tr>");
                    for(int i=1;i<=6;i++){   
                   out.print("<tr><td align=center>"+b[i-1]+"</td><td align=center> "+stmt.getInt(i+7)+"</td></tr>");}
                    out.print("</table>");
                      out.print("</br>");
                   out.print("<h1 align=center>2018</h1>");
                    out.print("<table align=center width=80% border=1><tr><th>Branch</th><th>Total students placed</th></tr>");
                    for(int i=1;i<=6;i++){   
                   out.print("<tr><td align=center>"+b[i-1]+"</td><td align=center> "+stmt.getInt(i+13)+"</td></tr>");}
                   out.print("</table>");
                 }
                 while(rs.next())
                 {
                     String query ="select id, package from placement where roll="+rs.getInt(1);
                     Statement st=c.createStatement();
                     ResultSet rs3=st.executeQuery(query);
                     for(int i=1;i<=1;i++){
                         out.print("Name:"+rs.getString(2)+"<br>");
                         out.print("Branch:"+rs.getString(3)+"<br>");
                         out.print("Year:"+rs.getInt(4)+"<br>");
                         out.print("Father's Name:"+rs.getString(5)+"<br>");
                         out.print("Address:"+rs.getString(6)+"<br>");
                         out.print("Mobile:"+rs.getString(7)+"<br>");
                         out.print("Email:"+rs.getString(8)+"<br>");
                     i++;}
                     while(rs3.next()){
                         String q="select cname from company where cid="+rs3.getInt(1);
                         Statement stt=c.createStatement();
                         ResultSet rs4=stt.executeQuery(q);
                         while(rs4.next()){out.print("Company:"+rs4.getString(1)+"  ");}
                          out.print("Package:" +rs3.getFloat(2)+" <br>");
                     }
                 }
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