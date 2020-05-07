package com.daiwei.learnandroidcontentprovider;

import android.database.ContentObserver;
import android.net.Uri;
import android.util.Log;

final class BitCoinPriceContentObserver extends ContentObserver {

  private static final String TAG = BitCoinPriceContentObserver.class.getSimpleName();

  BitCoinPriceContentObserver() {
    super(null);
  }

  @Override
  public void onChange(boolean selfChange, Uri uri) {
    Log.d(TAG, "onChange " + uri);
  }
}
