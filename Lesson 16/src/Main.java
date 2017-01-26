import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by vig on 11/25/16.
 */
public class Main {
    public static void main(String[] args) {
        Set s = new HashSet();
        List<String> alp = new ArrayList<>();
        alp.add("string1");
        alp.add("String1");
        alp.add("sTring1");
        alp.add("sTring2");
        alp.add("stRing3");
        Collections.sort(alp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        int index = Collections.binarySearch(alp, "STRING1", String.CASE_INSENSITIVE_ORDER);
        //or String.CASE_INSENSITIVE_ORDER);
        //example: alp.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(alp);
        System.out.println(index);

        Collections.sort(alp);
        System.out.println(alp);
        index = Collections.binarySearch(alp, "string1");
        System.out.println(index);

        for(String ss : alp) {
            System.out.println(ss);
        }
        for (String ss : alp) {                //поиск по коллекции с условием
            if(ss.equalsIgnoreCase("STRING1"));
            System.out.println(ss);
        }
        //Lambda

        // (s1,s2) -> s1.length() - s2.length(); //если только одна строка в методе
        Comparator<String> comparator = (s1,s2) -> {
          return s1.length() - s2.length();
        };
        //int compare(T o1,T o2)
        //(T o1,T o2)
        //(String s1, String s2)
        //(s1, s2)

        //int compare(T o1,T o2){
        //  return s1.length() - s2.length();
        //}
        //---
        //(s1, s2) -> {                         // если метод больше одной строки
        //    System.out.println();
        //    return s1.length() - s2.length();
        //}

        Predicate<Integer> p = (i) -> i % 2 == 0; //выдает boolean
        System.out.println(p.test(5)); //метод из предиката
        System.out.println(p.test(4)); //метод из предиката

        Function<Integer, Double> f = (i) -> (double)i * 2; //функция <входной параметр, выходной параметр> название объекта = переменная -> тело функции;
        System.out.println(f.apply(2)); //применяет лямбду
        System.out.println(f.apply(3));

        alp.stream()
                .filter(sss -> sss.equalsIgnoreCase("STRING1"))
                .forEach(sss1 -> System.out.println(sss1));

        // Многопоточность

        List<String> c = new ArrayList<>();
        c.add("string1dsfdsf");
        c.add("stRing3sdfsdfsdfsdf");
        c.add("String1sdf");
        c.add("sTring2sdfsdfsdfsdfsdfsdf");
        c.add("sTr");

        List<Integer> ints = c.stream()
                .map(ss -> ss.length())
                .collect(Collectors.toList()); //одна коллекция преобразовуется в другую

        Optional<String> opt = c.stream()
                .filter(ss -> s.equals("sTr"))
                .findAny();
        opt.isPresent();
        String ob = opt.orElseGet(() -> "default");

        System.out.println(ob);

        System.out.println(ints);
        int max = c.stream()
                .filter(ss -> ss.length() > 3)
                .map(ss -> ss.length())
                .max((o1, o2) -> o1 - o2)
                .map(i -> i * 2)
                .get();  // получает лишь по одному элементу из коллекции

        System.out.println(max);

    }
}
