import java.util.Scanner;

public class Main {
    public static void showcaseArrayList(){
        Scanner sc = new Scanner(System.in);
        MyArrayList myArrayListInt = new MyArrayList<Integer>();
        System.out.println("MyArrayList<Integer>:");
        System.out.println("> Size: " + myArrayListInt.size());
        System.out.println("<Integer>:");
        System.out.println("Write -1 for stop input");
        int nextInt;
        while(true) {
            nextInt = sc.nextInt();
            if (nextInt == -1) break;
            myArrayListInt.add(nextInt);
        }
        System.out.println("> Your array: " + myArrayListInt);
        System.out.println("> Size: " + myArrayListInt.size());

        System.out.println(" Enter the element and index separated by a space:");
        nextInt = sc.nextInt();
        int nextIndex = sc.nextInt();
        myArrayListInt.add(nextInt, nextIndex);
        System.out.println(" To remove the element at your index. Enter it:");
        nextIndex = sc.nextInt();
        myArrayListInt.remove(nextIndex);
        System.out.println("> Your array: " + myArrayListInt);

        System.out.println("To remove the element without knowing its index. Enter number to delete:");
        nextInt = sc.nextInt();
        myArrayListInt.remove((Object) nextInt);
        System.out.println("> Your array: " + myArrayListInt);

        System.out.println("Is the element you entered in the array?");
        nextInt = sc.nextInt();
        System.out.println(myArrayListInt.contains(nextInt));

        System.out.println("The first index of the occurrence of the element you entered in the array");
        nextInt = sc.nextInt();
        System.out.println(myArrayListInt.indexOf(nextInt));

        System.out.println("The last index of the occurrence of the element you entered in the array");
        nextInt = sc.nextInt();
        System.out.println(myArrayListInt.lastIndexOf(nextInt));
    }

    public static void showCaseLinkedNode() {
        Scanner sc = new Scanner(System.in);
        MyLinkedList myLinkedList = new MyLinkedList<Integer>();
        System.out.println(" MyLinkedList<Integer>:");
        System.out.println("> Size: " + myLinkedList.size());
        System.out.println("<Integer>:");
        System.out.println("Write -1 for stop input");
        int nextInt;
        while (true) {
            nextInt = sc.nextInt();
            if (nextInt == -1) break;
            myLinkedList.add(nextInt);
        }
        System.out.println("> Size: " + myLinkedList.size());

        System.out.println(" Enter the element and index separated by a space:");
        nextInt = sc.nextInt();
        int nextIndex = sc.nextInt();
        myLinkedList.add(nextInt, nextIndex);
        System.out.println("To remove the element at your index. Enter it:");
        nextIndex = sc.nextInt();
        myLinkedList.remove(nextIndex);
        System.out.println("> Your array: " + myLinkedList);

        System.out.println("To remove the element without knowing its index. Enter number to delete:");
        nextInt = sc.nextInt();
        myLinkedList.remove((Object) nextInt);
        System.out.println("> Your array: " + myLinkedList);

        System.out.println("Is the element you entered in the array?");
        nextInt = sc.nextInt();
        System.out.println(myLinkedList.contains(nextInt));

        System.out.println("The first index of the occurrence of the element you entered in the array");
        nextInt = sc.nextInt();
        System.out.println(myLinkedList.indexOf(nextInt));

        System.out.println("The last index of the occurrence of the element you entered in the array");
        nextInt = sc.nextInt();
        System.out.println(myLinkedList.lastIndexOf(nextInt));
    }
    public static void main(String[] args) {
            showcaseArrayList();
            showCaseLinkedNode();
        }
    }