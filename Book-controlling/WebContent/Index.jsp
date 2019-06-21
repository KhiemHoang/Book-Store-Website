<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, model.*, controller.*" %>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    
<link rel="stylesheet" type="text/css" href="assets/css/setup.css">
<link rel="stylesheet" type="text/css" href="assets/css/Style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<title>index.html</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" />
	<script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
	<!-- JS táº¡o nÃºt báº¥m di chuyá»n trang start -->
	<script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
	<!-- JS táº¡o nÃºt báº¥m di chuyá»n trang end -->
	<script type="text/javascript">
	$(function () {
		var pageSize = 6; // Hiá»n thá» 6 sáº£n pháº©m trÃªn 1 trang
		showPage = function(page) {
			$(".contentPage").hide();
			$(".contentPage").each(function(n) {
				if (n >= pageSize * (page - 1) && n < pageSize * page)
					$(this).show();
			});        
		}
		showPage(1);
		///** Cáº§n truyá»n giÃ¡ trá» vÃ o ÄÃ¢y **///
		var bla = $('#Totalrecord').html();
		var totalRows = 
			bla; 
		var btnPage = 4; 
		var iTotalPages = Math.ceil(totalRows / pageSize);

		var obj = $('#pagination').twbsPagination({
			totalPages: iTotalPages,
			visiblePages: btnPage,
			onPageClick: function (event, page) {
				/* console.info(page); */
				showPage(page);
			}
		});
			/*console.info(obj.data());*/
	});
	</script>
	
	<style>
	
		#pagination {
		display: flex;
		display: -webkit-flex; /* Safari 8 */
		flex-wrap: wrap;
		-webkit-flex-wrap: wrap; /* Safari 8 */
		justify-content: center;
		-webkit-justify-content: center;
		position:absolute;
		left:35%;
		bottom:10px;
		user-select: none;
		}
		
		
	
}
	
	</style>

</head>
<body style="background-color:#c6baba">

    <div class="navbar" style="position:fixed">

 <div class="search">
            <form action = "SearchNameServlet" method = "GET">
                <input type="text" name="name" placeholder="Search...">
            </form>
        </div>


        <div>
            <ul>
                <li><a href="#abc">Help</a></li>
                <li><a href="#abc">Events</a></li>
                <%
                	if(session.getAttribute("username") != null)
                	out.println("<li><a href=\"test?"+session.getAttribute("username")+"\">HELLO "+ session.getAttribute("username")+"</a></li>");

                %>
                <li style="float:left"><a href="#abc" style="font-family:'Times New Roman'">My Book Store</a></li>
                <%
            	if(session.getAttribute("username") != null)
            		System.out.println("<li style=\"float:left\"><a href=\"#abc\">Cart</a></li>");
                %>
                
            </ul>
        </div>





    </div>

    <div style="width:100%;height:48px"></div>
    <div class="adsbanner" style="left:1%">
        <h style="font-size:50px">ADS BANNER</h>
    </div>
    <div class="adsbanner" style="left:84%;background-color:red">
        <h style="font-size:50px">ADS BANNER</h>
    </div>

    <div class="bodypagecontainer">

        <div class="slgcontainer">
            <div class="Slg">
                <h1>
                    FIND YOURSELF IN A
                    <br />
                    GREAT BOOK
                </h1>
                <h2 style="color:white;font-family:Karla">
                   KNOWLEDGE IS 
                   <BR>
                   POWER
                </h2>
            </div>
        </div>

        <div class="slider">
            <a href="link1.php" target="_parent"><img class='photo' src="assets/image/1.png" alt="img1" /></a>

            <a href="link2.php" target="_parent"><img class='photo' src="assets/image/2.jpg" alt="img2" /></a>


            <a href="link3.php" target="_parent"><img class='photo' src="assets/image/3.jpg" alt="img3" /></a>


            <a href="link4.php" target="_parent"><img class='photo' src="assets/image/4.jpg" alt="img4" /></a>
        </div>
        <div style="height:220px"></div>
        <div class="category bordered">
        	<ul>
        	<%
        		List<String> type = (List<String>) request.getAttribute("booktypes");
        		for (int i = 0; i<type.size(); i++)
        			out.println("<li><a href =\"categoryservlet?type="+type.get(i)+"\">"+type.get(i)+"</a></li>	");
        	
        	
        	%>
        
        	</ul>

            
        </div>
        




	 <%
        
        
        List<Book> books = (List<Book>) request.getAttribute("booklist");
		int top = 0;
		int left = 21;
		int n = (int)request.getAttribute("numberofitem");
		int k = 1;
		out.println("<p hidden id=\"Totalrecord\">"+n+"</p>");
		String button = "<input type=\"submit\" name=\"button_clicked\" value=\"Button"+k+"\" />";
		String bar = "<div class=\"bar top \"></div><div class=\"bar right delay\"></div><div class=\"bar bottom delay\"></div><div class=\"bar left \"></div>";
		String box = "<div class=\"bookcontainer contentPage\" style=\"left:"+left+ "%\">"+bar+"</div>";
		

		int o = n/6; //chan
		int p = n%6; //le
		if (o<1)
		{
			if (p<=3)
			{
					for (int i =0;i<p;i++)				
				{
						String URL = books.get(i).getBookImg();
						String URLbox = 	"<a href=\"Book_Display_Servlet?name="+(String)books.get(i).getBookName()+"\"><div class=\"bookimagecontainer\" \"><img src=\""+URL+"\" style=\"height:100%;width:100%\">"+"</div></a>";
						String elements = bar+URLbox;
						String name = "<div style =\"text-align: center;\"class=\"namecontainer\"><p class=\"infofont\" style=\"font-size:17px\">"+ books.get(i).getBookName()+"</p><p class=\"infofont\">Price:"+books.get(i).getBookPrice() + "$</p></div>";
						elements = elements+name;
						box = "<div class=\"bookcontainer contentPage\" style=\"left:"+left+ "%\">"+elements+"</div>";
						out.println(box);
					
					left= left+23;
					k++;
				}
					
			}
			else if (p>3)
			{
				top =55;
				int temp = p - 3;
				for (int i =0;i<3;i++)				
				{
					String URL = books.get(i).getBookImg();
					String URLbox = 	"<a href=\"Book_Display_Servlet?name="+(String)books.get(i).getBookName()+"\"><div class=\"bookimagecontainer\" \"><img src=\""+URL+"\" style=\"height:100%;width:100%\">"+"</div></a>";
					String elements = bar+URLbox;
					String name = "<div style =\"text-align: center;\"class=\"namecontainer\"><p class=\"infofont\" style=\"font-size:17px\">"+ books.get(i).getBookName()+"</p><p class=\"infofont\">Price:"+books.get(i).getBookPrice() + "$</p></div>";
					elements = elements+name;
					box = "<div class=\"bookcontainer contentPage\" style=\"left:"+left+ "%\">"+elements+"</div>";
					out.println(box);
					left= left+23;
					k++;
					button = "<input type=\"submit\" name=\"button_clicked\" value=\"Button"+k+"\" />";
				}
				left = 21;
				for (int j =0;j<temp;j++)				
				{	
					String URL = books.get(k-1).getBookImg();
					String URLbox = 	"<a href=\"Book_Display_Servlet?name="+(String)books.get(k-1).getBookName()+"\"><div class=\"bookimagecontainer\" \"><img src=\""+URL+"\" style=\"height:100%;width:100%\">"+"</div></a>";
					String elements = bar+URLbox;
					String name = "<div style =\"text-align: center;\"class=\"namecontainer\"><p class=\"infofont\" style=\"font-size:17px\">"+ books.get(k-1).getBookName()+"</p><p class=\"infofont\">Price:"+books.get(k-1).getBookPrice() + "$</p></div>";
					elements = elements+name;
					box = "<div class=\"bookcontainer contentPage\" style=\"left:"+left+ "%;top:"+top+"%\">"+elements+"</div>";
					out.println(box);
					left= left+23;
					k++;
					button = "<input type=\"submit\" name=\"button_clicked\" value=\"Button"+k+"\" />";
				}
			}
		}
		else if (o>=1)
		{
			
			for(int i =0;i<o;i++)
			{
				left =21;
				for (int j =0;j<3;j++)				
				{
					String URL = books.get(k-1).getBookImg();
					String URLbox = 	"<a href=\"Book_Display_Servlet?name="+(String)books.get(k-1).getBookName()+"\"><div class=\"bookimagecontainer\" \"><img src=\""+URL+"\" style=\"height:100%;width:100%\">"+"</div></a>";
					String elements = bar+URLbox;
					String name = "<div style =\"text-align: center;\"class=\"namecontainer\"><p class=\"infofont\" style=\"font-size:17px\">"+ books.get(k-1).getBookName()+"</p><p class=\"infofont\">Price:"+books.get(k-1).getBookPrice() + "$</p></div>";
					elements = elements+name;
					box = "<div class=\"bookcontainer contentPage\" style=\"left:"+left+ "%\">"+elements+"</div>";
					out.println(box);
					left= left+23;
					k++;
					button = "<input type=\"submit\" name=\"button_clicked\" value=\"Button"+k+"\" />";
				}
				left = 21;
				top = 55;
				for (int j =0;j<3;j++)				
				{
					String URL = books.get(k-1).getBookImg();
					String URLbox = 	"<a href=\"Book_Display_Servlet?name="+(String)books.get(k-1).getBookName()+"\"><div class=\"bookimagecontainer\" \"><img src=\""+URL+"\" style=\"height:100%;width:100%\">"+"</div></a>";
					String elements = bar+URLbox;
					String name = "<div style =\"text-align: center;\"class=\"namecontainer\"><p class=\"infofont\" style=\"font-size:17px\">"+ books.get(k-1).getBookName()+"</p><p class=\"infofont\">Price:"+books.get(k-1).getBookPrice() + "$</p></div>";
					elements = elements+name;
					box = "<div class=\"bookcontainer contentPage\" style=\"left:"+left+ "%;top:"+top+"%\">"+elements+"</div>";
					out.println(box);		
					left= left+23;
					k++;
					button = "<input type=\"submit\" name=\"button_clicked\" value=\"Button"+k+"\" />";
				}
			}
			left = 21;
			top = 0;
			if (p<=3)
			{
					for (int i =0;i<p;i++)				
				{
						String URL = books.get(k-1).getBookImg();
						String URLbox = 	"<a href=\"Book_Display_Servlet?name="+(String)books.get(k-1).getBookName()+"\"><div class=\"bookimagecontainer\" \"><img src=\""+URL+"\" style=\"height:100%;width:100%\">"+"</div></a>";
					String elements = bar+URLbox;
					String name = "<div style =\"text-align: center;\"class=\"namecontainer\"><p class=\"infofont\" style=\"font-size:17px\">"+ books.get(k-1).getBookName()+"</p><p class=\"infofont\">Price:"+books.get(k-1).getBookPrice() + "$</p></div>";
					elements = elements+name;	
					box = "<div class=\"bookcontainer contentPage\" style=\"left:"+left+ "%\">"+elements+"</div>";
					out.println(box);
					left= left+23;
					k++;
				}
			}
			else if (p>3)
			{
				top =55;
				int temp = p - 3;
				for (int i =0;i<3;i++)				
				{
					String URL = books.get(k-1).getBookImg();
					String URLbox = 	"<a href=\"Book_Display_Servlet?name="+(String)books.get(k-1).getBookName()+"\"><div class=\"bookimagecontainer\" \"><img src=\""+URL+"\" style=\"height:100%;width:100%\">"+"</div></a>";
					String elements = bar+URLbox;
					String name = "<div style =\"text-align: center;\"class=\"namecontainer\"><p class=\"infofont\" style=\"font-size:17px\">"+ books.get(k-1).getBookName()+"</p><p class=\"infofont\">Price:"+books.get(k-1).getBookPrice() + "$</p></div>";
					elements = elements+name;
						
					box = "<div class=\"bookcontainer contentPage\" style=\"left:"+left+ "%\">"+elements+"</div>";
					out.println(box);
					left= left+23;
					k++;
				}
				left = 21;
				for (int j =0;j<temp;j++)				
				{
					String URL = books.get(k-1).getBookImg();
					String URLbox = 	"<a href=\"Book_Display_Servlet?name="+(String)books.get(k-1).getBookName()+"\"><div class=\"bookimagecontainer\" \"><img src=\""+URL+"\" style=\"height:100%;width:100%\">"+"</div></a>";
					String elements = bar+URLbox;
					String name = "<div style =\"text-align: center;\"class=\"namecontainer\"><p class=\"infofont\" style=\"font-size:17px\">"+ books.get(k-1).getBookName()+"</p><p class=\"infofont\">Price:"+books.get(k-1).getBookPrice() + "$</p></div>";
					elements = elements+name;
					box = "<div class=\"bookcontainer contentPage\" style=\"left:"+left+ "%;top:"+top+"%\">"+elements+"</div>";
					out.println(box);		
					left= left+23;
					k++;
				}
			}
			
		}
		
		%> 
        
        
        
        
        
        
        <div class="paginationcontainer">
		<%
		out.println("<ul id=\"pagination\"></ul>");
		%>
		</div>
	
        
        
        
        
        
        
        
        
        
                       
        
        
        
        
        




        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      
    </div>

    

    <div class="footer whiteword">
        <p class="subcribetext">
                Subcribe to pewdiepie's lastest news
        </p>
        <p class="chance">
                Don't Miss out our sale off season
        </p>



        <input  id="input-email-box" type="text" name="email" placeholder="Your Email">

        <button class="buttonsummit">Submit</button>




        <hr style="top:105px;position:absolute;color:white;width:100%;height:1px; border: 0 none;background-color: white">
        <p class="headerr" style="left:5%">
            CUSTOMER SERVICES
        </p>
        <p class="servicetext">
            <span style="color:red; font-size:20PX"> Hotlines order: 3004 - 1975 </span>
            <br>
            (Free, 6a.m-18:00,daily)
            <br> <br>

            <span style="color:red; font-size:20PX"> Hotlines order: 3004 - 1975 </span>
            <br>
            (Free, 6a.m-18:00,daily)
        </p>
        <p class="headerr" style="left:31%">
            ABOUT US
        </p>
        <p class="Abouttext">
             <a href="Introduction.html"> Introduction </a> <br>
            <a href="recruit.html"> Recruitment  </a> <br> 
            <a href="payment.html"> Payment security policy  </a> <br>
            <a href="security.html"> Information security policy </a> <br>
            <a href="complaints.html"> Resolve complaints policy </a> <br>
            <a href="termsofuse.html"> Terms of use </a> <br>
        </p>

        <p class="headerr" style="left:53%">
            PAYMENT METHODS
        </p>
        <div class="smallcontainer" style="left:53%;top:155px;">
            <i class="fab fa-cc-visa fa-4x "></i>
        </div>

        <div class="smallcontainer" style="left:61%;top:155px;">
            <i class="fab fa-cc-mastercard fa-4x"></i>    
          </div>
        
        <div class="smallcontainer" style="left:68.7%;top:155px;">
            <i class="far fa-credit-card fa-4x"  ></i>
        </div>

        <div class="smallcontainer" style="left:53%;top:230px;">
             <i class="far fa-money-bill-alt fa-4x" ></i>
        </div>
         <div class="smallcontainer" style="left:61.5%;top:230px;">
            <i class="fas fa-university fa-4x" ></i> 
          </div>
        
        <div class="smallcontainer" style="left:68.7%;top:230px;">
            <i class="fas fa-piggy-bank fa-4x"  ></i>
        </div>

         <p class="headerr" style="left:78%">
            CONTACT US
        </p>
        <div class="smallcontainer" style="left:78%;top:155px;">
            <i class="fab fa-facebook-square fa-4x"></i>
        </div>
        <div class="smallcontainer" style="left:84%;top:155px;">
            <i class="fab fa-youtube fa-4x"></i>
        </div>
        <div class="smallcontainer" style="left:91.2%;top:155px;">
            <i class="fab fa-instagram fa-4x"></i>
        </div>

         <p class="headerr" style="left:78%; top:250px ">
            AVAILABLE ON
        </p>
        <div class="smallcontainer" style="left:78%;top:285PX;">
            <i class="fab fa-google-play fa-4x"></i>
        </div>
         <div class="smallcontainer" style="left:85%;top:285PX;">
            <i class="fab fa-app-store-ios fa-4x"></i>
        </div>


    </div>






   

</body>
</html>