package rsa.user;

public enum UserStars {
    ONE_STAR(1),     // Lousy ride
    TWO_STARS(2),    // Bad ride
    THREE_STARS(3),  // Average ride
    FOUR_STARS(4),   // Good ride
    FIVE_STARS(5);   // Great ride

    private final int stars;

    UserStars(int stars) {
        this.stars = stars;
    }

    public int getStars() {
        return stars;
    }


}