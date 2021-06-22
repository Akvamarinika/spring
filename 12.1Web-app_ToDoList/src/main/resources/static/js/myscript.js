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
            let id = POSTFormEvent(formObj);
            GETListEvent(id);
            container.style.display = 'none';
            document.body.removeChild(darkBG);
        }
        event.stopPropagation();
    }

   darkBG.onclick = () => {
        container.style.display = 'none';
        document.body.removeChild(darkBG);
    }
}


function GETListEvent(id) {
    let  url = '/events/';
    fetch(url)
        .then((response) => {
            console.log( response.json());
        })
        .then((data) => {
            console.log('data: ', data);
        })
        .catch((error) => {
            console.log(error);
        });
}

function checkAndCreateObjectForm() {
    let formObj = new Object();
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

function POSTFormEvent(jsonObj) {
    console.log(jsonObj);
    let url = '/events/';
    /*
// request options
    const options = {
        method: 'POST',
        body: JSON.stringify(jsonObj),
        headers: {
            'Content-Type': 'application/json'
        }
    }

// send POST request
    fetch(url, options)
        .then(res => res.json())
        .then(res => console.log(res));
*/
    fetch(url, {
          method: 'POST',
          headers:{
              //'Accept':'application/json',
              'Content-Type':'application/json'
          },
          body: JSON.stringify(jsonObj)
      })
          .then((response) => {
              try {
                  if (response.status === 200){
                      return response.json();
                  }
                  return Promise.reject();
              } catch (error) {
                  console.log(Error(error));
              }
          });

}

const appendEvent = (data) => {
    let container = document.querySelector('#list');
    let eventHtml = '<h3>' + data.theme + '</h3>';
    container.innerHTML = eventHtml;
}

openForm();
//GETListEvent();
