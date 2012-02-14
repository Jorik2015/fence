package com.abner.action;

import java.util.Calendar;
import java.util.Stack;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.abner.fence.web.Params;

@Controller
@Scope("globalSession")
public class ChatAction {
	private static Stack<String> stack = new Stack<String>();

	public Stack<String> getChatContent() {
		return stack;
	}

	public void send() {
		String c = Params.getParam("say").getStringValue();
		System.out.println("some one say:" + c);
		stack.add(DateFormatUtils.format(Calendar.getInstance(), "MM/dd HH:ss")	+ "  " + c);
	}
}
