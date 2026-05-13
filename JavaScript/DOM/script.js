// var h1 = document.querySelector('#ab'); // selection
// h1.textContent = "sajhbckdb"

// var h1 = document.getElementsByTagName('h1');
// h1.textContent = "jayshree"

// var apna_Var = document.querySelector("#test")
// apna_Var.style.color = "red";

var apna_Var = document.querySelector('#test');
// apna_Var.classList.add('apna-css');
apna_Var.classList.remove('apna-css');

// creating element
var h1 = document.createElement('h1')
h1.textContent="hello"
h1.classList.add('test')

// adding element
document.querySelector("body").appendChild(h1)

var btn = document.querySelector("button")
// btn.remove();

// ------------------
// Event handling in JS

var btn = document.querySelector("button")
btn.addEventListener('dblclick', function() {
    btn.innerText = "Fuck you"
})