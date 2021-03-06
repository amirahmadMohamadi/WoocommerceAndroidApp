package com.test.newshop1.data.database.product.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.newshop1.data.database.product.Image;

import java.lang.reflect.Type;
import java.util.List;

public class ImageConverter {

    @TypeConverter
    public String toString(List<Image> images){
        Gson gson = new Gson();
        return gson.toJson(images);
    }

    @TypeConverter
    public List<Image> fromString(String images){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Image>>() {}.getType();
        return gson.fromJson(images, listType);
    }

}
