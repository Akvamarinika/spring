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

        if (response.status === 404) {
            alert("Sorry, event not found!");
        } else {
            location.reload();
        }

    } catch (error) {
        alert('error: ' + error);
    }
}


export default PUTRequest;