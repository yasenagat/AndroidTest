package com.yasenagat.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public class FC3DParse implements IParse {

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
                        || "2".equals(lCodeInfo.getSaleId())
                        || "3".equals(lCodeInfo.getSaleId())) {
                    danshi_list.add(lCodeInfo);
                } /*else if ("2".equals(lCodeInfo.getSaleId())) {
                    fushi_list.add(lCodeInfo);
                } else if ("3".equals(lCodeInfo.getSaleId())) {
                    dantuo_list.add(lCodeInfo);
                }*/ else {
                    fushi_list.add(lCodeInfo);
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
            times = "0" + times;
        }
        List<String> _tuo_red = new ArrayList<String>();
        List<String> _dan_red = new ArrayList<String>();
        List<String> _tuo_blue = new ArrayList<String>();
        List<String> _dan_blue = new ArrayList<String>();
        StringBuffer ret = new StringBuffer("");

        try {
            CodeUtil.parseCode(codeInfo.getCode(), _tuo_red, _dan_red, _tuo_blue, _dan_blue);

            if ("1".equals(codeInfo.getSaleId())) {
                ret.append("00");
                ret.append(times);
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("2".equals(codeInfo.getSaleId())) {
                ret.append("01");
                ret.append(times);
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("3".equals(codeInfo.getSaleId())) {
                ret.append("02");
                ret.append(times);
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("4".equals(codeInfo.getSaleId())) {

                String codes[] = codeInfo.getCode().split("\\*");

                ret.append("20");
                ret.append(times);
                String[] rets;
                for(String code : codes){
                    rets = CodeUtil.getCode_append0(code);
                    ret.append(rets[0]);
                    ret.append(rets[1]);
                    ret.append(ITicketCreater.TICK);
                }

            }
            else if ("5".equals(codeInfo.getSaleId())) {
                ret.append("31");
                ret.append(times);
                if (_tuo_red.size() < 10) {
                    ret.append("0"+_tuo_red.size());
                }else {
                    ret.append(_tuo_red.size());
                }
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            }
            else if ("6".equals(codeInfo.getSaleId())) {
                ret.append("32");
                ret.append(times);
                if (_tuo_red.size() < 10) {
                    ret.append("0"+_tuo_red.size());
                }else {
                    ret.append(_tuo_red.size());
                }
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("7".equals(codeInfo.getSaleId())) {
                ret.append("51");
                ret.append(times);
                ret.append(CodeUtil.getCode_append0(_dan_red));
                ret.append(ITicketCreater.STAR);
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("8".equals(codeInfo.getSaleId())) {
                ret.append("52");
                ret.append(times);
                ret.append(CodeUtil.getCode_append0(_dan_red));
                ret.append(ITicketCreater.STAR);
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("9".equals(codeInfo.getSaleId())) {
                ret.append("30");
                ret.append(times);
                if (_tuo_red.size() < 10) {
                    ret.append("0"+_tuo_red.size());
                }else {
                    ret.append(_tuo_red.size());
                }
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("10".equals(codeInfo.getSaleId())) {
                ret.append("50");
                ret.append(times);
                ret.append(CodeUtil.getCode_append0(_dan_red));
                ret.append(ITicketCreater.STAR);
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("11".equals(codeInfo.getSaleId())) {
                ret.append("10");
                ret.append(times);
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("12".equals(codeInfo.getSaleId())) {
                ret.append("11");
                ret.append(times);
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("13".equals(codeInfo.getSaleId())) {
                ret.append("12");
                ret.append(times);
                ret.append(CodeUtil.getCode_append0(_tuo_red));
                ret.append(ITicketCreater.TICK);
            } else if ("14".equals(codeInfo.getSaleId())) {

            } else if ("15".equals(codeInfo.getSaleId())) {

            } else if ("16".equals(codeInfo.getSaleId())) {

            } else if ("17".equals(codeInfo.getSaleId())) {

            } else if ("18".equals(codeInfo.getSaleId())) {

            } else if ("19".equals(codeInfo.getSaleId())) {

            } else if ("20".equals(codeInfo.getSaleId())) {

            } else if ("21".equals(codeInfo.getSaleId())) {

            } else if ("22".equals(codeInfo.getSaleId())) {

            } else if ("23".equals(codeInfo.getSaleId())) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret.toString();
    }
}
