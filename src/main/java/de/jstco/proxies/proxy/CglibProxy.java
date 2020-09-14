package de.jstco.proxies.proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.util.Arrays;

public class CglibProxy<T> implements InvocationHandler {
    private final T actualImpl;

    public CglibProxy(T actualImpl) {
        this.actualImpl = actualImpl;
    }

    public static <T> T newProxy(Class<T> returnType, T actualImpl) {
        InvocationHandler handler = new CglibProxy<T>(actualImpl);
        Object proxyInstance = Enhancer.create(returnType, handler);

        return returnType.cast(proxyInstance);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("[cglib    ] method=" + method);
        System.out.println("[cglib    ] args=" + Arrays.toString(args));

        System.out.println("[cglib    ] >> before method");
        Object result = method.invoke(actualImpl, args);
        System.out.println("[cglib    ] << after method");

        return result;
    }

}