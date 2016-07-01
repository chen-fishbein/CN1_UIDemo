/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.demo.forms;

import com.codename1.components.ImageViewer;
import com.codename1.io.Log;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.list.DefaultListModel;
import java.io.IOException;

/**
 *
 * @author Chen
 */
public class ImageViewerForm extends BaseForm {

    public ImageViewerForm() {
        setTitle("Image Viewer");
    }

    @Override
    protected void initUI() {
        try {
            setLayout(new BorderLayout());
            Image img1 = Image.createImage("/landscape1.jpg");
            Image img2 = Image.createImage("/landscape2.jpg");
            Image img3 = Image.createImage("/landscape3.jpg");
            
            ImageViewer iv = new ImageViewer(img1);
            iv.setImageList(new DefaultListModel(img1, img2, img3));
            add(BorderLayout.CENTER, iv);
        } catch (IOException ex) {
            Log.e(ex);
        }
    }

}
