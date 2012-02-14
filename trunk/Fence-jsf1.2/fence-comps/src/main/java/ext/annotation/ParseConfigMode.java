package ext.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * PersistenceMode 决定组件渲染的方式，默认为Component，
 * 直接渲染成一个新的组件并RendererTo到输出的ContainerID中；
 * InnerProperty为渲染成子控件的一个属性,
 * ParentProperty为渲染成父控件的一个属性,
 * Custom 自定义渲染，一般为可自由的模式;
 * 
 * JsonMode 只是组件渲染后的输出模式，如var指定义一个变量；
 * 
 * name指组件渲染到其他组件时，将添加到哪个属性中，如：items
 * 
 * ui 代表组件是否有html输出
 */
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ParseConfigMode {
	PersistenceMode pmode() default PersistenceMode.Component;

	ReferenceMode rmode() default ReferenceMode.Var;

	String name() default "";
	
	boolean ui() default true;
	
	boolean id() default true;
}
