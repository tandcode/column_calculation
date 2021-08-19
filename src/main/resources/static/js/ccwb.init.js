window.addEventListener("load", init);

const standardDdl = document.getElementById("sectionStandard");
const weldedInputBlock = document.getElementById("welded_section_input");
const shapedInputBlock = document.getElementById("shaped_section_input");
const gost8239_89 = document.getElementById("gost8239-89");
const gost19425_74IBeam = document.getElementById("gost19425-74-i-beam");
const gost8240_89p = document.getElementById("gost8240-89p");
const gost8240_89s = document.getElementById("gost8240-89s");
const gost302245_94r = document.getElementById("gost302245-94r");
const gost302245_94s = document.getElementById("gost302245-94s");
const sectionCheck = document.getElementById("sectionType");
const profilesDdl = document.getElementById("sectionNumber");

function chooseStandard() {

    switch ($("input[type='radio'][name='sectionType']:checked").val()) {
        case "I_BEAM":
            standardDdl.value=gost8239_89.value;
            gost8239_89.style.display = "block";
            gost19425_74IBeam.style.display = "block";
            gost8240_89p.style.display = "none";
            gost8240_89s.style.display = "none";
            gost302245_94r.style.display = "none";
            gost302245_94s.style.display = "none";
            weldedInputBlock.style.display = "none";
            shapedInputBlock.style.display = "block";
            break;
        case "U_PROFILE":
            standardDdl.value=gost8240_89p.value;
            gost8239_89.style.display = "none";
            gost19425_74IBeam.style.display = "none";
            gost8240_89p.style.display = "block";
            gost8240_89s.style.display = "block";
            gost302245_94r.style.display = "none";
            gost302245_94s.style.display = "none";
            weldedInputBlock.style.display = "none";
            shapedInputBlock.style.display = "block";
            break;
        case "HOLLOW":
            standardDdl.value=gost302245_94r.value;
            gost8239_89.style.display = "none";
            gost19425_74IBeam.style.display = "none";
            gost8240_89p.style.display = "none";
            gost8240_89s.style.display = "none";
            gost302245_94r.style.display = "block";
            gost302245_94s.style.display = "block";
            weldedInputBlock.style.display = "none";
            shapedInputBlock.style.display = "block";
            break;
        case "WELDED_I_BEAM":
            weldedInputBlock.style.display = "block";
            shapedInputBlock.style.display = "none";
    }
    setSectionNumbers();
}

function init() {
    setSectionNumbers();
    if(input.sectionType !== null) $('#' + input.sectionType).click();
    standardDdl.addEventListener('change', function () {
        setSectionNumbers();
    });
    sectionCheck.addEventListener('change', function () {
        setSectionNumbers();
    });
    eraseSabeButtAndResultOnChange();
}

function setSectionNumbers() {
    const sectionNumberDdl = profilesDdl;
    const sectionNumbers = profilesByStandard[standardDdl.value];

    sectionNumberDdl.innerHTML = '';
    sectionNumbers.forEach(function(sectionNumber) {
        const opt = document.createElement('option');
        opt.value = sectionNumber;
        opt.textContent = sectionNumber;
        if(sectionNumber === curSectionNumber) {
            opt.selected = true;
        }
        sectionNumberDdl.appendChild(opt);
    });
}

function eraseSabeButtAndResultOnChange() {
    document.querySelectorAll('.btn-check, .form-select, .form-control').forEach(input => {
        input.addEventListener('change', event => {
            const saveBlock = document.getElementById("saveBlock");
            const resultBlock = document.getElementById("resultBlock");
            saveBlock.style.display = "none";
            resultBlock.style.display = "none";
        })
    })
}