package com.codingfanatic.richyad.mob_deep;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

public class mob_deep extends TileService{
 @Override
 public void onTileAdded(){
  Log.d("logtag", "onTileAdded called");
  getQsTile().setState(Tile.STATE_INACTIVE);
  getQsTile().updateTile();
  Log.d("logtag", "Tile updated");
 }

 public void onTileRemoved(){
  Log.d("Logtag", "OnTileRemoved called");
  getQsTile().setState(Tile.STATE_INACTIVE);
  getQsTile().updateTile();
  Log.d("Logtag", "Tile updated");

 }

 public void onClick(){
  Log.d("logtag", "onClick() called");
   if(getQsTile().getState() == Tile.STATE_INACTIVE) {
    getQsTile().setState(Tile.STATE_ACTIVE);
    getQsTile().updateTile();
    Log.d("Logtag", "Tile updated");
    dataOn();
    Log.d("logtag", "Should be active");
   }
   else{
    getQsTile().setState(Tile.STATE_INACTIVE);
    getQsTile().updateTile();
    Log.d("Logtag", "Tile updated");
    dataOff();
    Log.d("Logtag", "Should NOT be active");
   }
 }

 public void dataOn(){
  TelephonyManager teleManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
  teleManager.setDataEnabled();
 }
 public void dataOff(){}
}
