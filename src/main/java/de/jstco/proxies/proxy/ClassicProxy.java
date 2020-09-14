package de.jstco.proxies.proxy;

import de.jstco.proxies.app.Something;

public class ClassicProxy implements Something {

    private final Something delegate;

    public ClassicProxy(Something something) {
        this.delegate = something;
    }

    @Override
    public String doSomething(String input) {
        System.out.println("[classic  ] before");
        String result = delegate.doSomething(input);
        System.out.println("[classic  ] after");

        return result;
    }
}
