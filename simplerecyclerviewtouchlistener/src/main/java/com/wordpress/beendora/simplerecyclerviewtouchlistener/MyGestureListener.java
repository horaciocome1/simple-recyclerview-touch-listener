package com.wordpress.beendora.simplerecyclerviewtouchlistener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

    private RecyclerView mRecyclerView;
    private SimpleRecyclerViewOnItemTouchListener.OnItemClickListener mOnItemClickListener;
    private SimpleRecyclerViewOnItemTouchListener.OnItemDoubleClickListener mOnItemDoubleClickListener;
    private SimpleRecyclerViewOnItemTouchListener.OnItemLongPressListener mOnItemLongPressListener;

    public MyGestureListener(RecyclerView mRecyclerView,
                             SimpleRecyclerViewOnItemTouchListener.OnItemClickListener mOnItemClickListener,
                             SimpleRecyclerViewOnItemTouchListener.OnItemDoubleClickListener mOnItemDoubleClickListener,
                             SimpleRecyclerViewOnItemTouchListener.OnItemLongPressListener mOnItemLongPressListener) {
        this.mRecyclerView = mRecyclerView;
        this.mOnItemClickListener = mOnItemClickListener;
        this.mOnItemDoubleClickListener = mOnItemDoubleClickListener;
        this.mOnItemLongPressListener = mOnItemLongPressListener;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        if (!(mRecyclerView == null)) {
            View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (!(view == null) && !(mOnItemClickListener == null))
                mOnItemClickListener.onClick(view, mRecyclerView.getChildAdapterPosition(view));
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        if (!(mRecyclerView == null)) {
            View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (!(view == null) && !(mOnItemClickListener == null))
                mOnItemLongPressListener.onLongPress(view, mRecyclerView.getChildAdapterPosition(view));
        }
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        if (!(mRecyclerView == null)) {
            View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            if (!(view == null) && !(mOnItemClickListener == null))
                mOnItemDoubleClickListener.onDoubleClick(view, mRecyclerView.getChildAdapterPosition(view));
        }
        return true;
    }

}
