import json
import random
import faker

# Initialize the Faker library
fake = faker.Faker()

# Generate a list of departments
departments = ["HR", "IT", "Finance", "Marketing", "Sales"]

# Generate the data
people_data = []
for i in range(1, 10001):
    person = {
        "id": i,
        "name": fake.name(),
        "age": random.randint(18, 65),
        "salary": round(random.uniform(30000, 150000), 2),
        "department": random.choice(departments)
    }
    people_data.append(person)

# Convert the data to JSON format
people_data_json = json.dumps(people_data, indent=4)

# Save to a file
file_path = "D:\Learn\Java\JavaLearn\src\main\resources\people_data.json"
with open(file_path, "w") as f:
    f.write(people_data_json)

file_path
