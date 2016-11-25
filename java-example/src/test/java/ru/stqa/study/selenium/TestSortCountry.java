package ru.stqa.study.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.*;

/**
 * Created by oleg on 25.11.16.
 */
public class TestSortCountry extends TestBase {



    @Test
    public void testSortCountry() throws Exception {
        openLiteCartAdmin();
        loginLiteCart("admin", "admin");
        driver.findElement(By.cssSelector("a[href*=countries]")).click();
        List<String> listContries =  getArraysContriesList();
//        Collator ruCollator = Collator.getInstance(Locale.US);
//        ruCollator.compare(listContries);


//        Set<String> sortedSet = new TreeSet<String>(new Comparator<String>() {
//            public int compare(String o1, String o2) {
//                return o1.toString().compareTo(o2.toString());
//            }
//        });
//        sortedSet.addAll(getArraysContriesSet());
//        System.out.println(sortedSet.addAll(getArraysContriesSet()));

    }


    public List<String> getArraysContriesList(){
        List<String> arrayCountries = new ArrayList<>();
        List<WebElement> countries = driver.findElements(By.cssSelector("tr.row td:nth-of-type(5) a"));

        for (WebElement country: countries){
            arrayCountries.add(country.getText());

        }
        return arrayCountries;
    }


//    private String[] collatorSort(String alphabet, Locale locale) {
//        return sort(new TreeSet<String>(Collator.getInstance(locale)),alphabet[]);
//    }


    public Set<String> getArraysContriesSet(){
        Set<String> arrayCountries = new HashSet<>();
        List<WebElement> countries = driver.findElements(By.cssSelector("tr.row td:nth-of-type(5) a"));

        for (WebElement country: countries){
            arrayCountries.add(country.getText());

        }
        return arrayCountries;
    }


//    public Set<String> sortSet(Set<String> set){
//        Set<String> sortedSet = new TreeSet<String>(new Comparator<String>() {
//            public int compare(String o1, String o2) {
//                return o1.toString().compareTo(o2.toString());
//            }
//        });
//       sortedSet.addAll(set);
//    }

//    Comparator<? super  String> alphabet = (g1,g2)-> g1.toString().equals(g2.toString());


//    private String[] collatorSort(String text, Locale locale){
//        return
//    }


    private String[] sort(String[] text){
        Set<String> set = new TreeSet<String>(Arrays.asList(text));
        return set.toArray(new String[set.size()]);
    }


//    private List<String> sortList(List<String> text){
//        List<String> set = new TreeSet<String>(ArrayList<String>.add(text));
//        return set.toArray(new String[set.size()]);
//    }

    private String[] sort(Set<String> set, String[] text){
        set.addAll(Arrays.asList(text));
        return set.toArray(new String[set.size()]);
    }



}
