package com.demoqa.ui.Helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {

    public String getRandomString(String[] data) {

         return data[new Random().nextInt(data.length)];

    }

    public List<String> getRandomStringList(List<String> data) {

        List<String> res = new ArrayList<>();
        Random rand = new Random();

        int r = rand.nextInt(data.size());

        for (int i = 0; i < r; i++) {
            int randomIndex = rand.nextInt(data.size());
            res.add(data.get(randomIndex));
        }
        return res;
    }

//    public int getRandomNumber(int lenth) {
//
//        return
//
//    }


}
