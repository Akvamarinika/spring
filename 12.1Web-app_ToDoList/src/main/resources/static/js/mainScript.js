import appendEvent from './appendEvent.js';
import checkAndCreateObjectForm from './createObjectFromForm.js';

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

function Form() {
    let container = document.querySelector('#list');
    let btnAdd = document.getElementById('show-add-event-form');
    let btnSave = document.getElementById('save-event');
   // let editLink = document.querySelector('.event-block__edit-link');

    btnAdd.onclick = () => {
        openForm();
    }

    document.addEventListener("click", function(ev) {
        if (ev.target.id === "dark-bg"){
            closeForm();
        }
    });

   btnSave.onclick = () => {
        let formObj = checkAndCreateObjectForm();
        if (formObj){
            POSTFormEvent(formObj);
            closeForm();
        }
        //event.stopPropagation();
    }





   container.addEventListener('click', (ev) => {
        if (ev.target.classList.contains('event-block__edit-link')){
            openForm();
        }
   });

}


function POSTFormEvent(eventObj) {
    let url = '/events/';

    fetch(url, {
          method: 'POST',
          headers:{
              'Accept':'application/json',
              'Content-Type':'application/json'
          },
          body: JSON.stringify(eventObj)
      })
        .then((response) => {
            return response.json();
          })
        .then(data => {
            let event = {};
            event.id = data;
            //console.log('id---', data);
            for (let key in eventObj){
                event[key] = eventObj[key];
            }
            appendEvent(event);
        })
    .catch((error) => {
        console.log(error);
    });

}


Form();


