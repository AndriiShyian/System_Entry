function validate(){
let login = document.form.login.value;
let password = document.form.password.value;
let typeofuser = document.form.typeofuser.value;

 if(login.split(' ').join('').length == 0){
	alert("Please enter login");
	return false;
}
else if(password.split(' ').join('').length == 0){
	alert("Please enter password");
	return false;
}
else if(typeofuser.split(' ').join('').length == 0){
	alert("Please enter typeofuser");
	return false;
}
}