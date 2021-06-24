package com.macpietr.barbershop;

import org.apache.commons.lang3.RandomStringUtils;

public class UrlGenerator {

    public static String generate(){
        return RandomStringUtils.random(20,true,true);
    }
}
