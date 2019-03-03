/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x.o;

import java.util.Arrays;

/**
 *
 * @author miljan003
 */
public class Contain {
    String[] arr;
    String[] targetValue;
    
    
    
    
    public static boolean useList(String[] arr, String[] targetValue) {
	return Arrays.asList(arr).containsAll(Arrays.asList(targetValue));
}
}
