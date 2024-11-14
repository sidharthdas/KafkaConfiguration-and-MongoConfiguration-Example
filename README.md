
# Project Configuration for KafkaConfiguration-and-MongoConfiguration-Example
Required java 17 and kafka in local system

# Kafka Operation:

- Send Data To Kafka Topic

```
kafkaBean.publishRecords("test1", 0, "test", "hello world", null);
```

- Read Data From Kafka Topic

```
ConsumerRecord c1 = (ConsumerRecord) consumerRecords.records("test1").iterator().next();
        System.out.println("Value : "+ c1.value());
        System.out.println("Key : " +  c1.key());
```



# MongoDB Operation:

- Search Operation

```
public List<Map<String, Object>> getEmployee(){
        FindIterable<Map> data = mongoDatabase.getCollection("employee").find(Map.class);
        List<Map<String, Object>> list = new ArrayList<>();
        data.forEach(employee -> {
            list.add(employee);
        });
        return list;
    }
```
- Search Operation (Get Particular Object)

```
public Map<String, Object> getEmployeeByName(String empName){
        FindIterable<Map> data = mongoDatabase.getCollection("employee").find(new Document("empName", empName),Map.class);
        return data.first();
    }
```

- Insert Operation

```
public String insertEmployee(Map<String, Object> map) {
        MongoCollection<Document> employeeCollection = mongoDatabase.getCollection("employee");
        String empId = (String)map.get("empId");
        Bson searchQuery = Filters.eq("_id", empId);
        Document document = new Document(map);
        document.putIfAbsent("_id", empId);
        ReplaceOptions options = new ReplaceOptions().upsert(true);
        employeeCollection.replaceOne(searchQuery, document, options);
        return "Inserted successfully";

    }
```

- Update Operation

```
public String updateEmployee(Map<String, Object> map){
        MongoCollection<Document> employeeCollection = mongoDatabase.getCollection("employee");
        String empId = (String)map.get("empId");
        Bson searchQuery = Filters.eq("_id", empId);
        Document document = new Document(map);
        document.putIfAbsent("_id", empId);
        ReplaceOptions options = new ReplaceOptions().upsert(false);
        employeeCollection.replaceOne(searchQuery, document, options);
        return "Updated successfully";
    }
```

- Delete Operation

```
public String deleteEmployee(String empName){
        MongoCollection<Document> employeeCollection = mongoDatabase.getCollection("employee");
        Bson searchQuery = Filters.eq("empName", empName);
        employeeCollection.deleteMany(searchQuery);
        return "Deleted Successfully.";
    }
```


