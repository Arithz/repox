<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="welcome-text">
        <h1>Welcome To Repo-X</h1>
    </div>
	<div class="middle">
		<a href="login"><button class="btn" style="margin:60px;"><i class="fa fa-user" aria-hidden="true"></i>User</button></a>
		<a href="adminPage"><button class="btn" style="margin:60px;"><i class="fa fa-user-plus" aria-hidden="true"></i>Admin</button></a>
	</div>
</body>
<style>
@charset "ISO-8859-1";
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@300&display=swap');

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Roboto', sans-serif;
}

body{
	background-color: #D8AA96;
    background-size: cover;
    height: 100vh;
    font-size: 16px;
}

a{
    text-decoration: none;
}

header{
    display: -webkit-flex;
    display: -moz-flex;
    display: -ms-flex;
    display: -o-flex;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 30px 70px;
    background-color: black;
    height: 60px;
    width: 100%;
    position: fixed;
}

header img{
    height: 8vh;
}

.top-nav li{
    display: inline-block;
    padding: 0 15px;
}

.top-nav li a{
 color: #fff;
}

.top-nav li a:hover{
    font-size: 18px;
    text-shadow: 0 0 10px #00f1ff,
                 0 0 20px #00f1ff,
                 0 0 40px #00f1ff,
                 0 0 80px #00f1ff,
                 0 0 120px #00f1ff,
                 0 0 160px #00f1ff;
}

.r-btn{
    color: white;
}

.r-btn:hover{
    font-size: 18px;
    text-shadow: 0 0 10px #00f1ff,
                 0 0 20px #00f1ff,
                 0 0 40px #00f1ff,
                 0 0 80px #00f1ff,
                 0 0 120px #00f1ff,
                 0 0 160px #00f1ff;
}

.fix{
    clear: both;
    overflow: hidden;
    height: 100vh;
}

.middle{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    text-align: center;
}

.btn{
    background: white;
    border: 0;
    border-radius: 10px;
    padding: 30px 80px;
    font-size: 20px;
    font-family: 'Open Sans', sans-serif;
    cursor: pointer;
    transition: 0.4s;
}

.btn i{
    padding-right: 10px;
}

.btn:hover{
    background: black;
    color: white;
}

.btn i:hover{
    color: white;
}

.welcome-text{
    position: absolute;
    width: 600px;
    height: 300px;
    margin: 13% 30%;
    text-align: center;
}

.welcome-text h1{
    text-align: center;
    color: black;
    font-size: 60px;
	font-weight: normal;
}

</style>
</html>
