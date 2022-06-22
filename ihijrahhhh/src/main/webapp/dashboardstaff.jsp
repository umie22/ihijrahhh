<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<title>Dashboard Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<head><link rel="stylesheet" href="main.css"></head>

<body>


<!-- SIDEBAR -->
<div class="container" style="padding:0; margin:0; height:100%;width:200px;background-color:#353c49;position:fixed!important;z-index:1;overflow:auto">
<img class="logo" alt="" src="IHijrahLogo.PNG">
<h3 style="text-align: center; color: rgb(255, 255, 255);">WELCOME</h3>
<a href="#" class="btn2" style="display:block;">PAYMENT VERIFICATION </a>
<a href="#" class="btn4" style="display:block;">CLASS SCHEDULE</a>
<a href="AnnouncementList.jsp" class="btn5" style="display:block;">ANNOUNCEMENT</a>
<a href="#" class="btn1" style="display:block;">REPORT</a>
<a href="#" class="btn6" style="display:block;">ACCOUNT</a>
<a href="#" class="btn8" style="display:block;">REGISTER STAFF</a>

</div>
<!-- SIDEBAR -->

<!-- TOPBAR -->      
 <div style=" background-color: #102e44; height:100px; color:blue; padding-left:70px; "><img class="user" alt="" src="user.jpg"></div>
 <!-- TOPBAR -->   
<div class="divs">
    <div class="card mb-3 content">
    <h1 class="m-3 pt-3" >Account</h1>
    <div class="card-body">
    <div class="row">
        <div class="col-md-3">
            <h5>Full Name</h5>
        </div>
        <div class="col-md-9 text-secondary">
            Idham Ahmad
        </div>

    </div>
    <hr>
    <div class="row">
        <div class="col-md-3">
            <h5>Email</h5>
        </div>
        <div class="col-md-9 text-secondary">
            idhamahmad@gmail.com
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-md-3">
            <h5>Phone</h5>
        </div>
        <div class="col-md-9 text-secondary">
            0134567890
        </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-3">
                <h5>Role</h5>
            </div>
            <div class="col-md-9 text-secondary">
                Head Administration
            </div>
            </div>
            <hr>
            <input type="button" class="edit" style="background-color: #4B6FE8; margin-left:33em; margin-top:5em;" value="Edit">
          <input type="button" class="delete" onclick="document.getElementById('id01').style.display='block'" style="background-color:red;" value="Delete">
    </div>
    </div>
</div>

	
<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">×</span>
  <form class="modal-content" action="/action_page.php">
    <div class="modal-container">
      <h1>Delete Account</h1>
      <p>Are you sure you want to this account?</p>
    
      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="deletebtn">Delete</button>
      </div>
    </div>
  </form>
</div>
<script>
//Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
		
</body>
</html>