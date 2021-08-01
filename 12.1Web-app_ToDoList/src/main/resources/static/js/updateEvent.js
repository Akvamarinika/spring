async function PUTRequest(id, eventObj) {
    try{
        let response = await fetch(`/events/${id}`, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(eventObj)
        });

        let data = await response.json();
    } catch (error) {
        alert('error: ' + error);
    }
}

