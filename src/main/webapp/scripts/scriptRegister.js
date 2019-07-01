const login = document.getElementById("login");
const password = document.getElementById("password");
const repeatedPassword = document.getElementById("repeatedPassword");
const error = document.getElementById('error');
const error2 = document.getElementById('error2');
const error3 = document.getElementById('error3');
const submit = document.getElementById('submit');
function validate(){
    if(login.value === ''){
    	login.classList.add('error');
        error.innerHTML ='there is no login';
        return false;}
        if(password.value === ''){
        	password.classList.add('error2');
            error2.innerHTML ='there is no password';
            return false;}
            if(repeatedPassword.value === ''){
            	repeatedPassword.classList.add('error3');
                error3.innerHTML ='there is no repeated password';
                return false;
        }
    
}
login.addEventListener('click',function(){
    login.classList.remove('error');
    error.innerHTML = '';
    });
    password.addEventListener('click',function(){
        password.classList.remove('error2');
        error2.innerHTML = '';
        });
    repeatedPassword.addEventListener('click',function(){
    	repeatedPassword.classList.remove('error3');
        error3.innerHTML = '';
        });
        