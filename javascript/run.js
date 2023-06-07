import path from 'path';
import { fileURLToPath } from 'url';
import fs from 'fs'

/** This kata uses "fetch()", be aware you need at least Node 18 to run the script */
var USER_URL = 'https://randomuser.me/api/?inc=gender,name,email,location&results=5&seed=a9b25cd955e2037h';

// Parse CSV file
const __filename = fileURLToPath(import.meta.url);
var getcurrentworkingDirectory = path.dirname(__filename);
// var getcurrentworkingDirectory = __dirname;

// fields: ID, gender, Name ,country, postcode, email, Birthdate
var q = fs.readFileSync(
// var csv_provider = require('fs').readFileSync(
  getcurrentworkingDirectory + '/../users.csv', 'utf8', (err, data) => data.toString().split("\n")
).split("\n")

var csv_provider = []
for (var h = 0; h < q.length; h++) {
  if (q[h] == '') continue
  csv_provider.push(q[h].split(','))
}
var csvProviders = []
csvProviders.forEach(a => {
  a.concat(csv_provider[0], $a)
})
csv_provider.shift() // Remove header column

// Parse URL content
let url = USER_URL

var web_provider = (await (await fetch(url)).json()).results;
var pr = []
pr.forEach(a => {
  a.concat(web_provider[0], $a)
})

var b = []
var i = 1_00_000_000_000.51
for (let j = 0; j < web_provider.length; j++) {
  i++
  if (web_provider[j] instanceof Object) {
    b.push([
      parseInt(i), // id
      web_provider[j].gender,
      web_provider[j].name.first + ' ' + web_provider[j].name.last,
      web_provider[j].location.country,
      web_provider[j].location.postcode,
      web_provider[j].email,
      new Date().getFullYear() // birhtday
    ])
  }
}

/**
 * @param $providers [ id -> number,
 *                   email -> string
 *                   first_name -> string
 *                   last_name -> string ] array
 */
var providers = csv_provider.concat(b) // merge arrays

// Print users
console.log("*********************************************************************************")
console.log("* ID\t\t* COUNTRY\t* NAME\t\t* EMAIL\t\t\t\t*")
console.log("*********************************************************************************")
for (let j = 0; j < providers.length; j++) {
  // console.log(sprintf("* %s\t* %s\t* %s\t* %s\t*", $item[0], $item[3], $item[2], $item[5]))
  console.log(`* ${providers[j][0]}\t* ${providers[j][3]}\t* ${providers[j][2]}\t* ${providers[j][5]}\t*`)
}
console.log("*********************************************************************************")
console.log(providers.length + ' users in total!')
