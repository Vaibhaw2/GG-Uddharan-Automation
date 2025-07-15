package com.gg.testcases;

import com.gg.base.BaseTest;

public class UpdateMasterTest extends BaseTest {

    public static void main(String[] args) throws Exception {
        UpdateMasterTest master = new UpdateMasterTest();
        master.loginToGG();

        // ✅ Toggle ONLY ONE to true at a time
        boolean runModifyGroupSubject     = false;
        boolean runModifySandarbhPath     = false;
        boolean runModifyShastraPath      = false;
        boolean runModifyUSN              = false;
        boolean runUpdateUTypeUSubType    = false;
        boolean runModifyWithCtrlM        = false;
        boolean runUddharanPopupModify    = true;  // ✅ SHIFT+F4 popup flow

        if (runModifyGroupSubject) {
            runModifyGroupSubjectFlow();
        }

        if (runModifySandarbhPath) {
            runModifySandarbhPathFlow();
        }

        if (runModifyShastraPath) {
            runModifyShastraPathFlow();
        }

        if (runModifyUSN) {
            runModifyUSNFlow();
        }

        if (runUpdateUTypeUSubType) {
            runUpdateUTypeUSubTypeFlow();
        }

        if (runModifyWithCtrlM) {
            runModifyWithCtrlMFlow();
        }

        if (runUddharanPopupModify) {
            runUddharanPopupModifyFlow();
        }
    }

    public void loginToGG() throws Exception {
        LoginTest login = new LoginTest();
        login.loginToGG();
    }

    public static void runModifyGroupSubjectFlow() throws Exception {
        ModifyGroupSubjectTest.run(false, 70, "1276");  // Already logged in
    }

    public static void runModifySandarbhPathFlow() throws Exception {
        ModifySandarbhPathTest.run(false);  // Already logged in
    }

    public static void runModifyShastraPathFlow() throws Exception {
        ModifyShastraPathTest.main(null);  // Login inside handled
    }

    public static void runModifyUSNFlow() throws Exception {
        ModifyUSNTest.main(null);  // Login inside handled
    }

    public static void runUpdateUTypeUSubTypeFlow() throws Exception {
        UpdateUTypeUSubTypeTest.run(true);  // Already logged in
    }

    public static void runModifyWithCtrlMFlow() throws Exception {
        ModifyWithCtrlMTest.run(true);  // Already logged in
    }

    public static void runUddharanPopupModifyFlow() throws Exception {
        UddharanPopupModifyTest.run(true);  // Already logged in
    }
}
