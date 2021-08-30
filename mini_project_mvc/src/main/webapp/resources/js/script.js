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

async function request(id, method, url) {
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
     //ev.preventDefault();
     console.log(ev.target);
     console.log(this);
    if (ev.target.classList.contains('btn-info')){

        let myModal = new bootstrap.Modal(document.getElementById("modal-form-employee"), {});
        let idEmp = ev.target.dataset.id;
        let formHiddenId = document.getElementById('empId');
        let employee = await request(idEmp, "GET", `/employees/${idEmp}`);
        let fields = document.querySelectorAll('.form-group > input');
        setPropertyInForm(employee, fields);
        formHiddenId.value = idEmp;
        myModal.show();

   console.log(employee);
   //ev.stopPropagation();
}
});

//add employee
let btnAdd = document.querySelector('.btn-add');
btnAdd.addEventListener('click', () => {
    document.getElementById(".modal-form-employee").reset();
});
