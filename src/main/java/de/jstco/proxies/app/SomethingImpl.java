package de.jstco.proxies.app;

public class SomethingImpl implements Something {

    @Override
    public String doSomething(String input) {
        String result = input.toUpperCase();
        System.out.println("[impl     ] input=" + input + ", result=" + result);
        return result;
    }

}
