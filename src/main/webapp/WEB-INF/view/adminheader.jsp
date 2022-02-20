<style><%@include file="/WEB-INF/css/header.css"%></style>

<script>
	window.addEventListener('load', (event) => {
		if(document.getElementById("active").getAttribute("data-active")) {
			var active = document.getElementById("active").getAttribute("data-active");
			if(active === "adminswlist") {
				document.getElementById("swlist").classList.add("active");
			}else if(active === "adminfeedback") {
				document.getElementById("feedback").classList.add("active");
			}else if(active === "addregister") {
				document.getElementById("addadmin").classList.add("active");
			}else if(active === "adminRequestList") {
				document.getElementById("requestlist").classList.add("active");
			}
		}
	});
</script>

<div class="topnav">
  <a id = "swlist" href="adminswlist">View Software</a>
  <a id = "addadmin" href="adminregister">Add Admin</a>
  <a id = "requestlist" href="adminRequestList">Request List</a>
  <a id = "feedback" href="adminfeedback">View Feedback</a>
  <a href="index" style="color:blue;">Logout</a>
  <p>REPO-X</p>
</div>