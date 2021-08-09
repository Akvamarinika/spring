import appendEvent from "./appendEvent.js";

function GETListEvents( callbackInsertAll) {
    let  url = '/events/';
    fetch(url)
        .then((response) =>
            response.json()
        )
        .then((data) => {
            //console.log( "data----",  data);
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

GETListEvents(insertAllEvents);