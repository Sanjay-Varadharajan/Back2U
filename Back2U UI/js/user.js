const USER_API = "http://localhost:8080/back2u";

// Add User
document.getElementById("addUserForm")?.addEventListener("submit", async (e) => {
    e.preventDefault();
    const data = {
        userName: document.getElementById("userName").value,
        userMail: document.getElementById("userMail").value,
        userPhone: document.getElementById("userPhone").value
    };
    const res = await fetch(`${USER_API}/adduser`, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    });
    const result = await res.text();
    document.getElementById("response").innerText = result;
});

// Fetch Users
async function fetchUsers() {
    const res = await fetch(`${USER_API}/users`);
    return await res.json();
}
    