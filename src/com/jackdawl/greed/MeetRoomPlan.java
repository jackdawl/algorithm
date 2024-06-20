package com.jackdawl.greed;

import java.util.ArrayList;
import java.util.List;

public class MeetRoomPlan {

    public static void main(String[] args) {
        List<Meet> list = new ArrayList<Meet>(List.of(new Meet(1, 8, 10),
                new Meet(2, 10, 17),
                new Meet(3, 11, 14),
                new Meet(4, 13, 15),
                new Meet(5, 18, 20),
                new Meet(6, 9, 12)));

        //key 1: greedy strategy: sorting
        list.sort(null);
        int avaTime = 8;
        for (Meet meet : list) {
            //key 2: Achieve global optimality through local optimality
            if (meet.getStartTime() > avaTime) {
                System.out.println(meet);
                avaTime = meet.getEndTime();
            }
        }

    }



}
