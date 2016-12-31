<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta charset="utf-8"/>
    <title>Movie Data</title>
    <meta name="description"
          content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="css/app.v2.css" type="text/css"/>
    <link rel="stylesheet" href="js/calendar/bootstrap_calendar.css" type="text/css"/>
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <link rel="stylesheet" href="js/fuelux/fuelux.css" type="text/css">
    <link rel="stylesheet" href="js/select2/select2.css" type="text/css" cache="false"/>
    <link rel="stylesheet" href="js/select2/theme.css" type="text/css" cache="false"/>
    <link rel="stylesheet" href="js/slider/slider.css" type="text/css" cache="false"/>
    <link rel="stylesheet" href="css/font-awesome.css" type="text/css">
    <!-- my js -->
    <script src="js/main.js"></script>
    <!-- echarts.js -->
    <script src="js/charts/echarts.js"></script>
    <script src="js/wordcloud.js"></script>

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
                                    <li class="active">
                                        <a href="index.jsp">
                                            <i class="fa fa-dashboard icon"> <b class="bg-danger"></b> </i>
                                            <span>Home</span> </a>
                                    </li>
                                    <li>
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
                            <li><a href="index.jsp"><i class="fa fa-home"></i> Home</a></li>
                            <li class="active">Home</li>
                        </ul>
                        <div class="row">
                            <!-- hot points -->
                            <div class="col-md-6">
                                <div class="m-b-md">
                                    <h3 class="m-b-none">Hot&nbsp;Points</h3>
                                    <small>there are hottest</small>
                                </div>
                                <div id="wordcloud" style="width: 600px;height:400px;"></div>
                                <script>wordscloud();</script>
                            </div>
                            <!-- news -->
                            <div class="col-md-6">
                                <div class="m-b-md">
                                    <h3 class="m-b-none">Newest</h3>
                                    <small>For your taste</small>
                                    <section class="panel-body">
                                        <article class="media">
                                            <div class="pull-left">
                                                <span class="fa-stack fa-lg">
                                                    <i class="fa fa-circle fa-stack-2x"></i>
                                                    <i class="fa fa-film fa-stack-1x text-white"></i>
                                                </span>
                                            </div>
                                            <div class="media-body">
                                                <a href="#" class="h4">Bootstrap 3: What you need to know</a>
                                                <small class="block m-t-xs">Sleek, intuitive, and powerful mobile-first
                                                    front-end framework for faster and easier web development.
                                                </small>
                                                <em class="text-xs">Posted on
                                                    <span class="text-danger">Feb 23, 2013</span>
                                                </em>
                                            </div>
                                        </article>
                                        <div class="line pull-in"></div>
                                        <article class="media">
                                            <div class="pull-left">
                                                <span class="fa-stack fa-lg">
                                                    <i class="fa fa-circle fa-stack-2x text-info"></i>
                                                    <i class="fa fa-film fa-stack-1x text-white"></i>
                                                </span>
                                            </div>
                                            <div class="media-body">
                                                <a href="#" class="h4">Bootstrap documents</a>
                                                <small class="block m-t-xs">There are a few easy ways to quickly get
                                                    started with Bootstrap, each one appealing to a different skill
                                                    level and use case. Read through to see what suits your particular
                                                    needs.
                                                </small>
                                                <em class="text-xs">Posted on
                                                    <span class="text-danger">Feb 12, 2013</span>
                                                </em>
                                            </div>
                                        </article>
                                        <div class="line pull-in"></div>
                                        <article class="media">
                                            <div class="pull-left">
                                                <span class="fa-stack fa-lg">
                                                    <i class="fa fa-circle fa-stack-2x icon-muted"></i>
                                                    <i class="fa fa-music fa-stack-1x text-white"></i>
                                                </span>
                                            </div>
                                            <div class="media-body"><a href="#" class="h4 text-success">Mobile first
                                                html/css framework</a>
                                                <small class="block m-t-xs">Bootstrap, Ratchet</small>
                                                <em class="text-xs">Posted on
                                                    <span class="text-danger">Feb 05, 2013</span>
                                                </em>
                                            </div>
                                        </article>
                                        <div class="line pull-in"></div>
                                        <article class="media">
                                            <div class="pull-left">
                                                <span class="fa-stack fa-lg">
                                                    <i class="fa fa-circle fa-stack-2x text-info"></i>
                                                    <i class="fa fa-film fa-stack-1x text-white"></i>
                                                </span>
                                            </div>
                                            <div class="media-body">
                                                <a href="#" class="h4">Bootstrap documents</a>
                                                <small class="block m-t-xs">There are a few easy ways to quickly get
                                                    started with Bootstrap, each one appealing to a different skill
                                                    level and use case. Read through to see what suits your particular
                                                    needs.
                                                </small>
                                                <em class="text-xs">Posted on
                                                    <span class="text-danger">Feb 12, 2013</span>
                                                </em>
                                            </div>
                                        </article>
                                    </section>
                                </div>
                            </div>
                        </div>
                        <!-- statistics bar -->
                        <section class="panel panel-default">
                            <div class="row m-l-none m-r-none bg-light lter">
                                <div class="col-sm-6 col-md-3 padder-v b-r b-light"><span
                                        class="fa-stack fa-2x pull-left m-r-sm"> <i
                                        class="fa fa-circle fa-stack-2x text-info"></i> <i
                                        class="fa fa-male fa-stack-1x text-white"></i> </span>
                                    <a class="clear" href="#">
                                        <span class="h3 block m-t-xs"><strong>52,000</strong></span>
                                        <small class="text-muted text-uc">All actors</small>
                                    </a>
                                </div>
                                <div class="col-sm-6 col-md-3 padder-v b-r b-light lt"><span
                                        class="fa-stack fa-2x pull-left m-r-sm"> <i
                                        class="fa fa-circle fa-stack-2x text-warning"></i> <i
                                        class="fa fa-film fa-stack-1x text-white"></i> </span>
                                    <a class="clear" href="#">
                                        <span class="h3 block m-t-xs"><strong id="bugs">468</strong></span>
                                        <small class="text-muted text-uc">All films</small>
                                    </a>
                                </div>
                                <div class="col-sm-6 col-md-3 padder-v b-r b-light"><span
                                        class="fa-stack fa-2x pull-left m-r-sm"> <i
                                        class="fa fa-circle fa-stack-2x text-info"></i> <i
                                        class="fa fa-camera fa-stack-1x text-white"></i> </span>
                                    <a class="clear" href="#">
                                        <span class="h3 block m-t-xs"><strong>52,000</strong></span>
                                        <small class="text-muted text-uc">All Director</small>
                                    </a>
                                </div>
                                <div class="col-sm-6 col-md-3 padder-v b-r b-light lt"><span
                                        class="fa-stack fa-2x pull-left m-r-sm"> <i
                                        class="fa fa-circle fa-stack-2x icon-muted"></i> <i
                                        class="fa fa-clock-o fa-stack-1x text-white"></i> </span>
                                    <a class="clear" href="#">
                                        <span class="h3 block m-t-xs"><strong>31:50</strong></span>
                                        <small class="text-muted text-uc">Time</small>
                                    </a></div>
                            </div>
                        </section>
                        <div class="m-b-md" style="margin-bottom: 20px">
                            <h3 class="m-b-none">Search</h3>
                            <small>find any you want</small>
                        </div>
                        <!-- search by name directly -->
                        <form class="form-horizontal" action="SearchMovies" method="post">
                            <div class="form-group" style="margin-bottom: 20px">
                                <label class="col-sm-2 control-label">Movie Name</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <input type="text" class="form-control" id="inputMoviename">
                                        <input type="hidden" value="{}" id="inputMain" name="inputJSON">
                                        <span class="input-group-btn">
                       	                    <button class="btn btn-primary" type="submit" onclick="submitJSON()">GO!!!!!</button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </form>

                        <!-- search by some range -->
                        <section class="panel panel-default">
                            <form class="form-horizontal" method="get">
                                <div class="wizard clearfix">
                                    <ul class="steps">
                                        <li data-target="#step1" class="active"><span class="badge badge-info">1</span>Time</li>
                                        <li data-target="#step2"><span class="badge">2</span>Type</li>
                                        <li data-target="#step3"><span class="badge">3</span>Artist</li>
                                    </ul>
                                    <div class="actions">
                                        <button type="button" class="btn btn-default btn-xs btn-prev"
                                                disabled="disabled">Prev
                                        </button>
                                        <button type="button" class="btn btn-default btn-xs btn-next"
                                                data-last="Finish">Next
                                        </button>
                                    </div>
                                </div>
                                <div class="step-content">
                                    <!-- time select -->
                                    <div class="step-pane active" id="step1">
                                        <section>
                                            <!-- by year -->
                                            <div class="form-group">
                                                <div class="col-sm-1 control-label">
                                                    <div class="checkbox">
                                                        <label class="checkbox-custom">
                                                            <input type="checkbox" name="checkboxA">
                                                            <i class="fa fa-fw fa-square-o"></i>
                                                        </label>
                                                    </div>
                                                </div>
                                                <label class="col-sm-1 control-label">Year</label>
                                                <div class="col-sm-10">
                                                    <input class="slider slider-horizontal form-control disabled"
                                                           type="text"
                                                           value="" data-slider-min="1970" data-slider-max="2016"
                                                           data-slider-step="1" data-slider-value="1970"
                                                           data-slider-orientation="horizontal" style="width: 600px">
                                                </div>
                                            </div>
                                            <div class="line line-dashed line-lg pull-in"></div>
                                            <!-- by month -->
                                            <div class="form-group">
                                                <div class="col-sm-1 control-label">
                                                    <div class="checkbox">
                                                        <label class="checkbox-custom">
                                                            <input type="checkbox" name="checkboxB">
                                                            <i class="fa fa-fw fa-square-o"></i>
                                                        </label>
                                                    </div>
                                                </div>
                                                <label class="col-sm-1 control-label">Month</label>
                                                <div class="col-sm-10">
                                                    <input class="slider slider-horizontal form-control" type="text"
                                                           value="" data-slider-min="1" data-slider-max="12"
                                                           data-slider-step="1" data-slider-value="1"
                                                           data-slider-orientation="horizontal" style="width: 300px">
                                                </div>
                                            </div>
                                            <div class="line line-dashed line-lg pull-in"></div>
                                            <!-- by day -->
                                            <div class="form-group">
                                                <div class="col-sm-1 control-label">
                                                    <div class="checkbox">
                                                        <label class="checkbox-custom">
                                                            <input type="checkbox" name="checkboxC">
                                                            <i class="fa fa-fw fa-square-o"></i>
                                                        </label>
                                                    </div>
                                                </div>
                                                <label class="col-sm-1 control-label">Day</label>
                                                <div class="col-sm-10">
                                                    <input class="slider slider-horizontal form-control" type="text"
                                                           value="" data-slider-min="1" data-slider-max="31"
                                                           data-slider-step="1" data-slider-value="1"
                                                           data-slider-orientation="horizontal" style="width: 500px">
                                                </div>
                                            </div>
                                            <div class="line line-dashed line-lg pull-in"></div>
                                            <!-- by weekday -->
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Weekday</label>
                                                <div class="col-sm-10">
                                                    <div class="m-b-sm">
                                                        <div class="btn-group" data-toggle="buttons">
                                                            <label class="btn btn-sm btn-info" name="weeks">Monday<input type="radio" name="options" id="week1"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-success" name="weeks">Tuesday<input type="radio" name="options" id="week2"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-primary" name="weeks">Wednesday<input type="radio" name="options" id="week3"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-warning" name="weeks">Thursday<input type="radio" name="options" id="week4"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-danger" name="weeks">Friday<input type="radio" name="options" id="week5"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-twitter" name="weeks">Saturday<input type="radio" name="options" id="week6"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-facebook" name="weeks">Sunday<input type="radio" name="options" id="week7"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-dark active" name="weeks">N/A<input type="radio" name="options" id="week8"><i class="fa fa-check text-active"></i></label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="line line-dashed line-lg pull-in"></div>
                                            <!-- by season -->
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Season</label>
                                                <div class="col-sm-10">
                                                    <div class="m-b-sm">
                                                        <div class="btn-group" data-toggle="buttons">
                                                            <label class="btn btn-sm btn-info" name="seasons">Spring<input type="radio" name="options" id="season1"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-success" name="seasons">Summer<input type="radio" name="options" id="season2"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-primary" name="seasons">Autumn<input type="radio" name="options" id="season3"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-facebook" name="seasons">Winter<input type="radio" name="options" id="season4"><i class="fa fa-check text-active"></i></label>
                                                            <label class="btn btn-sm btn-dark active" name="seasons">N/A<input type="radio" name="options" id="season5"><i class="fa fa-check text-active"></i></label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <footer class="panel-footer text-right bg-light lter">
                                                <!-- <button type="submit" class="btn btn-success btn-s-xs">Submit</button> -->
                                            </footer>
                                        </section>
                                    </div>
                                    <!-- type select -->
                                    <div class="step-pane" id="step2">
                                        <section>
                                            <div class="row">
                                                <!-- by type -->
                                                <div class="col-sm-7 portlet">
                                                    <div class="doc-buttons">
                                                        <a href="#"
                                                           class="btn btn-s-md btn-default btn-rounded portlet-item">Action</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-primary btn-rounded portlet-item">Adventure</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-success btn-rounded portlet-item">Comedy</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-info btn-rounded portlet-item">Documentary</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-warning btn-rounded portlet-item">Drama</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-danger btn-rounded portlet-item">Fantasy</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-dark btn-rounded portlet-item">Gay Lesbian</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-default btn-rounded portlet-item">Horror</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-primary btn-rounded portlet-item">International</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-success btn-rounded portlet-item">Kids Family</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-info btn-rounded portlet-item">Military War</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-warning btn-rounded portlet-item">Music</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-danger btn-rounded portlet-item">Musical</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-dark btn-rounded portlet-item">Mystery</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-default btn-rounded portlet-item">Reality Tv</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-primary btn-rounded portlet-item">Romance</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-success btn-rounded portlet-item">Science Fiction</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-info btn-rounded portlet-item">Sports</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-warning btn-rounded portlet-item">Thriller</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-danger btn-rounded portlet-item">Tv Show</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-dark btn-rounded portlet-item">Tv Talk Shows</a>
                                                        <a href="#"
                                                           class="btn btn-s-md btn-default btn-rounded portlet-item">Western</a>
                                                    </div>
                                                </div>
                                                <div class="col-sm-2" style="margin-top: 3%">
                                                    <p><i class="icon-random icon-5x"></i></p>
                                                    <h5 class="">Drop here</h5>
                                                </div>
                                                <div class="col-sm-2 visible-lg dropfile doc-buttons portlet"
                                                     style="height: 150px">
                                                </div>
                                            </div>
                                            <!--
                                            <footer class="panel-footer text-right bg-light lter">
                                                <button type="submit" class="btn btn-success btn-s-xs">Submit</button>
                                            </footer> -->
                                        </section>
                                    </div>
                                    <!-- artist select -->
                                    <div class="step-pane" id="step3">
                                        <!-- by director -->
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Director</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" data-type="name" id="inputDirector"
                                                       placeholder="Director">
                                            </div>
                                        </div>
                                        <div class="line line-dashed line-lg pull-in"></div>
                                        <!-- by star -->
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Star</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" data-type="name" id="inputStar"
                                                       placeholder="Star">
                                            </div>
                                        </div>
                                        <div class="line line-dashed line-lg pull-in"></div>
                                        <!-- by actor -->
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">Actor</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" data-type="name" id="inputActor"
                                                       placeholder="Actor">
                                            </div>
                                        </div>
                                        <footer class="panel-footer text-right bg-light lter">
                                            <!-- <button type="submit" class="btn btn-success btn-s-xs">Submit</button> -->
                                        </footer>
                                    </div>
                                </div>
                            </form>
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
<!--[if lt IE 9]-->
<script src="js/ie/html5shiv.js" cache="false"></script>
<script src="js/ie/respond.min.js" cache="false"></script>
<script src="js/ie/excanvas.js" cache="false"></script>
<!--[endif]-->
<script src="js/app.v2.js"></script>
<script src="js/fuelux/fuelux.js"></script>
<!-- Bootstrap --> <!-- App -->
<script src="js/charts/easypiechart/jquery.easy-pie-chart.js" cache="false"></script>
<script src="js/charts/sparkline/jquery.sparkline.min.js" cache="false"></script>
<script src="js/charts/flot/jquery.flot.min.js" cache="false"></script>
<script src="js/charts/flot/jquery.flot.tooltip.min.js" cache="false"></script>
<script src="js/charts/flot/jquery.flot.resize.js" cache="false"></script>
<script src="js/charts/flot/jquery.flot.grow.js" cache="false"></script>
<script src="js/charts/flot/demo.js" cache="false"></script>
<script src="js/calendar/bootstrap_calendar.js" cache="false"></script>
<script src="js/calendar/demo.js" cache="false"></script>
<script src="js/sortable/jquery.sortable.js" cache="false"></script>
<!-- slider -->
<script src="js/slider/bootstrap-slider.js" cache="false"></script>
<!-- combodate -->
<script src="js/libs/moment.min.js" cache="false"></script>
<script src="js/combodate/combodate.js" cache="false"></script>
<!-- touch -->
<script src="js/jquery.ui.touch-punch.min.js" cache="false"></script>
<script src="js/jquery-ui-1.10.3.custom.min.js" cache="false"></script>
</body>
</html>