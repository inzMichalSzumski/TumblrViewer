package com.szumal.tumblrviewer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by szuma on 18.01.2018.
 */

public class functions extends AppCompatActivity {
    public static List<Button> btnContainer = new ArrayList<Button>();
    public static List<Bitmap> bitmaps = new ArrayList<Bitmap>();
    public static List<singlePost> posts = new ArrayList<singlePost>();

    static void getXML(final LinearLayout lila, final String username, final Context cst){

        Thread thread1 = new Thread() {
            @Override
            public void run() {

                btnContainer.clear();
                posts.clear();

                Document doc;
                String uri =
                        "https://" + username + ".tumblr.com/api/read?num=10";

                try {
                    URL url = new URL(uri);
                    HttpURLConnection connection =
                            (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Accept", "application/xml");

                    InputStream xml = connection.getInputStream();

                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    doc = db.parse(xml);
                    doc.getDocumentElement().normalize();

                    NodeList nList = doc.getElementsByTagName("post");

                    for (int i = 0; i < nList.getLength(); i++) {

                        Node nNode = nList.item(i);
                        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) nNode;
                            try {

                                posts.add(new singlePost());
                                posts.get(posts.size() - 1).setId(Long.parseLong(eElement.getAttribute("id")));
                                try {
                                    posts.get(posts.size() - 1).setTitle(eElement.getElementsByTagName("regular-title").item(0).getTextContent());
                                } catch (Exception e){
                                    posts.get(posts.size() - 1).setTitle("No title");
                                }
                                try {
                                    posts.get(posts.size() - 1).setText(eElement.getElementsByTagName("regular-body").item(0).getTextContent());
                                } catch (Exception e){
                                    posts.get(posts.size() - 1).setText("");
                                }
                                try {
                                    posts.get(posts.size() - 1).setTags(eElement.getElementsByTagName("tag").item(0).getTextContent());
                                } catch (Exception e){
                                    posts.get(posts.size() - 1).setTags("");
                                }
                                try {
                                    posts.get(posts.size() - 1).setImgurl(eElement.getElementsByTagName("photo-url").item(0).getTextContent());
                                    bitmaps.add(BitmapFactory.decodeStream((new URL(eElement.getElementsByTagName("photo-url").item(0).getTextContent())).openConnection().getInputStream()));
                                } catch (Exception e){
                                    posts.get(posts.size() - 1).setImgurl("");
                                    bitmaps.add(null);
                                }
                                posts.get(posts.size() - 1).setDate(eElement.getAttribute("date"));

                            } catch (Exception f){
                                System.out.println(f.toString());
                            }
                        }
                                btnContainer.add(new Button(cst));
                                btnContainer.get(i).setText(posts.get(i).getTitle());
                                btnContainer.get(i).setTag(String.valueOf(i));
                                btnContainer.get(i).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        System.out.println(v.getTag());
                                        Intent _intent = new Intent(v.getContext(), postActivity.class);
                                        _intent.putExtra("postNr", v.getTag().toString());
                                        v.getContext().startActivity(_intent);
                                    }
                                });
                                lila.addView(btnContainer.get(i));
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        };

        thread1.start();
        try {
            thread1.join();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}