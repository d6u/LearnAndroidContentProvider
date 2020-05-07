package com.daiwei.learnandroidcontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.daiwei.learnandroidcontentprovider.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();
  private static final Uri CONTENT_URI =
      Uri.parse("content://com.daiwei.learnandroidcontentprovider.bit_coin_price/route1");

  @Nullable private BitCoinPriceContentObserver mBitCoinPriceContentObserver;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    queryContent(); // query initial value
    observeContent(); // observe future value changes, but won't get initial value
    updateContent(); // notify observers
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    if (mBitCoinPriceContentObserver != null) {
      getContentResolver().unregisterContentObserver(mBitCoinPriceContentObserver);
      mBitCoinPriceContentObserver = null;
    }
  }

  private void queryContent() {
    try (
        @Nullable Cursor cursor = getContentResolver().query(
            CONTENT_URI,
            new String[]{"a"},
            null,
            null,
            null
        )) {

      Log.d(TAG, "Queried");

      if (cursor != null && cursor.moveToNext()) {
        Log.d(TAG, "Has data");
        // cursor.getCount();
      } else {
        Log.d(TAG, "No data");
      }
    }
  }

  private void observeContent() {
    mBitCoinPriceContentObserver = new BitCoinPriceContentObserver();

    getContentResolver().registerContentObserver(
        CONTENT_URI,
        true,
        Objects.requireNonNull(mBitCoinPriceContentObserver)
    );
  }

  private void updateContent() {
    getContentResolver()
        .update(CONTENT_URI, null, null, new String[]{"a"});

    getContentResolver().notifyChange(CONTENT_URI, null);
  }
}
