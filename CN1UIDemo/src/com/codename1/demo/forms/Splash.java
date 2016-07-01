/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.InfiniteProgress;
import com.codename1.demo.Main;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author Chen
 */
public class Splash extends Form{

    public Splash() {
        BorderLayout bl = new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE);
        setLayout(bl);
        getToolbar().hideToolbar();
        Container box = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Image icn = Main.theme.getImage("duke-no-logos.png");
        box.add(icn);
        box.add(FlowLayout.encloseCenter(new InfiniteProgress()));
        
        add(BorderLayout.CENTER, box);
    }
    
}
