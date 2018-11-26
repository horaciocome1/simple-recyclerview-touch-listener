package com.wordpress.beendora.simplerecyclerviewtouchlistener;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleRecyclerViewOnItemTouchListener implements RecyclerView.OnItemTouchListener {
    
    private GestureDetector mGestureDetector;

    private SimpleRecyclerViewOnItemTouchListener(Context context, Builder builder, RecyclerView recyclerView) {
        MyGestureListener gestureListener = new MyGestureListener(recyclerView,
                builder.mOnItemClickListener,
                builder.mOnItemDoubleClickListener,
                builder.mOnItemLongPressListener);
        mGestureDetector = new GestureDetector(context, gestureListener);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView,
            @NonNull MotionEvent motionEvent) {
        mGestureDetector.onTouchEvent(motionEvent);
        return false;
    }
    
    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {}
    
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {}

    public static class Builder {

        private SimpleRecyclerViewOnItemTouchListener.OnItemClickListener mOnItemClickListener = null;
        private SimpleRecyclerViewOnItemTouchListener.OnItemDoubleClickListener mOnItemDoubleClickListener = null;
        private SimpleRecyclerViewOnItemTouchListener.OnItemLongPressListener mOnItemLongPressListener = null;

        public Builder setOnItemClickListener(SimpleRecyclerViewOnItemTouchListener.OnItemClickListener mOnItemClickListener) {
            this.mOnItemClickListener = mOnItemClickListener;
            return this;
        }

        public Builder setOnItemDoubleClickListener(SimpleRecyclerViewOnItemTouchListener.OnItemDoubleClickListener mOnItemDoubleClickListener) {
            this.mOnItemDoubleClickListener = mOnItemDoubleClickListener;
            return this;
        }

        public Builder setOnItemLongPressListener(SimpleRecyclerViewOnItemTouchListener.OnItemLongPressListener mOnItemLongPressListener) {
            this.mOnItemLongPressListener = mOnItemLongPressListener;
            return this;
        }

        public SimpleRecyclerViewOnItemTouchListener build(Context context, RecyclerView recyclerView) {
            return new SimpleRecyclerViewOnItemTouchListener(context, this, recyclerView);
        }

    }

    public interface OnItemClickListener {

        void onClick(View view, int position);

    }

    public interface OnItemDoubleClickListener {

        void onDoubleClick(View view, int position);

    }

    public interface OnItemLongPressListener {

        void onLongPress(View view, int position);

    }

}
