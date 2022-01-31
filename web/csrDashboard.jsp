<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" >Welcome <c:out value='${sessionScope.csrname}'/>
            </a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        
                        
                        <li><a class="dropdown-item" href="logoutCsr">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            
                            <a class="nav-link" href="csrDashboard.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Action
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        <a class="nav-link" href="issueRegister.jsp">New Ticket</a>
                                            <a class="nav-link" href="userDisplayUpdate.jsp">User Display</a>
                                        
                                    </a>
                                    
                                    
                                </nav>
                            </div>
                            
                        </div>
                    </div>
                    
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Hello CSR,</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">here are all the issues</li>
                        </ol>
                        <s:form action="logincsr" method="post">
                            <s:textfield label="Email" name="csrEmail" readonly="true"/>
                            <s:submit cssClass="button-register" value="View Tickets" />

                        </s:form>
                        <br>
                        <s:if test="true">
                            <table>
                                <thead>
                        <tr style="background-color: #E0E0E1;">
                            <th>Issue Id &nbsp; &nbsp; &nbsp;&nbsp;</th>
                            <th>Issue Type &nbsp;&nbsp; &nbsp;&nbsp;</th>
                            <th>Issue Description &nbsp;&nbsp; &nbsp;&nbsp;</th>
                            <th>Equipment Type &nbsp;&nbsp; &nbsp;&nbsp;</th>
                            <th>Ticket Level &nbsp;&nbsp; &nbsp;&nbsp;</th>
                            <th>Tech Email &nbsp;&nbsp; &nbsp;&nbsp;</th>
                            <th>Ticket Status &nbsp;&nbsp; &nbsp;&nbsp;</th>
                            <th>Date Caused &nbsp;&nbsp; &nbsp;&nbsp;</th>
                            <th>Tentative Date &nbsp;&nbsp; &nbsp;&nbsp;</th>
                            </tr>
                    </thead>
                            <s:iterator value="issueList">
                            <tr>
                        <td><s:property value="issueId" /></td>
                        <td><s:property value="issueType" /></td>
                        <td><s:property value="issueDescription" /></td>
                        <td><s:property value="equipmentType" /></td>
                        <td><s:property value="ticketLevel" /></td>
                        <td><s:property value="techEmail" /></td>
                        <td><s:property value="ticketStatus" /></td>
                        <td><s:property value="dateCaused" /></td>
                        <td><s:property value="tentativeDates" /></td>
                        
                        
                        </tr>
                    </s:iterator>
                            </table>
                        </s:if>
                        <s:else>
                <div style="color: red;">No Data Found.</div>
            </s:else>
                        </div>
                    </div>
                </main>
<!--                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted"></div>
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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>
