package com.example.karine.carousel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager mViewPager = findViewById(R.id.pager);

// Aqui estao suas imagens dentro do drawable
        int[] mResources = {
                R.drawable.first,
                R.drawable.second,
                R.drawable.third,
                R.drawable.fourth,
                R.drawable.fifth,
                R.drawable.sixth
        };

        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this, mResources);

        mViewPager.setAdapter(mCustomPagerAdapter);
    }
    public class CustomPagerAdapter extends PagerAdapter {

        private Context mContext;
        private LayoutInflater mLayoutInflater;
        private int[] mResources;

        public CustomPagerAdapter(Context context, int[] resources) {
            mContext = context;
            mResources = resources;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

            ImageView imageView = itemView.findViewById(R.id.imageView);
            imageView.setImageResource(mResources[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }

    }
}

