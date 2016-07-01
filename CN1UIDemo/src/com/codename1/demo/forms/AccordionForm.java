/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.Accordion;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Chen
 */
public class AccordionForm extends BaseForm {

    public AccordionForm() {
        setTitle("Accordion");
    }

    protected void initUI() {
        setLayout(new BorderLayout());
        Accordion accr = new Accordion();
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD, e -> addEntry(accr));
        addEntry(accr);
        add(BorderLayout.CENTER, accr);
    }

    private void addEntry(Accordion accr) {
        SpanLabel body = new SpanLabel("The quick brown fox jumps over the lazy dog\n"
                + "The quick brown fox jumps over the lazy dog\n"
                + "The quick brown fox jumps over the lazy dog");
        Button delete = new Button();
        delete.setUIID("Container");
        FontImage.setMaterialIcon(delete, FontImage.MATERIAL_DELETE);
        Label title = new Label("Click to Open");
        title.setUIID("AccordHeader");
        delete.addActionListener(ee -> {
            accr.removeContent(body);
            accr.animateLayout(200);
        });
        delete.setBlockLead(true);
        Container header = BorderLayout.center(title).
                add(BorderLayout.EAST, delete);
        accr.addContent(header, body);
        accr.animateLayout(200);
    }
}
