async function convert() {
    const amount = parseFloat(document.getElementById("amount").value);
    const from = document.getElementById("from").value.toUpperCase();
    const to = document.getElementById("to").value.toUpperCase();

    if(!amount) {
        document.getElementById("result").innerText = "Please enter a valid amount";
        return;
    }

    document.getElementById("result").innerText = "Converting...";

    const response = await fetch(`/convert?from=${from}&to=${to}&amount=${amount}`);
    const data = await response.json();

    

    document.getElementById("result").innerText =
         `${amount} ${from} → ${data.convertedAmount.toFixed(2)} ${to}`;


}
function swapCurrencies() {
    const from = document.getElementById("from");
    const to = document.getElementById("to");

    const temp = from.value;
    from.value = to.value;
    to.value = temp;
}
