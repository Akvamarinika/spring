function checkFieldsValidation() {
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

        let dateStartPlan = document.querySelector('#date_start');
        let dateEndPlan = document.querySelector('#date_end');
        let dateStartInMs = dateConverter(dateStartPlan);
        let dateEndInMs = dateConverter(dateEndPlan);
        let dateNow = new Date().setHours(0,0,0,0);

        if (dateStartInMs < dateNow) {
            let error = generateError("Date entered must be greater than or equal to today's date!");
            dateStartPlan.parentElement.after(error);
        }

        if (dateStartInMs > dateEndInMs) {
            let error = generateError("Start date is greater than End date!");
            dateEndPlan.parentElement.after(error);
        }

        let timeStart = document.querySelector('#time_start');
        let timeEnd = document.querySelector('#time_end');
        let timeStartInMs = timeConverter(timeStart);
        let timeEndInMs = timeConverter(timeEnd);
        if (dateStartInMs === dateEndInMs && timeStartInMs >= timeEndInMs){
            let error = generateError("Time start is greater than or equal Time end!");
            timeStart.parentElement.after(error);
        }

    });

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