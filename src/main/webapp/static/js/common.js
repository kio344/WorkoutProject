var btn = document.getElementById("btn");
var layer = document.getElementById("layer");
var nav = document.querySelector("nav");
console.log(btn, layer, nav);

btn.addEventListener("click", ()=>{
	nav.style.left = "0px";
	layer.style.display="block";
})


layer.addEventListener("click", ()=>{
	nav.style.left="-280px";
	layer.style.display="none";
})