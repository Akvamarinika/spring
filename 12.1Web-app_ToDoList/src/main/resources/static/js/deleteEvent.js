async function deleteEvent(id) {
    try{
        let response = await fetch(`/events/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(id)
        });

        if (response.status === 404) {
            alert('Event not found.')
        } else {
            let linksEvent = document.querySelectorAll('.event-block');
            for (const link of linksEvent){
                if (link.dataset.id === id){
                    link.remove();
                }
            }
        }

    } catch (error) {
        console.log(error);
    }
}

export default deleteEvent;