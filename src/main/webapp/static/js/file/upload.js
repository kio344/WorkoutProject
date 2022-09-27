const Upload = {
	upload(files) {
		const dropEl = document.getElementById("drop");
		let formdata = new FormData();



		for (file of files) {

			if (dropEl.dataset.imageonly) {
				if (file.type.indexOf('image') == -1) {
					alert('이미지 파일만 선택해주세요')
					return;
				}
				
				console.log(file);
			}
			formdata.append("file", file);
		}

		formdata.append("gid", dropEl.dataset.gid);
		
		if (dropEl.dataset.imageonly) {
			formdata.append("gid", dropEl.dataset.gid+"_image");
		}
		console.log(formdata)

		let xhr = new XMLHttpRequest();
		xhr.open("POST", location.href);
		xhr.responseType = "json"
		xhr.addEventListener("readystatechange", function() {
			if (xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE) {
				let respons = xhr.response
				console.log(respons);



				if (dropEl.dataset.imageonly) {
					parent.callBackimage(respons);

				} else {
					Upload.addFilesEl(respons);
					parent.callBackFileUpload(respons);
				}


			}
		})

		xhr.send(formdata);




	},

	addFilesEl(resp) {
		const filesEl = document.getElementById("files");
		const domparser = new DOMParser();
		for (file_json of resp) {
			console.log(file_json)
			let html = document.getElementById("tmp").innerHTML;
			html = html.replace(/#_fileName_/g, file_json.fileName)
				.replace(/#_num_/g, file_json.id);

			let createEl = domparser.parseFromString(html, "text/html");
			let getEl = createEl.querySelectorAll("#file")[0];
			console.log(getEl);
			filesEl.append(getEl);

		}

	}
}


window.addEventListener("DOMContentLoaded", function() {
	const El = {
		dropEl: document.getElementById("drop"),
		parentcontentEl: parent.document.getElementById("drop_content")

	}

	console.log(El.parentcontentEl);
	El.dropEl.addEventListener("dragover", function(e) {
		e.preventDefault();
	})

	El.dropEl.addEventListener("drop", function(e) {
		e.preventDefault();
		const files = e.dataTransfer.files;

		Upload.upload(files)


	})
	El.parentcontentEl.addEventListener("dragover", function(e) {
		e.preventDefault();

	})

	El.parentcontentEl.addEventListener("drop", function(e) {
		e.preventDefault();
		const files = e.dataTransfer.files;

		Upload.upload(files)
	})



})