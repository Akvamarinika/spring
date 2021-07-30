function checkAndCreateObjectForm() {
    let formObj = {};
    let myFormObj = document.querySelector('form').elements;
    let isFilled = true;

    for (let i = 0, element; element = myFormObj[i++];) {
        let elemOnRight = element.parentElement.nextElementSibling;
        let span = document.createElement("span");
        let elemInDOM = document.getElementById(String(i));
        span.id = String(i);
        span.className = 'error';

        if (elemOnRight != null && element.value !== '' && elemOnRight.className === 'error'){elemOnRight.remove();}

        if (element.name !== 'comment' && element.value === ""){
            isFilled = false;

            if (elemInDOM == null){
                span.innerText = "It an empty field!";
                element.parentElement.after(span);
            }
        }

        if(element.type === 'date' && element.value !== ""){
            let arrNums = element.value.split('-');
            let dateNow = new Date().setHours(0,0,0,0);
            let dateForm = new Date(arrNums[0], arrNums[1]-1, arrNums[2]).setHours(0,0,0,0);

            if (dateForm < dateNow) {
                span.innerText = "Date entered must be greater than or equal to today's date!";
                element.parentElement.after(span);
                isFilled = false;
            }
        }

        formObj[element.name] = element.value;
    }

    if(myFormObj['timeStart'].value !== "" && myFormObj['timeEnd'].value !== "" && (myFormObj['timeStart'].value >= myFormObj['timeEnd'].value)){
        isFilled = false;

        if (document.getElementById('8') == null){
            let span = document.createElement("span");
            span.id = '8';
            span.className = 'error';
            span.innerText = "Start time is greater than or equal to end time!";
            myFormObj['timeStart'].parentElement.after(span);
        }
    }

    if (isFilled){
        return formObj;
    }
}

export default checkAndCreateObjectForm;