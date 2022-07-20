package main.java.Lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;

public class LambdaProvider implements RequestHandler<String, ArrayList<String>> {
    @Override
    public ArrayList<String> handleRequest(String input, Context context) {
        return null;
    }
}
