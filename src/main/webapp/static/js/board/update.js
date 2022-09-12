window.addEventListener("DOMContentLoaded", function(){
	const btnEl = document.getElementsByClassName("btn");
	
	for(btn of btnEl) {
		btn.addEventListener("click", function(e) {
			const target = e.target;
			const parent = target.parentElement;
			const abs = parent.previousElementSibling.firstChild.nextElementSibling;
			abs.removeAttribute("disabled");
			
			const id = target.dataset.id;
			const gid = target.dataset.gid;
			
			const div = document.createElement("div");
			const upd = document.createElement("button");
			const del = document.createElement("a");
			
			upd.setAttribute("type", "submit");
			del.setAttribute("href", "../comment/delete?id=" + id + "&gid=" + gid);
			
			upd.innerText = "수정하기";
			del.innerText = "삭제하기";
			
			div.appendChild(upd);
			div.appendChild(del);
			parent.appendChild(div);
			parent.removeChild(target);
			
		});
	}
});