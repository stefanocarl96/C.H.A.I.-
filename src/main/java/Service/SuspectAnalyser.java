package service;

import model.Suspect;

public class SuspectAnalyser {

    public boolean match(Suspect s1, Suspect s2) {

        boolean result = false;
        int totalPoint = 0;
        boolean sameName = false;
        boolean sameAge = false;
        boolean sameWeight = false;
        boolean sameHeight = false;

        if(s1.isMale() != s1.isMale()) {
            result = false;

        } else {
            if (s1.getName().toUpperCase().equals(s2.getName().toUpperCase())) {
                totalPoint++;
                sameName = true;
            }
            if (Math.abs(s1.getAge() - s2.getAge()) <= 1) {
                totalPoint++;
                sameAge = true;
            }
            if (Math.abs(s1.getHeight() - s2.getHeight()) <= 2) {
                totalPoint++;
                sameHeight = true;
            }
            if (Math.abs(s1.getWeight() - s2.getWeight()) <= 5) {
                totalPoint++;
                sameWeight = true;
            }
            if (s1.getHairColor().toUpperCase().equals(s2.getHairColor().toUpperCase())) {
                totalPoint++;
            }
            if (s1.getEyeColor().toUpperCase().equals(s2.getEyeColor().toUpperCase())) {
                totalPoint++;
            }

            if (totalPoint >= 5) {
                result = true;
            } else if (sameName & sameAge & sameHeight & sameWeight) {
                result = true;
            } else {
                result = false;
            }
        }

        return result;
    }
}