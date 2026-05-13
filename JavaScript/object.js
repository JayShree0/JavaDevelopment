const student = {
    name: "jayshree",
    age: 16,
    course: "Java"
}

console.log(student.name)

// bracket notation
console.log(student["age"])


// adding/ updating/ deleting

student.name="Raj";
student.add="Agra"
console.log(student)

delete student.add;
console.log(student)


const user = {
    name:"Raj",
    address: {
        city: "Agra",
        state: "UP"
    }
}


console.log(user)
console.log(user.address)
console.log(user.address.city)



const person = {
    name : "Aman",
    welcome(){
        console.log(`Hello I am ${this.name}`)
    }
}


person.welcome();
// Here, this refers to the current object (person) that calls the method.

const obj = {
    name: "karan",
    age: 16,
    course: "Java"
}


for(let key in obj)
{
    console.log(`${key}: ${obj[key]}`)
}

Object.keys(obj).forEach(key=>{
    console.log(`${key}: ${obj[key]}`)
})

Object.values(obj).forEach((v)=>{
    console.log(v);
    
})