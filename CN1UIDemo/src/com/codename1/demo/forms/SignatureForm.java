/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.SignatureComponent;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Chen
 */
public class SignatureForm extends BaseForm {

    public SignatureForm() {
        setTitle("Signature");
    }

    @Override
    protected void initUI() {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        add("Signature:");
        SignatureComponent sig = new SignatureComponent();
        sig.addActionListener((evt) -> {
            System.out.println("The signature was changed");
            Image img = sig.getSignatureImage();
            // Now we can do whatever we want with the image of this signature.
        });
        addComponent(sig);
    }

}
