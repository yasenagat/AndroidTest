package com.yasenagat;

import com.yasenagat.code.CodeInfo;
import com.yasenagat.code.TicketInvoke;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<CodeInfo> list = new ArrayList<CodeInfo>();
        List<CodeInfo> other_list = new ArrayList<CodeInfo>();
//        list.add(new CodeInfo("01,02,03,04,05,06,07,08", "2", "5"));
//        list.add(new CodeInfo("01,02,03,04,05,06,07,08", "2", "5"));
//        list.add(new CodeInfo("01,02,03,04,05,06,07", "1", "5"));
//        list.add(new CodeInfo("01,02,03,04,05,06,07", "1", "5"));
//        list.add(new CodeInfo("01,02,03,04,05,06,07", "1", "5"));
//        list.add(new CodeInfo("01,02,03,04,05,06,07", "1", "5"));
//        list.add(new CodeInfo("01,02,03,04,05,06,07", "1", "5"));
//        list.add(new CodeInfo("01,02,03,04,05,06,07", "1", "5"));
//        list.add(new CodeInfo("01,02,03,04,05,06,07", "1", "5"));
//        list.add(new CodeInfo("01,02,03,04,05*06,07,08,09", "3", "5"));
//        list.add(new CodeInfo("01,02,03,04,05*06,07,08,09", "3", "5"));

//        list.add(new CodeInfo("01", "1", "1"));
//        list.add(new CodeInfo("05,02", "3", "1"));
//        list.add(new CodeInfo("05,02,09", "38", "1"));
//        list.add(new CodeInfo("05,02,09", "41", "1"));
//        list.add(new CodeInfo("05,02,09", "6", "1"));
//        list.add(new CodeInfo("05,02,09", "6", "1"));
//        list.add(new CodeInfo("05,02,09", "6", "1"));

//        list.add(new CodeInfo("01,02,03,04,05,06|01", "1", "1"));
//        list.add(new CodeInfo("01,02,03,04,05,06,07,08|01,02,03", "2", "1"));
//        list.add(new CodeInfo("01,02,03,04,05*06,07,08,09|01,02,03", "3", "1"));

        list.add(new CodeInfo("15", "4", "1"));
        String ret = TicketInvoke.execute("FC3D", list, "10");

        System.out.println(ret);


    }
}
