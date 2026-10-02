/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    /**
     * Code that is not publicly available cannot be used.
     */
    @Test
    public void testPrivateCodeIsNotAllowed() {
        assertFalse("Expected false: code is not publicly available",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
    }

    /**
     * Code from another student's course work is not allowed.
     */
    @Test
    public void testStudentCourseWorkIsForbidden() {
        assertFalse("Expected false: code was written as course work",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, false, false));
    }

    /**
     * Public code can be used when the source is cited and the assignment
     * does not require implementing the same feature.
     */
    @Test
    public void testCitedPublicCodeCanBeUsed() {
        assertTrue("Expected true: public code is cited and not required",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }
}