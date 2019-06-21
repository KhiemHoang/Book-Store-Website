function imageZoom(imgs) {
  var expandImg = document.getElementById("zoomImg");
  
  expandImg.src = imgs.src;
  expandImg.parentElement.style.display = "block";
}


function show_cmt(){
	var div = document.getElementById("new-cmt-pnl");

	div.style.display = "block";
}

// //For slide show
// var slide_index = 1;

// show_slide_category_1(slide_index);

// // For category slide show
// function plus_slide_category_1(n) {
// // body...
// 	show_slide_category_1(slide_index += 1);
// }

// function show_slide_category_1(n) {
// // body...
// 	var i;
// 	var slides = document.getElementsByClassName("slide-show-category-1");
// 	if (n > slides.length) 
// 	{
// 		slide_index = 1;
// 	}

// 	if (n < 1)
// 	{
// 		slide_index = slides.length;
// 	}

// 	for(i = 0; i < slides.length; i++)
// 	{
// 		slides[i].style.display = "none";
// 	}

// 	slides[slide_index-1].style.display = "block";
// }
