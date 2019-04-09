package com.first.alina.utilsdemo.imageManager;

/**
 * Created by alina on 2019/4/9.
 */

public class ImageLoaderOptions {
    public int placeRes;//占位符
    public int errorRes;
    public boolean skipMemoryCache;//是否跳过内存缓存

    public ImageLoaderOptions(int placeRes, int errorRes, boolean skipMemoryCache) {
        this.placeRes = placeRes;
        this.errorRes = errorRes;
        this.skipMemoryCache = skipMemoryCache;
    }

    public static final class Builder{
        private int placeRes;//占位符
        private int errorRes;
        private boolean skipMemoryCache;//是否跳过内存缓存

        public Builder placeRes(int res){
            this.placeRes=res;
            return this;
        }

        public Builder errorRes(int errorRes){
            this.errorRes=errorRes;
            return this;
        }

        public Builder skipMemoryCache(boolean skipMemoryCache){
            this.skipMemoryCache=skipMemoryCache;
            return this;
        }

        public ImageLoaderOptions build(){
            return new ImageLoaderOptions(placeRes,errorRes,skipMemoryCache);
        }
    }

}
