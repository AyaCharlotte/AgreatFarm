/**
 * Farm List 구성
 */

function makeFarmList(m_num){
	$.ajax({
		url:"/AgreatFarm/getFarminfo/" + m_num,
		success: function(data, status){
			var farmList = data;
			var content = `
			<div class="w3-container" style="margin-top:80px" id="showcase">
				<h1 class="w3-jumbo">
					<b>축사관리</b>
				</h1>
				<h1 class="w3-xxxlarge w3-text-green">
					<b>나의 축사 목록</b>
				</h1>
				<hr style="width:50px;border:5px solid green" class="w3-round">
			</div>
			<table id="farmList" class="w3-table w3-bordered w3-hoverable">`;
			
			content += "<tr><th>번호</th><th>이름</th><th>종류</th><th>개체 수</th><th>주소</th></tr>";
			for(var i = 0, length = farmList.length; i < length; i++){
				content += `<tr onclick="moveToNodeServer('${farmList[i].f_url}')">`;
				content += `<td>${farmList[i].f_num}</td>`;
				content += `<td>${farmList[i].f_cagename}</td>`;
				content += `<td>${farmList[i].f_type}</td>`;
				content += `<td>${farmList[i].f_count}</td>`;
				content += `<td>${farmList[i].f_location}</td>`;
				content += `</tr>`;	
			}
			content += '</table>';
			console.log(content, "??");
			$('#main_content').empty();
			$('#main_content').append(content);
		},
		error: function(e){
			console.log(e);
		}
	});
}