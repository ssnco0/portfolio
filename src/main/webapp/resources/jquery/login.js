//로그인 
var loginBox = document.querySelector('.outBox');
    var loginIdInputBox = document.querySelector('#sampleId');
    var loginPwInputBox = document.querySelector('#samplePw');

    loginIdInputBox.addEventListener('keyup', function(){
    
        if(!loginIdInputBox.value == ''){
        
            loginBox.classList.add('existence');   
    
        }else{
        
            loginBox.classList.remove('existence');   
    
        }
        
    });   
     loginPwInputBox.addEventListener('keyup', function(){   
        if(!loginPwInputBox.value == ''){       
            loginBox.classList.add('existence');       
        }else{       
            loginBox.classList.remove('existence');   
        }        
    });

  // 현재 페이지에만 적용
        $(document).ready(function() {
            $('.switch').click(function() { // 로그인 유지 작동
                $(this).toggleClass("switchOn");
            });
            $('.quick_area').hide(); // 우측 빠른 실행 메뉴 숨김 
        });
        
        
 // 사용자별 로그인 화면
