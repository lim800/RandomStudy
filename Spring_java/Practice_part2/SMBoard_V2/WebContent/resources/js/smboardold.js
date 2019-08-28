function modifyboard(){
		modifyform.submit();
	}
function replyboard(){
	boardform.submit();
}

function addboard(){
	boardform.submit();
}

// 검색 폼 체크
function searchCheck() {
	var form = document.search;
	if (form.keyword.value=='') {
		alert('검색어를 입력하세요.');
		form.keyword.focus();
		return false;
	}
	search.submit();
	//return true;
}


function addboard() {
	if (!boardform.name.value) // form 에 있는 name 값이 없을 때
	{
		alert("이름을 적어주세요!"); // 경고창 띄움
		boardform.name.focus(); // form 에 있는 name 위치로 이동
		return;
	}

	if (!boardform.pass.value) {
		alert("비밀번호를 적어주세요!");
		boardform.pass.focus();
		return;
	}

	if (!boardform.subject.value) {
		alert("제목을 적어주세요!");
		boardform.subject.focus();
		return;
	}

	if (!boardform.content.value) {
		alert("내용을 적어주세요!");
		boardform.content.focus();
		return;
	}
	boardform.submit();
}
