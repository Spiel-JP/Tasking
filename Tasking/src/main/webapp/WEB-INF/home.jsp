<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TaskingApp</title>
<link rel="stylesheet" href="fontawesome/css/all.min.css">
<!-- https://fontawesome.com/ -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"
	rel="stylesheet" />
<!-- https://fonts.google.com/ -->
<link rel="stylesheet" href="css/tooplate-wave-cafe.css">
<!--
Tooplate 2121 Wave Cafe
https://www.tooplate.com/view/2121-wave-cafe
-->
</head>
<body>
	<div class="tm-container">
		<div class="tm-row">
			<!-- Site Header -->
			<div class="tm-left">
				<div class="tm-left-inner">
					<!-- title -->
					<div class="tm-site-header">
						<i class="fas fa-coffee fa-3x tm-site-logo"></i>
						<h1 class="tm-site-name">TaskManager</h1>
					</div>
					<!-- link -->
					<nav class="tm-site-nav">
						<ul class="tm-site-nav-ul">
							<!-- Main -->
							<li class="tm-page-nav-item"><a href="#Home"
								class="tm-page-link active">
								<i class="fas fa-mug-hot tm-page-link-icon"></i> 
									<span>HOME SCREEN</span>
							</a></li>
							<!-- To Home  -->
							<li class="tm-page-nav-item">
							<a href="#Creat" class="tm-page-link">
								<i class="fas fa-users tm-page-link-icon"></i>
									<span>CREATE TASK</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>

			<div class="tm-right">
				<main class="tm-main">
					<!-- This Home Page -->
					<div id="Home" class="tm-page-content">
						<nav class="tm-black-bg tm-drinks-nav">
							<ul>
								<li><a href="#TODO" class="tm-tab-link active"
									data-id="TODO">TODO</a></li>
								<li><a href="#DOING" class="tm-tab-link" data-id="DOING">DOING</a>
								</li>
								<li><a href="#DONE" class="tm-tab-link" data-id="DONE">DONE</a>
								</li>
							</ul>
						</nav>

						<div id="TODO" class="tm-tab-content">
							<!-- MODEL 
								<div class="tm-list-item">
									<img src="img/iced-americano.png" alt="Image"
										class="tm-list-item-img">
									<div class="tm-black-bg tm-list-item-text">
										<h3 class="tm-list-item-name">
											Iced Americano<span class="tm-list-item-price">$10.25</span>
										</h3>
										<p class="tm-list-item-description">Here is a short
											description for the first item. Wave Cafe Template is
											provided by Tooplate.</p>
									</div>
								</div>
								-->
							<!-- TODOTaskList -->
							<c:forEach var="task" items="${todoTasks}">
								<div class="tm-list-item">
									<img src="img/iced-americano.png" alt="Image"
										class="tm-list-item-img">
									<div class="tm-black-bg tm-list-item-text">
										<h3 class="tm-list-item-name">
											<c:out value="${task.getTitle()}" />
											<span class="tm-list-item-price"> <c:out
													value="${task.getLocalDateTime().toString()}" />
											</span>
										</h3>
										<p class="tm-list-item-description">
											<c:out value="${task.getDescription()}" />
										</p>
									</div>
								</div>
							</c:forEach>
							<!-- End TODOTaskList -->
						</div>

						<div id="DOING" class="tm-tab-content">
							<!-- DOINGTaskList -->
							<c:forEach var="task" items="${doingTasks}">
								<div class="tm-list-item">
									<img src="img/iced-americano.png" alt="Image"
										class="tm-list-item-img">
									<div class="tm-black-bg tm-list-item-text">
										<h3 class="tm-list-item-name">
											<c:out value="${task.getTitle()}" />
											<span class="tm-list-item-price"> 
											<c:out value="${task.getLocalDateTime().toString()}" />
											</span>
										</h3>
										<p class="tm-list-item-description">
											<c:out value="${task.getDescription()}" />
										</p>
									</div>
								</div>
							</c:forEach>
							<!-- End DOINGTaskList -->
						</div>


						<div id="DONE" class="tm-tab-content">
							<!-- DONETaskList -->
							<c:forEach var="task" items="${doneTasks}">
								<div class="tm-list-item">
									<img src="img/iced-americano.png" alt="Image"
										class="tm-list-item-img">
									<div class="tm-black-bg tm-list-item-text">
										<h3 class="tm-list-item-name">
											<c:out value="${task.getTitle()}" />
											<span class="tm-list-item-price">
											<c:out value="${task.getLocalDateTime().toString()}" />
											</span>
										</h3>
										<p class="tm-list-item-description">
											<c:out value="${task.getDescription()}" />
										</p>
									</div>
								</div>
							</c:forEach>
							<!-- End DONETaskList -->
						</div>
					</div>
				</main>
			</div>
			<!-- end This Home Page -->

			<!-- Creat New Task -->
			<div id="Creat" class="tm-page-content">
				<form action="#" method="post">
					<div class="input-space">
						<div class="input-item">
							<label for="titlelabel">タイトル</label>
							<input type="text" name="title" id="titlelabel" placeholder="例） タイトル">
						</div>
						<div class="input-item">
							<label for="due-date-label">期限日</label>
							<input type="datetime" name="due_date" id="due-date-label">
						</div>
						<div class="input-item">
							<label for="descriptionlabel">説明</label>
							<textarea name="description" id="descriptionlabel" placeholder="100文字以内で"></textarea>
						</div>
					</div>
				</form>
				<!-- end Drink Menu Page -->
			</div>
		</div>
	</div>
	<footer class="tm-site-footer">
		<p class="tm-black-bg tm-footer-text">
			Copyright 2023 TaskManager | CHDesign: <a
				href="https://www.yamatozakura.work" class="tm-footer-link"
				rel="sponsored" target="_parent">Yamatozakura</a>
		</p>
	</footer>
	</div>

	<!-- Background video -->
	<div class="tm-video-wrapper">
		<i id="tm-video-control-button" class="fas fa-pause"></i>
		<video autoplay muted loop id="tm-video">
			<source src="video/wave-cafe-video-bg.mp4" type="video/mp4">
		</video>
	</div>

	<script src="js/jquery-3.4.1.min.js"></script>
	<script>

    function setVideoSize() {
      const vidWidth = 1920;
      const vidHeight = 1080;
      const windowWidth = window.innerWidth;
      const windowHeight = window.innerHeight;
      const tempVidWidth = windowHeight * vidWidth / vidHeight;
      const tempVidHeight = windowWidth * vidHeight / vidWidth;
      const newVidWidth = tempVidWidth > windowWidth ? tempVidWidth : windowWidth;
      const newVidHeight = tempVidHeight > windowHeight ? tempVidHeight : windowHeight;
      const tmVideo = $('#tm-video');

      tmVideo.css('width', newVidWidth);
      tmVideo.css('height', newVidHeight);
    }

    function openTab(evt, id) {
      $('.tm-tab-content').hide();
      $('#' + id).show();
      $('.tm-tab-link').removeClass('active');
      $(evt.currentTarget).addClass('active');
    }    

    function initPage() {
      let pageId = location.hash;

      if(pageId) {
        highlightMenu($(`.tm-page-link[href^="${pageId}"]`)); 
        showPage($(pageId));
      }
      else {
        pageId = $('.tm-page-link.active').attr('href');
        showPage($(pageId));
      }
    }

    function highlightMenu(menuItem) {
      $('.tm-page-link').removeClass('active');
      menuItem.addClass('active');
    }

    function showPage(page) {
      $('.tm-page-content').hide();
      page.show();
    }

    $(document).ready(function(){

      /***************** Pages *****************/

      initPage();

      $('.tm-page-link').click(function(event) {
        
        if(window.innerWidth > 991) {
          event.preventDefault();
        }

        highlightMenu($(event.currentTarget));
        showPage($(event.currentTarget.hash));
      });

      
      /***************** Tabs *******************/

      $('.tm-tab-link').on('click', e => {
        e.preventDefault(); 
        openTab(e, $(e.target).data('id'));
      });

      $('.tm-tab-link.active').click(); // Open default tab


      /************** Video background *********/

      setVideoSize();

      // Set video background size based on window size
      let timeout;
      window.onresize = function(){
        clearTimeout(timeout);
        timeout = setTimeout(setVideoSize, 100);
      };

      // Play/Pause button for video background      
      const btn = $("#tm-video-control-button");

      btn.on("click", function(e) {
        const video = document.getElementById("tm-video");
        $(this).removeClass();

        if (video.paused) {
          video.play();
          $(this).addClass("fas fa-pause");
        } else {
          video.pause();
          $(this).addClass("fas fa-play");
        }
      });
    });
      
  </script>
</body>
</html>