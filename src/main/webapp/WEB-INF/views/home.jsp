<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="myApp" class="no-js"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SocialWorkout App</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/bower_components/html5-boilerplate/dist/css/normalize.css">
  <link rel="stylesheet" href="resources/bower_components/html5-boilerplate/dist/css/main.css">
  <link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/bower_components/angular-ui-grid/ui-grid.min.css">
  <link rel="stylesheet" href="resources/css/app.css">
  <link rel="stylesheet" href="resources/css/font.css" type="text/css" />
  <link rel="stylesheet" href="resources/css/app.css" type="text/css"  />
  <link rel="stylesheet" href="resources/assets/animate.css/animate.css" type="text/css" />
  <link rel="stylesheet" href="resources/assets/font-awesome/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="resources/assets/simple-line-icons/css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="resources/jquery/bootstrap/dist/css/bootstrap.css" type="text/css" />
  <script src="resources/bower_components/html5-boilerplate/dist/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
  <!--[if lt IE 7]>
      <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
  <![endif]-->
  <!-- header -->
  <!-- header -->
  <header id="header" class="navbar navbar-fixed-top bg-white-only padder-v"  data-spy="affix" data-offset-top="1">
    <div class="container">
      <div class="navbar-header">
        <button class="btn btn-link visible-xs pull-right m-r" type="button" data-toggle="collapse" data-target=".navbar-collapse">
          <i class="fa fa-bars"></i>
        </button>
        <a href="#" class="navbar-brand m-r-lg"><img src="img/logo.png" class="m-r-sm hide"><span class="h3 font-bold">SocialWorkout</span></a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav font-bold">
          <li>
            <a href="#what" data-ride="scroll">Home</a>
          </li>
          <li>
            <a href="#why" data-ride="scroll">Rutinas</a>
          </li>
          <li>
            <a href="#features" data-ride="scroll">Objectivos</a>
          </li>
          <li>
            <a href="http://themeforest.net/item/angulr-bootstrap-admin-web-app-with-angularjs/8437259">Usuarios</a>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li>
            <div class="m-t-sm">
              <a href="../angular/#/access/signin" class="btn btn-link btn-sm">Sign in</a> or 
              <a href="../angular/#/access/signup" class="btn btn-sm btn-success btn-rounded m-l"><strong>Sign up</strong></a>
            </div>
          </li>
        </ul>     
      </div>
    </div>
  </header>
  <!-- / header -->
  <!-- / header -->
  <div ng-view></div>
  <br/>
  <!-- footer -->
  <footer id="footer">
    <div class="bg-info">
      <div class="container">
        <div class="row m-t-xl m-b-xl">
          <div class="col-sm-6 text-white text-center">
            <h4 class="m-b">Que rutina deseas Realizar?</h4>
          </div>
          <div class="col-sm-6 text-center">
            <a href="http://themeforest.net/item/angulr-bootstrap-admin-web-app-with-angularjs/8437259?ref=flatfull" class="btn btn-lg btn-default btn-rounded">Ver Rutinas Disponibles</a>
          </div>
        </div>
      </div>
    </div>
    <div class="bg-white">
      <div class="container">
        <div class="row m-t-xl m-b-xl">
          <div class="col-sm-3">
            <h4 class="text-u-c m-b font-thin"><span class="b-b b-dark font-bold">Version</span> options</h4>
            <ul class="list-unstyled">
              <li><a href="../angular"><i class="fa fa-angle-right m-r-sm"></i>Angular App</a></li>
              <li><a href="../html"><i class="fa fa-angle-right m-r-sm"></i>Html Template</a></li>
              <li><a href="../angular/#music/home"><i class="fa fa-angle-right m-r-sm"></i>Music single page application</a></li>
              <li><a href="#"><i class="fa fa-angle-right m-r-sm"></i>App landing page</a></li>
            </ul>
            <p class="m-b-xl">More coming...</p>
          </div>
          <div class="col-sm-3">
            <h4 class="text-u-c m-b font-thin"><span class="b-b b-dark font-bold">Find</span> Us</h4>
            <p class="text-sm">23 soe Midlokls <br>
              120002 Loki — UNITED KINGDOM <br>
              +333 432 321 322
             </p>
             <p>Sale: <a href="mailto:hey@example.com">info@example.com</a></p>
             <p class="m-b-xl">Job: <a href="mailto:hey@example.com">job@example.com</a></p>
          </div>
          <div class="col-sm-3">
            <h4 class="text-u-c m-b-xl font-thin"><span class="b-b b-dark font-bold">Follow</span> Us</h4>
            <div class="m-b-xl">
              <a href="#" class="btn btn-icon btn-rounded btn-dark"><i class="fa fa-facebook"></i></a>
              <a href="#" class="btn btn-icon btn-rounded btn-dark"><i class="fa fa-twitter"></i></a>
              <a href="#" class="btn btn-icon btn-rounded btn-dark"><i class="fa fa-google-plus"></i></a>
              <a href="#" class="btn btn-icon btn-rounded btn-dark"><i class="fa fa-linkedin"></i></a>
              <a href="#" class="btn btn-icon btn-rounded btn-dark"><i class="fa fa-pinterest"></i></a>
            </div>
          </div>
          <div class="col-sm-3">
            <h4 class="text-u-c m-b font-thin"><span class="b-b b-dark font-bold">News</span> Letter</h4>
            <p>Do not want to miss anything? Subscribe to our newsletter box</p>
            <form class="form-inline m-t m-b text-center m-b-xl">
              <div class="aside-xl inline">
                <div class="input-group">
                    <input type="text" id="address" name="address" class="form-control btn-rounded" placeholder="Your email">
                    <span class="input-group-btn">
                      <button class="btn btn-default btn-rounded" type="submit">Subscribe</button>
                    </span>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="bg-light dk">
      <div class="container">
        <div class="row padder-v m-t">
          <div class="col-xs-8">
            <ul class="list-inline">
              <li><a href="#">Sales</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">API</a></li>
              <li><a href="#">Contact us</a></li>
              <li><a href="#">Job</a></li>
            </ul> 
          </div>
          <div class="col-xs-4 text-right">
            Angulr &copy; 2015
          </div>
        </div>
      </div>
    </div>
  </footer>
  <!-- / footer -->
  <!-- In production use:
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
  -->
  <script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
  <script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
  <script src="resources/bower_components/angular/angular.js"></script>
  <script src="resources/bower_components/angular-route/angular-route.js"></script>
  <script src="resources/bower_components/angular-ui-grid/ui-grid.min.js"></script>
  <script src="resources/non_bower_components/angular-file-upload-shim.min.js"></script>
  <script src="resources/non_bower_components/angular-file-upload.min.js"></script>
  <script src="resources/app.js"></script>
  <script src="resources/view1/view1.js"></script>
  <script src="resources/view2/view2.js"></script>
  <script src="resources/components/version/version.js"></script>
  <script src="resources/components/version/version-directive.js"></script>
  <script src="resources/components/version/interpolate-filter.js"></script>
  <script src="resources/js/ui-load.js"></script>
  <script src="resources/js/ui-jp.config.js"></script>
  <script src="resources/js/ui-jp.js"></script>
  <script src="resources/js/ui-nav.js"></script>
  <script src="resources/js/ui-toggle.js"></script>
  <script src="resources/js/ui-client.js"></script>
</body>
</html>
