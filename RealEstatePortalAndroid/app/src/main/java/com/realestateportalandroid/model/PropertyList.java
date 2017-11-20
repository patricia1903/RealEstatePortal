package com.realestateportalandroid.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyList {

    private static List<Property> properties=new ArrayList<>(Arrays.asList(
            new Property("12KSBSZ44","Nice apartment in the heart of the city. 1 kitchen...","Nice apartment in the heart of the city","55.500$","D","E","F","G"),
            new Property("62KSBSS4","Beautiful house at the country. Green space..","Beautiful house at the country side","100.000$","D","E","F","G"),
            new Property("33KSXyZ41","Modern apartment on the 50 Avenue...","Modern apartment on the 50 Avenue","33.455$","D","E","F","G")));



    public static List<Property> getProperties(){
        return properties;
    }

}
