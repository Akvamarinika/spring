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


function GETListEvent( callbackInsertAll) {
    let  url = '/events/';
    fetch(url)
        .then((response) =>
             response.json()
        )
        .then((data) => {
            console.log( "data----",  data);
            callbackInsertAll(data);
        })
        .catch((error) => {
            console.log(error);
        });
}

function insertAllEvents(eventsList) {
    for (let eventObj of eventsList){
        appendEvent(eventObj);
    }
}

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
            console.log('id---', data);
            for (let key in eventObj){
                event[key] = eventObj[key];
            }
            appendEvent(event);
        })
    .catch((error) => {
        console.log(error);
    });

}

const appendEvent = (event) => {
    let container = document.querySelector('#list');
    let div = document.createElement('div');
    let eventHtml = `<a href="#" class="event-link" data-id="${event.id}">${event.theme}</a> 
                type: ${event.type} 
                date: ${event.date} 
                timeStart: ${event.timeStart} 
                timeEnd: ${event.timeEnd}`;
    div.innerHTML = `<div>  ${eventHtml} </div>`;
    container.appendChild(div);
}

//get event
function openLink() {
    let container = document.querySelector('#list');
   // let eventLink = document.querySelector('.event-link');

       // console.log('eventLink---', eventLink);
        container.addEventListener('click', async (ev) => {
            console.log(ev.target.tagName);
            if (ev.target.tagName === 'A'){
                let link = ev.target;
                console.log(link);
                let eventId = link.dataset.id;
                console.log(eventId);
                let div = document.createElement('div');
                div.className = 'list--link_block';

                try {
                    let response = await fetch(`/events/${eventId}`);
                    let json = await response.json();
                    console.log(json);
                    let eventObj = json;
                    console.log('eventObj---', eventObj);
                    let html = `<span> place: ${eventObj.place} </span>
                               <span> comment: ${eventObj.comment} </span>`;
                    console.log(html);
                    div.innerHTML = html;
                    console.log(this);
                    console.log( this.parentElement);
                    link.parentElement.appendChild(div); ///

                } catch (error) {
                    if (error.status === 404) {
                        alert('Sorry, event not found!');
                    }
                }
                //ev.stopPropagation();
                //return false;
            }
        }, false);


}



openForm();
GETListEvent(insertAllEvents);
openLink();
