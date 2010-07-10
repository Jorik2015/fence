package com.abner.fence.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.abner.fence.commons.Enums.JsonMode;

@Target( { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientConfig {
	JsonMode value() default JsonMode.Value;

	String name() default "";
}
