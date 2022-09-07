window.addEventListener("DOMContentLoaded", function(){
	/**에디터 로드 */
	CKEDITOR.replace("content", {
	height: 350
	});
});
function deleteEl(e){
	
}

window.addEventListener("DOMContentLoaded",function(){
	const fileuploadbtnEl=document.getElementById("fileuploadbtn");
	const imageuploadbtnEl=document.getElementById("imageuploadbtn");	
	const filedeleteEl=document.getElementsByClassName("filedelete");
	console.log(filedeleteEl)
	
	if(filedeleteEl){
		
		for(el of filedeleteEl){
			el.addEventListener("click",function(e){
				let target=e.target
				let parentel= target.parentElement;
				console.log(parentel);
				parentel.innerHTML="";
			})
		}
	}
	
	const fileuploadEl=document.getElementById("fileuploadEl");
	fileuploadbtnEl.addEventListener("click",function(){
		fileuploadEl.className="center";
	});
	fileuploadEl.addEventListener("click",function(){
		fileuploadEl.className="center dn";
	})

	const imageuploadEl=document.getElementById("imageuploadEl");
	imageuploadbtnEl.addEventListener("click",function(e){
		imageuploadEl.className="center";
	})
	imageuploadEl.addEventListener("click",function(e){
		imageuploadEl.className="center dn";
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
			let removeEl=getEl.children[1];
			
			removeEl.addEventListener("click",function(e){
				let target=e.target;
				let parent=target.parentElement;
				parent.innerHTML="";
			})
			
			filesEl.append(getEl);

		}

}
function callBackimage(resp){
		for(file_json of resp){
			
			let imgtag=`<img src='../community/uploadFolder/${file_json.id%10}/${file_json.id}'>`
			
			console.log(imgtag)
					CKEDITOR.instances.content.insertHtml(imgtag);	


		}
}