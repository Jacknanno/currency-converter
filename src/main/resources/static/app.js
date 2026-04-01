// Asynchronous function to handle currency conversion
// 'async' allows us to use 'await' for API calls later
async function convert() {

    // Retrieve the value entered by the user in the "amount" input field
    // parseFloat converts the string input into a decimal number
    const amount = parseFloat(document.getElementById("amount").value);

    // Get the selected source currency from the dropdown/input
    // Convert it to uppercase to match API format (e.g., "usd" → "USD")
    const from = document.getElementById("from").value.toUpperCase();

    // Get the selected target currency and normalize it to uppercase
    const to = document.getElementById("to").value.toUpperCase();

    // Check if the amount is missing, null, 0, or otherwise falsy.
    // This prevents sending an invalid request to the backend.
    if(!amount) {
        // Display an error message to the user in the "result" element
        document.getElementById("result").innerText = "Please enter a valid amount";
        // Stop execution of the function early since input is invalid
        return;
    }
    
    // Provide immediate feedback to the user while waiting for the API response.
    document.getElementById("result").innerText = "Converting...";

    // Send a GET request to the backend conversion endpoint.
    // Pass query parameters: source currency, target currency, and amount.
    const response = await fetch(`/convert?from=${from}&to=${to}&amount=${amount}`);

    // Parse the JSON response from the server into a JavaScript object.
    const data = await response.json();

    
    // This line updates the inner text of the element with the id "result" to display the conversion result.
    document.getElementById("result").innerText =
         `${amount} ${from} → ${data.convertedAmount.toFixed(2)} ${to}`;


}
/* This is not working at the moment but will be resumed soon.
// This event listener waits for the entire HTML document to be loaded and parsed before executing the function.
document.addEventListener("DOMContentLoaded", function () {

    document.getElementById("amount").addEventListener("keydown", function(event) {
        if (event.key === "Enter") {
            convert();
        }
    });

});
*/

// This creates a function called swapCurrencies that swaps the values of the "from" and "to" select elements when called. 
// It uses a temporary variable to hold one of the values during the swap process.
function swapCurrencies() {
    const from = document.getElementById("from");
    const to = document.getElementById("to");

    const temp = from.value;
    from.value = to.value;
    to.value = temp;
}


