function checkFieldsPresence() {
    let myForm = document.querySelector('#myForm');
    myForm.addEventListener('submit',(ev) => {
        ev.preventDefault();

        let errors = myForm.querySelectorAll('.error');
        for (let i = 0; i < errors.length; i++) {
            errors[i].remove();
        }

        let fields = myForm.querySelectorAll('.form-event__field');
        for (let i = 0; i<fields.length; i++){
            if (!fields[i].value){
                let error = generateError("It an empty field!");
                fields[i].parentElement.after(error);
            }
        }



    });

}


let generateError = function (textError) {
    let error = document.createElement("span");
    error.className = 'error';
    error.innerText = textError;
    return error;
}



export default checkFieldsPresence();