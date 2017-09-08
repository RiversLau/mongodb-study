package com.zhaoxiang.quickStart;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.zhaoxiang.component.CategoryComponent;
import com.zhaoxiang.component.PatientInfoComponent;
import com.zhaoxiang.component.ResultComponent;
import com.zhaoxiang.component.SimpleLevelComponent;
import com.zhaoxiang.tables.JOA001Table;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: RiversLau
 * Date: 2017/9/8 10:48
 */
public class TableDocTest {

    public static void main(String[] args) {

        JOA001Table joa001Table = initialJOATable();

        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase mgdb = client.getDatabase("estimate_tables");

        System.out.println("Connect to MongoDB successfully!" + "Database is " + mgdb.getName());

        MongoCollection<Document> collection = mgdb.getCollection("estimate_table");
        System.out.println("Create collection " + collection.getNamespace() + " successfully!");

        String jsonStr = JSONObject.toJSONString(joa001Table);
        collection.insertOne(Document.parse(jsonStr));

        collection.find().forEach(new Block<Document>() {
            public void apply(Document document) {
                System.out.println(document.toJson());
            }
        });

        client.close();
    }

    private static JOA001Table initialJOATable() {

        JOA001Table joa001Table = new JOA001Table();
        joa001Table.setName("腰椎JOA评分表");
        joa001Table.setRemark("满分29分，差：<10分；中度：10－15分；良好：16－24分；优：25－29分。治疗改善率＝[（治疗后评分－治疗前评分）÷（满分29－治疗前评分)]×100％　　优：>=75%；良50－74％；中：25－49％；差：0－24％。通过改善指数可反映患者治疗前后腰椎功能的改善情况，通过改善率可了解临床治疗效果。改善率还可对应于通常采用的疗效判定标准：改善率为100%时为治愈，改善率大于60%为显效，25-60%为有效，小于25%为无效。");

        joa001Table.setPatientInfoComponent(initialPatientInfo());

        ResultComponent resultComponent = new ResultComponent();
        joa001Table.setResultComponent(resultComponent);

        joa001Table.setSubjective(initialSubjectiveList());
        joa001Table.setClinlcal(initialClinlcal());
        joa001Table.setLife(initialLife());

        joa001Table.setBladder(initialBladder());

        return joa001Table;
    }

    private static PatientInfoComponent initialPatientInfo() {

        PatientInfoComponent patientInfo = new PatientInfoComponent();
        patientInfo.setPatientUserId("100001");
        patientInfo.setAge(35);
        patientInfo.setName("Don't Know");
        patientInfo.setSex("男");
        patientInfo.setDeptName("康复科");
        patientInfo.setBedNum("1220");
        patientInfo.setInHospitalNum("200001");

        return patientInfo;
    }

    private static CategoryComponent initialSubjectiveList() {

        List<SimpleLevelComponent> subjetiveList = new ArrayList<SimpleLevelComponent>();
        SimpleLevelComponent slc1 = new SimpleLevelComponent();
        slc1.setItemName("下腰背痛");
        slc1.setEstimateRules("无任何疼痛（3分）\n" + "偶尔轻微疼痛（2分）\n" + "频发轻微疼痛或偶发严重疼痛（1分）\n" + "频发或持续严重疼痛（0分）\n");
        subjetiveList.add(slc1);

        SimpleLevelComponent slc2 = new SimpleLevelComponent();
        slc2.setItemName("腿疼兼/或麻刺痛");
        slc2.setEstimateRules("无任何疼痛（3分）\n" + "偶尔轻微疼痛（2分）\n" + "频发轻微疼痛或偶发严重疼痛（1分）\n" + "频发或持续严重疼痛（0分）\n");
        subjetiveList.add(slc2);

        SimpleLevelComponent slc3 = new SimpleLevelComponent();
        slc3.setItemName("步态");
        slc3.setEstimateRules("正常（3分）\n" + "即使感觉肌肉无力，也可步行超过500米（2分）\n" + "步行＜500米，即出现腿疼，刺痛，无力（1分）\n" + "步行＜100米，即出现腿疼，刺痛，无力（0分）\n");
        subjetiveList.add(slc3);

        CategoryComponent subComponent = new CategoryComponent();
        subComponent.setName("主观症状");
        subComponent.setType("");
        subComponent.setComponentList(subjetiveList);

        return subComponent;
    }

    private static CategoryComponent initialClinlcal() {

        List<SimpleLevelComponent> clinlcalList = new ArrayList<SimpleLevelComponent>();
        SimpleLevelComponent slc1 = new SimpleLevelComponent();
        slc1.setItemName("直腿抬高试验（包括加强实验）");
        slc1.setEstimateRules("正常（2分）\n" + "30-70°（1分）\n" + "＜30°（0分）\n");
        clinlcalList.add(slc1);

        SimpleLevelComponent slc2 = new SimpleLevelComponent();
        slc2.setItemName("感觉障碍");
        slc2.setEstimateRules("无（2分）\n" + "轻度障碍（1分）\n" + "明显障碍（0分）\n");
        clinlcalList.add(slc2);

        SimpleLevelComponent slc3 = new SimpleLevelComponent();
        slc3.setItemName("运动障碍");
        slc3.setEstimateRules("正常，肌力5级（2分）\n" + "轻度无力，肌力4级（1分）\n" + "明显无力，肌力0-3级（0分）\n");
        clinlcalList.add(slc3);

        CategoryComponent subComponent = new CategoryComponent();
        subComponent.setName("临床症状");
        subComponent.setType("");
        subComponent.setComponentList(clinlcalList);

        return subComponent;
    }

    private static CategoryComponent initialLife() {

        List<SimpleLevelComponent> lifeList = new ArrayList<SimpleLevelComponent>();
        SimpleLevelComponent slc1 = new SimpleLevelComponent();
        slc1.setItemName("平卧翻身");
        slc1.setEstimateRules("正常（2分）\n" +
                "轻度受限（1分）\n" +
                "明显受限（0分）\n");
        lifeList.add(slc1);

        SimpleLevelComponent slc2 = new SimpleLevelComponent();
        slc2.setItemName("站立大约1小时");
        slc2.setEstimateRules("正常（2分）\n" +
                "轻度受限（1分）\n" +
                "明显受限（0分）\n");
        lifeList.add(slc2);

        SimpleLevelComponent slc3 = new SimpleLevelComponent();
        slc3.setItemName("洗漱");
        slc3.setEstimateRules("正常（2分）\n" +
                "轻度受限（1分）\n" +
                "明显受限（0分）\n");
        lifeList.add(slc3);

        SimpleLevelComponent slc4 = new SimpleLevelComponent();
        slc4.setItemName("前屈");
        slc4.setEstimateRules("正常（2分）\n" +
                "轻度受限（1分）\n" +
                "明显受限（0分）\n");
        lifeList.add(slc4);

        SimpleLevelComponent slc5 = new SimpleLevelComponent();
        slc5.setItemName("坐位");
        slc5.setEstimateRules("正常（2分）\n" +
                "轻度受限（1分）\n" +
                "明显受限（0分）\n");
        lifeList.add(slc5);

        SimpleLevelComponent slc6 = new SimpleLevelComponent();
        slc6.setItemName("举重物");
        slc6.setEstimateRules("正常（2分）\n" +
                "轻度受限（1分）\n" +
                "明显受限（0分）\n");
        lifeList.add(slc6);

        SimpleLevelComponent slc7 = new SimpleLevelComponent();
        slc7.setItemName("行走");
        slc7.setEstimateRules("正常（2分）\n" +
                "轻度受限（1分）\n" +
                "明显受限（0分）\n");
        lifeList.add(slc7);

        CategoryComponent subComponent = new CategoryComponent();
        subComponent.setName("临床症状");
        subComponent.setType("");
        subComponent.setComponentList(lifeList);

        return subComponent;
    }

    private static SimpleLevelComponent initialBladder() {

        SimpleLevelComponent slc = new SimpleLevelComponent();
        slc.setItemName("膀胱功能");
        slc.setEstimateRules("正常（0分）\n" + "轻度受限（-3分）\n" + "明显受限（尿储留、尿失禁）（-6分）");

        return slc;
    }
}
