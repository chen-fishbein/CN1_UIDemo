/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.ui.BrowserComponent;
import com.codename1.ui.layouts.BorderLayout;

/**
 *
 * @author Chen
 */
public class BrowserForm extends BaseForm {

    private BrowserComponent browser;
    
    public BrowserForm() {
        setTitle("Browser");
    }

    protected void initUI() {
        setLayout(new BorderLayout());
        browser = new BrowserComponent();
        add(BorderLayout.CENTER, browser);
        browser.addWebEventListener("onLoad", (e)->{
            System.out.println("onLoad");
            repaint();
        });
        browser.addWebEventListener("onStart", (e)->{
            System.out.println("onStart");
        });
        browser.addWebEventListener("onError", (e)->{
            System.out.println("onError");
        });
    }

    @Override
    protected void onShowCompleted() {
        browser.setURL("https://www.codenameone.com/");
    }
    
    
}
