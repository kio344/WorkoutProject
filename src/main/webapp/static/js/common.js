
const sideMenuBtnEl2 = document.querySelector(".join-menu #btn");
const sideMenuEl = document.querySelector(".layer");
if (sideMenuBtnEl2 && sideMenuEl) {
	sideMenuBtnEl2.addEventListener("click", function() {
		const classList = sideMenuEl.classList;
		if (classList.contains("on")) {
			classList.remove("on");
		} else {
			classList.add("on");
		}
	});
}
/**글씨 올라가기 */
window.addEventListener("DOMContentLoaded", function() {
	/*
	* 각 영역을 full 화면으로 조정 
	*
	*/
	const sectionEls = document.getElementsByTagName
	("section");
	const h = window.innerHeight;
	for (const el of sectionEls) {
		if (!el.classList.contains("auto_height")) {
			el.style.height= h + "px";
		}
	}
	
	window.addEventListener("scroll", function() {
		const sectionEls = document.getElementsByTagName
	("section");
		/**
		 * 각 영역에 위치에 도달하면 on 클래스 추가,
		 * 위치를 벗어나면 on 클래스 제거 
		 */
		 const st = window.pageYOffset
		 const baseSt = st + 400;
		 const screenH = window.innerHeight;
		 for (const el of sectionEls) {
			 el.classList.remove("on");
		 }
		for (const el of sectionEls) {
			const rect = el.getBoundingClientRect();
			const topPos = rect.top + st; // 각 요소의 시작 위치
			const bottomPos = topPos + screenH; // 각 요소의 끝 위치
			if (baseSt > topPos && baseSt < bottomPos) {
				el.classList.add("on");
			}
			
		}
	});
});

/**자주 묻는 질문 */
var QnA_texts = document.getElementsByClassName("QnA_text");

for(let QnA_text of QnA_texts){
	QnA_text.addEventListener("click", e =>{
		const panelEls = document.querySelectorAll('.QnA_texts .panel');
		for (const el of panelEls) {
			el.style.height="";
		}
		
		var panel = e.target.nextElementSibling;
		
		if(panel.style.height===""){
			panel.style.height = panel.scrollHeight + "px"
		}
	})
}