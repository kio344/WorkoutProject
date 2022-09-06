window.addEventListener("DOMContentLoaded", function(){
	/**에디터 로드 */
	CKEDITOR.replace("content", {
	height: 350
	});
});

window.addEventListener("DOMContentLoaded",function(){
	const fileuploadbtnEl=document.getElementById("fileuploadbtn");
	const fileuploadiframeEl=document.getElementById("fileuploadiframe");
	const centerEl=document.getElementsByClassName("center")[0];
	fileuploadbtnEl.addEventListener("click",function(){
		centerEl.className="center";
	});
	centerEl.addEventListener("click",function(){
		centerEl.className="center dn";
	})
	
	
});

function callBackFileUpload (resp){
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