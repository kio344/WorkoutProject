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
		
		<section>
		<div class="lazy">
		<div class="book_text">
			<h1>당신을 기다리는 </h1>
			<h1>수많은 도서</h1>
			<h3>첫 달 무료 구독을 통해</h3>
			<h3>어떤 도서가 있는지 확인해보세요!</h3>
			<img class="books" src="<c:url value="static/image/books.png"/>"/>
			</div>
		</div>
		</section>
		
		
		<div class="middle_texts">
			<div class="middle_img">
			<section>
				<div class="middle_text lazy">
					<h1>함께 얘기하며 읽어요!</h1>
					<h3>커뮤니티를 통해</h3>
					<h3>사람들과 함께 읽어보세요!</h3>
				</div>
			
				<div class="phones lazy">
					<img class="phone" src="<c:url value="static/image/phone.png"/>"/>
					<img class="phone" src="<c:url value="static/image/phone.png"/>"/>
					<img class="phone" src="<c:url value="static/image/phone.png"/>"/>
				</div>
				</section>
			</div>
		</div>
		
		<div class="QnA">
		<section>
			<h1 class="Q lazy">자주 묻는 질문</h1>
		
			<div class="QnA_texts">
				<div class="pb-30">
				<button class="QnA_text">맞지 않는 책이면 정말 환불해주나요? <i class="xi-angle-down"></i></button>
				<div class="panel"><p>네! 구매하신지 3일이내면 취소 사유를 정확히 입력하신 후 환불 가능합니다!</p></div>
				</div>
				<div class="pb-30">
				<button class="QnA_text">구독 중 해지 할 수 있나요? <i class="xi-angle-down"></i></button>
				<div class="panel"><p>구매 단위가 한달이기 때문에 한달 구독이 끝난 뒤 새롭게 구매하기 전에 취소가능합니다!</p></div>
				</div>
				<div class="pb-30">
				<button class="QnA_text">어떤 기기에서 사용가능한가요? <i class="xi-angle-down"></i></button>
				<div class="panel">현재 구현된 기능으로써는 구매는 PC 에서 가능하며 읽는 것은 앱으로 가능합니다!</p></div>
				</div>
			</div>
			</section>
		</div>
		<section class='auto_height'>
		<div class="last lazy">
			<h1>지금 바로 시작하세요!</h1>
			<!--<i class="xi-emoticon-smiley-o"></i> -->
		</div>
		</section>
		
</layout:main>