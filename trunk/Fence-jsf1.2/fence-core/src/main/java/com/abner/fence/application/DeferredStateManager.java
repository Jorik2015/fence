/*
 * DeferredStateManager.java
 *
 * Created on June 26, 2006, 8:36 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abner.fence.application;

import java.io.IOException;

import javax.faces.application.StateManager;
import javax.faces.application.StateManagerWrapper;
import javax.faces.context.FacesContext;

import com.abner.fence.util.RequestUtils;

/**
 * <p>Decorate the existing <code>StateManager</code> and disable
 * writing state in the case of an AJAX request, as indicated by a
 * <code>true</code> return from {@link
 * com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#isAjaxRequest}.
 * In this case, state is initiated manually by the {@link
 * com.abner.fence.lifecycle.PartialLifecycleImpl#render}
 * method.</p>
 */

public class DeferredStateManager extends StateManagerWrapper {
        
    private StateManager parent = null;
    public DeferredStateManager(StateManager parent) {
        this.parent = parent;
    }

    /**
     * <p>Return the parent <code>StateManager</code></p>
     */ 

    public StateManager getWrapped() { return parent; }

    /**
     * <p>If {@link
     * com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#isAjaxRequest}
     * returns <code>true</code>, take no action, otherwise call the
     * method on the wrapped object.</p>
     */

    public void writeState(FacesContext context, Object state) throws IOException {
        if (!RequestUtils.isAjaxRequest() || RequestUtils.isPostBack()) {
            getWrapped().writeState(context, state);
        }
    }

    /**
     * <p>If {@link
     * com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#isAjaxRequest}
     * returns <code>true</code>, take no action, otherwise call the
     * method on the wrapped object.</p>
     */

    public Object saveView(FacesContext context) {
        Object result = null;
        if (!RequestUtils.isAjaxRequest() || RequestUtils.isPostBack()) {
            result = getWrapped().saveView(context);
        }
        return result;
    }

    /**
     * <p>If {@link 
     * com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#isAjaxRequest}
     * returns <code>true</code>, take no action, otherwise call the
     * method on the wrapped object.</p>
     */

    @SuppressWarnings("deprecation")
	public StateManager.SerializedView saveSerializedView(FacesContext context) {
        StateManager.SerializedView result = null;
        if (!RequestUtils.isAjaxRequest() || RequestUtils.isPostBack()) {
            result = getWrapped().saveSerializedView(context);
        }

        return result;
    }

    /**
     * <p>If {@link 
     * com.sun.faces.extensions.avatar.lifecycle.AsyncResponse#isAjaxRequest}
     * returns <code>true</code>, take no action, otherwise call the
     * method on the wrapped object.</p>
     */

    @SuppressWarnings("deprecation")
	public void writeState(FacesContext context, StateManager.SerializedView state) throws IOException {
        if (!RequestUtils.isAjaxRequest() || RequestUtils.isPostBack()) {
            getWrapped().writeState(context, state);
        }
    }
}

