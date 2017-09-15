package com.zhaoxiang.quickStart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: RiversLau
 * Date: 2017/9/15 15:58
 */
public class SchoolGradeScoreTest {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase mgdb = client.getDatabase("school");

        String[] hobby = new String[]{"drawing", "swimming", "dance", "singing", "reading"};

        Set<String> studentHobby;
        MongoCollection<Document> grade11 = mgdb.getCollection("grade_1_4");
        for (int i = 1; i <= 10; i++) {
            int hobbyNum = (int)Math.round(Math.random() * 4 + 1);
            studentHobby = new HashSet<String>(hobbyNum);
            for (int j = 0; j < hobbyNum; j++) {
                int index = (int)Math.round(Math.random() * 4);
                studentHobby.add(hobby[index]);
            }
            JSONObject json = new JSONObject();
            json.put("chinese", 60 + Math.round(Math.random() * 40));
            json.put("math", 60 + Math.round(Math.random() * 40));
            json.put("english", 60 + Math.round(Math.random() * 40));
            grade11.insertOne(new Document().append("name", "Zhangsan" + i).
                    append("age", Math.round(Math.random() * 6 + 3)).
                    append("sex", Math.round(Math.random() * 10 % 2)).
                    append("hobby", studentHobby).
                    append("score", json));
        }

        client.close();
    }
}
