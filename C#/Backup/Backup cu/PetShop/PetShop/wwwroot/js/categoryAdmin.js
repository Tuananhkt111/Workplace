function loadCbPetAccessory(id) {
    $.ajax({
        type: "POST",
        url: "/PetCategory/LoadAllPetCategory",
        async: false,
        contentType: 'application/json',
        dataType: 'json',
        success: function (data) {
            $('#' + id).empty();
            $.each(data, function () {
                var opt = document.createElement("option");
                opt.value = this.petCatId;
                opt.innerHTML = this.petType;
                $('#' + id).append(opt);
            });
        },
        error: function () {
            alert("/PetCategory/LoadAllPetCategory error");
        }
    });
};
//Pet category
function generatePetCatID() {
    var id = "PC";
    const possible = "0123456789";
    do {
        for (let i = 0; i < 3; i++) {
            id += possible.charAt(Math.floor(Math.random() * possible.length));
        }
    } while (checkPetCatIDExisted(id));
    $('#petCatIDIns').val(id);
}
function checkPetCatIDExisted(id) {
    $.ajax({
        type: "POST",
        url: "/PetCategory/CheckPetCatIDExisted",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(id),
        success: function (data) {
            if (data === true) {
                return true;
            } else {
                return false;
            }
        },
        error: function () {
            alert("Some error occured at checkPetCatIDExisted.");
        }
    });
}
function insertPetCat() {
    let obj = {
        PetCatId: $('#petCatIDIns').val(),
        PetType: $('#petTypeIns').val()
    }
    $.ajax({
        type: "POST",
        url: "/PetCategory/InsertPetCat",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            alert(data);
            $('#petTypeIns').val('');
            generatePetCatID();
            searchPetCatByLikeType();
        },
        error: function () {
            alert("Insert pet category failed.");
        }
    });
}
function loadPetCat(petCatID, petType) {
    $('#petCatIDUpdt').val(petCatID);
    $('#petTypeUpdt').val(petType);
}
function searchPetCatByLikeType() {
    $.ajax({
        type: "POST",
        url: "/PetCategory/FindPetCatByLikeType",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify($('#petCatSearch').val()),
        success: function (data) {
            if (data !== null) {
                if (data !== null && data.length !== 0) {
                    $('#tbodypetCatSearch').empty();
                    $('#petCatSearch-not-found').css("display", "none");
                    $('#petCatTable').css("display", "table");
                    $.each(data, function () {
                        var row = document.createElement("tr");
                        var tdID = document.createElement("td");
                        var tdType = document.createElement("td");
                        var tdEdit = document.createElement("td");
                        var tdDelete = document.createElement("td");
                        var editLink = document.createElement("a");
                        var deleteLink = document.createElement("a");
                        tdID.innerHTML = this.petCatId;
                        tdType.innerHTML = this.petType;
                        editLink.href = "#petCatTable";
                        editLink.setAttribute("data-toggle", "modal");
                        editLink.setAttribute("data-target", "#modalUpdtPetCatForm");
                        editLink.style = "cursor: pointer";
                        editLink.addEventListener("click", function () {
                            loadPetCat(tdID.innerHTML, tdType.innerHTML);
                        });
                        editLink.innerHTML = "Edit";
                        deleteLink.href = "#petCatTable";
                        deleteLink.style = "cursor: pointer";
                        deleteLink.addEventListener("click", function () {
                            deletePetCat(tdID.innerHTML);
                        });
                        deleteLink.innerHTML = "Delete";
                        tdEdit.appendChild(editLink);
                        tdDelete.appendChild(deleteLink);
                        row.appendChild(tdID);
                        row.appendChild(tdType);
                        row.appendChild(tdEdit);
                        row.appendChild(tdDelete);
                        $('#tbodypetCatSearch').append(row);
                    });
                } else {
                    $('#petCatSearch-not-found').css("display", "block");
                    $('#petCatTable').css("display", "none");
                }
            } else {
                $('#petCatSearch-not-found').css("display", "block");
                $('#petCatTable').css("display", "none");
            }
        },
        error: function () {
            alert("/PetCategory/FindPetCatByLikeType error");
        }
    });
}
function updatePetCat() {
    let obj = {
        PetCatId: $('#petCatIDUpdt').val(),
        PetType: $('#petTypeUpdt').val()
    }
    $.ajax({
        type: "POST",
        url: "/PetCategory/UpdatePetCat",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            alert(data);
            searchPetCatByLikeType();
        },
        error: function () {
            alert("Update pet category failed.");
        }
    });
}
function deletePetCat(id) {
    $.ajax({
        type: "POST",
        url: "/PetCategory/DeletePetCat",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(id),
        success: function (data) {
            alert(data);
            searchPetCatByLikeType();
        },
        error: function () {
            alert("Delete pet category failed. It may contains some other categories.");
        }
    });
}
$(function () {
    searchPetCatByLikeType();
    $('#form-pet-cat-search').submit(function (e) {
        e.preventDefault();
    });
    $('#form-pet-cat-ins').validate({
        rules: {
            petTypeIns: {
                required: true
            }
        },
        messages: {
            petTypeIns: {
                required: "Pet type cannot be epmty.",
                pattern: "Pet type must be 1-40 characters."
            }
        },
        submitHandler: function () {
            insertPetCat();
        }
    });
    $('#form-pet-cat-updt').validate({
        rules: {
            petTypeUpdt: {
                required: true
            }
        },
        messages: {
            petTypeUpdt: {
                required: "Pet type cannot be epmty.",
                pattern: "Pet type must be 1-40 characters."
            }
        },
        submitHandler: function () {
            updatePetCat();
        }
    });
});
//End Pet category

//Accessory category
function generateAccCatID() {
    var id = "AC";
    const possible = "0123456789";
    do {
        for (let i = 0; i < 3; i++) {
            id += possible.charAt(Math.floor(Math.random() * possible.length));
        }
    } while (checkAccCatIDExisted(id));
    $('#accCatIDIns').val(id);
}
function checkAccCatIDExisted(id) {
    $.ajax({
        type: "POST",
        url: "/AccessoryCategory/CheckAccCatIDExisted",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(id),
        success: function (data) {
            if (data === true) {
                return true;
            } else {
                return false;
            }
        },
        error: function () {
            alert("Some error occured at checkAccCatIDExisted.");
        }
    });
}
function insertAccCat() {
    let obj = {
        AccCatId: $('#accCatIDIns').val(),
        AccCatName: $('#accCatNameIns').val(),
        PetCatId: $('#petCatIDInsFr').val()
    }
    $.ajax({
        type: "POST",
        url: "/AccessoryCategory/InsertAccCat",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            alert(data);
            $('#accCatNameIns').val('');
            generateAccCatID();
            searchAccCatByLikeName();
        },
        error: function () {
            alert("Insert accessory category failed.");
        }
    });
}
function loadAccCat(accCatID, accCatName, petCatID) {
    $('#accCatIDUpdt').val(accCatID);
    $('#accCatNameUpdt').val(accCatName);
    $('#petCatIDUpdtFr').val(petCatID);
}
function searchAccCatByLikeName() {
    $.ajax({
        type: "POST",
        url: "/AccessoryCategory/FindAccCatByLikeName",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify($('#accCatSearch').val()),
        success: function (data) {
            if (data !== null) {
                if (data !== null && data.length !== 0) {
                    $('#tbodyaccCatSearch').empty();
                    $('#accCatSearch-not-found').css("display", "none");
                    $('#accCatTable').css("display", "table");
                    $.each(data, function () {
                        var row = document.createElement("tr");
                        var tdID = document.createElement("td");
                        var tdCatName = document.createElement("td");
                        var tdPetType = document.createElement("td");
                        var tdEdit = document.createElement("td");
                        var tdDelete = document.createElement("td");
                        var editLink = document.createElement("a");
                        var deleteLink = document.createElement("a");
                        tdID.innerHTML = this.accCatId;
                        tdCatName.innerHTML = this.accCatName;
                        tdPetType.innerHTML = this.petType;
                        var petCatId = this.petCatId;
                        editLink.href = "#accCatTable";
                        editLink.setAttribute("data-toggle", "modal");
                        editLink.setAttribute("data-target", "#modalUpdtAccCatForm");
                        editLink.style = "cursor: pointer";
                        editLink.addEventListener("click", function () {
                            loadCbPetAccessory('petCatIDUpdtFr');
                            loadAccCat(tdID.innerHTML, tdCatName.innerHTML, petCatId);
                        });
                        editLink.innerHTML = "Edit";
                        deleteLink.href = "#accCatTable";
                        deleteLink.style = "cursor: pointer";
                        deleteLink.addEventListener("click", function () {
                            deleteAccCat(tdID.innerHTML);
                        });
                        deleteLink.innerHTML = "Delete";
                        tdEdit.appendChild(editLink);
                        tdDelete.appendChild(deleteLink);
                        row.appendChild(tdID);
                        row.appendChild(tdCatName);
                        row.appendChild(tdPetType);
                        row.appendChild(tdEdit);
                        row.appendChild(tdDelete);
                        $('#tbodyaccCatSearch').append(row);
                    });
                } else {
                    $('#accCatSearch-not-found').css("display", "block");
                    $('#accCatTable').css("display", "none");
                }
            } else {
                $('#accCatSearch-not-found').css("display", "block");
                $('#accCatTable').css("display", "none");
            }
        },
        error: function () {
            alert("/AccessoryCategory/FindAccCatByLikeName error");
        }
    });
}
function updateAccCat() {
    let obj = {
        AccCatId: $('#accCatIDUpdt').val(),
        AccCatName: $('#accCatNameUpdt').val(),
        PetCatId: $('#petCatIDUpdtFr').val()
    }
    $.ajax({
        type: "POST",
        url: "/AccessoryCategory/UpdateAccCat",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(obj),
        success: function (data) {
            alert(data);
            searchAccCatByLikeName();
        },
        error: function () {
            alert("Update accessory category failed.");
        }
    });
}
function deleteAccCat(id) {
    $.ajax({
        type: "POST",
        url: "/AccessoryCategory/DeleteAccCat",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(id),
        success: function (data) {
            alert(data);
            searchAccCatByLikeName();
        },
        error: function () {
            alert("Delete accessory category failed. It may contains some accessories.");
        }
    });
}
$(function () {
    searchAccCatByLikeName();
    $('#form-acc-cat-search').submit(function (e) {
        e.preventDefault();
    });
    $('#form-acc-cat-ins').validate({
        rules: {
            accCatNameIns: {
                required: true
            }
        },
        messages: {
            accCatNameIns: {
                required: "Accessory caterogy name cannot be epmty.",
                pattern: "Accessory category name must be 1-40 characters."
            }
        },
        submitHandler: function () {
            insertAccCat();
        }
    });
    $('#form-acc-cat-updt').validate({
        rules: {
            accCatNameUpdt: {
                required: true
            }
        },
        messages: {
            accCatNameUpdt: {
                required: "Accessory caterogy name cannot be epmty.",
                pattern: "Accessory category name must be 1-40 characters."
            }
        },
        submitHandler: function () {
            updateAccCat();
        }
    });
});
//End Accessory category
