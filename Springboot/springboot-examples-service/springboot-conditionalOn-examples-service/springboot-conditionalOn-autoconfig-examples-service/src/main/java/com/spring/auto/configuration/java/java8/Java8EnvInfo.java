package com.spring.auto.configuration.java.java8;

import com.spring.auto.configuration.java.JavaEnvInfo;

class Java8EnvInfo implements JavaEnvInfo {
    @Override
    public void printJvmEnvInfo() {
        System.out.println("Java <=8 Env Info");
    }
}
