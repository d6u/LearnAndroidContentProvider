package com.daiwei.learnandroidcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class BitCoinPriceContentProvider extends ContentProvider {

  private static final String TAG = BitCoinPriceContentProvider.class.getSimpleName();

  @Override
  public boolean onCreate() {
    Log.d(TAG, "onCreate");
    return false;
  }

  @Nullable
  @Override
  public Cursor query(
      @NonNull Uri uri,
      @Nullable String[] projection,
      @Nullable String selection,
      @Nullable String[] selectionArgs,
      @Nullable String sortOrder
  ) {
    Log.d(TAG, "query, uri = " + uri);
    return null;
  }

  @Nullable
  @Override
  public String getType(@NonNull Uri uri) {
    Log.d(TAG, "getType");
    return null;
  }

  @Nullable
  @Override
  public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
    Log.d(TAG, "insert");
    return null;
  }

  @Override
  public int delete(
      @NonNull Uri uri,
      @Nullable String selection,
      @Nullable String[] selectionArgs
  ) {
    Log.d(TAG, "delete");
    return 0;
  }

  @Override
  public int update(
      @NonNull Uri uri,
      @Nullable ContentValues values,
      @Nullable String selection,
      @Nullable String[] selectionArgs
  ) {
    Log.d(TAG, "update " + uri);
    return 1;
  }
}
