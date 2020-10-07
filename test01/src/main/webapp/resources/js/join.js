	$(document).ready(function(){
		
		let mail;
		
		// 홈버튼
		$('#home').click(function(){
			$(location).attr('href', './main.no4');
		});
		
		//아바타 클릭시 이벤트
		$('#mgen').click(function(){
			$('.mavtbox').removeClass('dnone');
			$('.wavtbox').addClass('dnone');
		});
		$('#wgen').click(function(){
			$('.mavtbox').addClass('dnone');
			$('.wavtbox').removeClass('dnone');
		});
		
		// 아이디 중복체크
		let ckIdResult = false;
		$('#idCheck').click(function(){
			let bid = $('#id').val();
			if(!bid)
				return;
			$.ajax({
					url: '/no4/member/idCheck.no4',
					type: 'POST',
					dataType: 'json',
					data: {
						'id': bid
					},
					success: function(data){
						let str = data;
						if(str == 0){
							$('#idmsg2').removeClass('dnone');
							$('#idmsg1').addClass('dnone');
							$('#idmsg2').attr('class', 'text-primary d-block w3-green');
							ckIdResult = true;
						} else {
							$('#idmsg1').removeClass('dnone');
							$('#idmsg2').addClass('dnone');
							$('#idmsg1').attr('class', 'text-danger d-block w3-red');
							ckIdResult = false;
						}
					},
					error: function(){
						alert('망할 통신실패');
					}
				});
		});
		
		// 비밀번호 중복확인
		$('#repw').keyup(function(){
			if($('#repw').val() == $('#pw').val()){
				$('#repwmsg1').removeClass('dnone');
				$('#repwmsg2').addClass('dnone');
				$('#repwmsg1').attr('class', 'text-primary w3-green');
			} else {
				$('#repwmsg2').removeClass('dnone');
				$('#repwmsg1').addClass('dnone');
				$('#repwmsg2').attr('class', 'text-danger w3-red');
			}
		});

	// 이메일 인증
		var mailnumber;
		var mailcode = false;
		
		$('#ckmail').click(function(){
			let mailId = $('#email1').val();
			let domain = $('#email2').val();
			if(!mailId || !domain){
				alert('메일 입력하셈!')
				return;
			}
			let mail = mailId + domain;
			$.ajax({
				url: '/no4/member/mailCk.no4',
				type: 'POST',
				dataType: 'json',
				data: {
					'mail' : mail
				},
				success : function(data){
					alert('메일감 ㄱㄱ');

				},
				error: function(){
					alert("망할 통신오류")
				}
			});
		});
		
		// 이메일 인증 코드값 확인 처리
		$('#eokbtn').click(function(){
			let mailo = $('#mailck').val();
			$.ajax({
				url: '/no4/member/MailNum.no4',
				type: 'POST',
				dataType: 'json',
				data: {
					'cftnum' : mailo
				},
				success: function(data){
					if(data.result == 'ok'){
						$('#mailmsg1').removeClass('dnone');
						$('#mailmsg2').addClass('dnone');
						mailcode = true;
					} else  if(data.result == 'no'){
						$('#mailmsg2').removeClass('dnone');
						$('#mailmsg1').addClass('dnone');
					}					
				},
				error: function(){
					alert('응 에러');
				}
			})
		});
		
		// 빈 input 타입 있는지 검사 전담 처리 함수
		function checkfrm(){
			var formtag = $('.ckinput');
			for(var i = 0; i < formtag.length; i++) {
				var tagval = $(formtag).eq(i).val();
				if(!tagval && mailcode == false){
					return -1;
				}
			}
			return 1;
		}
		
		// join 버튼 클릭시 input타입검사 함수 호출
		$('#join').click(function(){
			var result = checkfrm();
			if(result == -1){
				alert('다 입력안됨 ㅅㄱ');
				return;
			} else {
				$('#frm').submit();
			}
	});
});