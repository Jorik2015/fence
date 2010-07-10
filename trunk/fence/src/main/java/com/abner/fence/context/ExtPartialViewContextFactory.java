package com.abner.fence.context;

import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.context.PartialViewContextFactory;

public class ExtPartialViewContextFactory extends PartialViewContextFactory {
	private PartialViewContextFactory parent;

	public ExtPartialViewContextFactory(PartialViewContextFactory parent) {
		super();
		this.parent = parent;
	}

	@Override
	public PartialViewContext getPartialViewContext(FacesContext context) {
		ExtPartialViewContextImpl viewContext = new ExtPartialViewContextImpl(this.parent
				.getPartialViewContext(context), context);
		return viewContext;
	}
}
