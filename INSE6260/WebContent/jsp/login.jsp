<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SIS</title>

    <spring:url value="/resources/static/assets/css/bootstrap.css" var="bootstrapCSS" />
    <spring:url value="/resources/static/assets/font-awesome/css/font-awesome.css" var="fontAwesomeCSS" />
    <spring:url value="/resources/static/assets/lineicons/style.css" var="lineiconStyleCSS" />
    <spring:url value="/resources/static/assets/css/style.css" var="styleCSS" />
    <spring:url value="/resources/static/assets/css/style-responsive.css" var="responsiveCSS" />
    <spring:url value="/resources/static/assets/img/ui-sam.png" var="avatar" />
    <!-- Bootstrap core CSS --> 
    <link href="${bootstrapCSS}" rel="stylesheet" />
    
    <!--external css-->
    <link href="${fontAwesomeCSS}" rel="stylesheet" />
    <link href="${lineiconStyleCSS}" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="${styleCSS}" rel="stylesheet" />
    <link href="${responsiveCSS}" rel="stylesheet" />

    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
			 
		<form:form id="loginForm" method="post" action="login" modelAttribute="loginUser" class="form-login">
		    <font color="red">${message}</font>
			<h2 class="form-login-heading">sign in now</h2>
			<div class="login-wrap">
				<form:input id="userId" name="userId" path="" class="form-control" placeholder="Enter you ID" />
				<br>
				<form:password id="password" name="password" path="" class="form-control" placeholder="Password"/><br>
				<button type="submit" class="btn btn-theme btn-block"><i class="fa fa-lock"></i> SIGN IN</button>
				<hr>
			</div>
			<!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="forgotModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Forgot Password ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p id="forgotmsg">Enter your e-mail address below to retrieve your password.</p>
		                          <input id="forgotemail" name="email" type="email" placeholder="example@yourcompany.com" autocomplete="off" class="form-control placeholder-no-fix">

		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                          <button class="btn btn-theme" type="button" id="forgotBtn">Submit</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		</form:form>

	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    
    <spring:url value="/resources/static/assets/js/jquery.js" var="jquery" />
    <spring:url value="/resources/static/assets/js/bootstrap.min.js" var="bootstrapJS" />
    <spring:url value="/resources/static/assets/js/jquery.growl.js" var="growlJS" />
    
    <script src="${jquery}"></script>
    <script src="${bootstrapJS}"></script>
    <script src="${growlJS}"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js"></script>
	
  </body>
</html>
