//get event from server
async function GETEventFromServer(linkEvent, id) {
    let div = document.createElement('div');
    div.className = 'list--link_block';

    try {
        let response = await fetch(`/events/${id}`);
        if (response.ok) {
            let eventObj = await response.json();
            //console.log('eventObj---', eventObj);
            //console.log(html);
            div.innerHTML = `<span> place: ${eventObj.place} </span>
                                   <span> comment: ${eventObj.comment} </span>`;
            linkEvent.parentElement.appendChild(div); ///
        } else {
            response.status === 404 ? alert("Sorry, event not found!") : alert("Not 200 response");
        }
    } catch (error) {
        alert(error);
    }
}

function openLinkEvent() {
    let container = document.querySelector('#list');
    container.addEventListener('click',  async (ev) => {
        if (ev.target.tagName === 'A'){
            let link = ev.target;
            let idEvent = link.dataset.id;
            await GETEventFromServer(link, idEvent);

            //ev.stopPropagation();
        }
    }, false);
}

openLinkEvent();