import appendEvent from "./appendEvent.js";

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

export default POSTFormEvent;