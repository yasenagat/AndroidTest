package com.yasenagat.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public class QYHParse implements IParse {

    @Override
    public List<List<CodeInfo>> parse(List<CodeInfo> codeInfos, String times) {

        List<List<CodeInfo>> lLists = new ArrayList<List<CodeInfo>>();

        List<CodeInfo> danshi_list = new ArrayList<CodeInfo>();
        List<CodeInfo> fushi_list = new ArrayList<CodeInfo>();
        List<CodeInfo> dantuo_list = new ArrayList<CodeInfo>();

        try {
            for (int i = 0; i < codeInfos.size(); i++) {
                CodeInfo lCodeInfo = codeInfos.get(i);
                lCodeInfo.setCode(parse(lCodeInfo, times));
                if ("1".equals(lCodeInfo.getSaleId())
                        || "3".equals(lCodeInfo.getSaleId())
                        || "6".equals(lCodeInfo.getSaleId())
                        || "9".equals(lCodeInfo.getSaleId())
                        || "12".equals(lCodeInfo.getSaleId())
                        || "15".equals(lCodeInfo.getSaleId())
                        || "18".equals(lCodeInfo.getSaleId())
                        || "21".equals(lCodeInfo.getSaleId())
                        || "23".equals(lCodeInfo.getSaleId())
                        || "26".equals(lCodeInfo.getSaleId())
                        || "29".equals(lCodeInfo.getSaleId())
                        || "32".equals(lCodeInfo.getSaleId())
                        || "35".equals(lCodeInfo.getSaleId())
                        || "38".equals(lCodeInfo.getSaleId())
                        || "41".equals(lCodeInfo.getSaleId())
                        || "44".equals(lCodeInfo.getSaleId())
                        || "47".equals(lCodeInfo.getSaleId())
                        || "51".equals(lCodeInfo.getSaleId())) {
                    danshi_list.add(lCodeInfo);
                } else if ("10".equals(lCodeInfo.getSaleId())
                        || "13".equals(lCodeInfo.getSaleId())
                        || "16".equals(lCodeInfo.getSaleId())
                        || "19".equals(lCodeInfo.getSaleId())
                        || "22".equals(lCodeInfo.getSaleId())
                        || "24".equals(lCodeInfo.getSaleId())
                        || "27".equals(lCodeInfo.getSaleId())
                        || "30".equals(lCodeInfo.getSaleId())
                        || "33".equals(lCodeInfo.getSaleId())
                        || "36".equals(lCodeInfo.getSaleId())
                        || "39".equals(lCodeInfo.getSaleId())
                        || "42".equals(lCodeInfo.getSaleId())
                        || "45".equals(lCodeInfo.getSaleId())
                        || "48".equals(lCodeInfo.getSaleId())
                        || "52".equals(lCodeInfo.getSaleId())) {
                    fushi_list.add(lCodeInfo);
                } else if ("11".equals(lCodeInfo.getSaleId())
                        || "14".equals(lCodeInfo.getSaleId())
                        || "17".equals(lCodeInfo.getSaleId())
                        || "20".equals(lCodeInfo.getSaleId())
                        || "25".equals(lCodeInfo.getSaleId())
                        || "28".equals(lCodeInfo.getSaleId())
                        || "31".equals(lCodeInfo.getSaleId())
                        || "34".equals(lCodeInfo.getSaleId())
                        || "37".equals(lCodeInfo.getSaleId())
                        || "40".equals(lCodeInfo.getSaleId())
                        || "43".equals(lCodeInfo.getSaleId())
                        || "46".equals(lCodeInfo.getSaleId())
                        || "49".equals(lCodeInfo.getSaleId())
                        || "53".equals(lCodeInfo.getSaleId())) {
                    dantuo_list.add(lCodeInfo);
                }
            }

            lLists.add(danshi_list);
            lLists.add(fushi_list);
            lLists.add(dantuo_list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lLists;
    }

    @Override
    public String parse(CodeInfo codeInfo, String times) {
        if (times.length() == 1) {
            times = "000" + times;
        } else if (times.length() == 2) {
            times = "00" + times;
        } else if (times.length() == 3) {
            times = "0" + times;
        }
        System.out.println("times : " + times);
        List<String> _tuo_red = new ArrayList<String>();
        List<String> _dan_red = new ArrayList<String>();
        StringBuffer ret = new StringBuffer("");

        try {
            CodeUtil.parseCode(codeInfo.getCode(), _tuo_red, _dan_red);

            if ("1".equals(codeInfo.getSaleId())) {
                ret.append("01");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("3".equals(codeInfo.getSaleId())) {
                ret.append("02");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("6".equals(codeInfo.getSaleId())) {
                ret.append("03");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("9".equals(codeInfo.getSaleId())) {
                ret.append("12");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("12".equals(codeInfo.getSaleId())) {
                ret.append("13");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("15".equals(codeInfo.getSaleId())) {
                ret.append("14");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("18".equals(codeInfo.getSaleId())) {
                ret.append("15");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("21".equals(codeInfo.getSaleId())) {
                ret.append("21");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("23".equals(codeInfo.getSaleId())) {
                ret.append("22");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("26".equals(codeInfo.getSaleId())) {
                ret.append("23");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("29".equals(codeInfo.getSaleId())) {
                ret.append("24");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("32".equals(codeInfo.getSaleId())) {
                ret.append("25");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("35".equals(codeInfo.getSaleId())) {
                ret.append("26");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("38".equals(codeInfo.getSaleId())) {
                ret.append("27");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("41".equals(codeInfo.getSaleId())) {
                ret.append("28");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("44".equals(codeInfo.getSaleId())) {
                ret.append("29");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("47".equals(codeInfo.getSaleId())) {
                ret.append("a");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("10".equals(codeInfo.getSaleId())) {
                ret.append("32");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("13".equals(codeInfo.getSaleId())) {
                ret.append("33");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("16".equals(codeInfo.getSaleId())) {
                ret.append("34");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("19".equals(codeInfo.getSaleId())) {
                ret.append("35");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("22".equals(codeInfo.getSaleId())) {
                ret.append("41");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("24".equals(codeInfo.getSaleId())) {
                ret.append("42");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("27".equals(codeInfo.getSaleId())) {
                ret.append("43");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("30".equals(codeInfo.getSaleId())) {
                ret.append("44");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("33".equals(codeInfo.getSaleId())) {
                ret.append("45");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("36".equals(codeInfo.getSaleId())) {
                ret.append("46");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("39".equals(codeInfo.getSaleId())) {
                ret.append("47");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("42".equals(codeInfo.getSaleId())) {
                ret.append("48");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("45".equals(codeInfo.getSaleId())) {
                ret.append("49");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("48".equals(codeInfo.getSaleId())) {
                ret.append("a");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("25".equals(codeInfo.getSaleId())) {
                ret.append("52");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("28".equals(codeInfo.getSaleId())) {
                ret.append("53");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("31".equals(codeInfo.getSaleId())) {
                ret.append("54");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("34".equals(codeInfo.getSaleId())) {
                ret.append("55");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("37".equals(codeInfo.getSaleId())) {
                ret.append("56");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("40".equals(codeInfo.getSaleId())) {
                ret.append("57");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("43".equals(codeInfo.getSaleId())) {
                ret.append("58");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("46".equals(codeInfo.getSaleId())) {
                ret.append("59");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("49".equals(codeInfo.getSaleId())) {
                ret.append("a");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("11".equals(codeInfo.getSaleId())) {
                ret.append("72");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("14".equals(codeInfo.getSaleId())) {
                ret.append("73");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("17".equals(codeInfo.getSaleId())) {
                ret.append("74");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("20".equals(codeInfo.getSaleId())) {
                ret.append("75");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret.toString();
    }
}
