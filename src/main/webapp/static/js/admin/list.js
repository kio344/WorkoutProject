window.addEventListener("DOMContentLoaded", function() {
	/** check_all 처리 S */
	const checkAllEls = document.getElementsByClassName("allCheck");
	for(let el of checkAllEls) {
		el.addEventListener("click", function() {
			const targetName = this.dataset.targetName;
			const chks = document.getElementsByName(targetName);
			for(chk of chks) {
				chk.checked = this.checked;
			}
		})
	}
	/** check_all 처리 E */
	
});