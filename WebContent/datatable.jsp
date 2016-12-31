﻿<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta charset="utf-8"/>
    <title>Movie Data</title>
    <meta name="description"
          content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="css/app.v2.css" type="text/css"/>
    <link rel="stylesheet" href="js/datatables/datatables.css" type="text/css" cache="false">
    <link rel="stylesheet" href="css/clocks.css" type="text/css">
    <script src="js/clock/clock.js"></script>
    <script src="js/jquery-1.9.1.min.js"></script>
</head>
<body>
<section class="vbox">
    <header class="bg-dark dk header navbar navbar-fixed-top-xs">
        <div class="navbar-header aside-md"><a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen"
                                               data-target="#nav"> <i class="fa fa-bars"></i> </a> <a href="#"
                                                                                                      class="navbar-brand"
                                                                                                      data-toggle="fullscreen"><img
                src="images/logo.png" class="m-r-sm">Movie Data</a> <a class="btn btn-link visible-xs"
                                                                       data-toggle="dropdown" data-target=".nav-user">
            <i
                    class="fa fa-cog"></i> </a></div>
    </header>
    <section>
        <section class="hbox stretch">
            <!-- .aside -->
            <aside class="bg-light lter b-r aside-md hidden-print" id="nav">
                <section class="vbox">
                    <section class="w-f scrollable">
                        <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0"
                             data-size="5px" data-color="#333333">
                            <!-- nav -->
                            <nav class="nav-primary hidden-xs">
                                <ul class="nav">
                                    <li>
                                        <a href="index.jsp">
                                            <i class="fa fa-dashboard icon"> <b class="bg-danger"></b> </i>
                                            <span>Home</span> </a>
                                    </li>
                                    <li class="active">
                                        <a href="datatable.jsp" class="active">
                                            <i class="fa fa-flask icon"> <b class="bg-success"></b> </i>
                                            <span>DataTable</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                            <!-- / nav -->
                        </div>
                    </section>
                    <footer class="footer lt hidden-xs b-t b-light">
                        <a href="#nav" data-toggle="class:nav-xs" class="pull-right btn btn-sm btn-default btn-icon"> <i
                                class="fa fa-angle-left text"></i> <i class="fa fa-angle-right text-active"></i> </a>
                    </footer>
                </section>
            </aside>
            <!-- /.aside -->
            <section id="content">
                <section class="vbox">
                    <section class="scrollable padder">
                        <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
                            <li><a href="index.html"><i class="fa fa-home"></i> Home</a></li>
                            <li class="active">Datatable</li>
                        </ul>
                        <div class="m-b-md">
                            <h3 class="m-b-none">Time Compare</h3>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <section class="panel panel-default">
                                    <header class="panel-heading">DataWareHouse</header>
                                    <%
                                    long timeMysql = (long)request.getAttribute("timeMysql");
                                    long timeHive = (long)request.getAttribute("timeHive");
                                    int temp1 = (int)(timeMysql / 1000);
                                    int a = temp1 / 1000;
                                    int b = temp1 % 1000;
                                    int temp2 = (int)(timeHive / 1000);
                                    int c = temp2 / 1000;
                                    int d = temp2 % 1000;

                                    %>
                                    <script>clock(<%=a%>, <%=b%>, <%=c%>, <%=d%>)</script>
                                    <table class="table table-striped m-b-none text-sm">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <div class="clock" id="dwclock">
                                                    <ul>
                                                        <li id="sec1"></li>
                                                        <li id="point1"></li>
                                                        <li id="msec1"></li>
                                                        <li id="unit1"></li>
                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </section>
                            </div>
                            <div class="col-sm-6">
                                <section class="panel panel-default">
                                    <header class="panel-heading">Hive</header>
                                    <table class="table table-striped m-b-none text-sm">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <div class="clock" id="hiveclock">
                                                    <ul>
                                                        <li id="sec2"></li>
                                                        <li id="point2"></li>
                                                        <li id="msec2"></li>
                                                        <li id="unit2"></li>
                                                    </ul>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </section>
                            </div>
                        </div>

                        <div class="m-b-md">
                            <h3 class="m-b-none">Datatable</h3>
                        </div>
                        <section class="panel panel-default">
                            <header class="panel-heading"> DataTables <i class="fa fa-info-sign text-muted"
                                                                         data-toggle="tooltip" data-placement="bottom"
                                                                         data-title="ajax to load the data."></i>
                            </header>
                            <div class="table-responsive">
                                <table class="table table-striped m-b-none" data-ride="datatables" id="datatable">
                                    <thead>
                                    <tr>
                                        <th width="20%">Product Id</th>
                                        <th width="30%">Movie Name</th>
                                        <th width="20%">Posted Time</th>
                                        <th width="30%">Version</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </section>
                    </section>
                </section>
                <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a>
            </section>
            <aside class="bg-light lter b-l aside-md hide" id="notes">
                <div class="wrapper">Notification</div>
            </aside>
        </section>
    </section>
</section>
<script src="js/app.v2.js"></script> <!-- Bootstrap --> <!-- App --> <!-- datatables -->
<script src="js/datatables/jquery.dataTables.min.js" cache="false"></script>
<!--[if lt IE 9]-->
<script src="js/ie/html5shiv.js" cache="false"></script>
<script src="js/ie/respond.min.js" cache="false"></script>
<script src="js/ie/excanvas.js" cache="false"></script> <!--[endif]-->
</body>
</html>