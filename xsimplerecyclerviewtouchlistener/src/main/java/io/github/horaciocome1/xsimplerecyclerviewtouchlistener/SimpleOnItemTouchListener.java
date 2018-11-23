package io.github.horaciocome1.xsimplerecyclerviewtouchlistener;

import android.view.View;

public interface
SimpleOnItemTouchListener {
    
    // this interface should be implemented and passed as a parameter to the
    // SimpleRecyclerViewOnItemTouchListener class
    
    void onItemClick(View view, int position); // where dev should handle user single tap on list
    // item
    
    void onItemDoubleClick(View view, int position); // where dev should handle quick double tap
    // on list item
    
    void onItemLongPress(View view, int position); // where dev should handle a long press on
    // list item
    
}
