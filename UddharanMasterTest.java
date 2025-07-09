package com.gg.testcases;

import com.gg.base.BaseTest;
import com.gg.utils.UddharanUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class UddharanMasterTest extends LoginTest {

    boolean runViaShiftN = true;
    boolean runViaPlusIcon = false;
    boolean runAddInNewGroup = false;
    boolean runTransferNewGroup = false;
    boolean runAddInExistingGroup = false;
    boolean runAddNewCodeToSelected = false;
    boolean runAddNewPartialCode = false;

    @Test
    public void masterFlow() throws Exception {
        loginToGG();
        navigateToUddharan();

        if (runTransferNewGroup) {
            transferInNewUddharanGroup();
        }
        if (runAddNewPartialCode) {
            addNewPartialCode();
        }
        if (runAddNewCodeToSelected) {
            addNewCodeToSelected();
        }
        if (runAddInNewGroup) {
            addInNewUddharanGroup();
        }
        if (runAddInExistingGroup) {
            addInExistingGroup();
        }
        if (runViaShiftN) {
            addViaShiftN();
        }
        if (runViaPlusIcon) {
            addViaPlusIconEnhanced();
        }
    }

    public void navigateToUddharan() throws Exception {
        Robot robot = new Robot();
        robot.setAutoDelay(250);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_ALT);
        Thread.sleep(500);
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(200);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(9000);
    }

    public void addViaShiftN() throws Exception {
        Robot robot = new Robot();
        robot.setAutoDelay(250);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(3000);

        UddharanUtils.selectGranthAndAdd();
    }

    public void addViaPlusIconEnhanced() throws Exception {
        Robot robot = new Robot();
        robot.setAutoDelay(50);

        // Step 4: SHIFT + N to open Granth list popup
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(3000);

        // Step 5: TAB to move focus to granth list
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(1000);

        // Step 6: Select 25th granth
        int granthIndex = 24;
        for (int i = 0; i < granthIndex; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(250);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);

        // Step 7: Scroll to pointer start line 100
        int pointerStart = 100;
        for (int i = 0; i < pointerStart; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(100);
        }

        // Step 8: Select pointer range (100–150)
        int pointerLength = 50;
        robot.keyPress(KeyEvent.VK_SHIFT);
        for (int i = 0; i < pointerLength; i++) {
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_RIGHT);
            Thread.sleep(150);
        }
        robot.keyRelease(KeyEvent.VK_SHIFT);

        // Step 9: F6 to add pointer
        robot.keyPress(KeyEvent.VK_F6);
        robot.keyRelease(KeyEvent.VK_F6);
        Thread.sleep(3000);

        // Step 10: Confirm with Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);

        // Step 11: ESC to close popup
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(1000);

        System.out.println("✅ Pointer added successfully from Granth #25, pointers 100 to 150.");
    }

    public void addInExistingGroup() throws Exception {
        Robot robot = new Robot();
        robot.setAutoDelay(250);
        for (int i = 0; i < 56; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(100);
        }
        robot.keyPress(KeyEvent.VK_CONTEXT_MENU);
        robot.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        Thread.sleep(1000);
        pressDown(robot, 1);
        pressRight(robot);
        pressDown(robot, 4);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(500);
        for (int i = 0; i < 20; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(300);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        System.out.println("✅ Add In Existing Group No completed (Group No 14)");
    }

    public void addNewPartialCode() throws Exception {
        Robot robot = new Robot();
        Thread.sleep(8000);
        pressDown(robot, 14);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_CONTEXT_MENU);
        robot.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        Thread.sleep(800);
        pressDown(robot, 5);
        pressRight(robot);
        pressDown(robot, 4);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        System.out.println("✅ Redirected to See Code page successfully from record 15");
    }

    public void addNewCodeToSelected() throws Exception {
        Robot robot = new Robot();
        robot.setAutoDelay(250);
        Thread.sleep(8000);
        pressDown(robot, 6);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_CONTEXT_MENU);
        robot.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        Thread.sleep(800);
        pressDown(robot, 5);
        pressRight(robot);
        pressDown(robot, 2);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1200);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(800);
        for (char ch : "p123".toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(ch);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
            Thread.sleep(200);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1500);

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB); Thread.sleep(400);
            robot.keyPress(KeyEvent.VK_F2); robot.keyRelease(KeyEvent.VK_F2); Thread.sleep(1000);
            pressDown(robot, i); robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);

            robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB); Thread.sleep(400);
            robot.keyPress(KeyEvent.VK_F2); robot.keyRelease(KeyEvent.VK_F2); Thread.sleep(1000);
            pressDown(robot, i); robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);

            robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB); Thread.sleep(400);
            robot.keyPress(KeyEvent.VK_F2); robot.keyRelease(KeyEvent.VK_F2); Thread.sleep(1000);
            pressDown(robot, i); robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
        }

        robot.keyPress(KeyEvent.VK_ALT); robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S); robot.keyRelease(KeyEvent.VK_ALT);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ESCAPE); robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(1000);
        System.out.println("✅ 5 Codes added successfully on record 7.");
    }

    public void addInNewUddharanGroup() throws Exception {
        Robot robot = new Robot();
        Thread.sleep(10000);
        robot.keyPress(KeyEvent.VK_SHIFT);
        for (int i = 8; i < 10; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(300);
        }
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_CONTEXT_MENU);
        robot.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        Thread.sleep(1000);
        pressDown(robot, 1);
        pressRight(robot);
        pressDown(robot, 2);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        String usn = "U894";
        for (char c : usn.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
            Thread.sleep(3000);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(1000);
        System.out.println("✅ Add In New Uddharan Group done for USN: " + usn);
    }

    public void transferInNewUddharanGroup() throws Exception {
        Robot robot = new Robot();
        Thread.sleep(10000);
        for (int i = 0; i < 98; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(100);
        }
        robot.keyPress(KeyEvent.VK_SHIFT);
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(300);
        }
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_CONTEXT_MENU);
        robot.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        Thread.sleep(1000);
        pressDown(robot, 1);
        pressRight(robot);
        pressDown(robot, 3);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        String usn = "U895";
        for (char c : usn.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
            Thread.sleep(3000);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        System.out.println("✅ Transfer In New Uddharan Group successful for USN: " + usn);
    }

    private void pressDown(Robot robot, int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(300);
        }
    }

    private void pressRight(Robot robot) throws InterruptedException {
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        Thread.sleep(300);
    }
}
