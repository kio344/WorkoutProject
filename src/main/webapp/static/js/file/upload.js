 const Upload={
	upload(files){
		const dropEl=document.getElementById("drop");
		let formdata=new FormData();
		
		
		
		for(file of files){
			formdata.append("file",file);
			
			
		}
		formdata.append("gid",dropEl.dataset.gid);
		console.log(formdata)
		
		let xhr=new XMLHttpRequest();
		xhr.open("POST", location.href);
		xhr.responseType="json"
		xhr.addEventListener("readystatechange",function(){
			if(xhr.status==200&&xhr.readyState==XMLHttpRequest.DONE){
				let respons=xhr.response
				console.log(respons);
				
				
				Upload.addFilesEl(respons);
				parent.callBackFileUpload(respons);

	
			}
		})
		
		xhr.send(formdata);
		
		
				

	},
	
	addFilesEl(resp){
		const filesEl=document.getElementById("files");
		const domparser=new DOMParser();
		for(file_json of resp){
			console.log(file_json)
			let html=document.getElementById("tmp").innerHTML;
			html=html.replace(/#_fileName_/g,file_json.fileName)
						  .replace(/#_num_/g,file_json.id);
						  
			let createEl=domparser.parseFromString(html,"text/html");
			let getEl=createEl.querySelectorAll("#file")[0];
			console.log(getEl);
			filesEl.append(getEl);

		}

	}
}


window.addEventListener("DOMContentLoaded", function() {
	const El = {
		dropEl: document.getElementById("drop"),
		
	}

	El.dropEl.addEventListener("dragover",function(e){
		e.preventDefault();
	})
	
	El.dropEl.addEventListener("drop",function(e){
		e.preventDefault();
		const files=e.dataTransfer.files;
		
		Upload.upload(files)
		
		
	})
})