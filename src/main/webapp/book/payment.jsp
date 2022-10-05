<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts"%>

<layout:main title="구매/결제 페이지">
	<div class="content">
		<form action="<c:url value="/bookshop/payment"/>" method="post">
		<h1>주문/결제</h1>
			<hr>
		<h2>구매자 정보</h2>
			<hr>
						<input type="hidden" name="userId" value="${member.id }">
						<input type="hidden" name="abnum" value="${param.abnum }">
						<input type="hidden" name="count" value="${param.count }">
				이름 : ${member.name }
				<br>
				
				이메일 : ${member.email }
				<br>
				
				휴대폰 번호 : ${member.mobile }
				<br>
				 
		<hr>
		<h2>받는사람정보</h2>
		<hr>
				<div>이름 : ${member.name }</div>
				
				<div>휴대폰 번호 : ${member.mobile }</div>
				<br>
				
					<div class="pt-10"><input  type="text" name="postcode" id="sample6_postcode" placeholder="우편번호" readonly></div>
					<div class="pt-10"><input class="searchBtn" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"></div>
					<div class="pt-10"><input type="text" name="addr" id="sample6_address" placeholder="주소" readonly></div>
					<div class="pt-10"><input type="text" name="datiladdr" id="sample6_detailAddress" placeholder="상세주소"></div>
					<div class="pt-10"><input type="text" name="extraaddr" id="sample6_extraAddress" placeholder="참고항목" readonly></div>
				
		<h3>배송 수량 및 가격</h3>
			<div class="pt-10">상품명 : ${dto.name }</div>
			<br>
			<div class="pt-10">상품 수량 : ${param.count }</div>
			<br>
			<div class="pt-10">상품 총 가격 : ${dto.price * param.count }</div>
			<br>
		<div class="payment">
		<button class="paymentBtn">결제하기</button>
		</div>
		</form>
	</div>
</layout:main>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode(){
		new daum.Postcode({
			oncomplete : function(data){
				var addr = ''; // 주소 변수
				var extraAddr = ''; // 참고항목 변수
				

				// 사용자가 선택한 주소가 도로명 타입일 때 참고항목을 조합한다.
				if (data.userSelectedType === 'R'){ // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress; 
				}else{ // 사용자가 지번 주소를 선택했을 경우 (J)
					addr = data.jibunAddress;	
				}
				
				// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다
				if (data.userSelectedType === 'R'){
					// 법정동명이 있을 경우 추가한다.
					// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
					if(data.bname !== '' && /[동/로/가]$/g.test(data.bname)){
						extraAddr += data.bname;
					}
				
				// 건물명이 있고, 공동주택일 경우 추가한다
				if(data.buildingName !== '' && data.apartment === 'Y'){
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if(extraAddr !== ''){
					extraAddr = '(' + extraAddr + ')'
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("sample6_extraAddress").value = extraAddr;
				}else{
				document.getElementById("sample6_extraAddress").value = '';	
				}
				
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById("sample6_postcode").value = data.zonecode;
				document.getElementById("sample6_address").value = addr;
				document.getElementById("sample6_detailAddress").focus();
			}
		}).open();
	}
	
</script>












