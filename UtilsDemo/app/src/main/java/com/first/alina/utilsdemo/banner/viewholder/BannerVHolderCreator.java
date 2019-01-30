package com.first.alina.utilsdemo.banner.viewholder;

/**
 * Created by alina on 2018/10/10.
 */

public interface BannerVHolderCreator<VH extends BannerVHolder> {

     VH createHolder();
}
