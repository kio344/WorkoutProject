window.addEventListener("DOMContentLoaded", function() {

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

});