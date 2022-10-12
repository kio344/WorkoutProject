/**메뉴바 
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
*/
const slideMenu = {
		// 슬라이드 메뉴 열기
		open() {
			const layer = document.getElementById("layer");
			if (layer) {
				layer.classList.remove("dn");
			}
			const el = document.getElementById("slide_menu");
			console.log(el);
			if (el) {
				el.classList.remove("on")
				el.classList.add("on");
			}
		},
		close() {
			const el = document.getElementById("slide_menu");
			if (el) {
				el.classList.remove("on");
			}
			
			const layer = document.getElementById("layer");
			if (layer) {
				setTimeout(function() {
				layer.classList.remove("dn")
				layer.classList.add("dn");
				}, 1000);
			}
			
		}
};

window.addEventListener("DOMContentLoaded", function() {
	
	const slideMenuEl = document.getElementById("btn");
	if (slideMenuEl) {
		// 슬라이드 메뉴 열기
		slideMenuEl.addEventListener("click", function() {
			const el = document.getElementById("slide_menu");
			if (el.classList.contains("on")) {
				slideMenu.close();
			} else {
				slideMenu.open();
			}
		});
	 
		
		// 슬라이드 메뉴 닫기
		const layerDimEl = document.getElementById("layer");
		if (layerDimEl) {
			layerDimEl.addEventListener("click", function() {
				slideMenu.close();
			});
		}
	}
});



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