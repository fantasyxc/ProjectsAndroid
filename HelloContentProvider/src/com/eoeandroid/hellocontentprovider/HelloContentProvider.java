package com.eoeandroid.hellocontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class HelloContentProvider extends ContentProvider{
	
	private static final UriMatcher um = new UriMatcher(UriMatcher.NO_MATCH);
	private SQLiteDatabase sqLite;
	
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		um.addURI("com.eoeandroid.hellocontentprovider.provider.books", "books", 1);
		sqLite = SQLiteDatabase.openDatabase(
				"/data/data/com.eoeandroid.hellocontentprovider/eoedb", 
				null, 
				SQLiteDatabase.OPEN_READWRITE | SQLiteDatabase.CREATE_IF_NECESSARY | SQLiteDatabase.CONFLICT_REPLACE);
		try {
//			sqLite.execSQL("SELECT COUNT(*) as CNT FROM sqlite_master where type='table' and name='books'");
			sqLite.execSQL("create table books ([id] integer primary key autoincrement not null, [bookname] varchar(30) not null)");
			ContentValues cv = new ContentValues();
			cv.put("bookname", "Android开发入门与实践");
			sqLite.insert("books", null, cv);
		} catch (Exception e) {
			System.out.println("-----程序异常信息-----");
			e.printStackTrace();
			System.out.println("-----程序异常信息-----");
		}

		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		if (um.match(uri) == 1) {
			Cursor cursor = sqLite.query("books", null, null, null, null, null, null);
			return cursor;
		}
		else {
			return null;
		}
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		if (um.match(uri) == 1) {
			int result = sqLite.update("books", values, null, null);
			return result;
		}
		return 0;
	}

}