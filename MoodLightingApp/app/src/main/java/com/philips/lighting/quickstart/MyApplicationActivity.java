package com.philips.lighting.quickstart;

import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

/**
 * MyApplicationActivity - The starting point for creating your own Hue App.  
 * Currently contains a simple view with a button to change your lights to random colours.  Remove this and add your own app implementation here! Have fun!
 * 
 * @author SteveyO
 *
 */
public class MyApplicationActivity extends Activity {
    private PHHueSDK phHueSDK;
    private static final int MAX_HUE=65535;
    public static final String TAG = "QuickStart";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);
        phHueSDK = PHHueSDK.create();
        Button randomButton;
        randomButton = (Button) findViewById(R.id.buttonRand);
        randomButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                randomLights();
            }

        });
        Button sadButton;
        sadButton = (Button) findViewById(R.id.buttonSad);
        sadButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                sadLights();
            }

        });
        Button awakeButton;
        awakeButton = (Button) findViewById(R.id.buttonAwake);
        awakeButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                awakeLights();
            }

        });

        Button tiredButton;
        tiredButton = (Button) findViewById(R.id.buttonTired);
        tiredButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                tiredLights();
            }

        });
        Button exciteButton;
        exciteButton = (Button) findViewById(R.id.buttonExcite);
        exciteButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                exciteLights();
            }

        });
        Button calmButton;
        calmButton = (Button) findViewById(R.id.buttonCalm);
        calmButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                calmLights();
            }

        });

    }
    public void awakeLights() {
        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();


        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();
            lightState.setBrightness(254);
            lightState.setSaturation(50);
            lightState.setHue(40000);
            lightState.setOn(true);
            lightState.setEffectMode(PHLight.PHLightEffectMode.EFFECT_NONE);
            // To validate your lightstate is valid (before sending to the bridge) you can use:
            // String validState = lightState.validateState();
            bridge.updateLightState(light, lightState, listener);
            //  bridge.updateLightState(light, lightState);   // If no bridge response is required then use this simpler form.
        }
    }
    public void tiredLights() {
        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();


        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();
            lightState.setBrightness(50);
            lightState.setSaturation(80);
            lightState.setHue(25000);
            lightState.setOn(false);
            lightState.setEffectMode(PHLight.PHLightEffectMode.EFFECT_NONE);
            // To validate your lightstate is valid (before sending to the bridge) you can use:
            // String validState = lightState.validateState();
            bridge.updateLightState(light, lightState, listener);
            //  bridge.updateLightState(light, lightState);   // If no bridge response is required then use this simpler form.
        }
    }
    public void calmLights() {
        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();


        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();
            lightState.setBrightness(100);
            lightState.setSaturation(1);
            lightState.setHue(2000);
            lightState.setOn(true);
            lightState.setEffectMode(PHLight.PHLightEffectMode.EFFECT_NONE);
            // To validate your lightstate is valid (before sending to the bridge) you can use:
            // String validState = lightState.validateState();
            bridge.updateLightState(light, lightState, listener);
            //  bridge.updateLightState(light, lightState);   // If no bridge response is required then use this simpler form.
        }
    }
    public void exciteLights() {
        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();


        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();
            lightState.setBrightness(254);
            lightState.setSaturation(50);

                       lightState.setEffectMode(PHLight.PHLightEffectMode.EFFECT_COLORLOOP);
            lightState.setOn(true);
            // To validate your lightstate is valid (before sending to the bridge) you can use:
            // String validState = lightState.validateState();
            bridge.updateLightState(light, lightState, listener);
            //  bridge.updateLightState(light, lightState);   // If no bridge response is required then use this simpler form.
        }
    }
    public void sadLights() {
        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();


        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();
            lightState.setBrightness(254);
            lightState.setSaturation(250);
            lightState.setHue(154);
            lightState.setOn(true);
            lightState.setEffectMode(PHLight.PHLightEffectMode.EFFECT_NONE);
            // To validate your lightstate is valid (before sending to the bridge) you can use:
            // String validState = lightState.validateState();
            bridge.updateLightState(light, lightState, listener);
            //  bridge.updateLightState(light, lightState);   // If no bridge response is required then use this simpler form.
        }
    }
    public void randomLights() {
        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();
            lightState.setBrightness(154);
            lightState.setSaturation(4);
            lightState.setHue(10000);
            lightState.setOn(true);
            lightState.setEffectMode(PHLight.PHLightEffectMode.EFFECT_NONE);
            // To validate your lightstate is valid (before sending to the bridge) you can use:
            // String validState = lightState.validateState();
            bridge.updateLightState(light, lightState, listener);
            //  bridge.updateLightState(light, lightState);   // If no bridge response is required then use this simpler form.
        }
    }
    // If you want to handle the response from the bridge, create a PHLightListener object.
    PHLightListener listener = new PHLightListener() {
        
        @Override
        public void onSuccess() {  
        }
        
        @Override
        public void onStateUpdate(Map<String, String> arg0, List<PHHueError> arg1) {
           Log.w(TAG, "Light has updated");
        }
        
        @Override
        public void onError(int arg0, String arg1) {}

        @Override
        public void onReceivingLightDetails(PHLight arg0) {}

        @Override
        public void onReceivingLights(List<PHBridgeResource> arg0) {}

        @Override
        public void onSearchComplete() {}
    };
    
    @Override
    protected void onDestroy() {
        PHBridge bridge = phHueSDK.getSelectedBridge();
        if (bridge != null) {
            
            if (phHueSDK.isHeartbeatEnabled(bridge)) {
                phHueSDK.disableHeartbeat(bridge);
            }
            
            phHueSDK.disconnect(bridge);
            super.onDestroy();
        }
    }
}
