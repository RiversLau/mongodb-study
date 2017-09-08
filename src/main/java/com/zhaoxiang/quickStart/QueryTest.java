package com.zhaoxiang.quickStart;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;

/**
 * Author: RiversLau
 * Date: 2017/9/8 14:05
 */
public class QueryTest {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase mgdb = client.getDatabase("estimate_tables");

        System.out.println("Connect to MongoDB successfully!" + "Database is " + mgdb.getName());

        MongoCollection<Document> collection = mgdb.getCollection("estimate_table");
        System.out.println("Create collection " + collection.getNamespace() + " successfully!");

        collection.find().forEach(new Block<Document>() {
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });
        collection.find(Filters.eq("patientInfoComponent.patientUserId", "100001")).forEach(new Block<Document>() {
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });
        collection.find(new Document().append("patientInfoComponent.patientUserId", "100001")).forEach(new Block<Document>() {
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });
        collection.find(Filters.eq("patientInfoComponent.patientUserId", "100001")).projection(Projections.include("resultComponent")).forEach(new Block<Document>() {
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });

        client.close();
    }
}
