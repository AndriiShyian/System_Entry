function validate(){
let login = document.form.login.value;
let password = document.form.password.value;
if(login.split(' ').join('').length == 0 || password.split(' ').join('').length == 0){
	alert("Please enter login and password");
	return false;
}
else if(login.split(' ').join('').length == 0){
	alert("Please enter login");
	return false;
}
else if(password.split(' ').join('').length == 0){
	alert("Please enter password");
	return false;
}
}