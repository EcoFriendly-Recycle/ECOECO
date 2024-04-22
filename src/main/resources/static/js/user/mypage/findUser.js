/* 아이디 찾기 */
/* alert 창으로 표시 */
// document.querySelector(".searchIdButton").addEventListener("click", function(event) {
//     event.preventDefault(); // 기본 동작 방지
//
//     // 폼 데이터 생성
//     const formData = new FormData(document.getElementById("findId"));
//
//     // 서버로 아이디 찾기 요청 보내기
//     fetch('/user/mypage/findId', {
//         method: 'POST',
//         body: formData
//     })
//         .then(response => {
//             // 응답을 텍스트로 변환
//             return response.text();
//         })
//         .then(data => {
//             // 받은 데이터에 따라 알맞은 메시지를 alert 창으로 표시
//             if (data.startsWith("회원님의 아이디는")) {
//                 alert(data); // 아이디를 찾았을 경우 받은 데이터 그대로 표시
//             } else {
//                 alert(data); // 아이디를 찾지 못했을 경우 받은 데이터 표시
//             }
//         })
//         .catch(error => {
//             console.error('Error:', error);
//         });
// });


/* 아이디 찾기 */
/* 모달창으로 표시 */
function openFindIdModal() {
    // 폼 데이터 생성
    const formData = new FormData(document.getElementById('findId'));

    // 서버로 아이디 찾기 요청 보내기
    fetch('/user/mypage/findId', {
        method: 'POST',
        body: formData
    })
        .then(response => {
            // 응답을 텍스트로 변환
            return response.text();
        })
        .then(data => {
            // 모달 내용 설정
            const successFindIdModal = document.getElementById('successFindIdModal');
            const failFindIdModal = document.getElementById('failFindIdModal');
            if (data.startsWith("회원님의 아이디는")) {
                // 아이디를 찾았을 경우
                successFindIdModal.textContent = data;
                failFindIdModal.textContent = ""; // 아이디를 찾았을 경우 기존에 출력된 실패 메시지 제거
                failFindIdModal2.textContent = "";
            } else {
                // 아이디를 찾지 못했을 경우
                successFindIdModal.textContent = ""; // 아이디를 찾지 못했을 경우 기존에 출력된 성공 메시지 제거
                failFindIdModal.textContent = "등록된 회원정보가 없습니다.";
                failFindIdModal2.textContent = "다시 확인하여 주시기 바랍니다.";
            }

            // 모달 열기
            const findIdModal = document.getElementById('findIdModal');
            findIdModal.style.display = 'block';
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// 모달 닫기
function closeFindIdModal() {
    // 모달 닫기
    const findIdModal = document.getElementById('findIdModal');
    findIdModal.style.display = 'none';

    // 아이디를 찾은 경우 로그인 페이지로 이동
    const successFindIdModal = document.getElementById('successFindIdModal');
    if (successFindIdModal.textContent !== "") {
        window.location.href = "/login";
    }
}