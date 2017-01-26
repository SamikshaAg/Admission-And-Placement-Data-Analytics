<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>College Portal</title>

<link href="style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/coda-slider.css" type="text/css" media="screen" charset="utf-8" />

<script src="js/jquery-1.2.6.js" type="text/javascript"></script>
<script src="js/jquery.scrollTo-1.3.3.js" type="text/javascript"></script>
<script src="js/jquery.localscroll-1.2.5.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.serialScroll-1.2.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/coda-slider.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript" charset="utf-8"></script>


</head>
<body bgcolor="#2B4F6C" >

	<div id="slider" >
    <div id="sidebar">
    	<div id="header">
        	<img src="images/knit_logo.png" />
        </div> <!-- end of header -->
        
        <ul class="navigation">
            <li><a href="#home">Home<span class="ui_icon home"></span></a></li>
            <li><a href="#aboutus">About Us<span class="ui_icon aboutus"></span></a></li>
            <li><a href="#services">Services<span class="ui_icon services"></span></a></li>
            <li><a href="#gallery">Gallery<span class="ui_icon gallery"></span></a></li>
            <li><a href="#search">Search<span class="ui_icon search"></span></a></li>
        </ul>
    </div> <!-- end of sidebar -->

	<div id="main">
    	<ul id="social_box">
            <li><a href="http://www.ieindia.org"><img src="images/one.jpg" alt="IEI" /></a></li>
           <li><a href="http://www.isteonline.in"><img src="images/two.png" alt="ISTE" /></a></li>
            <li><a href="http://www.csi-india.org"><img src="images/three.jpg" alt="CSI" /></a></li>
            <li><a href="http://www.electrum.org"><img src="images/four.png" alt="Electrum" /></a></li>
            <li><a href="http://www.anubhuti.co.in"><img src="images/anu.jpg" alt="Anubhuti" /></a></li>   			
 			
        </ul>
        
        <div id="content">
        
        <!-- scroll -->
        
        	
            <div class="scroll">
                <div class="scrollContainer">
                
                    <div class="panel" id="home">
                        <h1>Introducing KNITians</h1>    
                        <div class="image_wrapper image_fl"><img src="images/Harvard.jpg" alt="image" /></div>
                        <p>KAMLA NEHRU INSTITUTE OF TECHNOLOGY (KNIT) SULTANPUR, was established by Govt. of Uttar Pradesh as a registered society in 1979 with a mission to advanced knowledge and educate students in Engineering & Technology and other areas of scholarship that will best serve the region and the nation. Initially institute was named as Kamla Nehru Institute of Science & Technology (Technological faculty) which was changed to KAMLA NEHRU INSTITUTE OF TECHNOLOGY, SULTANPUR in 1983.</p>
                    
                        
                       
                        <div class="btn_more"><a href="#aboutus">More <span>&raquo;</span></a></div>
                    </div> <!-- end of home -->
                    
                    <div class="panel" id="aboutus">
                        <h1>About Us</h1>
                    	

                    </div>
                    
                    <div class="panel" id="services">
                        <h1>Our Services</h1>
                		
                        <ul class="service_list">
                           
                            <li><a href="#admsnrcrds" class="service_one">Admission Records</a></li>
                         
                           
                            <li><a href="#branch" class="service_two">Branch Performance</a></li>
                            <li><a href="#base" class="service_three">Base Line Calculation</a></li>
                            <li><a href="#top_perform" class="service_four">Top Performer/<a href="#top_comp">company</a></li> 
                            
                        </ul>
                    </div>
                    
                     <div class="panel" id="admsnrcrds">
                        <h1>Admission Records</h1>
                		
                        <ul class="admsn_list">
                            <li><a href="Admission?id=2012" class="ar_one">2012</a></li>
                         
                           
                            <li><a href="Admission?id=2013" class="ar_two">2013</a></li>
                            <li><a href="Admission?id=2014" class="ar_three">2014</a></li>
                           
                        </ul>
                    </div>
                    
                     <div class="panel" id="branch">
                        <h1>Branch Performance</h1>
                		
                        <ul class="branch_list">
                           
                            <li><a href="BranchPerformance?id=2016" class="b_one">2016</a></li>
                         
                           
                            <li><a href="BranchPerformance?id=2017" class="b_two">2017</a></li>
                            <li><a href="BranchPerformance?id=2018" class="b_three">2018</a></li>
                            
                        </ul>
                    </div>
                    
                     <div class="panel" id="base">
                        <h1>Base Line Calculation</h1>
                		
                        <ul class="base_list">
                           
                            <li><a href="BaselineCal?id=2016" class="bp_one">2016</a></li>
                            <li><a href="BaselineCal?id=2017" class="bp_two">2017</a></li>
                            <li><a href="BaselineCal?id=2018" class="bp_three">2018</a></li>
                           
                        </ul>
                    </div>
                
                     <div class="panel" id="top_perform">
                        <h1>Top Performer</h1>
                        <ul class="topp_list">
                            <li><a href="Performer?id=2016" class="tp_one">2016</a></li>
                            <li><a href="Performer?id=2017" class="tp_two">2017</a></li>
                            <li><a href="Performer?id=2018" class="tp_three">2018</a></li>
                        </ul>
					</div>
					
						<div class="panel" id="top_comp">
                      <h1>Top Company</h1>
                        <ul class="topc_list">
                            <li><a href="T_Company?id=2016" class="tp_four">2016</a></li>
                            <li><a href="T_Company?id=2017" class="tp_five">2017</a></li>
                            <li><a href="T_Company?id=2018" class="tp_six">2018</a></li>
                        </ul>  
                    </div>
                
                    <div class="panel" id="gallery">
                        <h1>Our Gallery</h1>
                        
                        <div id="gallery_container">
                           	<div class="gallery_box">
                                <img src="images/gallery/civil.jpg" alt="01" />
                                <h4>Civil Engineering</h4>
                                
                                 <div class="btn_more"><h3>Head: Dr. N.K. Saxena </h3></div>
                                <div class="cleaner"></div>
                            </div>
                            <div class="gallery_box">
                                <img src="images/gallery/cs.jpg" alt="02" />
                                <h4>Computer Science And Engineering</h4>
                                
                                 <div class="btn_more"><h3>Head: Dr. A.K Malviya </h3></div>
                                <div class="cleaner"></div>                      
                            </div>
                            <div class="gallery_box">
                                <img src="images/gallery/ee.jpg" alt="03" />
                                <h4>Electrical Engineering</h4>
                                
                                 <div class="btn_more"><h3>Head: Dr. R.K. Singh </h3></div>
                                <div class="cleaner"></div>     
                            </div>
                            <div class="gallery_box">
                                <img src="images/gallery/el.jpg" alt="04" />
                                <h4>Electronics Engineering</h4>

                                 <div class="btn_more"><h3>Head: Dr. Awdhesh Kumar </h3></div>
                                <div class="cleaner"></div>             
                            </div>
                            <div class="gallery_box">
                                <img src="images/gallery/me.jpg" alt="05" />
                                <h4>Mechanical Engineering</h4>
                               
                                 <div class="btn_more"><h3>Head: Dr. H.D Ram</h3></div>
                                <div class="cleaner"></div>          
                            </div>
                            <div class="gallery_box">
                                <img src="images/gallery/it.jpg" alt="06" />
                                <h4>Information Technology</h4>

                                 <div class="btn_more"><h3>Head: Dr. A.K Malviya </h3</div>
                                <div class="cleaner"></div>          
                            </div>
                            <div class="cleaner"></div>
                        </div>
                
                    </div>
                
                    <div class="panel" id="search">
                        <h1>SEARCH</h1>
                             <form action="Searching">
							 <input type="text" name="search_name" size="30" />
							 <br></br>
							 <input type="submit" value="SEARCH" />
							 </form>
                    </div>
                
                </div>
			</div>
            
        <!-- end of scroll -->
        
        </div> <!-- end of content -->
        
        <div id="footer">

            Copyright © 2016 <a href="#">TCS Project</a> | <a href="#">Admission and Placement Analytics</a> by <a href="#">Suhani and Samiksha</a>
        
        </div> <!-- end of footer -->
    
    </div> <!-- end of main -->
</div>
</body>
</html>