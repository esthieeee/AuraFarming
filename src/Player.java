public class Player {
    private String username;
    private int followers;
    private int password;
    private int aura;
    private int ads;
    private int day, followersGained, auraGained;
    private int current, currentAura;

    public Player() {
        day = 1;
        followersGained = 0;
        auraGained = 0;
        username = "";
        followers = 0;
        aura = 0;
        ads = 0;
        current = 0;
        currentAura = 0;
        password = 0000;
    }

    public int addAura() {
        int auraToAdd = (int) (Math.random() * 1001);
        aura += auraToAdd;
        auraGained += auraToAdd;
        return auraToAdd;
    }

    public int deleteAura() {
        int auraToDelete = (int) (Math.random() * 101);
        aura -= auraToDelete;
        auraGained -= auraToDelete;
        return auraToDelete;
    }

    public void deleteAura(int amount) {
        aura -= amount;
    }

    public int getCurrent() {
        return current;
    }

    public int getCurrentAura() {
        return currentAura;
    }

    public void setCurrentAura(int amount) {
        currentAura = amount;
    }

    public void setCurrent(int amount) {
        current = amount;
    }

    public int getAura() {
        return aura;
    }

    public void addAds(int add) {
        ads += add;
    }

    public int getAds() {
        return ads;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUser) {
        username = newUser;
    }

    public int getFollowers() {
        return followers;
    }

    public void addFollowers(int newFollowers) {
        followers = followers + newFollowers;
        followersGained += followersGained;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void endDay() {
        day++;
        followersGained = 0;
        auraGained = 0;
        System.out.println("Day: " + day);
    }

    public int getFollowersGained() {
        return followersGained;
    }

    public int getAuraGained() {
        return auraGained;
    }
    public int getDay() {
        return day;
    }
}