// For Slide Show

var slide_index = 1;
show_slide_banner(slide_index);
show_slide_category_1(slide_index);

// For banner slide show
function plus_slide_banner(n) {
	// body...
	show_slide_banner(slide_index += 1);
}

function show_slide_banner(n) {
	// body...
	var i;
	var slides = document.getElementsByClassName("slide-show-banner");
	if (n > slides.length) 
	{
		slide_index = 1;
	}

	if (n < 1)
	{
		slide_index = slides.length;
	}

	for(i = 0; i < slides.length; i++)
	{
		slides[i].style.display = "none";
	}

	slides[slide_index-1].style.display = "block";
}


function openCategory(categoryName){
 	var i;
 	var x = document.getElementsByClassName("category");
 	for (i = 0; i < x.length; i++) {
     	x[i].style.display = "none";  
   	}
   	document.getElementById(categoryName).style.display = "block";
}

// For category slide show
function plus_slide_category_1(n) {
// body...
	show_slide_category_1(slide_index += 1);
}

function show_slide_category_1(n) {
// body...
	var i;
	var slides = document.getElementsByClassName("slide-show-category-1");
	if (n > slides.length) 
	{
		slide_index = 1;
	}

	if (n < 1)
	{
		slide_index = slides.length;
	}

	for(i = 0; i < slides.length; i++)
	{
		slides[i].style.display = "none";
	}

	slides[slide_index-1].style.display = "block";
}



