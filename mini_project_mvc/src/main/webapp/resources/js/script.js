/*let addModal = document.getElementById('modal-add-employee');
let modal = bootstrap.Modal.getOrCreateInstance(addModal);

document.getElementById('btn-add').addEventListener('click', () => {
    modal.show();
});*/

/*let testModal = document.getElementById("testModal");
//new bootstrap.Modal(testModal).show(); //works

let testDropdown = document.getElementById("modal-add-employee");
new bootstrap.Dropdown(testDropdown, {}).show();

// open from external trigger
let testBtn = document.getElementById("btn-add")
testBtn.addEventListener('click',()=>{
    bootstrap.Dropdown.getOrCreateInstance(testDropdown).toggle();
});*/

//field.value.replace(/^\s+|^0+|\s+$/g, '').length === 0
//`/employees/${id}`

function setPropertyInForm(obj, fields) {
    for(let prop in obj) {
        if(typeof(obj[prop]) === 'object') {
            setPropertyInForm(obj[prop], fields);
        } else {
            for (let field of fields) {
                if (field.id === prop) {
                    field.value = obj[prop];
                    break;
                }
            }
        }
    }
}

async function requestWithBody(id, method, url, bodyElement, contentType) {
    document.body.classList.add('load');
    try{
        let response = await fetch(url, {
            method: method,
            headers: {
                'Accept': contentType,
                'Content-Type': contentType
            },
            body: bodyElement
        });

        if (response.status === 404) {
            alert("Sorry, employee not found!");
        } else {
            document.body.classList.remove('load');
            //return response.json();
        }
    } catch (error) {
        alert('error: ' + error);
    }
}

async function requestWithoutBody(id, method, url) {
    document.body.classList.add('load');
    try{
        let response = await fetch(url, {
            method: method,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });

        if (response.status === 404) {
            alert("Sorry, employee not found!");
        } else {
            document.body.classList.remove('load');
            return response.json();
        }
    } catch (error) {
        alert('error: ' + error);
    }
}


//edit employee
let table = document.querySelector('.table');
 table.addEventListener('click',  async (ev) => {

    if (ev.target.classList.contains('btn-update')){
        let myModal = new bootstrap.Modal(document.getElementById("modal-form-employee"), {});
        let title = document.getElementById('main-modal-title');
        let idEmp = ev.target.dataset.id;
        let formHiddenId = document.getElementById('empId');
        let employee = await requestWithoutBody(idEmp, "GET", `/employees/${idEmp}`);
        let fields = document.querySelectorAll('.form-group > input');

        setPropertyInForm(employee, fields);

        if (employee.hasOwnProperty('department')){
            let idDepart = employee['department']['id'];
            let options = document.querySelectorAll('#department > option');
            console.log('options ', options);
            options.forEach(option => {
                if (idDepart === +option.value){
                    option.selected = 'selected';
                }
            });
        }

        formHiddenId.value = idEmp;
        title.innerHTML = 'Edit employee: ';
        myModal.show();
    }
});

//reset form
let btnAdd = document.querySelector('#btn-add');
console.log(btnAdd);
btnAdd.addEventListener('click', () => {
    console.log(document.getElementById("empObj"));
    document.getElementById("empObj").reset();
});

//delete employee
table.addEventListener('click',   (ev) => {
    if (ev.target.classList.contains('btn-delete')){
        let idEmp = ev.target.dataset.id;
        let myModal = new bootstrap.Modal(document.getElementById("modal-confirm"), {});
        myModal.show();

        document.getElementById("btn-confirm-delete").addEventListener('click', async () => {
            await requestWithBody(idEmp, 'DELETE', `/employees/${idEmp}`, JSON.stringify(idEmp), 'application/json');
            myModal.hide();
            document.getElementById(idEmp).remove();

        });
    }
});

//change title modal-form
document.getElementById('btn-add').addEventListener('click',() => {
    let title = document.getElementById('main-modal-title');
    title.innerHTML = 'Add new employee: ';
});