<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<layout:common>
<!-- 로그인 S -->
	<div class="loginArea">
	<form target="ifrmProcess" method="post" action="<c:url value="/seller/login" />">
		<dl>
			<a class="xi-user-o loginlogo"></a>
			<dt class="message"><h2>Please sign in</h2></dt>
			<dd class="input-grp" >
				<input placeholder="User ID" name="id">
				<input placeholder="Password" name="password">
			</dd>
		</dl>
		
		<div class="chk-grp">
			<input type="checkbox" id="remember">
			<label for="remember">Remember me</label>
		</div>
		
		<div class="btn-grp">
			<button>Sing in</button>
			<button type="button" id="showReg">Register</button>
		</div>
		
		</form>
	</div>
	<!-- 로그인 E -->
	
	<!-- 회원가입 S -->
	<div class="RegisterArea dn">
	<form action="<c:url value="/seller/createAccount" />" method="post">
		<dl>
		<!-- num, id, password, name, email, mobile, address, userType -->
			<a class="xi-user-o loginlogo"></a>
			
			<dt class="message">
				<h2>Create Account</h2>
			</dt>
			<div class="input-outer">			
				<dd class="input-grp" >
					<input placeholder="User ID" name="id">
					<input placeholder="Password" name="password">
					<input placeholder="PasswordRe" name="passwordRe">
					<input placeholder="Group">
					
				</dd>
			
				<dd class="input-grp" >
					<input placeholder="name" name="name">
					<input placeholder="email" name="email">
					<input placeholder="mobile" name="mobile">
					<input placeholder="address" name="address">
				</dd>
			<div>			
			
		</dl>
		
		<!-- <div class="chk-grp">
			<input type="checkbox" id="remember">
			<label for="remember">Remember me</label>
		</div> -->
		
		<div class="btn-grp">
			<button type="button" id="showSign">Sing in</button>
			<button>Register</button>
		</div>
		
		</form>
	</div>
		<!-- 회원가입 E -->
	
</layout:common>