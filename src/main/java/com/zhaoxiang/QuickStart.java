package com.zhaoxiang;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

/**
 * Author: RiversLau
 * Date: 2017/9/7 16:56
 */
public class QuickStart {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase mgdb = client.getDatabase("quickstart");

        System.out.println("Connect to MongoDB successfully!" + "Database is " + mgdb.getName());

        MongoCollection<Document> collection = mgdb.getCollection("estimate_table");
        System.out.println("Create collection " + collection.getNamespace() + " successfully!");

        Document patientDoc = new Document().append("patient_id", "100001").append("name", "张三").append("age", 30)
                                    .append("check_time", new Date());
        Document Fugl_MeyerDoc = new Document().append("patient_info", patientDoc)
                .append("question_one", Arrays.asList("Ⅰ无支撑坐位", "0分：不能保持坐位", "1分：能坐，但少于5min", "2分：能坚持坐5min"));

        collection.insertOne(Fugl_MeyerDoc);
        collection.find().forEach(new Block<Document>() {
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });
    }
}
