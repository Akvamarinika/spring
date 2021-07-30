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

export default appendEvent;