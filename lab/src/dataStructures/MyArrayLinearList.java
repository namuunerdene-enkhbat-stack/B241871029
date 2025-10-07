package dataStructures;


import java.util.Scanner;


public class MyArrayLinearList extends ArrayLinearList {

    public MyArrayLinearList() {
        super();
    }

    //minii interface uud//
    public int max() {
        if (size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        int maxVal = (Integer) get(0);
        for (int i = 0; i < size(); i++) {
            int val = (Integer) get(i);
            if (val > maxVal) {
                maxVal = val;
            }
        }
        return maxVal;
    }

    
    public int min() {
        if (size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        int minVal = (Integer) get(0);
        for (int i = 1; i < size(); i++) {
            int val = (Integer) get(i);
            if (val < minVal) {
                minVal = val;
            }
        }
        return minVal;
    }

    
    public int sum() {
        int s = 0;
        for (int i = 0; i < size(); i++) {
            s += (Integer) get(i);
        }
        return s;
    }


    public double average() {
        if (size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        return (double) sum() / size();
    }


    public void removeOdd() {
        int j = 0;
        for (int i = 0; i < size(); i++) {
            int val = (Integer) get(i);
            if (val % 2 == 0) {
                element[j++] = val; // tegsh toonuudaa uldeeh
            }
        }
        size = j;
    }

 
    public void sort() {
        for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - 1; j++) {
                int left = (Integer) get(j);
                int right = (Integer) get(j + 1);
                if (left > right) {
                    element[j] = right;
                    element[j + 1] = left;
                }
            }
        }
    }

    
    public static void main(String[] args) {
        MyArrayLinearList list = new MyArrayLinearList();
        Scanner sc = new Scanner(System.in);

        int cmd = 0;
        while (cmd != -1) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Add element");
            System.out.println("2. Remove last element");
            System.out.println("3. Display list");
            System.out.println("4. Max / Min");
            System.out.println("5. Sum / Average");
            System.out.println("6. Remove odd numbers");
            System.out.println("7. Sort list");
            System.out.println("-1. Exit");
            System.out.print("Command? ");

            try {
                cmd = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                sc.nextLine();
                continue;
            }

            try {
                switch (cmd) {
                    case 1 -> {
                        System.out.print("Value? ");
                        int val = sc.nextInt();
                        list.add(list.size(), val); 
                        System.out.println(val + " added.");
                    }
                    case 2 -> {
                        if (list.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            System.out.println("Removed: " + list.remove(list.size() - 1));
                        }
                    }
                    case 3 -> System.out.println("List: " + list);
                    case 4 -> {
                        if (list.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            System.out.println("Max = " + list.max() + ", Min = " + list.min());
                        }
                    }
                    case 5 -> {
                        if (list.isEmpty()) {
                            System.out.println("List is empty.");
                        } else {
                            System.out.println("Sum = " + list.sum() + ", Average = " + list.average());
                        }
                    }
                    case 6 -> {
                        list.removeOdd();
                        System.out.println("Removed odd numbers.");
                    }
                    case 7 -> {
                        list.sort();
                        System.out.println("List sorted.");
                    }
                    case -1 -> System.out.println("Exiting...");
                    default -> System.out.println("Unknown command.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }

    
    
}