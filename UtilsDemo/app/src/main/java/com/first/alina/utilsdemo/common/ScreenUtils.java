package com.first.alina.utilsdemo.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * 获得屏幕相关的辅助类
 *
 * @author shijicheng on 16/4/18
 *
 */
public class ScreenUtils
{
	private ScreenUtils()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * 获得屏幕高度pix
	 *
	 * @param context
	 * @return
	 */
	public static int getScreenWidth(Context context)
	{
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.widthPixels;
	}

	/**
	 * 获得屏幕宽度pix
	 *
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context)
	{
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.heightPixels;
	}

	/**
	 * 获得状态栏的高度pix
	 *
	 * @param context
	 * @return
	 */
	public static int getStatusHeight(Context context)
	{

		int statusHeight = -1;
		try
		{
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object object = clazz.newInstance();
			int height = Integer.parseInt(clazz.getField("status_bar_height")
					.get(object).toString());
			statusHeight = context.getResources().getDimensionPixelSize(height);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return statusHeight;
	}

	/***
	 * 获得标题栏的高度pix
	 * @param activity
	 * @param context
	 * @return
	 */
	public static int getTitleHeight(Activity activity, Context context){
		int contentTop =activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
		int titleheight=contentTop-getStatusHeight(context);
		return  titleheight;
	}


	/**
	 * 获取当前屏幕截图，包含状态栏
	 *
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithStatusBar(Activity activity)
	{
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		int width = getScreenWidth(activity);
		int height = getScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
		view.destroyDrawingCache();
		return bp;

	}

	/**
	 * 获取当前屏幕截图，不包含状态栏
	 *
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithoutStatusBar(Activity activity)
	{
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		Rect frame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;

		int width = getScreenWidth(activity);
		int height = getScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height
				- statusBarHeight);
		view.destroyDrawingCache();
		return bp;

	}

	/**
	 * 将px值转换为dip或dp值，保证尺寸大小不变
	 *
	 * @param pxValue
	 *            （DisplayMetrics类中属性density）
	 * @return
	 */
	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 将dip或dp值转换为px值，保证尺寸大小不变
	 *
	 * @param dipValue
	 *            （DisplayMetrics类中属性density）
	 * @return
	 */
	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 *
	 * @param pxValue
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 *
	 * @param spValue
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}

	/**
	 * 获取View的宽（像素）
	 *
	 * @param view
	 * @return
	 */
	public static int getViewWidth(View view){
		int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		int height  = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		view.measure(width, height);
		return view.getMeasuredWidth();
	}

	/**
	 * 获取View的高（像素）
	 *
	 * @param view
	 * @return
	 */
	public static int getViewHeight(View view){
		int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		int height  = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		view.measure(w, height);
		return view.getMeasuredHeight();
	}

	/**
	 * 对 ViewGroup.LayoutParams View 设置宽高
	 *
	 * @param view
	 * @param Width
	 * @param Height
	 */
	public static void setViewWidthHeight(View view , int Width, int Height){
		ViewGroup.LayoutParams layoutParams;
		layoutParams=view.getLayoutParams();
		layoutParams.width = Width;
		layoutParams.height = Height;
		view.setLayoutParams(layoutParams);
	}


	//截屏虚化
	/**
	 * 获得模糊化的背景图片
	 * @param activity 获取模糊化的背景activity
	 * @return 模糊化的背景图片
	 */
	public static Bitmap getBlurBackgroundDrawer(Activity activity) {
		Bitmap bmp = takeScreenShotNew(activity);
		return startBlurBackground(bmp);
	}

	/**
	 * 截屏
	 * @param activity 截屏的activity
	 * @return 截屏图片
	 */
	private static Bitmap takeScreenShot(Activity activity) {
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache(true);

		// this is the important code :)
		// Without it the view will have a dimension of 0,0 and the bitmap will be null

		//这里会导致界面重新绘制，存在 抖动的现象
		view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
				View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

		Log.d("BitmapUtils","view.getMeasuredWidth="+view.getMeasuredWidth()+",view.getMeasuredHeight="+view.getMeasuredHeight());

		int viewWidth = view.getMeasuredWidth();
		int viewHeight = view.getMeasuredHeight();

		view.layout(0, 0, viewWidth, viewHeight);

		Bitmap b1 = view.getDrawingCache();

		if(b1 == null){
			Log.d("BitmapUtils","view.getDrawingCache = = null");
			return null;
		}else {
			Log.d("BitmapUtils","view.getDrawingCache ! = null");
		}

		// 获取屏幕长和高
		int width = activity.getResources().getDisplayMetrics().widthPixels;
		int height = activity.getResources().getDisplayMetrics().heightPixels;

		Log.d("BitmapUtils","view.getDrawingCache ! = null width="+width+",viewWidth="+viewWidth+",height="+height+",viewHeight="+viewHeight);

		if(width>viewWidth){
			width = viewWidth;
		}

		if(height> viewHeight){
			height = viewHeight;
		}

		Bitmap bmp = Bitmap.createBitmap(b1, 0, 0, width, height);
		view.setDrawingCacheEnabled(false);
		view.destroyDrawingCache();
		return bmp;
	}

	public static Bitmap takeScreenShotNew(Activity act) {
		if (act == null || act.isFinishing()) {
			Log.d("BitmapUtils", "act参数为空.");
			return null;
		}

		// 获取当前视图的view
		View scrView = act.getWindow().getDecorView();
		scrView.setDrawingCacheEnabled(true);
		scrView.buildDrawingCache(true);

		// 获取状态栏高度
		Rect statuBarRect = new Rect();
		scrView.getWindowVisibleDisplayFrame(statuBarRect);
		int statusBarHeight = statuBarRect.top;
		int width = act.getWindowManager().getDefaultDisplay().getWidth();
		int height = act.getWindowManager().getDefaultDisplay().getHeight();


		Bitmap scrBmp = scrView.getDrawingCache();
		if(scrBmp == null){
			Log.d("BitmapUtils","view.getDrawingCache = = null");
			return null;
		}else {
			Log.d("BitmapUtils","view.getDrawingCache ! = null");
		}

		try {
			// 去掉标题栏的截图
			scrBmp = Bitmap.createBitmap(scrView.getDrawingCache(), 0, statusBarHeight,
					width, height - statusBarHeight);
		} catch (IllegalArgumentException e) {
			Log.d("BitmapUtils", "#### 旋转屏幕导致去掉状态栏失败");
		}
		scrView.setDrawingCacheEnabled(false);
		scrView.destroyDrawingCache();
		return scrBmp;
	}


	private static Bitmap startBlurBackground(Bitmap bkg) {
		if(bkg == null){
			return null;
		}

		long startMs = System.currentTimeMillis();
		float radius = 20; //模糊程度

		Bitmap overlay = fastblur(small(bkg), (int) radius);

		Log.i("BitmapUtils", "=====blur time:" + (System.currentTimeMillis() - startMs));
//		return big(overlay);
		return overlay;
	}

	/**
	 * 放大图片
	 * @param bitmap 需要放大的图片
	 * @return 放大的图片
	 */
	private static Bitmap big(Bitmap bitmap) {
		Matrix matrix = new Matrix();
		matrix.postScale(5f, 5f);
		Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return resizeBmp;
	}

	/**
	 * 缩小图片
	 * @param bitmap 需要缩小的图片
	 * @return 缩小的图片
	 */
	private static Bitmap small(Bitmap bitmap) {
		Matrix matrix = new Matrix();
		matrix.postScale(0.20f, 0.20f);
		Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return resizeBmp;
	}

	/**
	 * 将图片模糊化
	 * @param sentBitmap 需要模糊的图片
	 * @param radius     模糊程度
	 * @return 模糊后的图片
	 */
	private static Bitmap fastblur(Bitmap sentBitmap, int radius) {
		Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);

		if (radius < 1) {
			return (null);
		}

		int w = bitmap.getWidth();
		int h = bitmap.getHeight();

		int[] pix = new int[w * h];
		bitmap.getPixels(pix, 0, w, 0, 0, w, h);

		int wm = w - 1;
		int hm = h - 1;
		int wh = w * h;
		int div = radius + radius + 1;

		int r[] = new int[wh];
		int g[] = new int[wh];
		int b[] = new int[wh];
		int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
		int vmin[] = new int[Math.max(w, h)];

		int divsum = (div + 1) >> 1;
		divsum *= divsum;
		int dv[] = new int[256 * divsum];
		for (i = 0; i < 256 * divsum; i++) {
			dv[i] = (i / divsum);
		}

		yw = yi = 0;

		int[][] stack = new int[div][3];
		int stackpointer;
		int stackstart;
		int[] sir;
		int rbs;
		int r1 = radius + 1;
		int routsum, goutsum, boutsum;
		int rinsum, ginsum, binsum;

		for (y = 0; y < h; y++) {
			rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
			for (i = -radius; i <= radius; i++) {
				p = pix[yi + Math.min(wm, Math.max(i, 0))];
				sir = stack[i + radius];
				sir[0] = (p & 0xff0000) >> 16;
				sir[1] = (p & 0x00ff00) >> 8;
				sir[2] = (p & 0x0000ff);
				rbs = r1 - Math.abs(i);
				rsum += sir[0] * rbs;
				gsum += sir[1] * rbs;
				bsum += sir[2] * rbs;
				if (i > 0) {
					rinsum += sir[0];
					ginsum += sir[1];
					binsum += sir[2];
				} else {
					routsum += sir[0];
					goutsum += sir[1];
					boutsum += sir[2];
				}
			}
			stackpointer = radius;

			for (x = 0; x < w; x++) {

				r[yi] = dv[rsum];
				g[yi] = dv[gsum];
				b[yi] = dv[bsum];

				rsum -= routsum;
				gsum -= goutsum;
				bsum -= boutsum;

				stackstart = stackpointer - radius + div;
				sir = stack[stackstart % div];

				routsum -= sir[0];
				goutsum -= sir[1];
				boutsum -= sir[2];

				if (y == 0) {
					vmin[x] = Math.min(x + radius + 1, wm);
				}
				p = pix[yw + vmin[x]];

				sir[0] = (p & 0xff0000) >> 16;
				sir[1] = (p & 0x00ff00) >> 8;
				sir[2] = (p & 0x0000ff);

				rinsum += sir[0];
				ginsum += sir[1];
				binsum += sir[2];

				rsum += rinsum;
				gsum += ginsum;
				bsum += binsum;

				stackpointer = (stackpointer + 1) % div;
				sir = stack[(stackpointer) % div];

				routsum += sir[0];
				goutsum += sir[1];
				boutsum += sir[2];

				rinsum -= sir[0];
				ginsum -= sir[1];
				binsum -= sir[2];

				yi++;
			}
			yw += w;
		}
		for (x = 0; x < w; x++) {
			rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
			yp = -radius * w;
			for (i = -radius; i <= radius; i++) {
				yi = Math.max(0, yp) + x;

				sir = stack[i + radius];

				sir[0] = r[yi];
				sir[1] = g[yi];
				sir[2] = b[yi];

				rbs = r1 - Math.abs(i);

				rsum += r[yi] * rbs;
				gsum += g[yi] * rbs;
				bsum += b[yi] * rbs;

				if (i > 0) {
					rinsum += sir[0];
					ginsum += sir[1];
					binsum += sir[2];
				} else {
					routsum += sir[0];
					goutsum += sir[1];
					boutsum += sir[2];
				}

				if (i < hm) {
					yp += w;
				}
			}
			yi = x;
			stackpointer = radius;
			for (y = 0; y < h; y++) {
				pix[yi] = (0xff000000 & pix[yi]) | (dv[rsum] << 16) | (dv[gsum] << 8) | dv[bsum];

				rsum -= routsum;
				gsum -= goutsum;
				bsum -= boutsum;

				stackstart = stackpointer - radius + div;
				sir = stack[stackstart % div];

				routsum -= sir[0];
				goutsum -= sir[1];
				boutsum -= sir[2];

				if (x == 0) {
					vmin[y] = Math.min(y + r1, hm) * w;
				}
				p = x + vmin[y];

				sir[0] = r[p];
				sir[1] = g[p];
				sir[2] = b[p];

				rinsum += sir[0];
				ginsum += sir[1];
				binsum += sir[2];

				rsum += rinsum;
				gsum += ginsum;
				bsum += binsum;

				stackpointer = (stackpointer + 1) % div;
				sir = stack[stackpointer];

				routsum += sir[0];
				goutsum += sir[1];
				boutsum += sir[2];

				rinsum -= sir[0];
				ginsum -= sir[1];
				binsum -= sir[2];

				yi += w;
			}
		}

		bitmap.setPixels(pix, 0, w, 0, 0, w, h);

		return (bitmap);
	}

	/**
	 * 判断是否有虚拟返回键栏
	 * @param context
	 * @return
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	public static boolean hasNavBar(Context context) {
		Resources res = context.getResources();
		int resourceId = res.getIdentifier("config_showNavigationBar", "bool", "android");
		if (resourceId != 0) {
			boolean hasNav = res.getBoolean(resourceId);
			// check override flag
			String sNavBarOverride = getNavBarOverride();
			if ("1".equals(sNavBarOverride)) {
				hasNav = false;
			} else if ("0".equals(sNavBarOverride)) {
				hasNav = true;
			}
			return hasNav;
		} else { // fallback
			return !ViewConfiguration.get(context).hasPermanentMenuKey();
		}
	}

	/**
	 * 获取虚拟返回键栏高度
	 * @param context
	 * @return
	 */
	public static int getNavigationBarHeight(Context context) {
		int result = 0;
		if (hasNavBar(context)) {
			Resources res = context.getResources();
			int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
			if (resourceId > 0) {
				result = res.getDimensionPixelSize(resourceId);
			}
		}
		return result;
	}

	/**
	 * 检查虚拟返回键栏是否重写
	 * @return
	 */
	private static String getNavBarOverride() {
		String sNavBarOverride = null;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			try {
				Class c = Class.forName("android.os.SystemProperties");
				Method m = c.getDeclaredMethod("get", String.class);
				m.setAccessible(true);
				sNavBarOverride = (String) m.invoke(null, "qemu.hw.mainkeys");
			} catch (Throwable e) {
			}
		}
		return sNavBarOverride;
	}

}