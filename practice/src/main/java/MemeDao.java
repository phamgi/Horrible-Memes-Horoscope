package main.java;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


import java.util.ArrayList;

public class MemeDao {
    private AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
        .withRegion(Regions.US_WEST_2).build();
    private final DynamoDBMapper dynamoDBMapper;

    public MemeDao() {
        dynamoDBMapper = new DynamoDBMapper(dynamoDBClient);
    }

    public ArrayList<Meme> saveMemeList(ArrayList<Meme> memes) {
        for (Meme meme:memes) {
            dynamoDBMapper.save(meme);
        }
        return memes;
    }

}
