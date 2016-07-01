/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.demo.Main;
import static com.codename1.demo.Main.main;
import static com.codename1.demo.Main.theme;
import com.codename1.ui.Button;
import com.codename1.ui.RadioButton;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Chen
 */
public class ThemesForm extends BaseForm{

    public ThemesForm() {
        setTitle("Themes");
    }
    
    @Override
    protected void initUI() {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        RadioButton rb1 = new RadioButton("Orange");
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Blue");
        RadioButton rb3 = new RadioButton("Business");
        RadioButton rb4 = new RadioButton("SocialBoo");
        rb1.setGroup("grp1");
        rb2.setGroup("grp1");
        rb3.setGroup("grp1");
        rb4.setGroup("grp1");
        add(rb1);
        add(rb2);
        add(rb3);
        add(rb4);
        Button b = new Button("Change theme");
        b.addActionListener((e)->{
            String themeName = null;
            if(rb1.isSelected()){
                themeName = "Theme";
            }else if(rb2.isSelected()){
                themeName = "Theme1";
            }else if(rb3.isSelected()){
                themeName = "Theme2";
            }else if(rb4.isSelected()){
                themeName = "Theme3";
            }
            UIManager.getInstance().setThemeProps(Main.theme.getTheme(themeName));
            Main.main.refreshTheme();
            Main.main.showBack();
        });
        add(b);
    }
    
}
