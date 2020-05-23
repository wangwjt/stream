import entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangjiantao
 * @date 2020/5/23 11:44
 */
public class ApplicationMain {

    public static List<Person> list;

    static {
        list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
    }

    /**
     * filter使用：过滤
     * 过滤出age等于20的
     * @param list
     * @return
     */
    public static List<Person> filterDemo(List<Person> list){
        return list.stream().filter(e -> e.getAge() == 20).collect(Collectors.toList());
    }

    /**
     * sorted使用：排序
     * 按年龄排序(小->大)
     * @param list
     * @return
     */
    public static List<Person> sortedDemo1(List<Person> list){
        return list.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
    }
    /**
     * sorted使用：排序
     * 按年龄排序(大->小)
     * @param list
     * @return
     */
    public static List<Person> sortedDemo2(List<Person> list){
        return list.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
    }

    /**
     * limit使用：返回前几个元素
     * 返回前2个元素
     * @param list
     * @return
     */
    public static List<Person> limitDemo(List<Person> list){
        return list.stream().limit(2).collect(Collectors.toList());
    }

    /**
     * skip使用：忽略前几个元素
     * 忽略前2个元素
     * @param list
     * @return
     */
    public static List<Person> skipDemo(List<Person> list){
        return list.stream().skip(2).collect(Collectors.toList());
    }

    /**
     * map使用：映射，将流中的每一个元素 T 映射为 R（类似类型转换）
     * 将所有person的name提取出
     * @param list
     * @return
     */
    public static List<String> mapDemo(List<Person> list){
        return list.stream().map(e -> e.getName()).collect(Collectors.toList());
    }

    /**
     * flatMap使用：将流中的每一个元素 T 映射为一个流，再把每一个流连接成为一个流
     * 把 List 中每个字符串元素以" "分割开，变成一个新的 List<String>
     * @return
     */
    public static List<String> flatMapDemo(){
        List<String> list = new ArrayList<>();
        list.add("aa bb cc");
        list.add("dd ee ff");
        // 每个元素以" "分割开后，此时流的类型为 Stream<String[ ]>，因为 split 方法返回的是 String[ ] 类型；
        // 所以我们需要使用 flatMap 方法，先使用Arrays::stream将每个 String[ ] 元素变成一个 Stream<String> 流，
        // 然后 flatMap 会将每一个流连接成为一个流，最终返回我们需要的 Stream<String>
        return list.stream().map(e -> e.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    /**
     * anyMatch使用：流中是否有一个元素匹配给定的 T -> boolean 条件
     * 判断list中是否满足条件：年龄=20
     * @param list
     * @return
     */
    public static boolean anyMatchDemo(List<Person> list){
        return list.stream().anyMatch(e -> e.getAge() == 20);
    }

    /**
     * allMatch使用：流中是否所有元素都匹配给定的 T -> boolean 条件
     * 判断list中是否满足条件：年龄=20
     * @param list
     * @return
     */
    public static boolean allMatchDemo(List<Person> list){
        return list.stream().allMatch(e -> e.getAge() == 20);
    }

    /**
     * reduce使用：用于组合流中的元素，如求和，求积，求最大值等
     * 计算年龄总和
     * @param list
     * @return
     */
    public static Integer reduceDemo(List<Person> list){
        return list.stream().map(Person::getAge).reduce(0, (a, b) -> a + b);
    }

    /**
     * count使用：返回流中元素个数，结果为 long 类型
     * 计算list元素个数
     * @param list
     * @return
     */
    public static Long countDemo(List<Person> list){
        return list.stream().count();
    }

    /**
     * 遍历list
     * @param list
     * @return
     */
    public static void forEachDemo(List<Person> list){
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        forEachDemo(list);
    }
}
