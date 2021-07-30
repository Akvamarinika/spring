import appendEvent from './appendEvent.js';
import checkAndCreateObjectForm from './createObjectFromForm.js';

function openForm() {
    let btnAdd = document.getElementById('show-add-event-form');
    let btnSave = document.getElementById('save-event');
    let container = document.getElementById('to-do-list-form');
    let darkBG = document.createElement('div');

    btnAdd.onclick = () => {
        darkBG.style.height = window.innerHeight + 'px';
        darkBG.style.width = window.innerWidth + 'px';
        darkBG.id = 'dark-bg';
        document.body.prepend(darkBG);

        container.style.top = window.innerHeight / 2 - 300 + 'px';
        container.style.left = window.innerWidth / 2 - 250 + 'px';
        container.style.display = 'block';
    }

   btnSave.onclick = (event) => {
        let formObj = checkAndCreateObjectForm();
        if (formObj){
            POSTFormEvent(formObj);
            container.style.display = 'none';
            document.body.removeChild(darkBG);
            document.getElementById('myForm').reset();
        }
        event.stopPropagation();
    }

   darkBG.onclick = () => {
        container.style.display = 'none';
        document.body.removeChild(darkBG);
    }
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


openForm();


