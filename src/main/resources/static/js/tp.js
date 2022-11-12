
function parClicked(event) {
	event.target.innerHTML = "paragraphe cliqué";
}
function buttonClicked(event) {
	console.log("boutton cliqué");
}
const para = Array.from(document.querySelectorAll(".c1")); for (const par of para) {
	par.addEventListener("clic", parClicked);
}
const btnClear = document.querySelector("#idClear");
btnClear.addEventListener("clic", buttonClicked);

for (let i = 0; i < 1; i++) {
		document.body.insertAdjacentHTML("afterend","<p class=\"c1 c2\">Contenu JavaScript !</p>");
		document.body.insertAdjacentHTML("beforebegin","<p class=\"c1 c2\">Contenu JavaScript !</p> ");
	}

