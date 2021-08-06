function checkFieldsValidation() {
    let myForm = document.querySelector('#myForm');
    let dateStartPlan = myForm.querySelector('#date_start');
    let dateEndPlan = myForm.querySelector('#date_end');

    removeValidationErrors(myForm);
    let isValidFields = checkFieldsOnEmpty(myForm);
    let isValidDate = checkDate(myForm, dateStartPlan, dateEndPlan);
    let isValidTime = checkTime(myForm, dateStartPlan, dateEndPlan);

    return isValidFields && isValidDate && isValidTime;
}

function removeValidationErrors(parentNode){
    let errors = parentNode.querySelectorAll('.error');
    for (let i = 0; i < errors.length; i++) {
        errors[i].remove();
    }
}

function checkFieldsOnEmpty(parentNode){
    let isValidFields = true;
    let fields = parentNode.querySelectorAll('.form-event__field');
    let radioValue;
    for (let i = 0; i<fields.length; i++){
        if (!fields[i].value){
            let error = generateError("It an empty field!");
            fields[i].parentElement.after(error);
            isValidFields = false;
        }

        if (fields[i].type === 'radio' &&  fields[i].checked){
            radioValue = fields[i].value;
        }
    }

    if (!radioValue){
        let error = generateError("No event type selected!");
        parentNode.querySelector('.form-event__required').after(error);
        isValidFields = false;
    }

    return isValidFields;
}

function checkDate(parentNode, dateStart, dateEnd){
    let isValidDate = true;
    let dateStartInMs = dateConverter(dateStart);
    let dateEndInMs = dateConverter(dateEnd);
    let dateNow = new Date().setHours(0,0,0,0);

    if (dateStartInMs < dateNow) {
        let error = generateError("Date entered must be greater than or equal to today's date!");
        dateStart.parentElement.after(error);
        isValidDate = false;
    }

    if (dateStartInMs > dateEndInMs) {
        let error = generateError("Start date is greater than End date!");
        dateEnd.parentElement.after(error);
        isValidDate = false;
    }
    return isValidDate;
}

function checkTime(parentNode, dateStart, dateEnd){
    let isValidTime = true;
    let timeStart = parentNode.querySelector('#time_start');
    let timeEnd = parentNode.querySelector('#time_end');
    let timeStartInMs = timeConverter(timeStart);
    let timeEndInMs = timeConverter(timeEnd);

    if (dateConverter(dateStart) === dateConverter(dateEnd) && timeStartInMs >= timeEndInMs){
        let error = generateError("Time start is greater than or equal Time end!");
        timeStart.parentElement.after(error);
        isValidTime = false;
    }
    return isValidTime;
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