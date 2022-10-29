function insertions() {
		const par1 = document.querySelector("#p1");
		par1.insertAdjacentHTML("afterend", "<p>inséré après le 1er paragraphe</p>");
		const paraC1 = Array.from(document.querySelectorAll(".c1"));
		for (const par of paraC1) {
				par.insertAdjacentHTML("afterbegin", "(inséré au début) ");
				par.insertAdjacentHTML("beforeend", " (inséré à la fin)");
		}
}