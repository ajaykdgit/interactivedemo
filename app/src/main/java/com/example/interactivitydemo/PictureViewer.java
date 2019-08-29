package com.example.interactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class PictureViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_viewer);
    }

    ArrayList<CreateList> createLists = prepareData();

    public class CreateList {
        private String image_title;
        private Integer image_id;

        public String getImage_title() {
            return image_title;
        }

        public void setImage_title(String android_version_name) {
            this.image_title = android_version_name;
        }

        public Integer getImage_ID() {
            return image_id;
        }

        public void setImage_ID (Integer android_image_url) {
            this.image_id = android_image_url;
        }
    }

    private ArrayList<CreateList> prepareData() {
        ArrayList<CreateList> theimage = new ArrayList<>();
//        for (int i=0;i<theimage.)
        return  theimage;
    }


    public void getImages(View view) {
        ArrayList<CreateList> theImage = new ArrayList<>();

        String path = Environment.getRootDirectory().toString();
        File f = new File(path);
        File file[] = f.listFiles();
        for (int i=0; i < file.length; i++) {
            CreateList createList = new CreateList();
            createList.setImage_title(""); // image title
            createList.setImage_ID(1);     // set image id
            theImage.add(createList);
        }
    }

}
