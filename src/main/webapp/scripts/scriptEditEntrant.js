function validate(){
let name = document.form.name.value;
let surname = document.form.surname.value;
let date = document.form.date.value;

 if(name.split(' ').join('').length == 0){
	alert("Please enter name");
	return false;
}
else if(surname.split(' ').join('').length == 0){
	alert("Please enter surname");
	return false;
}
else if(date.split(' ').join('').length == 0){
	alert("Please enter date");
	return false;
}
}