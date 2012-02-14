/*
 * ExtensionsLifecycleFactoryImpl.java
 *
 * Created on May 15, 2006, 4:27 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abner.fence.lifecycle;

import java.util.Iterator;

import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;

/**
 * 
 * @author abner
 */
public class ExtLifecycleFactoryImpl extends LifecycleFactory {

	private final static String PARTIAL_LIFECYCLE = "com.abner.fence.lifecycle.PARTIAL";

	private LifecycleFactory parent = null;

	/** Creates a new instance of ExtensionsLifecycleFactoryImpl */
	public ExtLifecycleFactoryImpl(LifecycleFactory parent) {
		this.parent = parent;
		if (alreadyCreated(PARTIAL_LIFECYCLE)) {
			return;
		}
		PartialLifecycleImpl plf = new PartialLifecycleImpl(
				this.parent.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE));
		this.parent.addLifecycle(PARTIAL_LIFECYCLE, plf);
	}

	public Lifecycle getLifecycle(String string) {
		return parent.getLifecycle(string);
	}

	public void addLifecycle(String string, Lifecycle lifecycle) {
		if (alreadyCreated(string)) {
			return;
		}
		parent.addLifecycle(string, lifecycle);
	}

	public Iterator<String> getLifecycleIds() {
		return parent.getLifecycleIds();
	}

	boolean alreadyCreated(String lifecycleId) {
		Iterator<String> iter = this.getLifecycleIds();
		while (iter.hasNext()) {
			String existingId = iter.next();
			if (existingId.equals(lifecycleId)) {
				return true;
			}
		}
		return false;
	}
}
