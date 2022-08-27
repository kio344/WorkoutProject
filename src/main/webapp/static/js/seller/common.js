
window.addEventListener("DOMContentLoaded",function(){
	const navEl =document.getElementsByTagName("header")[0];
	const blurEl=document.getElementsByClassName("blur")[0];
	
	navEl.addEventListener("mouseover",function(){
		blurEl.className="blur"
	})
	navEl.addEventListener("mouseout",function(){
				blurEl.className="blur dn"

	})
})