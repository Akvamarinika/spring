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
        let isFilled = checkAndCreateObjectForm();
        if (isFilled){
            POSTFormEvent();
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


function GETListEvent() {
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


    /* myFormItems.forEach((item) => {
         console.log(item);
         if (item && typeof item == typeof 'string'){
             formObj[item.name] = item.value;
         }
     });*/

    /* for (let property in myFormObj){
     if (parseInt(property) != NaN){console.log(parseInt(property));}

     }*/
    console.log(myFormObj[1].name);
    console.log(Object.keys(myFormObj));

    let isFilled = true;
    for (let i = 0, element; element = myFormObj[i++];) {
        let span = document.createElement("span");
        let elemInDOM = document.getElementById(String(i));
        span.id = String(i);
        span.className = 'error';
        console.log(element.value);

        if (element.type === "text" && element.value === "" ){
            if (elemInDOM == null){
                span.innerText = "It an empty textfield!";
                element.after(span);
                console.log("it an empty textfield");
            }

            isFilled = false;
        }

        if(element.type === 'date' && element.value === ""){
            if (elemInDOM == null) {
                span.innerText = "It an empty date!";
                element.after(span);
            }

            isFilled = false;
        }

        if(element.type === 'time' && element.value === ""){
            if (elemInDOM == null) {
                span.innerText = "It an empty time!";
                element.after(span);
            }

            isFilled = false;
        }

        formObj[element.name] = element.value;

    }
    return isFilled;












}

async function POSTFormEvent() {
    let url = '/events/add';
    await fetch(url, {
        headers:{
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        body: JSON.stringify('test:string')
    })
        .then((response) => {
            try {
                if (response.status == 200){
                    return response.text();
                }
                return Promise.reject();
            } catch (error) {
                console.log(Error(error));
            }
        });

}
/*
const appendEvent = (data) => {
    let container = document.querySelector('#list');
    let eventHtml = '<h3>' + data + '</h3>';
    container.innerHTML = eventHtml;
}
*/
openForm();

