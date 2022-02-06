<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    if (request.getSession().getAttribute("username") == null) {
        String errorMsg = "You are not logged in. Please login first!!";
        request.setAttribute("ErrorMsg", errorMsg);
        request.getRequestDispatcher("welcomePage.jsp").forward(request, response);
    } else if ((Integer) request.getSession().getAttribute("roleid") != 2) {
        String errormsg = "You are not logged in. Please login first!!";
        request.setAttribute("errormsg", errormsg);

        if (session != null) {
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
        <title>Register - New Tickets</title>
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
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">New Tickets</h3></div>
                                    <div class="card-body">
                                        <form action="ticketraise.action" method="post">
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3">
                                                        <select class="form-select" aria-label="Equipment Type" name="equipmentType">
                                                            <option selected>Select Equipment Type</option>
                                                            <option value="Laptop">Laptop</option>
                                                            <option value="Desktop">Desktop</option>
                                                            <option value="Mobile">Mobile</option>
                                                            <option value="Tablet">Tablet</option>
                                                            <option value="Others">Others</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <!--<div class="row mb-3">-->
                                                
                                                <!--</div>-->
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <select class="form-select" aria-label="Assigned To" name="assignedTo">
                                                            <option selected>Select Technician Name</option>
                                                            <s:iterator value="techList">
                                                                <option value="<s:property value="userId"/>"><s:property value="userFullName"/></option>
                                                            </s:iterator>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="mt-4 mb-0">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" name="description" type="text" placeholder="Enter Issue description" />
                                                        <label for="Description" >Description</label>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><input type="submit" class="btn btn-primary btn-block" value="save"></div>
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <center>
                                                    <div class="d-grid"><a href="csrDashboard.jsp">Go To Dashboard</a></div>
                                                </center>
                                            </div>


                                        </form>
                                    </div>
                                </div>
                                <div class="card-footer text-center py-3">

                                </div>
                            </div>
                        </div>

                </main>
            </div>
        </div>
        <div id="layoutAuthentication_footer">
            <footer class="py-4 bg-light mt-auto">
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
            </footer>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
</body>
</html>
