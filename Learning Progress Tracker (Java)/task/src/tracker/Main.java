package tracker;

import tracker.core.Menu;

public class Main {
    public static void main(String[] args) {
        final String TITLE = "Learning Progress Tracker";
        System.out.println(TITLE);
        Menu menu = new Menu();
        menu.showMenu();
    }
}
