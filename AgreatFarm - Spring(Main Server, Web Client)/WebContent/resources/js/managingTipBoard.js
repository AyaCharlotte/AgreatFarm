/**
 * 운영 Tip 게시
 */

function makeManagingTipList(){
	$.ajax({
		url:"/AgreatFarm/getManagingTipBoardData",
		success: function(data, status){
			var boardList = data;
			var content = `
			<div class="w3-container" style="margin-top:80px" id="showcase">
				<h1 class="w3-jumbo">
					<b>축사 운영 Tip 게시판</b>
				</h1>
				<h1 class="w3-xxxlarge w3-text-green">
					<b>게시판 목록</b>
				</h1>
				<hr style="width:50px;border:5px solid green" class="w3-round">
			</div>
			<table id="managingTipBoard" class="w3-table w3-bordered w3-hoverable">`;
			
			content += "<tr><th>글 번호</th><th>작성자</th><th>제목</th><th>날짜</th><th>조회수</th><th>댓글 수</th></tr>";
			for(var i = 0, length = boardList.length; i < length; i++){
				content += `<tr onclick="readContent(${boardList[i].mId})">`;
				content += `<td>${boardList[i].mId}</td>`;
				content += `<td>${boardList[i].mUsername}</td>`;
				content += `<td>${boardList[i].mTitle}</td>`;
				content += `<td>${boardList[i].mDate}</td>`;
				content += `<td>${boardList[i].mHit}</td>`;
				content += `<td>${boardList[i].mCommentCount}</td>`;
				content += `</tr>`;	
			}
			
			// onclick="readContent('${boardList[i].mId}')"
			content += '</table>';
			
			$('#main_content').empty();
			$('#main_content').append(content);
		},
		error: function(e){
			console.log(e);
		}
	});
}

function readManagingTipContent(mId){
	$.ajax({
		url:"/AgreatFarm/readManagingTipContent/" + mId,
		success: function(data, status){
			console.log(data, typeof(data));
		},
		error: function(e){
			console.log(e);
		}
	});
}

