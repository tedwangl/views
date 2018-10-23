package com.wl.ui.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.wl.ui.banner.transformer.AccordionTransformer;
import com.wl.ui.banner.transformer.BackgroundToForegroundTransformer;
import com.wl.ui.banner.transformer.CubeInTransformer;
import com.wl.ui.banner.transformer.CubeOutTransformer;
import com.wl.ui.banner.transformer.DefaultTransformer;
import com.wl.ui.banner.transformer.DepthPageTransformer;
import com.wl.ui.banner.transformer.FlipHorizontalTransformer;
import com.wl.ui.banner.transformer.FlipVerticalTransformer;
import com.wl.ui.banner.transformer.ForegroundToBackgroundTransformer;
import com.wl.ui.banner.transformer.RotateDownTransformer;
import com.wl.ui.banner.transformer.RotateUpTransformer;
import com.wl.ui.banner.transformer.ScaleInOutTransformer;
import com.wl.ui.banner.transformer.StackTransformer;
import com.wl.ui.banner.transformer.TabletTransformer;
import com.wl.ui.banner.transformer.ZoomInTransformer;
import com.wl.ui.banner.transformer.ZoomOutSlideTransformer;
import com.wl.ui.banner.transformer.ZoomOutTranformer;

public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
