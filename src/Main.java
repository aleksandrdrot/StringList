public class Main {
    public static void main(String[] args) {
        StringList list = new StringList(5);
        StringList list1 = new StringList(5);
        list.add("Вчера");
        list.add("Было");
        list.add("Лучше");
        list.add("asd");

        list.getList();
        System.out.println(list.indexOf("asd"));
        System.out.println(list.lastIndexOf("asd"));
        System.out.println(list.get(1));
        System.out.println(list.contains(""));
//        list.clear();
//        list.getList();
//        System.out.println(list.size());
        //list.add(1,"asd");
//        list.add(4,"asd1");
//        list.getList();
//
        //list.set(2,"wer");
//        list.remove("Было");
//        list.getList();
//        System.out.println();
//        list.add(1,"asd1");
//        list.getList();
//        System.out.println();
//        list.remove(1);
//        list.getList();

    }
}