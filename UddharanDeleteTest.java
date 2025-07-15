package com.gg.testcases;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * Deletes SINGLE or MULTIPLE record(s) from the उद्धरण grid.
 * isMultipleDelete = false → Delete 10th record on Page 1
 * isMultipleDelete = true  → Go to Page 65, delete 3 selected records
 */
public class UddharanDeleteTest extends LoginTest {

    private static final String DELETE_PWD = "p123";
    private static final boolean isMultipleDelete = true; // 🔁 true = multiple delete, false = single delete

    public static void main(String[] args) throws Exception {
        UddharanDeleteTest test = new UddharanDeleteTest();
        test.loginToGG();

        Robot robot = new Robot();
        robot.setAutoDelay(250);

        // ALT + B → Menu
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_ALT);
        Thread.sleep(500);

        // DOWN × 4 → Select 'उद्धरण'
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(200);
        }
        pressEnter(robot);

        // Wait for table to load
        Thread.sleep(10_000);

        if (isMultipleDelete) {
            // SHIFT + G → Go to Page 65
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            Thread.sleep(500);

            typeString(robot, "65");
            pressEnter(robot);
            Thread.sleep(5000);

            // Select first 3 records using SHIFT + DOWN
            robot.keyPress(KeyEvent.VK_SHIFT);
            for (int i = 0; i < 3; i++) {
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                Thread.sleep(300);
            }
            robot.keyRelease(KeyEvent.VK_SHIFT);
        } else {
            // Go to 10th record on Page 1
            for (int i = 0; i < 10; i++) {
                robot.keyPress(KeyEvent.VK_DOWN);
                robot.keyRelease(KeyEvent.VK_DOWN);
                Thread.sleep(200);
            }
        }

        // CTRL + D → Delete
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(800);

        // Press ENTER on confirmation popup
        pressEnter(robot);
        Thread.sleep(1000);

        // Type password and ENTER
        typeString(robot, DELETE_PWD);
        pressEnter(robot);
        Thread.sleep(3000);

        // ESC to close popup
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        if (isMultipleDelete) {
            System.out.println("✅ Multiple records deleted from Page 65.");
        } else {
            System.out.println("✅ 10th record deleted from Page 1.");
        }
    }

    private static void pressEnter(Robot r) throws InterruptedException {
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(300);
    }

    private static void typeString(Robot r, String s) throws InterruptedException {
        for (char ch : s.toCharArray()) {
            int kc = KeyEvent.getExtendedKeyCodeForChar(ch);
            r.keyPress(kc);
            r.keyRelease(kc);
            Thread.sleep(120);
        }
    }
}
