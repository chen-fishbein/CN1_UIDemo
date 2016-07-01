/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.ui.Form;

/**
 *
 * @author Chen
 */
public abstract class BaseForm extends Form{

    public BaseForm() {
        initUI();
        getToolbar().setTitleCentered(true);
    }

    protected abstract void initUI();    
}
