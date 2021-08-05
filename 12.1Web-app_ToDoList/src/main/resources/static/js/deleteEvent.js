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

        let data = await response.json();
    } catch (error) {
        console.log(error);
    }
}

export default deleteEvent;