<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/static/css/mainPage.css" />"/>

<layout:main>
		<div class="bg_image">
			<div class="main_text">
				<h1>당신의 일상이 되는 책</h1>
				<h3>어디서든 당신과 함께</h3>
			</div>
		</div>
		
		<div class="book_text">
			<h1>당신을 기다리는 </h1>
			<h1>수많은 도서</h1>
			<h3>첫 달 무료 구독을 통해</h3>
			<h3>어떤 도서가 있는지 확인해보세요!</h3>
			<img class="books" src="<c:url value="static/image/books.png"/>"/>
		</div>
		
		<div class="middle_texts">
			<div class="middle_img">
				<div class="middle_text">
					<h1>관심 분야에 있는 책도 딱 골라드려요</h1>
					<h3>당신이 고른 해시태그를 통해</h3>
					<h3>맞춤 책을 찾아보세요!</h3>
				</div>
				<div class="phones">
					<img class="phone" src="<c:url value="static/image/phone.png"/>"/>
					<img class="phone" src="<c:url value="static/image/phone.png"/>"/>
					<img class="phone" src="<c:url value="static/image/phone.png"/>"/>
				</div>
			</div>
		</div>
		
		<div class="QnA">
			<h1 class="Q">자주 묻는 질문</h1>
			<div class="QnA_texts">
				<h3 class="QnA_text">맞지 않는 책이면 정말 환불해주나요? <i class="xi-angle-down"></i></h3>
				<h3 class="QnA_text">구독 중 해지 할 수 있나요? <i class="xi-angle-down"></i></h3>
				<h3 class="QnA_text">어떤 기기에서 사용가능한가요? <i class="xi-angle-down"></i></h3>
			</div>
		</div>
		
		<div class="last">
			<h1>지금 바로 시작하세요!</h1>
			<!--<i class="xi-emoticon-smiley-o"></i> -->
		</div>
		
</layout:main>