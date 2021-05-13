window.onload = init;
function init(){
    let vars = {'1':['11','12'],'2':['21', '22']};
    let ddl1l = document.getElementById("ddl1");
    let ddl2l = document.getElementById("ddl2");
    // document.getElementById("test").innerHTML += vars["1"];
    ddl1l.addEventListener('change', function () {
        // document.getElementById("test").innerHTML += vars[ddl1l.value];
        setOptions(ddl2l, vars[ddl1l.value]);
    });
}
// function changeProfiles() {
//     setOptions(document.getElementById("sectionNumber"), profilesByStandard.get(standardDdl.value));
// }

function setOptions(dropDown, options) {
    // clear out any existing values
    dropDown.innerHTML = '';
    // insert the new options into the drop-down
    options.forEach(function(value) {
        let opt = document.createElement('option');
        opt.value = value;
        opt.textContent = value;
        dropDown.appendChild(opt);
    });
}