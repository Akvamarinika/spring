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
        console.log(data);
    } catch (error) {
        alert('error: ' + error);
    }
}


export default PUTRequest;