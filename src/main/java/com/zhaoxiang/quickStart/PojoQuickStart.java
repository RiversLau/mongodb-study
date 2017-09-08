package com.zhaoxiang.quickStart;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.zhaoxiang.domain.Address;
import com.zhaoxiang.domain.Person;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.File;

import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Author: RiversLau
 * Date: 2017/9/8 15:29
 */
public class PojoQuickStart {

    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost", 27017);

        final CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoDatabase mgdb = client.getDatabase("quickstart").withCodecRegistry(pojoCodecRegistry);

        System.out.println("Connect to MongoDB successfully!" + "Database is " + mgdb.getName());

        MongoCollection<Person> collection = mgdb.getCollection("perpson", Person.class);
        System.out.println("Create collection " + collection.getNamespace() + " successfully!");

//        collection.deleteMany(Filters.eq("name", "HelloMG"));

        Person person = new Person();
        person.setName("RiversLau");
        person.setAge(28);
        Address address = new Address();
        address.setCity("NewYork");
        address.setStreet("Madison Square Garden");
        address.setZip("20-30-4008");
        person.setAddress(address);
//        collection.insertOne(person);

        collection.find().forEach(new Block<Person>() {
            public void apply(Person person) {
                System.out.println(person.toString());
            }
        });

        collection.find(Filters.eq("address.city", "LA")).forEach(new Block<Person>() {
            public void apply(Person person) {
                System.out.println(person.getName());
            }
        });

        Person first = collection.find(Filters.eq("address.city", "LA")).first();
        System.out.println(first.getName());

        Person second = collection.find(Filters.gt("age", 3)).first();
        System.out.println(second.getName());

        collection.updateOne(Filters.eq("name", "HelloMG"), combine(set("name", "Kobe Bryant"), set("age", 39)));
        collection.find().forEach(new Block<Person>() {
            public void apply(Person person) {
                System.out.println(person.toString());
            }
        });

        collection.updateMany(Filters.eq("description", null), set("description", "NBA Legend Players!"));
        collection.find().forEach(new Block<Person>() {
            public void apply(Person person) {
                System.out.println(person.toString());
            }
        });

        collection.deleteOne(Filters.eq("name", "RiversLau"));
        collection.deleteMany(Filters.eq("description", "NBA Legend Players!"));

        client.close();
    }
}
