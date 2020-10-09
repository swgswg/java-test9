package com;

import java.util.*;

/**
 * 1. 定义一个集合，集合中元素及元素出现的次数为 "a":2,“b”:2,“c”:1,“xxx”:0
 * 2.  定义一个集合， 要求：
 * 	1）元素及对应元素出现次数分别为 "a":2,“b”:3“c”:1,
 * 	2） 删除重复的元素
 * 3. 定义一个学生类Student，包含三个属性姓名name、年龄age、性别gender，创建三个学生对象存入ArrayList集合中。
 * 	姓名 年龄  性别
 * 	张三   20  男
 * 	李希  39   男
 * 	小七  18   女
 *   1）：遍历集合遍历输出。
 *   2）：求出年龄最大的学生，让后将该对象的姓名变为：葫芦娃。
 * 4. 创建一个List，在List 中增加三个工人Worker，基本信息如下：
 * 	姓名   年龄 工资
 * 	zhang3 18   3000
 * 	li4    25   3500
 * 	wang5  22   3200
 * 	2) 在li4 之前插入一个工人，信息为：姓名：zhao6，年龄：24，工资3300
 * 	3) 删除wang5 的信息
 * 	4) 利用for 循环遍历，打印List 中所有工人的信息
 * 5.  有如下Student 对象，包含三个属性姓名、年龄、分数，班号，
 * 	private String name;
 * 	private int age;
 * 	private int score;
 * 	private String classNum;
 * 其中，classNum 表示学生的班号，例如“class05”。 创建集合并完成下列要求：
 * 	1） 计算所有学生的平均年龄
 * 	2） 计算各个班级的平均分
 * 	姓名 年龄 分数 班号
 * 	Tom   18  100 class05
 * 	Jerry 22   70 class04
 * 	Owen  25   90 class05
 * 	Jim   30   80 class05
 * 	Steve 28   66 class06
 * 	Kevin 24  100 class04
 */
public class Main {

    public static void main(String[] args) {
        listTest();

        System.out.println("2---------------------------");
        listTest2();

        System.out.println("3---------------------------");
        student();

        System.out.println("4---------------------------");
        worker();

        System.out.println("5---------------------------");
        students();
    }


    /**
     * 定义一个集合，集合中元素及元素出现的次数为 "a":2,“b”:2,“c”:1,“xxx”:0
     */
    public static void listTest() {
        List<String> listTest = new ArrayList<>();

        listTest.add("a");
        listTest.add("a");
        listTest.add("b");
        listTest.add("b");
        listTest.add("c");

        System.out.println("a:"+listValueCount(listTest, "a"));
        System.out.println("b:"+listValueCount(listTest, "b"));
        System.out.println("c:"+listValueCount(listTest, "c"));
        System.out.println("xxx:"+listValueCount(listTest, "xxx"));
    }


    /**
     * 2.  定义一个集合， 要求：
     * 	1）元素及对应元素出现次数分别为 "a":2,“b”:3“c”:1,
     * 	2） 删除重复的元素
     */
    public static void listTest2() {
        List<String> listTest2 = new ArrayList<>();

        listTest2.add("a");
        listTest2.add("a");
        listTest2.add("b");
        listTest2.add("b");
        listTest2.add("b");
        listTest2.add("c");

        System.out.println("a:"+listValueCount(listTest2, "a"));
        System.out.println("b:"+listValueCount(listTest2, "b"));
        System.out.println("c:"+listValueCount(listTest2, "c"));

        System.out.println("去重后================");
        Collection lists = listUnique(listTest2);
        System.out.println("a:"+listValueCount(lists, "a"));
        System.out.println("b:"+listValueCount(lists, "b"));
        System.out.println("c:"+listValueCount(lists, "c"));
    }

    /**
     * 3. 定义一个学生类Student，包含三个属性姓名name、年龄age、性别gender，创建三个学生对象存入ArrayList集合中。
     * 	姓名 年龄  性别
     * 	张三   20  男
     * 	李希  39   男
     * 	小七  18   女
     *   1）：遍历集合遍历输出。
     *   2）：求出年龄最大的学生，让后将该对象的姓名变为：葫芦娃。
     */
    public static void student() {
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(20);
        s1.setSex("男");

        Student s2 = new Student();
        s2.setName("李希");
        s2.setAge(39);
        s2.setSex("男");

        Student s3 = new Student();
        s3.setName("小七");
        s3.setAge(18);
        s3.setSex("女");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        int maxAge = 0;
        Student maxAgeStu = null;
        for (Student student: students) {
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getSex());
            System.out.println("===========================");

            if (student.getAge() > maxAge) {
                maxAge = student.getAge();
                maxAgeStu = student;
            }
        }
        System.out.println("年龄最大的学生是: " + maxAgeStu.getName());
        maxAgeStu.setName("葫芦娃");
        System.out.println(maxAgeStu.getName());
        System.out.println(maxAgeStu.getAge());
        System.out.println(maxAgeStu.getSex());
        System.out.println("===========================");

    }


    /**
     * 4. 创建一个List，在List 中增加三个工人Worker，基本信息如下：
     * 	姓名   年龄 工资
     * 	zhang3 18   3000
     * 	li4    25   3500
     * 	wang5  22   3200
     * 	2) 在li4 之前插入一个工人，信息为：姓名：zhao6，年龄：24，工资3300
     * 	3) 删除wang5 的信息
     * 	4) 利用for 循环遍历，打印List 中所有工人的信息
     */
    public static void worker() {
        Worker w1 = new Worker();
        w1.setName("zhang3");
        w1.setAge(18);
        w1.setWages(3000);

        Worker w2 = new Worker();
        w2.setName("li4");
        w2.setAge(25);
        w2.setWages(3500);

        Worker w3 = new Worker();
        w3.setName("wang5");
        w3.setAge(22);
        w3.setWages(3200);

        List<Worker> list = new ArrayList();
        list.add(w1);
        list.add(w2);
        list.add(w3);

        for (Worker worker: list) {
            System.out.println(worker.getName());
            System.out.println(worker.getAge());
            System.out.println(worker.getWages());
            System.out.println("===========================");
        }

        Worker w4 = new Worker();
        w4.setName("zhao6");
        w4.setAge(24);
        w4.setWages(3300);

        // 插入zhao6
        System.out.println("插入zhao6===========================");
        int idx = list.indexOf(w2);
        list.add(idx, w4);

        for (Worker worker: list) {
            System.out.println(worker.getName());
            System.out.println(worker.getAge());
            System.out.println(worker.getWages());
            System.out.println("===========================");
        }

        // 删除wang5
        System.out.println("删除wang5==========================");
        int idx2 = list.indexOf(w3);
        list.remove(idx2);
        for (Worker worker: list) {
            System.out.println(worker.getName());
            System.out.println(worker.getAge());
            System.out.println(worker.getWages());
            System.out.println("===========================");
        }
    }


    /**
     * 1） 计算所有学生的平均年龄
     * 2） 计算各个班级的平均分
     *   姓名 年龄 分数 班号
     *   Tom   18  100 class05
     *   Jerry 22   70 class04
     *   Owen  25   90 class05
     *   Jim   30   80 class05
     *   Steve 28   66 class06
     *   Kevin 24  100 class04
     */
    public static void students() {
        Student s1 = new Student();
        s1.setName("Tom");
        s1.setAge(18);
        s1.setScore(100);
        s1.setClassNum("class05");

        Student s2 = new Student();
        s2.setName("Jerry");
        s2.setAge(22);
        s2.setScore(70);
        s2.setClassNum("class04");

        Student s3 = new Student();
        s3.setName("Owen");
        s3.setAge(25);
        s3.setScore(90);
        s3.setClassNum("class05");

        Student s4 = new Student();
        s4.setName("Jim");
        s4.setAge(30);
        s4.setScore(80);
        s4.setClassNum("class05");

        Student s5 = new Student();
        s5.setName("Steve");
        s5.setAge(28);
        s5.setScore(66);
        s5.setClassNum("class06");

        Student s6 = new Student();
        s6.setName("Kevin");
        s6.setAge(24);
        s6.setScore(100);
        s6.setClassNum("class04");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        int ageSum =0;
        int size = students.size();
        for(int i = 0; i < size; ++i){
            ageSum += students.get(i).getAge();
        }
        double vagAge = ageSum / size;
        System.out.println("平均年龄是: " + vagAge);

        Map<String, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> slist;
        for(Student stu : students){
            slist = map.get(stu.getClassNum());
            if(slist == null){
                slist = new ArrayList<>();
            }
            slist.add(stu.getScore());
            map.put(stu.getClassNum(), slist);
        }

        for(String className :map.keySet()){
            slist = map.get(className);
            int sumScore = 0;
            for(int score : slist){
                sumScore += score;
            }
            double vagScore = sumScore / slist.size();
            System.out.println(className + "平均分是：" + vagScore);
        }
    }


    /**
     * 统计集合中元素出现的次数
     * @param list
     * @param s
     * @return
     */
    public static int listValueCount(Collection<String> list, String s){
        int count = 0;
        for (String string : list) {
            if (s.equals(string)) {
                count++;
            }
        }
        return count;
    }


    /**
     * 集合去重
     * @param list
     * @return
     */
    public static Collection listUnique(Collection<String> list) {
        HashSet set = new HashSet(list);
        list.clear();
        list.addAll(set);
        return list;
    }

}
