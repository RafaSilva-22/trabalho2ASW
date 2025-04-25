package rsa.match;

public enum PreferredMatch {
    BETTER("better"),
    CHEAPER("cheaper"),
    CLOSER("closer");

    private final String pref;

    PreferredMatch(String pref) {
        this.pref = pref;
    }
    public String getPref() {
        return pref;
    }
}
