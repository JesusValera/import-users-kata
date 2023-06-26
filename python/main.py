import os
import csv
import json
import urllib.request
import datetime

USER_URL = 'https://randomuser.me/api/?inc=gender,name,email,location&results=5&seed=a9b25cd955e2037h'

# Parse CSV file
getcurrentworkingDirectory = os.getcwd()

# fields: ID, gender, Name ,country, postcode, email, Birthdate
with open(os.path.join(getcurrentworkingDirectory, '../users.csv'), 'r') as f:
    reader = csv.reader(f)
    csv_provider = list(reader)

csvProviders = []
for a in csv_provider:
    csvProviders.append(csv_provider[0] + a)
csv_provider.pop(0)  # Remove header column

# Parse URL content
url = USER_URL
with urllib.request.urlopen(url) as response:
    web_provider = json.loads(response.read())['results']

pr = []
for a in web_provider:
    pr.append(web_provider[0].update(a))

b = []
i = 100000000000.51
for item in web_provider:
    i += 1
    if isinstance(item, dict):
        b.append([
            int(i),  # id
            item['gender'],
            item['name']['first'] + ' ' + item['name']['last'],
            item['location']['country'],
            item['location']['postcode'],
            item['email'],
            datetime.datetime.now().strftime('%Y')  # birthday
        ])

# merge arrays
providers = csv_provider + b

# Print users
print("*********************************************************************************")
print("* ID\t\t* COUNTRY\t* NAME\t\t* EMAIL\t\t\t\t*")
print("*********************************************************************************")
for j in range(len(providers)):
    print(f"* {providers[j][0]}\t* {providers[j][3]}\t* {providers[j][2]}\t* {providers[j][5]}\t*")
print("*********************************************************************************")
print(f"{len(providers)} users in total!")

