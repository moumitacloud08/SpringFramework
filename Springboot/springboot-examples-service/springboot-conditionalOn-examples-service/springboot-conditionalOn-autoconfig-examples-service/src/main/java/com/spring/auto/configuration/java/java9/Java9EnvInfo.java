package com.spring.auto.configuration.java.java9;

import com.spring.auto.configuration.java.JavaEnvInfo;

class Java9EnvInfo implements JavaEnvInfo {
    @Override
    public void printJvmEnvInfo() {
        System.out.println("Java >=9 Env Info");
    }
}
