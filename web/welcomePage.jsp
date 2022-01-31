<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%><!doctype html>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

        <title>Welcome</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/cover/">

        <!-- Bootstrap core CSS -->
        <link href="./css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="./css/cover.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js%22">

        </script>
        <script>
            function dropdownFunction() {
                document.getElementById("myDropdown").classList.toggle("show");
            }

            // Close the dropdown menu if the user clicks outside of it
            window.onclick = function (event) {
                if (!event.target.matches('.dropbtn')) {
                    var dropdowns = document.getElementsByClassName("dropdown-content");
                    var i;
                    for (i = 0; i < dropdowns.length; i++) {
                        var openDropdown = dropdowns[i];
                        if (openDropdown.classList.contains('show')) {
                            openDropdown.classList.remove('show');
                        }
                    }
                }
            }
            function downFunction() {
                document.getElementById("Dropdown").classList.toggle("show");
            }

            // Close the dropdown menu if the user clicks outside of it
            window.onclick = function (event) {
                if (!event.target.matches('.dropbtn')) {
                    var dropdowns = document.getElementsByClassName("dropdown-content");
                    var i;
                    for (i = 0; i < dropdowns.length; i++) {
                        var openDropdown = dropdowns[i];
                        if (openDropdown.classList.contains('show')) {
                            openDropdown.classList.remove('show');
                        }
                    }
                }
            }
            
        </script>
    </head>

    <body class="text-center bg">


        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto">
                <div class="inner">
                    <h3 class="masthead-brand">Ticketing System</h3>
                    <nav class="nav nav-masthead justify-content-center">
                        <div class="dropdown">
                            <button onclick="dropdownFunction()" class="dropbtn nav-link active">Login</button>
                            <div id="myDropdown" class="dropdown-content">
                                <a href="adminLogin.jsp">Admin</a>
                                <a href="csrLogin.jsp">CSR</a>
                                <a href="techLogin.jsp">Technician</a>
                            </div>
                        </div>

                        <div class="dropdown">
                            <button onclick="downFunction()" class="dropbtn nav-link active">Contact</button>
                            <div id="Dropdown" class="dropdown-content" >
                                <a>exavalu@gmail.com</a>
                                <a>1800 349 249</a>

                            </div>
                        </div>
                    </nav>
                </div>
            </header>

            <main role="main" class="inner cover">
                <h1 class="cover-heading">We're there to help</h1>
                <p class="lead">Specifically designed to provide assistance when it is needed.<br> With our
                    highly trained and dedicated agents, you can be assured solutions are only a phone call or email away </p>
                <hr style="color: transparent">
                <form action="userDisplay.jsp" method="post">
                                <td>
                                    <form action="" method="post">
                                        <p class="lead">
                                            
                                            <button type="submit"  class="btn btn-lg btn-secondary">Track Your Ticket</button>
                                        </p>
                                    </form>
                                </td>
                                </form>
                <center>
                                               
                </center>
            </main>

            <footer class="mastfoot mt-auto">
                <div class="inner">
                    <!--<p>Cover template for <a href="https://getbootstrap.com/">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>-->
                </div>
            </footer>
        </div>


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
        <script src="../../assets/js/vendor/popper.min.js"></script>
        <script src="../../dist/js/bootstrap.min.js"></script>
    </body>
</html>
