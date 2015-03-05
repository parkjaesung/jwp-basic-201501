var answerWriteFormList = document.querySelectorAll('.answerWrite input[type=submit]');
var answerDeleteFormList = document.querySelectorAll('.answerDelete input[type=submit]');
for ( var j=0 ; j < answerWriteFormList.length ; j++) {
	answerWriteFormList[j].addEventListener('click', writeAnswers, false);
}
for ( var j=0 ; j < answerDeleteFormList.length ; j++) {
	answerDeleteFormList[j].addEventListener('click', deleteAnswers, false);
}

function writeAnswers(e) {
	 e.preventDefault();
	 
	 var url = "/api/addanswer.next";
	 var answerForm = e.currentTarget.form;
	 var params = "questionId=" + answerForm[0].value + "&writer=" + answerForm[1].value + "&contents=" + answerForm[2].value;

	 var request = new XMLHttpRequest();
	 request.open("POST", url, true);
	 request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	 
	 request.onreadystatechange = function() {
		 if(request.readyState == 4 && request.status == 200) {
			 location.reload(true);
		 }
	 }
	 
	 request.send(params);
}
function deleteAnswers(e) {
	 e.preventDefault();
	 var url = "/api/deleteanswer.next";
	 var answerForm = e.currentTarget.form;
	 var params = "questionId=" + answerForm[0].value + "&answerId=" + answerForm[1].value;

	 var request = new XMLHttpRequest();
	 request.open("POST", url, true);
	 request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	 
	 request.onreadystatechange = function() {
		 if(request.readyState == 4 && request.status == 200) {
			 location.reload(true);
		 }
	 }
	 
	 request.send(params);
}
