package de.jstco.proxies;

import de.jstco.proxies.app.Something;
import de.jstco.proxies.app.SomethingImpl;
import de.jstco.proxies.proxy.CglibProxy;
import de.jstco.proxies.proxy.ClassicProxy;
import de.jstco.proxies.proxy.ExtensionProxy;
import de.jstco.proxies.proxy.JdkProxy;

public class Main {

    private static final String LINE = "--------------------------------------------------------------------------------";

    public static void main(String[] args) {

        Something sth1 = new SomethingImpl();
        sth1.doSomething("Hello World!");

        System.out.println(LINE);

        Something sth2 = new ClassicProxy(new SomethingImpl());
        sth2.doSomething("Hello World!");

        System.out.println(LINE);

        Something sth3 = new ExtensionProxy();
        sth3.doSomething("Hello World!");

        System.out.println(LINE);

        Something sth4 = JdkProxy.newProxy(Something.class, new SomethingImpl());
        sth4.doSomething("Hello World!");

        System.out.println(LINE);

        Something sth5 = CglibProxy.newProxy(Something.class, new SomethingImpl());
        sth5.doSomething("Hello World!");
    }

}
