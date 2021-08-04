//get event from server
async function GETRequestEventId(id) {
    try {
        let response = await fetch(`/events/${id}`);
        if (response.ok) {
            return await response.json();
        } else {
            response.status === 404 ? alert("Sorry, event not found!") : alert("Not 200 response");
        }
    } catch (error) {
        alert(error);
    }
}

export default GETRequestEventId;