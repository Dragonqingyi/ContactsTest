package com.example.love.contactstest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Love on 2017/4/30.
 */

public class MyProvider extends ContentProvider {
    private static final int TABE1_DIR = 0;
    private static final int TABE1_ITEM = 1;
    private static final int TABE2_DIR = 2;
    private static final int TABE2_ITEM = 3;
    private static UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.app.provider","table1",TABE1_DIR);
        uriMatcher.addURI("com.example.app.provider","table1/#",TABE1_ITEM);
        uriMatcher.addURI("com.example.app.provider","table2",TABE1_DIR);
        uriMatcher.addURI("com.example.app.provider","table2/#",TABE1_ITEM);
    }
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        switch (uriMatcher.match(uri)){
            case TABE1_DIR:
                //c查询table1表中所有数据
                break;
            case TABE1_ITEM:
                //查询table1表中单条数据
                break;
            case TABE2_DIR:
                //c查询table2表中所有数据
                break;
            case TABE2_ITEM:
                //查询table2表中单条数据
                break;
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case TABE1_DIR:
                return "vdn.android.cursor.dir/vnd.com.example.app.provider.table1";
            case TABE1_ITEM:
                return "vdn.android.cursor.item/vnd.com.example.app.provider.table1";
            case TABE2_DIR:
                return "vdn.android.cursor.dir/vnd.com.example.app.provider.table2";
            case TABE2_ITEM:
                return "vdn.android.cursor.item/vnd.com.example.app.provider.table2";
                default:
                    break;
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
