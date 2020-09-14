package de.jstco.proxies.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkProxy<T> implements InvocationHandler {

    private final T actualImpl;

    public JdkProxy(T actualImpl) {
        this.actualImpl = actualImpl;
    }

    public static <T> T newProxy(Class<T> returnType, T actualImpl) {
        InvocationHandler handler = new JdkProxy<T>(actualImpl);
        Object proxyInstance = Proxy.newProxyInstance(returnType.getClassLoader(), new Class<?>[]{returnType}, handler);

        return returnType.cast(proxyInstance);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("[jdk proxy] method=" + method);
        System.out.println("[jdk proxy] args=" + Arrays.toString(args));

        System.out.println("[jdk proxy] >> before method");
        Object result = method.invoke(actualImpl, args);
        System.out.println("[jdk proxy] << after method");

        return result;
    }

}
