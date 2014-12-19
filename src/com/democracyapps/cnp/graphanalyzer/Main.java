package com.democracyapps.cnp.graphanalyzer;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main {

    public static void main(String[] args) {
        System.out.println("GraphAnalyzer - starting up ...");
        try {
            if (args.length < 1) {
                System.err.println("GraphAnalyzer usage:  graphanalyzer run-directory");
                System.exit(1);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println(" Got run directory: " + args[0]);
        String filePath = args[0] + "/ga.json";
        FileReader fr = null;
        try {
            fr = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        BufferedReader reader = new BufferedReader(fr);
        String contents = "";
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                contents += line;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println(contents);
        JSONParser parser = new JSONParser();

        try {

            String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
            Object obj = parser.parse(s);
            JSONArray array = (JSONArray) obj;
            System.out.println("======the 2nd element of array======");
            System.out.println(array.get(1));
            System.out.println();

            JSONObject obj2 = (JSONObject) array.get(1);
            System.out.println("======field \"1\"==========");
            System.out.println(obj2.get("1"));

            obj = parser.parse(contents);
            JSONObject o2 = (JSONObject) obj;
            JSONArray ar2 = (JSONArray) o2.get("sets");
            System.out.println("My name is " + o2.get("name"));
            System.out.println("And here's the array" + ar2.get(0));

        }
        catch (Exception e) {
            e.printStackTrace();
        }


	// write your code here
    }
}
