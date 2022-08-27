const submit = {

	handleEvent(e) {
		const status = e.currentTarget.dataset.status;
		const id = e.currentTarget.dataset.id;
		const str = (status == "true") ? "승인" : "미승인";
		if (!confirm("정말 " + str + " 하시겠습니까?")) {
			return;
		}

		const xhr = new XMLHttpRequest();
		xhr.open("GET", "update?status=" + status + "&id=" + id);
		xhr.addEventListener("readystatechange", function() {
			if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {

				window.location.reload();
			}
		});
		xhr.send(null);

	}
};

window.addEventListener("DOMContentLoaded", function() {
	const submitEl = document.querySelectorAll("#submit");
	for (el of submitEl) {
		el.addEventListener("click", submit);
	}
});