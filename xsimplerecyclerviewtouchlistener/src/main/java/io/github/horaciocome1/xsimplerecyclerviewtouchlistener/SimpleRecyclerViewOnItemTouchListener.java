package io.github.horaciocome1.xsimplerecyclerviewtouchlistener;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleRecyclerViewOnItemTouchListener implements RecyclerView.OnItemTouchListener {
    
    private GestureDetector mGestureDetector;
    
    public SimpleRecyclerViewOnItemTouchListener(Context mContext, final RecyclerView mRecyclerView,
            final SimpleOnItemTouchListener mSimpleOnItemTouchListener) {
        this.mGestureDetector = new GestureDetector(mContext, new GestureDetector
                .SimpleOnGestureListener() {
    
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
//                called when user quickly hits the screen, "maybe" on a list item
//                the goal of this code is to identify whether it was on any recyclerview item or
//                not
//                then to pass this item (view) and its position to the respactive method
//                implementation
    
                View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
                if (!(view == null) && !(mSimpleOnItemTouchListener == null))
                    mSimpleOnItemTouchListener.onItemClick(view, mRecyclerView
                            .getChildAdapterPosition(view));
                return true;
            }
    
            @Override
            public void onLongPress(MotionEvent e) {
//                called when user hits and hold the screen, "maybe" on a list item
//                the goal of this code is to identify whether it was on any recyclerview item or
//                not
//                then to pass this item (view) and its position to the respactive method
//                implementation
    
                View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
                if (!(view == null) && !(mSimpleOnItemTouchListener == null))
                    mSimpleOnItemTouchListener.onItemLongPress(view, mRecyclerView
                            .getChildAdapterPosition(view));
            }
    
            @Override
            public boolean onDoubleTap(MotionEvent e) {
//                called when user quickly hits the screen twice, maybe on a list item
//                the goal of this code is to identify whether it was on any recyclerview item or
//                not
//                then to pass this item (view) and its position to the respactive method
//                implementation
    
                View view = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
                if (!(view == null) && !(mSimpleOnItemTouchListener == null))
                    mSimpleOnItemTouchListener.onItemDoubleClick(view, mRecyclerView
                            .getChildAdapterPosition(view));
                return true;
            }
            
        });
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
}
