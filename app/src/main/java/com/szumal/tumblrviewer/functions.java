package com.szumal.tumblrviewer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

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
    public List<Button> btnContainer = new ArrayList<Button>();
    public List<singlePost> posts = new ArrayList<singlePost>();

    List<Button> getXML(final LinearLayout lila, final String username, final Context cst){


        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Document doc;
                String uri =
                        "https://" + username + ".tumblr.com/api/read#_=_";

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
                                    posts.get(posts.size() - 1).setTitle("");
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
                                } catch (Exception e){
                                    posts.get(posts.size() - 1).setImgurl("");
                                }
                                posts.get(posts.size() - 1).setDate(eElement.getAttribute("date"));


                                //System.out.println("xyz : " + posts.get(posts.size() - 1).getDate());
                            } catch (Exception f){
                                System.out.println(f.toString());
                            }
                        }


                                btnContainer.add(new Button(cst));
                                btnContainer.get(i).setText(posts.get(i).getTitle());
                                //lila.addView(btnContainer[i]);

                    }


                } catch (Exception e) {
                    System.out.println(e.toString());
                }




                System.out.println("xyz 1 " + btnContainer.size());

            }

        };
        thread1.start();
        try {
            thread1.join();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("xyz 2 " + btnContainer.size());
        return btnContainer;
    }
}
