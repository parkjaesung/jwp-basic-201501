var answerWriteFormList = document.querySelectorAll('.answerWrite input[type=submit]');
var answerDeleteFormList = document.querySelectorAll('.answerDelete input[type=submit]');
var questionDeleteFormList = document.querySelectorAll('.questionDelete input[type=submit]');

for (var j = 0; j < answerWriteFormList.length; j++) {
    answerWriteFormList[j].addEventListener('click', writeAnswers, false);
}
for (var j = 0; j < answerDeleteFormList.length; j++) {
    answerDeleteFormList[j].addEventListener('click', deleteAnswers, false);
}
for (var j = 0; j < questionDeleteFormList.length; j++) {
    questionDeleteFormList[j].addEventListener('click', deleteQuestion, false);
}

function writeAnswers(e) {
    e.preventDefault();

    var url = "/api/addanswer.next";
    var answerForm = e.currentTarget.form;
    var params = "questionId=" + answerForm[0].value + "&writer=" + answerForm[1].value + "&contents=" + answerForm[2].value;

    var request = new XMLHttpRequest();
    request.open("POST", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200) {
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
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200) {
            location.reload(true);
        }
    }

    request.send(params);
}

function deleteQuestion(e) {
	e.preventDefault();
	

	if (detectMobile()) {
		deleteQuestionByMobile(e);
	}else{
		deleteQuestionByComputer();
	}
}

function deleteQuestionByComputer() {
	// console.log("computer");
	var questionForm = document.deleteForm;
	questionForm.action = "/deletequestion.next";
	questionForm.submit();
}

function deleteQuestionByMobile(e) {
	// console.log("mobile");
    var url = "/api/deletequestion.next";
    var questionForm = document.deleteForm;
    var params = "questionId=" + questionForm[0].value;

    var request = new XMLHttpRequest();
    request.open("POST", url, true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    request.onreadystatechange = function() {
        if (request.readyState == 4 && request.status == 200) {
            location.replace("/list.next");
        }
    }
    request.send(params);
}

function detectMobile() {
    if (window.innerWidth <= 800 && window.innerHeight <= 600) {
        return true;
    } else {
        return false;
    }
}