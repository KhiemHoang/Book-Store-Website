<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    
<link rel="stylesheet" type="text/css" href="assets/css/setup.css">
<link rel="stylesheet" type="text/css" href="assets/css/register.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>


</head>
<body style="background-color:lightpink">
    <div class="navbar">


        <div class="search">
            <form>
                <input type="text" name="search" placeholder="Search...">
            </form>
        </div>

        <div>
            <ul>
                <li><a href="#abc">Help</a></li>
                <li><a href="#abc">Events</a></li>
                <li><a href="#abc">HELLO ABC</a></li>
                <li style="float:left"><a href="#abc" style="font-family:'Times New Roman'">My Book Store</a></li>
                <li style="float:left"><a href="#abc">Cart</a></li>
            </ul>
        </div>


    </div>
    <div style="width:100%;height:48px"></div>

     <div class="bodypagecontainer">
           <div class="slgcontainer">
            <h2 style="color:white;font-family:Karla;padding:40px">
                REGISTRATION FORM
            </h2>
          </div>
          <div class="loginbox">
        <form action = "SignUpServlet" method = "POST">
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username" required>
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password" minlength="6"  required>
            <p>Email</p>
            <input type="text" name="email" placeholder="Enter Email" required>
            <p>Address</p>
            <input type="text" name="address" placeholder="Enter Address" required>

            <input type="submit" name="" value="Sign Up">
            <a href="#">Lost your password?</a><br>
            <a href="login.jsp">Sign In</a>
        </form>
          </div>

    </div>











    <div class="footer whiteword">
        <hr style="position:absolute;color:white;width:100%;height:1px; border: 0 none;background-color: white">        
        <p class="subcribetext">
                Subcribe to pewdiepie's lastest news
        </p>
        <p class="chance">
                Don't Miss out.......................
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
            <a href="#ABC"> Introduction </a> <br>
            <a href="#ABC"> Recruitment  </a> <br> 
            <a href="#ABC"> Payment security policy  </a> <br>
            <a href="#ABC"> Information security policy </a> <br>
            <a href="#ABC"> Resolve complaints policy </a> <br>
            <a href="#ABC"> Terms of use </a> <br>
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