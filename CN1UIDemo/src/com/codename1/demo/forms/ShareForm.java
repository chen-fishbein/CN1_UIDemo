/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.ImageIO;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Chen
 */
public class ShareForm extends BaseForm {

    public ShareForm() {
        setTitle("Share");
    }

    protected void initUI() {
        setLayout(new BorderLayout());
        try {
            Image imgToShare = Image.createImage("/landscape1.jpg");
            ScaleImageLabel imageLabel = new ScaleImageLabel(imgToShare);
            add(BorderLayout.CENTER, imageLabel);
            
            ShareButton share = new ShareButton();
            String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "/landscape1.png";
            try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
                ImageIO.getImageIO().save(imgToShare, os, ImageIO.FORMAT_PNG, 1);
            } catch (IOException err) {
                Log.e(err);
            }

            share.setTextToShare("Nice view");
            share.setImageToShare(imageFile, "image/png");
            add(BorderLayout.SOUTH, FlowLayout.encloseCenter(share));

        } catch (IOException ex) {
            Log.e(ex);
        }

    }
}
