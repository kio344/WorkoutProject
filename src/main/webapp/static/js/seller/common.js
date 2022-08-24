window.addEventListener("DOMContentLoaded",function(){
	const menubtnEl=document.getElementById("menubtn");
	const menuEl=document.getElementsByClassName("menu")[0];
	const menuBackEl=document.getElementsByClassName("background")[0];
	
	menubtnEl.addEventListener("click",function(){
		menuEl.className="menu";
		menuBackEl.className="background"
	})
	
	menuBackEl.addEventListener("click",function(){
		menuEl.className="menu dn";
		menuBackEl.className="background dn"
	})
})