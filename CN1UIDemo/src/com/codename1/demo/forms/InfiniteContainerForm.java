/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.MultiButton;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Component;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 *
 * @author Chen
 */
public class InfiniteContainerForm extends BaseForm {

    private int pageNumber = 1;

    public InfiniteContainerForm() {
        setTitle("Infinite Container");
    }

    @Override
    protected void initUI() {
        setLayout(new BorderLayout());
        Style s = UIManager.getInstance().getComponentStyle("Label");
        FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
        EncodedImage placeholder = EncodedImage.createFromImage(p.scaled(p.getWidth() * 2, p.getHeight() * 2), false);

        InfiniteContainer ic = new InfiniteContainer() {
            @Override
            public Component[] fetchComponents(int index, int amount) {
                if (index == 0) {
                    pageNumber = 0;
                }
                java.util.List<Map<String, Object>> data = fetchPropertyData("Leeds");
                MultiButton[] cmps = new MultiButton[data.size()];
                for (int iter = 0; iter < cmps.length; iter++) {
                    Map<String, Object> currentListing = data.get(iter);
                    if (currentListing == null) {
                        return null;
                    }
                    String thumb_url = (String) currentListing.get("thumb_url");
                    String guid = (String) currentListing.get("guid");
                    String title = (String) currentListing.get("title");
                    String summary = (String) currentListing.get("summary");
                    String price_formatted = (String) currentListing.get("price_formatted");
                    cmps[iter] = new MultiButton(title);
                    cmps[iter].setTextLine2(summary);
                    cmps[iter].setTextLine3(price_formatted);
                    cmps[iter].setIcon(URLImage.createToStorage(placeholder, thumb_url, thumb_url));
                }
                return cmps;
            }
        };
        add(BorderLayout.CENTER, ic);
    }

    java.util.List<Map<String, Object>> fetchPropertyData(String text) {
        try {
            ConnectionRequest r = new ConnectionRequest();
            r.setPost(false);
            r.setUrl("http://api.nestoria.co.uk/api");
            r.addArgument("pretty", "0");
            r.addArgument("action", "search_listings");
            r.addArgument("encoding", "json");
            r.addArgument("listing_type", "buy");
            r.addArgument("page", "" + pageNumber);
            pageNumber++;
            r.addArgument("country", "uk");
            r.addArgument("place_name", text);
            NetworkManager.getInstance().addToQueueAndWait(r);
            Map<String, Object> result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(r.getResponseData()), "UTF-8"));
            Map<String, Object> response = (Map<String, Object>) result.get("response");
            return (java.util.List<Map<String, Object>>) response.get("listings");
        } catch (Exception err) {
            Log.e(err);
            return null;
        }
    }

}
