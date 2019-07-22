package pl.coderslab.springtest.student;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PageControllerTest {

    private PageController pageController = new PageController();
    private static String PAGE_VIEW_NAME = "page/index";

    @Test
    public void shouldReturnPage() {
        assertEquals(pageController.page(), PAGE_VIEW_NAME);
    }

}