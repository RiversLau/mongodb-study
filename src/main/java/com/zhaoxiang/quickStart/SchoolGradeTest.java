package com.zhaoxiang.quickStart;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: RiversLau
 * Date: 2017/9/15 12:01
 */
public class SchoolGradeTest {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase mgdb = client.getDatabase("school");

        String[] hobby = new String[]{"drawing", "swimming", "dance", "singing", "reading"};

        Set<String> studentHobby;
        MongoCollection<Document> grade11 = mgdb.getCollection("grade_1_1");
        for (int i = 1; i <= 10; i++) {
            int hobbyNum = (int)Math.round(Math.random() * 4 + 1);
            studentHobby = new HashSet<String>(hobbyNum);
            for (int j = 0; j < hobbyNum; j++) {
                int index = (int)Math.round(Math.random() * 4);
                studentHobby.add(hobby[index]);
            }
            grade11.insertOne(new Document().append("name", "Zhangsan" + i).
                    append("age", Math.round(Math.random() * 6 + 3)).append("sex", Math.round(Math.random() * 10 % 2)).append("hobby", studentHobby));
        }

        MongoCollection<Document> grade12 = mgdb.getCollection("grade_1_2");
        for (int i = 1; i <= 10; i++) {
            int hobbyNum = (int)Math.round(Math.random() * 4 + 1);
            studentHobby = new HashSet<String>(hobbyNum);
            for (int j = 0; j < hobbyNum; j++) {
                int index = (int)Math.round(Math.random() * 4);
                studentHobby.add(hobby[index]);
            }
            grade12.insertOne(new Document().append("name", "Zhangsan" + i).
                    append("age", Math.round(Math.random() * 6 + 3)).append("sex", Math.round(Math.random() * 10 % 2)).append("hobby", studentHobby));
        }

        MongoCollection<Document> grade13 = mgdb.getCollection("grade_1_3");
        for (int i = 1; i <= 10; i++) {
            int hobbyNum = (int)Math.round(Math.random() * 4 + 1);
            studentHobby = new HashSet<String>(hobbyNum);
            for (int j = 0; j < hobbyNum; j++) {
                int index = (int)Math.round(Math.random() * 4);
                studentHobby.add(hobby[index]);
            }
            grade13.insertOne(new Document().append("name", "Zhangsan" + i).
                    append("age", Math.round(Math.random() * 6 + 3)).append("sex", Math.round(Math.random() * 10 % 2)).append("hobby", studentHobby));
        }

        client.close();
    }
}
