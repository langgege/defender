package org.nico.defender.utils;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

public class AspectUtils {

	public static Method getMethod(ProceedingJoinPoint point) throws NoSuchMethodException, SecurityException {
		Signature sig = point.getSignature();
		MethodSignature msig = null;
		Method method = null;
		if (sig instanceof MethodSignature) {
			msig = (MethodSignature) sig;
			Object target = point.getTarget();
			method = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
		}
		return method;
	}
	
	public static Class<?> getClass(ProceedingJoinPoint point){
		return point.getTarget().getClass();
	}
}
