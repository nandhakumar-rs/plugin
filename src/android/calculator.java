package cordova.plugin.calculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class calculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        if(action.equals("add")){
            this.add(args,callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void add(JSONArray arg,CallbackContext callbackContext){

        if(arg != null){
            try{
                int number1 =  Interger.parseInt(arg.getJSONObject(0).getString("number1"));
                int number2 =  Interger.parseInt(arg.getJSONObject(0).getString("number2"));
                callbackContext.success(number1 + number2 +" is the result" );
            }catch(Exception e){
                callbackContext.error("Exception " + e);
            }
        }
        else{
            callbackContext.error("error");
        }
    }
}
