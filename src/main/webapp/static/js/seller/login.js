/**
 * 
 */
window.addEventListener("DOMContentLoaded",function(){
	const showSignEl=document.getElementById("showSign");
	const showRegEl=document.getElementById("showReg");
	const RegisterAreaEl=document.getElementsByClassName("RegisterArea")[0];
	const loginAreaEl=document.getElementsByClassName("loginArea")[0];
	
	showSignEl.addEventListener("click",function(){
		loginAreaEl.className="loginArea ";
		RegisterAreaEl.className="RegisterArea dn";
	});
	
	showRegEl.addEventListener("click",function(){
		loginAreaEl.className="loginArea dn";
		RegisterAreaEl.className="RegisterArea";
	})
	
})