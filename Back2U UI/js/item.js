const API_BASE = "http://localhost:8080/back2u";

// Add Item
document.getElementById("addItemForm")?.addEventListener("submit", async (e) => {
    e.preventDefault();
    const data = {
        itemTitle: document.getElementById("itemTitle").value,
        itemDescription: document.getElementById("itemDescription").value,
        itemCategory: document.getElementById("itemCategory").value,
        missedLocation: document.getElementById("missedLocation").value,
        userMail: document.getElementById("userMail").value,
        itemStatus: document.getElementById("itemStatus").value
    };
    const res = await fetch(`${API_BASE}/additem`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    });
    const result = await res.text();
    document.getElementById("response").innerText = result;
});

// Fetch Items
async function fetchItems() {
    const res = await fetch(`${API_BASE}/items`);
    return await res.json();
}
