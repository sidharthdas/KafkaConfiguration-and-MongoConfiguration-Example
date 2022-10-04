package com.core.mongoTesting.employeeservice;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Sidharth Das
 * created on  04/10/22
 */
@Repository
@AllArgsConstructor
public class EmployeeServices {

    private final MongoDatabase mongoDatabase;

    public List<Map<String, Object>> getEmployee(){
        FindIterable<Map> data = mongoDatabase.getCollection("employee").find(Map.class);
        List<Map<String, Object>> list = new ArrayList<>();
        data.forEach(employee -> {
            list.add(employee);
        });
        return list;
    }

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

    public String deleteEmployee(String empName){
        MongoCollection<Document> employeeCollection = mongoDatabase.getCollection("employee");
        Bson searchQuery = Filters.eq("empName", empName);
        employeeCollection.deleteMany(searchQuery);
        return "Deleted Successfully.";
    }

}
