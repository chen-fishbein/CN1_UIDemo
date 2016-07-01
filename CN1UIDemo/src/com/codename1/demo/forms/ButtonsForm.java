/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.MultiButton;
import com.codename1.components.OnOffSwitch;
import com.codename1.demo.Main;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;

/**
 *
 * @author Chen
 */
public class ButtonsForm extends BaseForm{
    

    public ButtonsForm() {
        setTitle("Buttons");
    }

    protected void initUI() {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
        
        Button simpleButton = new Button("Button with FontImage Icon");
        FontImage.setMaterialIcon(simpleButton, FontImage.MATERIAL_THUMB_UP);        
        add(simpleButton);

        Button multiButton = new Button("Button with MultiImage Icon");
        multiButton.setIcon(Main.theme.getImage("icon.png"));
        add(multiButton);
        Button buttonRight = new Button("Icon on Right");
        buttonRight.setIcon(Main.theme.getImage("icon.png"));
        buttonRight.setTextPosition(Component.LEFT);
        add(buttonRight);
        Button buttonTop = new Button("Icon on Top");
        buttonTop.setIcon(Main.theme.getImage("icon.png"));
        buttonTop.setTextPosition(Component.BOTTOM);
        add(buttonTop);
        Button buttonBottom = new Button("Icon on Bottom");
        buttonBottom.setIcon(Main.theme.getImage("icon.png"));
        buttonBottom.setTextPosition(Component.TOP);
        add(buttonBottom);
        
        Button customButton = new Button("Button with custom uiid");
        customButton.setUIID("CustomButton");
        add(customButton);

        CheckBox checkBox = new CheckBox("CheckBox");
        add(checkBox);
        
        Container radioBtns = new Container(new GridLayout(1, 2));
        RadioButton r1 = new RadioButton("Radio 1");
        RadioButton r2 = new RadioButton("Radio 2");
        r1.setGroup("group1");
        r2.setGroup("group1");
        radioBtns.add(r1);
        radioBtns.add(r2);
        
        add(radioBtns);

        OnOffSwitch switchBtn = new OnOffSwitch();
        add(BorderLayout.east(switchBtn).add(BorderLayout.CENTER, new Label("Switch Button")));
        
        MultiButton multi = new MultiButton("Multi line Button");
        multi.setTextLine2("Line 2");
        multi.setTextLine3("Line 3");
        FontImage emblem = FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT, getUIManager().getComponentStyle("Emblem"));
        multi.setEmblem(emblem);
        add(multi);
        
        
        
    }

    
}
