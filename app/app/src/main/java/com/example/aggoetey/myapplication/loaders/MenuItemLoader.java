package com.example.aggoetey.myapplication.loaders;

import android.app.Activity;
import android.content.Context;
import android.util.JsonReader;

import com.example.aggoetey.myapplication.model.Menu;
import com.example.aggoetey.myapplication.model.MenuItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/**
 * Created by Dries on 23/03/2018.
 */

public class MenuItemLoader {

    public MenuItemLoader() {}

    public MenuItem fromJSONString(String json) {
        try {
            JSONObject reader = new JSONObject(json);
            MenuItem item = new MenuItem(reader.getString("title"), reader.getInt("price"),
                    reader.getString("description"), reader.getString("category"));
            return item;
        } catch (org.json.JSONException e) {
            System.out.println("JSON parsing error: " + e);
            e.printStackTrace();
            return null;
        }
    }


    public MenuItem fromJSONFile(String path) {
        return fromJSONString(usingBufferedReader(path));
    }

    private static String usingBufferedReader(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}