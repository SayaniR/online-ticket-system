<%
    response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
    if (request.getSession().getAttribute("username") == null) {
        String errorMsg = "You are not logged in. Please login first!!";
        request.setAttribute("ErrorMsg", errorMsg);
        request.getRequestDispatcher("welcomePage.jsp").forward(request, response);
    }else if((Integer)request.getSession().getAttribute("roleid") != 1){
        String errormsg = "You are not logged in. Please login first!!";
        request.setAttribute("errormsg", errormsg);
        
        if(session!=null){  
        session.invalidate();
    }
        request.getRequestDispatcher("welcomePage.jsp").forward(request, response);
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Register </title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>

                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">NEW CSR/TECHNICIAN</h3></div>
                                    <div class="card-body">
                                        <form action="registeraction.action" method="post">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="userFullName" type="text" placeholder="Enter your first name" />
                                                        <label for="inputFirstName">Full Name</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <!--                                                        <input class="form-control" id="inputLastName" type="text" placeholder="Enter your last name" />
                                                                                                                <label for="inputLastName">Role Id</label>-->
                                                        <select class="form-select" aria-label="Role" name="roleId">
                                                            <option selected>Select Role Type</option>
                                                            <!--<option value="L1">L1</option>-->
                                                            <option value="2">CSR</option>
                                                            <option value="3">Technician</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" name="email" type="email" placeholder="name@example.com" />
                                                <label for="inputEmail">Email address</label>
                                            </div>
                                            <div class="form-floating mb-3">

                                                <input class="form-control" name="password" type="password" placeholder="Create a password" />
                                                <label for="inputPassword">Password</label>


                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><input type="submit" class="btn btn-primary btn-block" value="save"></div>
                                            </div>

                                            <div class="mt-4 mb-0">
                                                <center>
                                                <div class="d-grid"><a  href="adminDashboard.jsp">Go To Dashboard</a></div>
                                                </center>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center py-3">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>

                <div id="layoutAuthentication_footer">
                    <!--                <footer class="py-4 bg-light mt-auto">
                                        <div class="container-fluid px-4">
                                            <div class="d-flex align-items-center justify-content-between small">
                                                <div class="text-muted">Copyright &copy; Your Website 2021</div>
                                                <div>
                                                    <a href="#">Privacy Policy</a>
                                                    &middot;
                                                    <a href="#">Terms &amp; Conditions</a>
                                                </div>
                                            </div>
                                        </div>
                                    </footer>-->
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
            <script src="js/scripts.js"></script>
    </body>
</html>
