package com.dee.hamrobazzar.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.dee.hamrobazzar.R;

public class ImageSlideAdapter  extends PagerAdapter {

    private Context mContext;
    private int[] image_resource = new int[] {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five};
    private int custom_position = 0;
    public ImageSlideAdapter(Context context)
    {
        mContext = context;
    }

    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(image_resource[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

}
