<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'welcome.jsp' starting page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['table']});
      google.charts.setOnLoadCallback(drawTable);

      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('number', 'Rank');
        data.addColumn('string', 'Part');
        data.addColumn('string', 'Description');
        data.addColumn('number', 'Operator');
        data.addColumn('number', 'Supplier');
        data.addColumn('number', 'Total');
        data.addColumn('number', 'Avg Quantity');
        data.addRows([
          [1, "32895625", "Multiple", 1024, 4486, 5510, 271],
          [2, "6228973001", "Multiple", 797, 3294, 4091, 626],
          [3, "9806022001", "Multiple", 873, 3154, 4027, 253],
          [4, "VTF00B00", "Multiple", 693, 3288, 3981, 76],
        ]);

        var table = new google.visualization.Table(document.getElementById('table_div'));

        table.draw(data, {showRowNumber: true, width: '100%', height: '50%'});
      }
    </script>
    <script type="text/javascript">
    google.charts.load("current", {packages:['corechart']});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ["Element", "Density", { role: "style" } ],
        ["32895625", 1024, "#b87333"],
        ["6228973001", 797, "silver"],
        ["9806022001", 873, "gold"],
        ["VTF00B00", 693, "color: #e5e4e2"]
      ]);

      var view = new google.visualization.DataView(data);
      view.setColumns([0, 1,
                       { calc: "stringify",
                         sourceColumn: 1,
                         type: "string",
                         role: "annotation" },
                       2]);

      var options = {
        title: "Operator # of Different Parts",
        width: 600,
        height: 400,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };
      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
      chart.draw(view, options);
  }
  </script>
  <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Supplier', 'Numbers'],
          ['32895625', 5510],
          ["6228973001", 4091],
          ["9806022001", 4027],
          ["VTF00B00", 3981]
        ]);

        var options = {
          title: 'Supplier # of Suppliers'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
     <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Total', 'Number'],
          ['32895625', 5510],
          ["6228973001", 4091],
          ["9806022001", 4027],
          ["VTF00B00", 3981]]);

        var options = {
          title: 'Total #',
          legend: { position: 'none' },
        };

        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

</head>

<body style="text-align: center" class="p-3 mb-2 bg-light text-dark">
	<div id="content" style="width: 800px;">

		<div id="categorys"
			style="float: left; width: 200px; text-align: left;"
			class="p-3 mb-2 bg-info text-white rounded">
			Categories：
			<ul>
				<c:forEach var="category" items="${categorys}">
					<li><a
						href="${pageContext.request.contextPath }/client/WelcomeServlet?category_id=${category.id }">${category.name }</a></li>
				</c:forEach>
			</ul>
			<ul>
				<li><a href="${pageContext.request.contextPath }/client/geolocation.html" target="_blank">Request Form</a></li>
			</ul>
		</div>
		<script type="text/javascript"
			src="https://www.gstatic.com/charts/loader.js"></script>


		<div id="products"
			style="float: left; text-align: left; padding-left: 100px; width: 300px">
			<c:forEach var="product" items="${page.list}">
				<div id="product">
					<div style="float: left">
						<img
							src="${pageContext.request.contextPath }/images/${product.image }" alt="Missing">
					</div>
					<div style="float: left">
						<ul>
							<li>${product.name }</li>
							<li>${product.author }</li>
							<li>${product.price }</li>
							<li><a
								href="${pageContext.request.contextPath }/client/BuyServlet?productid=${product.id }">Bid It</a></li>
						</ul>
					</div>
					<div style="clear: both"></div>
					<br /> <br />
				</div>
			</c:forEach>
		</div>
		
		<div style="clear: both"></div>
		<div id="listpagenum" class="container-fluid">
			Current[${page.pagenum }]Page&nbsp;&nbsp;

			<c:forEach var="pageNum" begin="${page.foreachbegin}"
				end="${page.foreachend}">
   			[<a
					href="${pageContext.request.contextPath }/client/WelcomeServlet?pageNum=${pageNum }&category_id=${current_category_id }">${pageNum }</a>]
   		</c:forEach>

			&nbsp;&nbsp;There_are_[${page.totalpage }]Pages,There_are_[${page.totalrecord }]_Records
		</div>
		
	</div>
	
	<div id="table_div"></div>
    <div id="columnchart_values" style="width: 50%; height: 500px; float: left;"></div>
    <div id="piechart" style="width: 50%; height: 500px; float: left;"></div>
    <div id="chart_div" style="width: 50%; height: 500px; float: left;"></div>
	<div style="clear: both"></div>
</body>
</html>
