async function convert() {
    const amount = parseFloat(document.getElementById("amount").value);
    const from = document.getElementById("from").value.toUpperCase();
    const to = document.getElementById("to").value.toUpperCase();

    const response = await fetch(`/convert?from=${from}&to=${to}&amount=${amount}`);
    const data = await response.json();

    console.log("API response:", data); 

    document.getElementById("result").innerText =
         `${amount} ${from} = ${data.convertedAmount} ${to}`;
}