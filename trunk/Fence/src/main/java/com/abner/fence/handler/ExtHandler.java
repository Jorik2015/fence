package com.abner.fence.handler;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public interface ExtHandler {
	void processHandler(FacesContext context, UIComponent target) throws IOException;
}