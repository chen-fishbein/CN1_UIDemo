/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.contacts.Contact;
import com.codename1.demo.Main;
import com.codename1.io.Log;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 *
 * @author Chen
 */
public class ContactsForm extends BaseForm {
    
    public ContactsForm() {
        setTitle("Contacts");
    }

    @Override
    protected void initUI() {
        setLayout(BoxLayout.y());
        setScrollableY(true);
        add(new InfiniteProgress());
        Image duke = Main.theme.getImage("icon.png");
        int fiveMM = Display.getInstance().convertToPixels(5);
        final Image finalDuke = duke.scaledWidth(fiveMM);        
        Display.getInstance().scheduleBackgroundTask(() -> {
            // this will take a while...
            Contact[] cnts = Display.getInstance().getAllContacts(true, true, true, true, false, false);
            Display.getInstance().callSerially(() -> {
                removeAll();
                for (Contact c : cnts) {
                    MultiButton m = new MultiButton();
                    m.setTextLine1(c.getDisplayName());
                    m.setTextLine2(c.getPrimaryPhoneNumber());
                    Image pic = c.getPhoto();
                    if (pic != null) {
                        m.setIcon(fill(pic, finalDuke.getWidth(), finalDuke.getHeight()));
                    } else {
                        m.setIcon(finalDuke);
                    }
                    add(m);
                }
                revalidate();
            });
        });

        getToolbar().addSearchCommand(e -> {
            String text = (String) e.getSource();
            if (text == null || text.length() == 0) {
                // clear search
                for (Component cmp : getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
                getContentPane().animateLayout(150);
            } else {
                text = text.toLowerCase();
                for (Component cmp : getContentPane()) {
                    MultiButton mb = (MultiButton) cmp;
                    String line1 = mb.getTextLine1();
                    String line2 = mb.getTextLine2();
                    boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1
                            || line2 != null && line2.toLowerCase().indexOf(text) > -1;
                    mb.setHidden(!show);
                    mb.setVisible(show);
                }
                getContentPane().animateLayout(150);
            }
        }, 4);

    }

    private Image fill(Image pic, int width, int height) {
        return pic.scaled(width, height);
    }

}
