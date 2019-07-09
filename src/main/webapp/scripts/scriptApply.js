function validate() {
	const name = document.form.name.value;
	const surname = document.form.surname.value;
	const valueDate = document.forms["form"]["date"].value
	const subject1 = document.form.subject1.value;
	const subject2 = document.form.subject2.value;
	const subject3 = document.form.subject3.value;
	const certificate = document.form.certificate.value;
	if (/^[a-zA-Z]+$/.test(name)
			&& /^[a-zA-Z]+$/.test(surname)
			&& ((/^\d+$/.test(subject1) && (subject1 > 100 && subject1 < 201)))
			&& ((/^\d+$/.test(subject2) && (subject2 > 100 && subject2 < 201)))
			&& ((/^\d+$/.test(subject3) && (subject3 > 100 && subject3 < 201)))
			&& ((/^\d+$/.test(certificate) && (certificate > 100 && certificate < 201)))
			&& (valueDate.length != 0)) {
		return true;
	} else if (!/^[a-zA-Z]+$/.test(name)) {
		alert("Wrong name");
		return false;
	} else if (!/^[a-zA-Z]+$/.test(surname)) {
		alert("Wrong surname");
		return false;
	} else if (valueDate.length == 0) {
		alert("Wrong date");
		return false;
	} else if (!/^\d+$/.test(subject1) || subject1 < 100 || subject1 > 200) {
		alert("Wrong subject 1 data");
		return false;
	} else if (!/^\d+$/.test(subject2) || subject2 < 100 || subject2 > 200) {
		alert("Wrong subject 2 data");
		return false;
	} else if (!/^\d+$/.test(subject3) || subject3 < 100 || subject3 > 200) {
		alert("Wrong subject 3 data");
		return false;
	} else if (!/^\d+$/.test(certificate) || certificate < 100
			|| certificate > 200) {
		alert("Wrong subject certificate data");
		return false;
	} else if (day === null) {
		alert("Wrong subject date");
		return false;
	}
}