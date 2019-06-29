function validate(){
let login = document.form.login.value;
let password = document.form.password.value;
if(login.split(' ').join('').length == 0 || password.split(' ').join('').length == 0){
	alert("Please enter login and password");
}
else if(login.split(' ').join('').length == 0){
	alert("Please enter login");
	document.form.login.focus();
}
else if(password.split(' ').join('').length == 0){
	alert("Please enter password");
	document.form.password.focus();
}
}