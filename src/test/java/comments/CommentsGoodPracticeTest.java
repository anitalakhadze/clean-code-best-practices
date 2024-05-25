package comments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentsGoodPracticeTest {

    @Test
    void nameIsFormatted() {
        assertEquals(
                "firstName middleName lastName",
                CommentsGoodPractice.formatFullName(
                        "firstName",
                        "middleName",
                        "lastName"
                )
        );
    }

    @Test
    void whenMiddleNameIsBlank_nameIsCorrectlyFormatted() {
        assertEquals(
                "firstName lastName",
                CommentsGoodPractice.formatFullName(
                        "firstName",
                        "    ",
                        "lastName")
        );
    }

    @Test
    void whenMiddleNameIsNull_nameIsCorrectlyFormatted() {
        assertEquals(
                "firstName lastName",
                CommentsGoodPractice.formatFullName(
                        "firstName",
                        null,
                        "lastName"
                )
        );
    }

    @Test
    void whenMiddleNameIsEmpty_nameIsCorrectlyFormatted() {
        assertEquals(
                "firstName lastName",
                CommentsGoodPractice.formatFullName(
                        "firstName",
                        "",
                        "lastName"
                )
        );
    }

    @Test
    void whenFullNameIsProvided_nameIsCorrectlyFormatted() {
        assertEquals(
                "firstName middleName lastName",
                CommentsGoodPractice.formatFullName(
                        "firstName",
                        "middleName",
                        "lastName"
                )
        );
    }

}