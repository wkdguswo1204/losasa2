$(document).ready(function(){
	// 로그인 처리
		$('#login').click(function(){
			var sid = $('#id').val();
			var spw = $('#pw').val();
			if(!sid || !spw){
				alert('필요한 정보를 기입하세요');
			}
			$('#frm').submit();
		});
		
		// 홈버튼
		$('#home').click(function(){
			$(location).attr('href', '/no4/main.no4');
		});
		
		// 비번 찾기 
		$('#pwbtn').click(function(){
			$('#pwt').removeClass('dnone');
			$('#idt').addClass('dnone');
			$('#pwt').addClass('w3-margin-top');
		});
		
		//비번찾기 메일 보내기 함수
		$('#sendmail').click(function(){
			var nimid = $('#mid').val();
			var mailId = $('#memail').val();
			if(!nimid){
				alert('님 아디 빼먹음');
			}
			if(!mailId){
				alert('아 님 메일 입력좀;;;;');
				return;
			}
			$.ajax({
				url: '/no4/member/pwfind.no4',
				type: 'post',
				dataType: 'json',
				data: {
					'id' : nimid,
					'mail' : mailId
				},
				success: function(data){
					if(data.result == 'ok'){
						alert('메일발송함');
						
					} else if(data.result == 'no'){
						alert('그딴메일없음 ㅅㄱ');
					}
					
				},
				error: function(){
					alert('망할 통신 에러');
				}
			});
		});
		// 아디 찾기 
		$('#idbtn').click(function(){
			$('#idt').removeClass('dnone');
			$('#pwt').addClass('dnone');
			$('#idt').addClass('w3-margin-top');
		});
		// 아이디 찾기 비번 함수
		$('#sendmail2').click(function(){
			var nimname = $('#mname').val();
			var mailId2 = $('#memail2').val();
			if(!nimname){
				alert('니 이름이요');
				return;
			}
			if(!mailId2){
				alert('니 메일이요');
				return;
			}
			$.ajax({
				url:"/no4/member/idfind.no4",
				type: 'post',
				dataType: 'json',
				data: {
					'name' : nimname,
					'mail': mailId2
				},
				success : function(data){
					if(data.result == 'ok'){
						alert('메일 ㄱㄱ');
				} else if(data.result == 'no'){
						alert('응 없음');
						}
					},
					error: function(){
						alert('망할 통신 에러');
					}
			})
		});
});