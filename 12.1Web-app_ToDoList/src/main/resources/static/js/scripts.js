import GETRequestEventId from "./getEvent.js";

function insertHTMLEventDescription(linkEvent, eventObj) {
    let div = document.createElement('div');
    div.className = 'list__event-description';
    div.innerHTML = `<span> place: ${eventObj.place} </span>
                    <span> description: ${eventObj.description} </span>
                    <span> status: ${eventObj.status} </span>
                    <span> priority: ${eventObj.priority} </span>`;

    if (!linkEvent.parentElement.querySelector('.list__event-description')){
        linkEvent.parentElement.appendChild(div);
    }

}

//get event id
function openLinkTheme() {
    let container = document.querySelector('#list');

    container.addEventListener('click',  async (ev) => {
        if (ev.target.className === 'event-block__link'){
            let link = ev.target;
            let idEvent = link.dataset.id;
            let eventObj = await GETRequestEventId(idEvent);
            insertHTMLEventDescription(link, eventObj);

            console.log(eventObj);
            //ev.stopPropagation();
        }
    }, false);
}


openLinkTheme();