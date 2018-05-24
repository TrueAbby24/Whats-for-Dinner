package com.infs3202.wfd.whatsfordinner;

import android.support.design.widget.TextInputEditText;

/**
 * Declare methods to be overridden in NavBaseActivity that are used for interacting with fragments
 */

public interface OnFragmentInteractionListener {
    /**
     * Method for changing fragments without using the drawer menu
     * @param id - String used to identify which fragments will be loaded
     */
    void changeFragment(String id);

    String getNameSearchParam(TextInputEditText editText);
}


