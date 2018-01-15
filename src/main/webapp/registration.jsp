<%--
  Created by IntelliJ IDEA.
  User: new
  Date: 15.01.2018
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<style type="text/css" media="screen,projection">
    @import url("/style/test.css");
</style>
<script src="js/test.js"></script>
<body>

<h2>Modal Signup Form</h2>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Sign Up</button>
<button onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Sign In</button>

<div id="id01" class="modal">
    <span onclick="document.getElementById('id01').style.display='none'" class="close"
          title="Close Modal">&times;</span>
    <form class="modal-content" action="/action_page.php">
        <div class="container">
            <h1>Sign Up</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>
            <label><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>

            <label><b>Repeat Password</b></label>
            <input type="password" placeholder="Repeat Password" name="psw-repeat" required>

            <label>
                <input type="checkbox" checked="checked" style="margin-bottom:15px"> Remember me
            </label>
            <div class="clearfix">
                <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">
                    Cancel
                </button>
                <button type="submit" class="signupbtn">Sign Up</button>
            </div>
        </div>
    </form>
</div>

<div id="id02" class="modal">
    <span onclick="document.getElementById('id02').style.display='none'" class="close"
          title="Close Modal">&times;</span>
    <form class="modal-content" action="/action_page.php">
        <div class="container">
            <h1>Sign In</h1>
            <p>Please fill fields</p>
            <hr>
            <label><b>Email</b></label>
            <input type="text" placeholder="Enter Email" name="email" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>

            <div class="clearfix">
                <button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbtn">
                    Cancel
                </button>
                <button type="submit" class="signupbtn">Submit</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>