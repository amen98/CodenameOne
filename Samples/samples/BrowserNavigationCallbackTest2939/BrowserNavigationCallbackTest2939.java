package com.codename1.samples;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.CN;
import com.codename1.ui.Component;
import com.codename1.ui.events.BrowserNavigationCallback;
import com.codename1.ui.layouts.BorderLayout;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class BrowserNavigationCallbackTest2939 {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
         String dummyHtml = "<body><h1>TITLE TEST</h1><a href=\"https://www.codenameone.com/\">link</a></body>";        
        BrowserComponent bc = new BrowserComponent();
        bc.setPage(dummyHtml, "");

        bc.addBrowserNavigationCallback(createCallbackDontOpenLinksInComponent());

        Form f = new Form(new BorderLayout());
        f.add(Component.CENTER, bc);
        f.show();
    }
    
    public static BrowserNavigationCallback createCallbackDontOpenLinksInComponent() {
        return calledUrl -> {
            
            if(!calledUrl.startsWith("http")) return true;
            
            System.out.println("url called: " + calledUrl);
            callSerially(()->{
                if (CN.canExecute(calledUrl)) {
                    CN.execute(calledUrl);
                }
            });
            
            return false;
            
        };
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}