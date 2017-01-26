import java.awt.BasicStroke;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
public class BranchPerformance extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String branch[]={"CE","CSE","EE","EL","ME","IT"}; 
       String year=request.getParameter("id").toString();
       int yr=Integer.parseInt(year);
       response.setContentType("text/html;charset=UTF-8");
      // PrintWriter out=response.getWriter();
       OutputStream out=response.getOutputStream();
        try {
           Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cc=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","123");
        CallableStatement cstmt=cc.prepareCall("{call brnchprfm(?,?,?,?,?,?,?)}");
    DefaultPieDataset dataset=new DefaultPieDataset();
//     out.("<html>");
//        out.print(" <head>");
// out.print("<link rel='stylesheet' href='style2.css' type='text/css'>");
//               out.print("</head><body>");
//        out.print("<div id=\"t\">\n" +
//"<div id=\"gallery_container\">\n" +
//"<div class=\"gallery_box\">\n" +
//"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"right\" />\n" +
//"<img src=\"images/TOP.png\" alt=\"01\" align=\"right\" width=\"750px\" height=\"142px\"/>\n" +
//"<img src=\"images/knit_logo.png\" alt=\"01\" align=\"left\" />\n" +
//"<div class=\"cleaner\"></div>\n" +
//"</div>\n" +
//"</div>\n" +
//"</div>\n" +
//"</br></br>");      
  
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
       for(int i=2;i<=7;i++)
        {
         a[i]=cstmt.getFloat(i);
       
        dataset.setValue(v[i],a[i]);
        } 
            response.setContentType("image/png");

        JFreeChart chart=ChartFactory.createPieChart("Branch Performance", dataset, true, true, true);
        chart.setBorderPaint(Color.BLUE);
        chart.setBorderStroke(new BasicStroke(10.0f));
          chart.setBorderVisible(true); 
          int height=500;
          int width=350;
         ChartUtilities.writeChartAsPNG(out, chart, height, width);

        }
    catch(Exception e)
   {
      
   }
       finally {
      out.close();
     }
    }
    
}