<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      
<html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7">
   <![endif]-->
   <!--[if IE 7]>         
   <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8">
      <![endif]-->
      <!--[if IE 8]>         
      <html lang="en" ng-app="myApp" class="no-js lt-ie9">
         <![endif]-->
         <!--[if gt IE 8]><!-->
         <html lang="en" ng-app="myApp" class="no-js">
            <!--<![endif]-->
            <head>
               <meta charset="utf-8">
               <meta http-equiv="X-UA-Compatible" content="IE=edge">
               <title>SocialWorkout App</title>
               <meta name="description" content="">
               <meta name="viewport" content="width=device-width, initial-scale=1">
               <link rel="stylesheet"
                  href="resources/bower_components/html5-boilerplate/dist/css/normalize.css">
               <link rel="stylesheet"
                  href="resources/bower_components/html5-boilerplate/dist/css/main.css">
               <link rel="stylesheet"
                  href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
               <link rel="stylesheet"
                  href="resources/bower_components/bootstrap/dist/css/bootstrap-theme.min.css">
               <link rel="stylesheet"
                  href="resources/bower_components/angular-ui-grid/ui-grid.min.css">
               <link rel="stylesheet"
                  href="resources/bower_components/pickadate/lib/themes/classic.css">
               <link rel="stylesheet"
                  href="resources/bower_components/pickadate/lib/themes/classic.date.css">
               <link rel="stylesheet" href="resources/css/app.css">
               <link rel="stylesheet" href="resources/css/font.css" type="text/css" />
               <link rel="stylesheet" href="resources/css/app.css" type="text/css" />
               <link rel="stylesheet" href="resources/assets/animate.css/animate.css"
                  type="text/css" />
               <link rel="stylesheet"
                  href="resources/assets/font-awesome/css/font-awesome.min.css"
                  type="text/css" />
               <link rel="stylesheet"
                  href="resources/assets/simple-line-icons/css/simple-line-icons.css"
                  type="text/css" />
               <link rel="stylesheet"
                  href="resources/jquery/bootstrap/dist/css/bootstrap.css"
                  type="text/css" />
               <script
                  src="resources/bower_components/html5-boilerplate/dist/js/vendor/modernizr-2.8.3.min.js"></script>
            </head>
            <body ng-controller="homeCtrl">
               <!--[if lt IE 7]>
               <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
               <![endif]-->
               <div class="app app-header-fixed ">
               <!-- header -->
               <header id="header" class="app-header navbar" role="menu">
                  <!-- navbar header -->
                  <div class="navbar-header bg-dark">
                     <button class="pull-right visible-xs dk" ui-toggle-class="show"
                        target=".navbar-collapse">
                     <i class="glyphicon glyphicon-cog"></i>
                     </button>
                     <button class="pull-right visible-xs" ui-toggle-class="off-screen"
                        target=".app-aside" ui-scroll="app">
                     <i class="glyphicon glyphicon-align-justify"></i>
                     </button>
                     <!-- brand -->
                     <a href="#/" class="navbar-brand text-lt"> <span
                        class="hidden-folded m-l-xs">Social Workout</span>
                     </a>
                     <!-- / brand -->
                  </div>
                  <!-- / navbar header -->
                  <!-- navbar collapse -->
                  <div
                     class="collapse pos-rlt navbar-collapse box-shadow bg-white-only">
                     <!-- buttons -->
                     <!-- / search form -->
                     <!-- nabar right -->
                     <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                           <a data-toggle="dropdown"
                              class="dropdown-toggle clear" data-toggle="dropdown"> <span
                              class="hidden-sm hidden-md">{{usuario.nombre}}
                           {{usuario.apellidos}}</span> <b class="caret"></b>
                           </a> <!-- dropdown -->
                           <ul class="dropdown-menu animated fadeInRight w">
                              <li><a href="app#/miPerfil">Mi perfil</a></li>
                              </li>
                              <li class="divider"></li>
                              <li><a href="/socialWorkout/#/login">Cerrar sesión</a></li>
                           </ul>
                           <!-- / dropdown -->
                        </li>
                     </ul>
                     <!-- / navbar right -->
                  </div>
                  <!-- / navbar collapse -->
               </header>
               <!-- / header -->
               <!-- aside -->
               <aside id="aside" class="app-aside hidden-xs bg-dark">
                  <div class="aside-wrap">
                     <div class="navi-wrap">
                        <!-- user -->
                        <img src="resources/img/fit.jpg" class="img-full" alt="...">
                        <div class="clearfix hidden-xs text-center hide" id="aside-user">
                           <div class="dropdown wrapper">
                              <a href="app.page.profile"> <span
                                 class="thumb-lg w-auto-folded avatar m-t-sm"> </span>
                              </a> <a href="#" data-toggle="dropdown"
                                 class="dropdown-toggle hidden-folded"> <span class="clear">
                              <span class="block m-t-sm"> <strong
                                 class="font-bold text-lt">John.Smith</strong> <b class="caret"></b>
                              </span> <span class="text-muted text-xs block">Art Director</span>
                              </span>
                              </a>
                              <!-- dropdown -->
                              <ul class="dropdown-menu animated fadeInRight w hidden-folded">
                                 <li class="wrapper b-b m-b-sm bg-info m-t-n-xs">
                                    <span
                                       class="arrow top hidden-folded arrow-info"></span>
                                    <div>
                                       <p>300mb of 500mb used</p>
                                    </div>
                                    <div class="progress progress-xs m-b-none dker">
                                       <div class="progress-bar bg-white" data-toggle="tooltip"
                                          data-original-title="50%" style="width: 50%"></div>
                                    </div>
                                 </li>
                                 <li><a href>Settings</a></li>
                                 <li><a href="page_profile.html">Profile</a></li>
                                 <li><a href> <span class="badge bg-danger pull-right">3</span>
                                    Notifications
                                    </a>
                                 </li>
                                 <li class="divider"></li>
                                 <li><a href="page_signin.html">Logout</a></li>
                              </ul>
                              <!-- / dropdown -->
                           </div>
                           <div class="line dk hidden-folded"></div>
                        </div>
                        <!-- / user -->
                        <!-- nav -->
                        <nav ui-nav class="navi clearfix">
                           <ul class="nav">
                              <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                              </li>
                              <li class="line dk"></li>
                              <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                                 <span>Opciones</span>
                              </li>
                              <li ng-if="mostrarCliente">
                                 <a href class="auto"> <span
                                    class="pull-right text-muted"> <i
                                    class="fa fa-fw fa-angle-right text"></i> <i
                                    class="fa fa-fw fa-angle-down text-active"></i>
                                 </span> <b class="badge bg-info pull-right">2</b> <i
                                    class="glyphicon glyphicon-th"></i> <span>Gimnasio</span>
                                 </a>
                                 <ul class="nav nav-sub dk">
                                    <li class="nav-sub-header"></li>
                                    <li><a href="app#/ocupacion"> <span>Ocupaci&#243n</span>
                                       </a>
                                    </li>
                                    <li><a href="#"> <span>Mis
                                       rutinas</span>
                                       </a>
                                    </li>
                                 </ul>
                              </li>
                              <li ng-if='mostrarCliente'>
                                 <a class="auto"> <span
                                    class="pull-right text-muted"> <i
                                    class="fa fa-fw fa-angle-right text"></i> <i
                                    class="fa fa-fw fa-angle-down text-active"></i>
                                 </span> <b class="badge bg-info pull-right">3</b> <i
                                    class="glyphicon glyphicon-th"></i> <span>Mi Perfil</span>
                                 </a>
                                 <ul class="nav nav-sub dk">
                                    <li class="nav-sub-header"></li>
                                    <li><a href="app#/miPerfil"> <span>Datos
                                       generales</span>
                                       </a>
                                    </li>
                                    <li><a href="app#/historialMedidas"> <span>Historial
                                       de medidas</span>
                                       </a>
                                    </li>
                                    <li><a href="app#/historialAsistencia"> <span>Historial
                                       de asistencia</span>
                                       </a>
                                    </li>
                                 </ul>
                              </li>
                              <li ng-if='mostrarAdministrador'>
                                 <a href class="auto">  
                                 <i
                                    class="glyphicon glyphicon-th-list"></i> <span>Gestiones</span>
                                 </a>
                                 <ul class="nav nav-sub dk">
                                    <li class="nav-sub-header"><a href> <span>Layout</span>
                                       </a>
                                    </li>
                                    <li><a href="#"> <span>Rutinas</span>
                                       </a>
                                    </li>  
                                    <li><a href="app#/ejercicios"> <span>Ejercicios</span>
                                       </a>
                                    </li>
                                    <li><a href="app#/maquinas"> <span>Máquinas</span>
                                       </a>
                                    </li>
                                    <li><a href="app#/unidadesMedidas"> <span>Unidades de medida</span>
                                       </a>
                                    </li>
                                    <li><a href="app#/lugarMedicion"> <span>Lugares de medición</span>
                                       </a>
                                    </li>                                     
                                    <li><a href="app#/objetivos"> <span>Objetivos</span>
                                       </a>
                                    </li>
                                    <li><a href="app#/clases"> <span>Clases</span>
                                       </a>
                                    </li>
                                    <li><a href="app#/eventos"> <span>Eventos</span>
                                       </a>
                                    </li>  
                                    <li><a href="app#/usuarios"> <span>Usuarios</span>
                                       </a>
                                    </li>                                                                           
                                    <li><a href="app#/tiposUsuario"> <span>Tipos de usuario</span>
                                       </a>
                                    </li>                                                                           
                                    </li>                                    
                                 </ul>
                              <li ng-if='mostrarAdministrador'>
                                 <a href class="auto">  
                                 <i
                                    class="glyphicon glyphicon-th-list"></i> <span>Gestión Gimnasio</span>
                                 </a>
                                  <ul class="nav nav-sub dk">
                                    <li class="nav-sub-header"><a href> <span>Layout</span>
                                       </a>
                                    </li>
                                    <li><a href="app#/usuariosAdministrador"> <span>Usuarios del Gimnasio</span>
                                       </a>
                                    </li>  
                             
                              </li>   
                              </li>
                              <li ng-if="mostrarInstructor">
                                 <a href class="auto"> <span
                                    class="pull-right text-muted"> <i
                                    class="fa fa-fw fa-angle-right text"></i> <i
                                    class="fa fa-fw fa-angle-down text-active"></i>
                                 </span> <i class="glyphicon glyphicon-briefcase icon"></i> <span>Estadisticas</span>
                                 </a>
                                 <ul class="nav nav-sub dk">
                                    <li class="nav-sub-header">
                                    </li>
                                    <li><a href="app#/ocupacionGeneral"> <span>Ocupación del gimnasio</span>
                                       </a>
                                    </li>
                                    
                                 </ul>
                              </li>
                              <li ng-if="mostrarInstructor">
                                 <a href class="auto"> <span
                                    class="pull-right text-muted"> <i
                                    class="fa fa-fw fa-angle-right text"></i> <i
                                    class="fa fa-fw fa-angle-down text-active"></i>
                                 </span> <i class="glyphicon glyphicon-list"></i> <span>Asignar
                                 rutinas</span>
                                 </a>
                                 <ul class="nav nav-sub dk">
                                    <li class="nav-sub-header"><a href> <span>Table</span>
                                       </a>
                                    </li>
                                    <li><a href="table_static.html"> <span>Table
                                       static</span>
                                       </a>
                                    </li>
                                    <li><a href="table_datatable.html"> <span>Datatable</span>
                                       </a>
                                    </li>
                                    <li><a href="table_footable.html"> <span>Footable</span>
                                       </a>
                                    </li>
                                 </ul>
                              </li>
                              <li ng-if="mostrarInstructor">
                                 <a href class="auto"> <span
                                    class="pull-right text-muted"> <i
                                    class="fa fa-fw fa-angle-right text"></i> <i
                                    class="fa fa-fw fa-angle-down text-active"></i>
                                 </span> <i class="glyphicon glyphicon-edit"></i> <span>Gestionar
                                 Rutinas</span>
                                 </a>
                                 <ul class="nav nav-sub dk">
                                    <li class="nav-sub-header"><a href> <span>Form</span>
                                       </a>
                                    </li>
                                    <li><a href="form_element.html"> <span>Form
                                       elements</span>
                                       </a>
                                    </li>
                                 </ul>
                              </li>
                              <li>
                              <li class="line dk hidden-folded"></li>
                           </ul>
                        </nav>
                        <!-- nav -->
                        <!-- / aside footer -->
                     </div>
                  </div>
               </aside>
               <!-- / aside -->
               <!-- content -->
               <div id="content" class="app-content" role="main">
                  <div class="app-content-body ">
                     <div ng-view></div>
                     <!-- /content -->
                     <!-- footer -->
                     <footer id="footer" class="app-footer" role="footer">
                        <div class="wrapper b-t bg-light">
                           <span class="pull-right">2.2.0 <a href ui-scroll="app"
                              class="m-l-sm text-muted"><i class="fa fa-long-arrow-up"></i></a></span>
                           &copy; 2016 Copyright.
                        </div>
                     </footer>
                     <!-- / footer -->
                  </div>
               </div>
               <br />
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
               <script src="resources/bower_components/angular-bootstrap/ui-bootstrap-tpls.js"></script>
               <script src="resources/bower_components/angular-schema-form/dist/schema-form.min.js"></script>
               <script src="resources/bower_components/angular-schema-form-dynamic-select/angular-schema-form-dynamic-select.js"></script>
               <script src="resources/bower_components/angular-schema-form-datepicker/bootstrap-datepicker.min.js"></script>
               <script src="resources/bower_components/angular-sanitize/angular-sanitize.min.js"></script>
               <script src='resources/bower_components/angular-ui-select/dist/select.js'></script>
               <script src="resources/bower_components/tv4/tv4.js"></script>
               <script src="resources/bower_components/objectpath/lib/ObjectPath.js"></script>
               <script src="resources/bower_components/pickadate/lib/picker.js"></script>
               <script src="resources/bower_components/pickadate/lib/picker.date.js"></script>
               <script src="resources/bower_components/angular-schema-form/dist/schema-form.min.js"></script>
               <script src="resources/bower_components/angular-schema-form/dist/bootstrap-decorator.min.js"></script>
               <script src="resources/app.js"></script>
               <script src="resources/view1/view1.js"></script>
               <script src="resources/view2/view2.js"></script>
               <script src="resources/eventos/eventos.js"></script>
               <script src="resources/eventosUsuarios/eventosUsuarios.js"></script>               
               <script src="resources/eventos/eventosModal.js"></script>
               <script src="resources/objetivos/objetivos.js"></script>
               <script src="resources/objetivos/objetivosModal.js"></script>
               <script src="resources/usuarios/usuarios.js"></script>
               <script src="resources/usuarios/modalHistorialMedidas.js"></script>
               <script src="resources/usuarios/modalRegistrarMedida.js"></script>
               <script src="resources/usuarios/modalEditarMedida.js"></script>
               <script src="resources/usuarios/vistaUsuarioAdministrador.js"></script>
               <script src="resources/tiposUsuario/tiposUsuario.js"></script>
               <script src="resources/usuarios/modalController.js"></script>
               <script src="resources/homeController/homeController.js"></script>
               <script src="resources/tiposUsuario/modalControllerTipoUsuario.js"></script>
               <script src="resources/clases/clases.js"></script>
               <script src="resources/clases/clasesModal.js"></script>
               <script src="resources/facturacion/facturacion.js"></script>
               <script src="resources/registrar/registrar.js"></script>
               <script src="resources/miPerfil/miPerfil.js"></script>
               <script src="resources/ocupacion/ocupacion.js"></script>
               <script src="resources/lugarMedicion/lugarMedicion.js"></script>
               <script src="resources/lugarMedicion/modalControllerLugarMedicion.js"></script>
	 	         <script src="resources/rutinas/rutinas.js"></script>
  		         <script src="resources/rutinas/rutinaMaestroCtrl.js"></script>
  		         <script src="resources/rutinas/rutinaDetalleModal.js"></script>
               <script src="resources/rutinas/editarRutinaDetalleModal.js"></script>
               <script src="resources/rutinas/editarRutinaMaestro.js"></script>
               <script src="resources/components/version/version.js"></script>
               <script src="resources/components/version/version-directive.js"></script>
               <script src="resources/components/version/interpolate-filter.js"></script>
               <script src="resources/js/ui-load.js"></script>
               <script src="resources/js/ui-jp.config.js"></script>
               <script src="resources/js/ui-jp.js"></script>
               <script src="resources/js/ui-nav.js"></script>
               <script src="resources/js/ui-toggle.js"></script>
               <script src="resources/js/ui-client.js"></script>
               <script src="resources/libs/jquery/flot/jquery.flot.js"></script>
               <script src="resources/libs/jquery/flot/jquery.flot.pie.js"></script>
               <script src="resources/libs/jquery/flot/jquery.flot.resize.js"></script>
               <script src="resources/libs/jquery/jquery.easy-pie-chart/dist/jquery.easypiechart.fill.js"></script>
               <script src="resources/libs/jquery/flot.tooltip/js/jquery.flot.tooltip.min.js"></script>
               <script src="resources/libs/jquery/flot.orderbars/js/jquery.flot.orderBars.js"></script>
               <script src="resources/libs/jquery/flot-spline/js/jquery.flot.spline.min.js"></script>
               <script src="resources/libs/jquery/jquery.sparkline/dist/jquery.sparkline.retina.js"></script>
               <script src="resources/unidadesMedidas/unidadesMedidas.js"></script>
               <script src="resources/unidadesMedidas/modalRegistrarUnidadMedida.js"></script>
               <script src="resources/unidadesMedidas/modalEditarUnidadMedida.js"></script>
               <script src="resources/maquinas/maquinas.js"></script>
               <script src="resources/maquinas/modalEditarMaquina.js"></script>
               <script src="resources/maquinas/modalRegistrarMaquina.js"></script>
               <script src="resources/ejercicios/ejercicios.js"></script>
               <script src="resources/ejercicios/modalRegistrarEjercicio.js"></script>
               <script src="resources/ejercicios/modalEditarEjercicio.js"></script>
               <script src="resources/ejercicios/modalRegistrarMaquinaEjercicio.js"></script>
               <script src="resources/registrosMedidas/registrosMedidas.js"></script>
               <script src="resources/historialAsistencia/historialAsistencia.js"></script>
               <script src="resources/historialMedidas/historialMedidas.js"></script>
               <script src="resources/ocupacionGeneral/ocupacionGeneral.js"></script>
            </body>
         </html>
