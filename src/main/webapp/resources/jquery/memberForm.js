 function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }


//가입
	$(document).ready(function() {
		// 취소
		$(".cencle").on("click", function() {
			location.href = "/main.do";
		});
		
		$("#submit").on("click", function() {
			if ($("#_cusId").val() == "") {
				alert("아이디를 입력해주세요.");
				$("#_cusId").focus();
				return false;
			}
			if ($("#pwd1").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$("#pwd1").focus();
				return false;
			}
			if ($("#pwd1").val() != $("#pwd2").val()){
				alert("비밀번호가 일치하지 않습니다.")
				$("#pwd2").focus();
				return false;
			}
			if ($("#pwd1").val() <8 || $("#pwd1").val() >15) {
				alert("비밀번호 제한이 맞지 않습니다.")
				$("#pwd1").focus();
				return false;
			}
			if ($("#name_lbl").val() == "") {
				alert("이름을 입력해주세요.");
				$("#name_lbl").focus();
				return false;
			}
			if ($("#email_lbl").val() == "") {
				alert("이메일을 입력해주세요.");
				$("#email_lbl").focus();
				return false;
			}
			if ($("#birth_lbl").val() == "") {
				alert("생년월일을 입력해주세요.");
				$("#birth_lbl").focus();
				return false;
			}
			var idChkVal = $("#id_check").val();
			if (idChkVal == "N") {
				alert("아이디 중복확인 버튼을 눌러주세요.");
			} else if (idChkVal == "Y") {
				
			}
			var phChkVal = $("#ph_check").val();
			if (phChkVal == "N") {
				alert("아이디 중복확인 버튼을 눌러주세요.");
			} else if (phChkVal == "Y") {
				
			}
			var emailChkVal = $("#em_check").val();
			if (emailChkVal == "N") {
				alert("이메일 중복확인 버튼을 눌러주세요.");
			} else if (idChkVal == "Y") {
				
			}
			if (emailChkVal == "Y" && idChkVal == "Y"){
				$("#join").submit();
				//alert("가입이 완료되었습니다. 잠시 후 메인페이지로 이동합니다.");
			}
		});
	})



 //비밀번호 일치 확인 -가입
             $(function(){ 
             $("#alert-success").hide();
             $("#alert-danger").hide();
    		
             $("input").keyup(function(){ 
                 var pwd1=$("#pwd1").val(); 
                 var pwd2=$("#pwd2").val(); 
          
				 if(pwd1 != "" || pwd2 != "" ){ 
                     if(pwd1 == pwd2){ 
			$('#pw_check2').text('비밀번호가 일치합니다.');
	 		$('#pw_check2').css('color', 'green');

                     }else{ 
				$('#pw_check2').text('비밀번호가 일치하지 않습니다.');
				$('#pw_check2').css('color', 'red');
                     }                   
                 } 
             }); 
				       
         }); 

//이름 정규식
$(function() {
	var pwJ = /^[A-Za-z0-9]{4,12}$/; 
	var nameJ = /^[가-힣]{2,6}$/;
	$("#name_lbl").keyup(function() {
		if (nameJ.test($(this).val()) ) {
			$("#name_check").text('');
		} else {
			$('#name_check').text('이름을 확인해주세요');
			$('#name_check').css('color', 'red');
		}
	});
	$("#pwd1").keyup(function() {
		if (pwJ.test($(this).val()) ) {		
			$("#pw_check").text('');
		} else {
			$('#pw_check').text('영문,숫자 포함 4~12만 가능합니다 :)');
			$('#pw_check').css('color', 'red');
	}
	});

});
     //비밀번호 확인 - 수정 진입용
    $(function(){ 
    $("#pw-success").hide();
    $("#pw-danger").hide();
    $("#btnpwchk").attr("disabled", "disabled");  
    $(".w3-input").keyup(function(){ 
        var pwd1=$("#pw1").val(); 
        var pwd2=$("#pw2").val(); 
 
		 if(pwd2 != "" ){ 
            if(pwd1 == pwd2){ 
                $("#pw-success").show(); 
                $("#pw-danger").hide(); 
                $("#btnpwchk").removeAttr("disabled");  
            }else{ 
                $("#pw-success").hide(); 
                $("#pw-danger").show(); 
                $("#btnpwchk").attr("disabled", "disabled");  
            }                   
        } 
    }); 		       
}); 
  $(function(){ 
// 생일 유효성 검사
	var birthJ = false;
	
	// 생년월일	birthJ 유효성 검사
	$('#cusBirth').blur(function(){
		var dateStr = $(this).val();		
	    var year = Number(dateStr.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
	    var month = Number(dateStr.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
	    var day = Number(dateStr.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
	    var today = new Date(); // 날짜 변수 선언
	    var yearNow = today.getFullYear(); // 올해 연도 가져옴
		
	    if (dateStr.length <=8) {
			// 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환합니다.
		    if (1900 > year || year > yearNow){
		    	
		    	$('#birth_check').text('생년월일을 확인해주세요 :)');
				$('#birth_check').css('color', 'red');
		    	
		    }else if (month < 1 || month > 12) {
		    		
		    	$('#birth_check').text('생년월일을 확인해주세요 :)');
				$('#birth_check').css('color', 'red'); 
		    
		    }else if (day < 1 || day > 31) {
		    	
		    	$('#birth_check').text('생년월일을 확인해주세요 :)');
				$('#birth_check').css('color', 'red'); 
		    	
		    }else if ((month==4 || month==6 || month==9 || month==11) && day==31) {
		    	 
		    	$('#birth_check').text('생년월일을 확인해주세요 :)');
				$('#birth_check').css('color', 'red'); 
		    	 
		    }else if (month == 2) {
		    	 
		       	var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		       	
		     	if (day>29 || (day==29 && !isleap)) {
		     		
		     		$('#birth_check').text('생년월일을 확인해주세요 :)');
					$('#birth_check').css('color', 'red'); 
		    	
				}else{
					$('#birth_check').text('');
					birthJ = true;
				}//end of if (day>29 || (day==29 && !isleap))
		     	
		    }else{
		    	
		    	$('#birth_check').text(''); 
				birthJ = true;
			}//end of if
			
			}else{
				//1.입력된 생년월일이 8자 초과할때 :  auth:false
				$('#birth_check').text('생년월일을 확인해주세요 :)');
				$('#birth_check').css('color', 'red');  
			}
		}); //End of method /*
});






