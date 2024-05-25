package comments;

public class CommentsGoodPractice {

    /**
     * Formats a full name from given first name, middle name, and last name.
     * The middle name is optional and should be handled appropriately.
     *
     * @param firstName  the user's first name
     * @param middleName the user's middle name (can be null or empty)
     * @param lastName   the user's last name
     * @return the formatted full name
     */
    public static String formatFullName(String firstName, String middleName, String lastName) {
        firstName = firstName.trim();
        lastName = lastName.trim();

        if (!middleName.isBlank()) {
            middleName = middleName.trim();
            return String.format("%s %s %s", firstName, middleName, lastName);
        }

        return String.format("%s %s", firstName, lastName);
    }

}
