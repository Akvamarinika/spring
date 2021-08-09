const appendEvent = (event) => {
    let container = document.querySelector('#list');
    let div = document.createElement('div');
    div.className = 'event-block';
    div.dataset.id = `${event.id}`;
    let eventHtml = `<a href="#" class="event-block__link" data-id="${event.id}">${event.theme}</a> 
               <span> type: ${event.type} </span>
               <span> dateStartPlan: ${event.dateStartPlan} </span>
               <span> dateEndPlan: ${event.dateEndPlan} </span>
               <span> timeStart: ${event.timeStart} </span>
               <span> timeEnd: ${event.timeEnd} </span>
                <a href="#" class="event-block__edit-link">Edit</a>
                <a href="#" class="event-block__remove-link">Remove</a>`;

    div.innerHTML = `${eventHtml}`;
    container.appendChild(div);
}

export default appendEvent;