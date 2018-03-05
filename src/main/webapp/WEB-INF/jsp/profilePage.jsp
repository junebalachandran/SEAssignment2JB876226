<html>
<head>
<title>ProfilePage</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	  <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
	  <style>
  body { 
      background-color: #1abc9c; /* Green */
      color: #ffffff;
  }
  img{
  height: 300px;
  width:300px;
  }
  </style>
</head>
<body style="background-image:url(cat.jpg)">
<header>
	<div class="navbar navbar-dark bg-dark box-shadow">
	<div class="container d-flex justify-content-between">	
		Logo
	</div>
	</div>
</header><br><br><br>
<div class="container">
	<div class="row">
		<div class="col-md-4">
			<img src="${imgSrc}" alt="ProfileImg"/>
		</div>
		<div >
			<h2>June Balachandran</h2>
			<p>Hi, I'm June. This is a short assignment given for my Software Engineering course. Pleased to meet you :)</p>
		</div>
	</div>
</div>
<nav class="navbar fixed-bottom navbar-dark bg-dark box-shadow">
  <a class="navbar-brand" href="#">Made by JB876226</a>
</nav>
</body>
</html>