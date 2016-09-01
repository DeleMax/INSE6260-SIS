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
    <spring:url value="/resources/static/assets/css/jquery.growl.css" var="growlCSS" />
    <spring:url value="/resources/static/assets/img/ui-sam.png" var="avatar" />
    <!-- Bootstrap core CSS --> 
    <link href="${bootstrapCSS}" rel="stylesheet" />
    
    <!--external css-->
    <link href="${fontAwesomeCSS}" rel="stylesheet" />
    <link href="${lineiconStyleCSS}" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="${styleCSS}" rel="stylesheet" />
    <link href="${responsiveCSS}" rel="stylesheet" />
    <link href="${growlCSS}" rel="stylesheet">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" rel="stylesheet" />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body data-user="${userId}">

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
          <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="#" class="logo"><b>CONCORDIA</b></a>
            <!--logo end-->
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="/INSE6260/login">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="#"><img src="${avatar}" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">${loggedInUser}</h5>
              	  	
                  <li class="mt">
                      <a class="active" href="#">
                          <i class="glyphicon glyphicon-home"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>

                  <li class="mt" id="menuviewmycourses">
                        <a class="">
                          <i class="fa fa-desktop"></i>
                          <span>View/Drop Courses</span></br>
                      </a>
                  </li>
                  
                  <li class="mt" id="menuviewnewcourses">
                        <a class="">
                          <i class="fa fa-desktop"></i>
                          <span>View/Add Courses</span></br>
                      </a>
                  </li>
                  
                  <li class="mt" id="menuviewmygpa">
                      <a class="">
                          <i class="fa fa-desktop"></i>
                          <span>View My Grades</span></br>
                      </a>
                  </li>
                  
                  <li class="mt" id="menuviewmytranscript">
                      <a class="">
                          <i class="fa fa-desktop"></i>
                          <span>View Transcript</span></br>
                      </a>
                  </li>

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">

              <div class="row">

                  <div class="col-lg-9 main-chart" id="containerperks">
                      <h4 style="color: black;font-size: x-large;font-weight: 900;">DashBoard</h4>
					  <div class="panel panel-default" id="filtermenu">
					  	<div class="panel-heading">Filter</div>
	                          <select id="termdd" style="width:150px;">
								  <option value="1">Winter</option>
								  <option value="2">Summer</option>
								  <option value="3">Fall</option>
							  </select>
							  
							  <select id="yeardd" style="width:150px;">
								  <option value="2015">2015</option>
								  <option value="2016">2016</option>
								  <option value="2017">2017</option>
							  </select>
							  
							  <button id="donebtn" class="btn btn-primary">Done</button>
							  
						</div>
					<div class="panel panel-default" id="coursebyterm">
						<div class="panel-heading">Courses</div>
						  <table class="table">
						  	<thead>
						  		<tr>
						  			<th>Code</th><th>Name</th><th>Grade</th><th>Credits</th><th>Professor</th><th>Action</th>
						  		</tr>
						  	</thead>
						    <tbody>
						  		
						  	</tbody>
						  </table>
					  </div>
					  
					  <div class="panel panel-default" id="newcourses" style="display:none;">
						<div class="panel-heading">Add Courses</div>
						  <table class="table">
						  	<thead>
						  		<tr>
						  			<th>Code</th><th>Name</th><th>Max Students</th><th>Reg. Students</th><th>Credits</th><th>Professor</th><th>Department</th><th>Action</th>
						  		</tr>
						  	</thead>
						    <tbody>
						  		
						  	</tbody>
						  </table>
					  </div>
					  
					  <div class="panel panel-default" id="gpabyterm" style="display:none;">
						  <div class="panel-heading">Grade Point Average</div>
							  <div class="panel-body">
							    <p id="cgpa"></p>
							  </div>
					  <table class="table">
					  	<thead>
					  		<tr>
					  			<th>Code</th><th>Name</th><th>Grade</th><th>Credits</th><th>Professor</th><th>GPA</th>
					  		</tr>
					  	</thead>
					    <tbody>
					  		
					  	</tbody>
					  </table>
					</div>
					
					<div class="panel panel-default" id="transcript" style="display:none;">
						<div class="panel-heading">Transcript</div>
					</div>
					
                  </div><!-- /col-lg-9 END SECTION MIDDLE -->

              </div><! --/row -->

          </section>
      </section>

      <!--main content end-->
  </section>

	<spring:url value="/resources/static/assets/js/jquery.js" var="jquery" />
    <spring:url value="/resources/static/assets/js/bootstrap.min.js" var="bootstrapJS" />
    <spring:url value="/resources/static/assets/js/jquery.dcjqaccordion.2.7.js" var="accordianJS" />
    <spring:url value="/resources/static/assets/js/jquery.scrollTo.min.js" var="scrollTOJS" />
    <spring:url value="/resources/static/assets/js/jquery.nicescroll.js" var="nicescrollJS" />
    <spring:url value="/resources/static/assets/js/jquery.sparkline.js" var="sparklineJS" />
    <spring:url value="/resources/static/assets/js/jquery.growl.js" var="growlJS" />
    <spring:url value="/resources/static/assets/js/common-scripts.js" var="commonJS" />
   
    <!-- js placed at the end of the document so the pages load faster -->
    
    <script src="${jquery}"></script>
    <script src="${bootstrapJS}"></script>
    <script src="${accordianJS}"></script>
    <script src="${scrollTOJS}"></script>
    <script src="${nicescrollJS}"></script>
    <script src="${sparklineJS}"></script>
    <script src="${growlJS}"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
	<script src="http://momentjs.com/downloads/moment.js"></script>
    <!--common script for all pages-->
    <script src="${commonJS }"></script>
    <script>
    
		$(document).ready(function(){
			
			var disc = "07-15-2016";
			var dne = "05-09-2016";
			var self  = this;
			var currMonth = moment().month() + 1;
			var currYear = moment().year();
			if(currMonth >=1 && currMonth <= 4) currSemester = 1;
			else if(currMonth >=5 && currMonth <= 8) currSemester = 2;
			else if(currMonth >=9 && currMonth <= 12) currSemester = 3;
			
			this.current = "viewcourses";
			
			function getStudentCourseByTerm(obj){
			       $.ajax({
				        type: "POST",
				        header:{
				        	Accept: "application/json; charset=utf-8",
				        	"Content-Type": "application/json; charset=utf-8"
				        },
				        url: "/INSE6260/student/coursesbyterm",
				        data:obj,
				        success: function(response){
				        	$("#coursebyterm tbody").empty();
				        	if(response.length==0) {
				        		$.growl.notice({ message: "You have not register any course in this term" });
				        	}else{
					        	 var template = ";"
								_.each(response,function(model,index){
									template += "<tr data-code="+model.coursecode+"><td>"+model.coursecode+"</td><td>"+model.coursename+"</td><td>"+model.grade+"</td><td>"+model.credits+"</td><td>Raza</td><td>";										
									if(parseInt($('#termdd').val()) >= currSemester && parseInt($('#yeardd').val()) >= currYear){
										if(model.grade=="N/A")
											template +="<button class='btn btn-danger drop-course'>Drop</button></td></tr>";
										else
											template +="<button class='btn btn-primary'>No Action</button></td></tr>";
									}
									else
										template +="<button class='btn btn-primary'>No Action</button></td></tr>";	
								});		
					        	$("#coursebyterm tbody").append(template);
					        	$('.drop-course').on('click', dropCourse);
				        	}
				        },
				
				        error: function(e){
				        	$.growl.error({ message: "Error Occured:"+e });
				        }
			        });
			}
			
			function getGpaByTerm(obj){
			       $.ajax({
				        type: "POST",
				        header:{
				        	Accept: "application/json; charset=utf-8",
				        	"Content-Type": "application/json; charset=utf-8"
				        },
				        url: "/INSE6260/student/gpabyterm",
				        data:obj,
				        success: function(response){
				        	$("#gpabyterm tbody").empty();
				        	if(_.isEmpty(obj.term)){
				        		makeTranscript(response);
				        	}
				        	else if(response.length==0) {
				        		$.growl.notice({ message: "You have not register any course in this term" });
				        		return;
				        	}else{
					        	var template = "", cgpa = 0, discCount = 0;
								_.each(response,function(model,index){
									if(model.grade=="DISC")
										discCount++;
									else
										cgpa += model.gradeunit;
									
									template += "<tr data-code="+model.coursecode+"><td>"+model.coursecode+"</td><td>"+model.coursename+"</td><td>"+model.grade+"</td><td>"+model.credits+"</td><td>Raza</td><td>";										
									template += model.gradeunit+"</td></tr>";	
								});		
								var total = response.length - discCount;
								cgpa /= total;
					        	$("#gpabyterm tbody").append(template);
					        	$('#cgpa').text("CGPA: "+cgpa);
				        	}
				        },
				
				        error: function(e){
				        	$.growl.error({ message: "Error Occured:"+e });
				        }
			        });
			}
			
			function makeTranscript(data){
				if(data.length==0){
					$.growl.warning({ message: "Your Transcript has no courses" });
					return;
				}
				$("#transcript").empty();
				
				var groupedData = _(data).groupBy(function(course) {
					    if(course.term==1)						    	
					    	return   'Winter-' + course.year;
					    if(course.term==2)						    	
					    	return   'Summer-' + course.year;
					    if(course.term==3)						    	
					    	return   'Fall-' + course.year;
				    });
				var template = "", cgpa = 0, discCount = 0;
				for(var term in groupedData){
					
					template += "<a href='#"+term+"' class='btn btn-info' data-toggle='collapse'>"+term+"</a><div id='"+term+"' class='collapse in'>";
					template += "<table class='table'><thead><tr><td id='tcgpa'></td></tr><tr><th>Code</th><th>Name</th><th>Grade</th><th>Credits</th><th>GPA</th></tr></thead><tbody>";
					_.each(groupedData[term], function(model,index){
						if(model.grade=="DISC")
							discCount++;
						else
							cgpa += model.gradeunit;
						template += "<tr data-code="+model.coursecode+"><td>"+model.coursecode+"</td><td>"+model.coursename+"</td><td>"+model.grade+"</td><td>"+model.credits+"</td><td>";										
						template += model.gradeunit+"</td></tr>";							
					});
					template += "</tbody></table>";
					$("#transcript").append(template);
					template = "";
				}
			    var total = data.length - discCount;
			    if(total>0)
					cgpa /= total;
	        	$('#tcgpa').text("CGPA: "+cgpa);
	        	
			}
			
			function dropCourse(e){
				
				var obj = {studentId:$('body').data("user"), courseCode: $(e.target).parent().parent().data('code'), status: '', term:$('#termdd').val(), year: $('#yeardd').val()};
				
				if(moment().format("MM/DD/YYYY") > moment(disc).format('MM/DD/YYYY') && $('#termdd').val()==currSemester){
					$.growl.warning({ message: "You are not allowed to drop after DISC deadline" });
					return;
				}
				
				if($('#termdd').val()==currSemester){
					
					if(moment().format("mm/dd/yyyy") < moment(dne).format('mm/dd/yyyy'))
			        	obj['status'] = "DNE";
		        	else if(moment().format("mm/dd/yyyy") > moment(dne).format('mm/dd/yyyy'))
		        		obj['status'] = "DISC";
				}
				else{
						obj['status'] = "DNE";
					}
				
				 $.ajax({
				        type: "POST",
				        url: "/INSE6260/student/dropcourse",
				        data: obj,
				        success: function(response){
				        	
				        	if(moment().format("MM/DD/YYYY") < moment(dne).format('MM/DD/YYYY'))
					        	$.growl.notice({ message: "Course drop successfully within DNE deadline" });
				        	else if(moment().format("MM/DD/YYYY") > moment(dne).format('MM/DD/YYYY') && $('#termdd').val()==currSemester)
				        		$.growl.warning({ message: "You will be charged for course - Reason: Dropped after DNE" });
				        	else
				        		$.growl.notice({ message: "Course drop successfully" });
				        
				        	$(e.target).parent().parent().remove();
				        },
				        error: function(e){
				        	$.growl.error({ message: "Error Occured:"+e });
				        }
			        });
		    }
					
			function getCoursesByTerm(obj){
			       $.ajax({
				        type: "POST",
				        header:{
				        	Accept: "application/json; charset=utf-8",
				        	"Content-Type": "application/json; charset=utf-8"
				        },
				        url: "/INSE6260/student/courseslist",
				        data:obj,
				        success: function(response){
				        	$("#newcourses tbody").empty();
				        	if(response.length==0) {
				        		$.growl.notice({ message: "No courses currently available" });
				        	}else{
					        	 var template = ""
								_.each(response,function(model,index){
									template += "<tr data-code="+model.code+"><td>"+model.code+"</td><td id='coursenamedd'>"+model.name+"</td><td>"+model.maxstudents+"</td><td>"+model.regstudents+"</td><td>"+model.credits+"</td><td id='profname'>"+model.professor+"</td><td>"+model.department+"</td><td>";										
									if(parseInt($('#termdd').val()) >= currSemester && parseInt($('#yeardd').val()) >= currYear)
										template +="<button class='btn btn-success add-course'>Add</button></td></tr>";
									else
										template +="<button class='btn btn-primary'>No Action</button></td></tr>";	
								});		
					        	$("#newcourses tbody").append(template);
					        	$('.add-course').on('click', addCourse);
				        	}
				        },
				
				        error: function(e){
				        	$.growl.error({ message: "Error Occured:"+e });
				        }
			        });
			}
			
		function addCourse(e){
				
			var obj = {studentId:$('body').data("user"), courseCode: $(e.target).parent().parent().data('code'), courseName: $(e.target).parent().parent().find('#coursenamedd').text(), professor: $(e.target).parent().parent().find('#profname').text(), term:$('#termdd').val(), year: $('#yeardd').val()};
				if(moment().format("MM/DD/YYYY") > moment(dne).format('MM/DD/YYYY') && $('#termdd').val()==currSemester){
					$.growl.warning({ message: "You are not allowed to add after DNE deadline" });
					return;
				}
				
				if(moment().format("mm/dd/yyyy") > moment(disc).format('mm/dd/yyyy') && $('#termdd').val()==currSemester){
	        		$.growl.warning({ message: "You are not allowed to add after DISC deadline" });
					return;
				}
					
				 $.ajax({
				        type: "POST",
				        url: "/INSE6260/student/addcourse",
				        data:obj, 
				        success: function(response){
				        					  
				        	if(!response){
				        		$.growl.notice({ message: "Course limit has been reached." });
				        	}
				        	else{
				        		$(e.target).parent().parent().remove();
				       		 	$.growl.notice({ message: "Course registered successfully" });
				        	}
				        },
				        error: function(e){
				        	$.growl.error({ message: "Error Occured:"+e });
				        }
			        });
		    }
		    
			function bindEvents(){
				
				$('#donebtn').click(function(){
					
					var term = $('#termdd').val();
					var year = $('#yeardd').val();
					
						if(parseInt(year)  < currYear && self.current == "newcourses"){
							$.growl.warning({ message: "You cannot add/drop the courses of previous terms" });
							return;
						}
						else if(parseInt(term) < currSemester && year == currYear && self.current == "newcourses"){
							$.growl.warning({ message: "You cannot add/drop the courses of previous terms" });
							return;
						}
						
						if(self.current=="viewcourses"){
							getStudentCourseByTerm({studentId:$('body').data("user"),term:$('#termdd').val(), year:$('#yeardd').val()});
						}
						else if(self.current == "newcourses"){
							getCoursesByTerm({studentId:$('body').data("user"),term:$('#termdd').val(), year: $('#yeardd').val()});
						}
						else if(self.current=="gpa"){
							getGpaByTerm({studentId:$('body').data("user"),term:$('#termdd').val(), year: $('#yeardd').val()});
						}
						else if(self.current=="transcript"){
							getGpaByTerm({studentId:id,term:"", year:""});
						}
					
				});
				
				$('#termdd').on('change', function(e){
					//getStudentCourseByTerm({studentId:$('body').data("user"), term:$(e.target).val(), year:$('#yeardd').val()});
					//getGpaByTerm({studentId: $('body').data("user"),term:$(e.target).val(), year:$('#yeardd').val()});
					//getCoursesByTerm({studentId:$('body').data("user"),term:$('#termdd').val(), year: $('#yeardd').val()});
				});
				
				$('#yeardd').on('change', function(e){
					//getStudentCourseByTerm({studentId:$('body').data("user"),term:$('#termdd').val(), year:$(e.target).val()});
					//getGpaByTerm({studentId:$('body').data("user"),term:$(e.target).val(), year:$('#yeardd').val()});
					//getCoursesByTerm({studentId:$('body').data("user"),term:$('#termdd').val(), year: $('#yeardd').val()});
				});
				
				$('#menuviewmygpa').on('click', function(e){
					$('#newcourses').fadeOut();
					$('#filtermenu').fadeIn();
					$('#coursebyterm').fadeOut();
					$('#transcript').fadeOut();
					$('#gpabyterm').fadeIn();
					self.current = "gpa";
					//getGpaByTerm({studentId:$('body').data("user"),term:$('#termdd').val(), year: $('#yeardd').val()});
				});
				
				$('#menuviewmycourses').on('click', function(e){
					$('#newcourses').fadeOut();
					$('#filtermenu').fadeIn();
					$('#gpabyterm').fadeOut();
					$('#transcript').fadeOut();
					$('#coursebyterm').fadeIn();
					self.current = "viewcourses";
					//getStudentCourseByTerm({studentId:$('body').data("user"), term:$(e.target).val(), year:$('#yeardd').val()});
				});
				
				$('#menuviewnewcourses').on('click', function(e){
					$('#filtermenu').fadeIn();
					$('#gpabyterm').fadeOut();
					$('#transcript').fadeOut();
					$('#coursebyterm').fadeOut();
					$('#newcourses').fadeIn();
					self.current = "newcourses";
					//getCoursesByTerm({studentId:$('body').data("user"),term:$('#termdd').val(), year: $('#yeardd').val()});
				});
				
				$('#menuviewmytranscript').on('click', function(e){
					$('#transcript').fadeIn();
					$('#gpabyterm').fadeOut();
					$('#coursebyterm').fadeOut();
					$('#filtermenu').fadeOut();
					$('#newcourses').fadeOut();
					self.current = "transcript";
					getGpaByTerm({studentId:$('body').data("user"),term:"", year:""});
				});
				
				$('#termdd').val(currSemester);
				$('#yeardd').val(currYear);
				$("#termdd").select2({placeholder:"Select student"});
				$("#yeardd").select2({placeholder:"Select student"});
				
				getStudentCourseByTerm({studentId:$('body').data("user"),term:$('#termdd').val(), year: $('#yeardd').val()});
			}
			bindEvents();
				 				       
		});
	</script>    

  </body>
</html>
