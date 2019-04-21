function popSnackBar(msg, colorcode) {
	var x = document.getElementById("snackbar");
	x.style.backgroundColor = colorcode;
	x.innerHTML = "";
	x.innerHTML = msg;
	x.className = "show";
	setTimeout(function() {
		x.className = x.className.replace("show", "");
		x.innerHTML = "";
	}, 3000);
}