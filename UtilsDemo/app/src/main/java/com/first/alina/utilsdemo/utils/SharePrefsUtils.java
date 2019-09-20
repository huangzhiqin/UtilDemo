package com.first.alina.utilsdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Shared Preferences存储
 *
 * @author Patrick.Li
 *
 */
public class SharePrefsUtils {
	private Context context;
	private String prefName;
	private int mode;

	public SharePrefsUtils(Context context, String prefName) {
		this.context = context;
		this.prefName = prefName;
		this.mode = Context.MODE_PRIVATE;
	}

	public SharePrefsUtils(Context context, String prefName, int mode) {
		this.context = context;
		this.prefName = prefName;
		this.mode = mode;
	}

	public void clearPreferences() {
		getPreferences().edit().clear().apply();

	}

	public String getString(String key, String defValue) {
		return getPreferences().getString(key, defValue);
	}

	public void setString(String key, String value) {
		getEditor().putString(key, value).apply();
	}

	public int getInt(String key, int defValue) {
		return getPreferences().getInt(key, defValue);
	}

	public void setInt(String key, int value) {
		getEditor().putInt(key, value).apply();
	}

	public long getLong(String key, long defValue) {
		return getPreferences().getLong(key, defValue);
	}

	public void setLong(String key, long value) {
		getEditor().putLong(key, value).apply();
	}

	public float getFloat(String key, float defValue) {
		return getPreferences().getFloat(key, defValue);
	}

	public void setFloat(String key, float value) {
		getEditor().putFloat(key, value).apply();
	}

	public boolean getBoolean(String key, boolean defValue) {
		return getPreferences().getBoolean(key, defValue);
	}

	public void setBoolean(String key, boolean value) {
		getEditor().putBoolean(key, value).apply();
	}

	public void setSet(String key, Set<String> set){
		getEditor().remove(key).apply();
		getEditor().putStringSet(key,set).apply();
	}

	public Set<String> getSet(String key){
		return getPreferences().getStringSet(key,new HashSet<String>());
	}

	public void clearKey(String key){
		getEditor().remove(key).apply();
	}

	public SharedPreferences getPreferences() {
		return context.getSharedPreferences(prefName, mode);
	}

	public SharedPreferences.Editor getEditor() {
		return getPreferences().edit();
	}
}
