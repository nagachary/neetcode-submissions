class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (String email : emails) {

            if (!validateEmailAddress(email)) {
                continue;
            }
            String firstPart = email.split("@")[0];
            firstPart = replaceDot(firstPart);
            firstPart = ignorePlus(firstPart);
            String lastPart = email.split("@")[1];
            set.add(firstPart + "@" + lastPart);
        }
        return set.size();
    }

    private boolean validateEmailAddress(String email) {
        int astreickCount = 0;
        for (char c : email.toCharArray()) {
            if (c == '@') {
                astreickCount++;
            }
        }

        if (astreickCount == 0 || astreickCount > 1) {
            return false;
        }

        if (email.indexOf("+") == 0) {
            return false;
        }
        return true;
    }

    private String replaceDot(String emailLastName) {
        int dotIdx = emailLastName.indexOf(".");

        if (dotIdx != -1) {
            emailLastName = emailLastName.replace(".", "");
        }
        return emailLastName;
    }

    private String ignorePlus(String emailLastName) {
        if (emailLastName.contains("+")) {
            int dotIdx = emailLastName.indexOf("+");
            emailLastName = emailLastName.substring(0, dotIdx);
        }
        return emailLastName;
    }
}