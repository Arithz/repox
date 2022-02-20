<style><%@include file="/WEB-INF/css/header.css"%></style>

<script>
	window.addEventListener('load', (event) => {
		if(document.getElementById("active").getAttribute("data-active")) {
			var active = document.getElementById("active").getAttribute("data-active");
			if(active === "swviewer") {
				document.getElementById("swviewer").classList.add("active");
			}else if(active === "reqsw") {
				document.getElementById("reqsw").classList.add("active");
			}else if(active === "addregister") {
				document.getElementById("reqviewer").classList.add("active");
			}else if(active === "feedback") {
				document.getElementById("feedback").classList.add("active");
			}
		}
	});
</script>

<div class="topnav">
 <a id = "swviewer" href="softwareviewer">View Software</a>
  <a id = "reqsw" href="requestsoftware">Request Software</a>
  <a id = "reqviewer" href="requestviewer">View Request</a>
  <a id = "feedback" href="feedback">Feedback</a>
  <a href="index" style="color: blue;">Logout</a>
  <p>REPO-X</p>
</div>