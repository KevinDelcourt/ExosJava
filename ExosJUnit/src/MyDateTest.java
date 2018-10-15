import junit.framework.TestCase;

/**
 * @author graffion
 *
 */
public class MyDateTest extends TestCase {

    /**
     * Test method for {@link MyDate#getDay()}.
     */
    public void testGetDay() {
        MyDate d = new MyDate(31, 12, 2006);
        assertEquals(31, d.getDay());
    }

    /**
     * Test method for {@link MyDate#getMonth()}.
     */
    public void testGetMonth() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link MyDate#getYear()}.
     */
    public void testGetYear() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link MyDate#checkData()} .
     */
    public void testCheckData() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test simple valid dates - CE a1
     */
    public void testSimpleValidDates() {
        boolean b = MyDate.isValidDate(1, 1, 2000);
        assertTrue(b);
        b = MyDate.isValidDate(31, 12, 2000);
        assertTrue(b);
    }

    /**
     * Day < 1 - CE b1
     */
    public void testDayInferiorTo1() {
        boolean b = MyDate.isValidDate(-2, 1, 2000);
        assertFalse(b);
    }
    
    /**
     * Day > 31 - CE b2
     */
    public void testDaySuperiorTo31() {
        boolean b = MyDate.isValidDate(45, 1, 2000);
        assertFalse(b);
    }

    /**
     * Month < 1 - CE b3
     */
    public void testMonthInferiorTo1() {
        boolean b = MyDate.isValidDate(2, 0, 2000);
        assertFalse(b);
    }
    
    /**
     * Month < 12 - CE b4
     */
    public void testMonthSuperiorTo12() {
        boolean b = MyDate.isValidDate(2, 13, 2000);
        assertFalse(b);
    }
    
    /**
     * Year < 1812 - CE b6
     */
    public void testYearInferiorTo1812() {
        boolean b = MyDate.isValidDate(2, 1, 1811);
        assertFalse(b);
    }
    
    /**
     * Year > 2012 - CE b5
     */
    public void testYearSuperiorTo2012() {
        boolean b = MyDate.isValidDate(2, 1, 2012);
        assertFalse(b);
    }

    /**
     * Test simple valid dates - 30 days month - CE a2
     */
    public void testValidDates30DaysMonth() {
        boolean b = MyDate.isValidDate(30, 11, 2000);
        assertTrue(b);
    }
    
    /**
     * Day at 31 on a 30 days month - CE b7
     */
    public void testDayEqual31On30DaysMonth() {
        boolean b = MyDate.isValidDate(31, 11, 2000);
        assertFalse(b);
    }
    
    /**
     * 28/02 on a non leap year - CE a3
     */
    public void testFebruaryValidDateNonLeapYear() {
        boolean b = MyDate.isValidDate(28, 2, 2001);
        assertTrue(b);
    }
    
    /**
     * 29/02 on a non leap year - CE b8
     */
    public void testFebruaryInvalidDateNonLeapYear() {
        boolean b = MyDate.isValidDate(29, 2, 2001);
        assertFalse(b);
    }
    
    /**
     * 29/02 on a leap year - CE a3
     */
    public void testFebruaryValidDateLeapYear() {
        boolean b = MyDate.isValidDate(29, 2, 2004);
        assertTrue(b);
    }
    
    /**
     * 30/02 on a leap year - CE b9
     */
    public void testFebruaryInvalidDateLeapYear() {
        boolean b = MyDate.isValidDate(30, 2, 2008);
        assertFalse(b);
    }
}
