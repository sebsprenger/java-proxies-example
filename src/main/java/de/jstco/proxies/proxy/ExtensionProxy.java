package de.jstco.proxies.proxy;

import de.jstco.proxies.app.SomethingImpl;

public class ExtensionProxy extends SomethingImpl {

    @Override
    public String doSomething(String input) {
        System.out.println("[extension] in");
        String result = super.doSomething(input);
        System.out.println("[extension] out");

        return result;
    }

}
