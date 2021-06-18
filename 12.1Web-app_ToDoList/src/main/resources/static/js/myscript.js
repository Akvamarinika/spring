function openForm() {
    let btnAdd = document.getElementById('show-add-event-form');
    let btnSave = document.getElementById('save-event');
    let container = document.getElementById('to-do-list-form');
    let darkBG = document.createElement('div');

    btnAdd.onclick = () => {
        darkBG.style.height = window.innerHeight + 'px';
        darkBG.style.width = window.innerWidth + 'px';
        darkBG.id = 'dark-bg';
        document.body.prepend(darkBG);

        container.style.top = window.innerHeight / 2 - 250 + 'px';
        container.style.left = window.innerWidth / 2 - 200 + 'px';
        container.style.display = 'block';
    }

    btnSave.onclick = () => {
        container.style.display = 'none';
    }

    darkBG.onclick = () => {
        container.style.display = 'none';
        document.body.removeChild(darkBG);
    }
}

openForm();