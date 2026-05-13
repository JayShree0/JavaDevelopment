// all student data url
const apiurl = 'http://localhost:8080/students'

// function to fetch and display user data 
function fetchStdData() {
    fetch(apiurl)
        .then(response => response.json())
        .then(data => {
            const userTableBody = document.querySelector('#userTable tbody')

            // clear any existing data in the table
            userTableBody.innerHTML = "";

            // Loop through the data and create table rows
            data.forEach(user => {
                const row = document.createElement('tr')

                // create table cells for each piece of data 
                row.innerHTML = `
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                `;

                // Append the row to the table body
                userTableBody.appendChild(row);
            })
        })
        .catch(error => {
            console.log("Error fetching data: ", error);
        })
}

// calling fetchStdData
window.onload = fetchStdData;