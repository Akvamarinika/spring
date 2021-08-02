function checkFieldsValidation() {
    let myForm = document.querySelector('#myForm');
    let dateStartPlan = myForm.querySelector('#date_start');
    let dateEndPlan = myForm.querySelector('#date_end');

    myForm.addEventListener('submit',(ev) => {
        ev.preventDefault();

        removeValidationErrors(myForm);
        checkFieldsOnEmpty(myForm);
        checkDate(myForm, dateStartPlan, dateEndPlan);
        checkTime(myForm, dateStartPlan, dateEndPlan);

    });

}

function removeValidationErrors(parentNode){
    let errors = parentNode.querySelectorAll('.error');
    for (let i = 0; i < errors.length; i++) {
        errors[i].remove();
    }
}

function checkFieldsOnEmpty(parentNode){
    let fields = parentNode.querySelectorAll('.form-event__field');
    for (let i = 0; i<fields.length; i++){
        if (!fields[i].value){
            let error = generateError("It an empty field!");
            fields[i].parentElement.after(error);
        }
    }
}

function checkDate(parentNode, dateStart, dateEnd){
    let dateStartInMs = dateConverter(dateStart);
    let dateEndInMs = dateConverter(dateEnd);
    let dateNow = new Date().setHours(0,0,0,0);

    if (dateStartInMs < dateNow) {
        let error = generateError("Date entered must be greater than or equal to today's date!");
        dateStart.parentElement.after(error);
    }

    if (dateStartInMs > dateEndInMs) {
        let error = generateError("Start date is greater than End date!");
        dateEnd.parentElement.after(error);
    }
}

function checkTime(parentNode, dateStart, dateEnd){
    let timeStart = parentNode.querySelector('#time_start');
    let timeEnd = parentNode.querySelector('#time_end');
    let timeStartInMs = timeConverter(timeStart);
    let timeEndInMs = timeConverter(timeEnd);

    if (dateConverter(dateStart) === dateConverter(dateEnd) && timeStartInMs >= timeEndInMs){
        let error = generateError("Time start is greater than or equal Time end!");
        timeStart.parentElement.after(error);
    }
}

let dateConverter = (date) => {
    let dateArr = date.value.split('-');
    return +new Date(dateArr[0], dateArr[1]-1, dateArr[2]).setHours(0,0,0,0);
}

let timeConverter = (time) => {
    let timeArr = time.value.split(':');
    return +new Date().setHours(timeArr[0],timeArr[1],0,0);
}

let generateError = function (textError) {
    let error = document.createElement("span");
    error.className = 'error';
    error.innerText = textError;
    return error;
}


export default checkFieldsValidation;