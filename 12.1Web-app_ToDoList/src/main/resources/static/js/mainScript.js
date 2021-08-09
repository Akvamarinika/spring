import checkFieldsValidation from './validationForm.js';
import PUTRequest from './updateEvent.js';
import POSTFormEvent from "./sendEvent.js";
import GETRequestEventId from "./getEvent.js";
import deleteEvent from "./deleteEvent.js";

function openForm() {
    let container = document.getElementById('to-do-list-form');
    let darkBG = document.createElement('div');
    darkBG.style.height = window.innerHeight + 'px';
    darkBG.style.width = window.innerWidth + 'px';
    darkBG.id = 'dark-bg';
    darkBG.className = 'dark-bg';
    document.body.prepend(darkBG);

    container.style.top = window.innerHeight / 2 - 300 + 'px';
    container.style.left = window.innerWidth / 2 - 250 + 'px';
    container.style.display = 'block';
}

function closeForm() {
    let container = document.getElementById('to-do-list-form');
    let darkBG = document.getElementById('dark-bg');
    container.style.display = 'none';
    document.body.removeChild(darkBG);
    document.getElementById('myForm').reset();
}

function replaceInFormOnEditBtn() {
    let title = document.querySelector('.title');
    let btnPrimary = document.querySelector('.btn-primary');
    title.innerHTML = "Edit event:";
    btnPrimary.innerHTML = "Update event";
    btnPrimary.id = "btn-edit";
}

function replaceInFormOnAddBtn() {
    let title = document.querySelector('.title');
    let btnPrimary = document.querySelector('.btn-primary');
    title.innerHTML = "Add new event:";
    btnPrimary.innerHTML = "Save event";
    btnPrimary.id = "btn-save";
}

function createEventObject() {
    let myForm = document.querySelector('#myForm');
    let isValidFields = checkFieldsValidation();
    let eventObj;

    if (isValidFields){
        console.log(isValidFields);
        eventObj = {
            theme: myForm.querySelector('#theme').value,
            type: myForm.querySelector('input[name=type]:checked').value,
            place: myForm.querySelector('#place').value,
            dateStartPlan: myForm.querySelector('#date_start').value,
            dateEndPlan: myForm.querySelector('#date_end').value,
            timeStart: myForm.querySelector('#time_start').value,
            timeEnd: myForm.querySelector('#time_end').value,
            description: myForm.querySelector('#description').value,
            status:  'Not started',
            dateStartActual:  '',
            dateEndActual:  '',
            timeStartActual:  '',
            timeEndActual:  '',
            priority:  'Medium'
        };

    }
    return eventObj;
}

async function insertObjectInForm(linkEdit) {
    let eventId = linkEdit.parentElement.dataset.id;
    let event = await GETRequestEventId(eventId);
    console.log('event--', event);
    let elementsForm = document.querySelector('#myForm').elements;
    for(let i=0; i<elementsForm.length; i++){
        if (event.hasOwnProperty(elementsForm[i].name)){
            if (elementsForm[i].type != 'radio'){
                elementsForm[i].value = event[elementsForm[i].name];
            }

            if ((elementsForm[i].type === 'radio') && (event[elementsForm[i].name] === elementsForm[i].value)){
                elementsForm[i].checked = true;
            }
        }



    }




}

function Main() {
    let container = document.querySelector('#list');
    let btnAdd = document.getElementById('show-add-event-form');
    let btnSave = document.querySelector('.btn-primary');
    let btnClose = document.querySelector('.btn-secondary');
    let idGlobal;

    btnClose.addEventListener("click", function(ev) {
            closeForm();
    });

    //add Event
    btnAdd.onclick = () => {
        replaceInFormOnAddBtn();
        openForm();
    }

    //edit Event
    container.addEventListener('click', (ev) => {
        if (ev.target.classList.contains('event-block__edit-link')){
            let link = ev.target;
            idGlobal = ev.target.parentElement.dataset.id;
            insertObjectInForm(link);
            replaceInFormOnEditBtn();
            openForm();
        }
    });

    //remove Event
    container.addEventListener('click', (ev) => {
        if (ev.target.classList.contains('event-block__remove-link')){
            let id = ev.target.parentElement.dataset.id;
            deleteEvent(id);
        }
    });

    document.addEventListener("click", function(ev) {
        if (ev.target.id === "dark-bg"){
            closeForm();
        }
    });

    //btn Modal-window
   btnSave.addEventListener('click',(ev) => {
       ev.preventDefault();
        let eventObj = createEventObject();
       console.log(eventObj);
       console.log(idGlobal);
        if (eventObj && !idGlobal){
            POSTFormEvent(eventObj);
            closeForm();
        }

       if (eventObj && idGlobal){
           eventObj.id = idGlobal;
           PUTRequest(idGlobal, eventObj);
           closeForm();
       }
    });







}





Main();


