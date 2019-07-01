function validate(){
let login = document.form.login.value;
let password = document.form.password.value;
let repeatedPassword = document.form.repeatedPassword.value;
if(login.split(' ').join('').length == 0){
	alert("Please enter login");
	return false;
}
else if(password.split(' ').join('').length == 0){
	alert("Please enter password");
	return false;
}
else if(repeatedPassword.split(' ').join('').length == 0){
	alert("Please enter repeated password");
	return false;
}
else if(repeatedPassword != password){
	alert("Repeated password must be like password");
	return false;
}
}