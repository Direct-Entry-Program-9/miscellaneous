public class Demo {

    public static void main(String[] args) {
        String paragraph = "I see something inside you. But the issue is you don't see that in yourself.";
        System.out.println(paragraph.contains("see"));
        System.out.println(paragraph.indexOf("see",0));
        System.out.println(paragraph.indexOf("see",4));
        System.out.println(paragraph.lastIndexOf("see"));
        System.out.println(paragraph.lastIndexOf("see" , 54));
    }
}
