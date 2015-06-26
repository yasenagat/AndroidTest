package com.yasenagat.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2015/6/11.
 */
public class SSQParse implements IParse {

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
                if ("1".equals(lCodeInfo.getSaleId())) {
                    danshi_list.add(lCodeInfo);
                } else if ("2".equals(lCodeInfo.getSaleId())) {
                    fushi_list.add(lCodeInfo);
                } else if ("3".equals(lCodeInfo.getSaleId())) {
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
            times = "0" + times;
        }
        List<String> _tuo_red = new ArrayList<String>();
        List<String> _dan_red = new ArrayList<String>();
        List<String> _tuo_blue = new ArrayList<String>();
        List<String> _dan_blue = new ArrayList<String>();
        StringBuffer ret = new StringBuffer("");

        try {
            CodeUtil.parseCode(codeInfo.getCode(), _tuo_red, _dan_red, _tuo_blue, _dan_blue);


            if (_dan_red.size() == 0
                    && _dan_blue.size() == 0
                    && _tuo_red.size() == 6
                    && _tuo_blue.size() == 1) {

                ret.append("00");
                ret.append(times);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TILDE);
                ret.append(CodeUtil.getCode(_tuo_blue));
                ret.append(ITicketCreater.TICK);
            } else if (_dan_red.size() == 0
                    && _dan_blue.size() == 0
                    && _tuo_red.size() > 6
                    && _tuo_blue.size() == 1) {

                ret.append("10");
                ret.append(times);
                ret.append(ITicketCreater.STAR);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TILDE);
                ret.append(CodeUtil.getCode(_tuo_blue));
                ret.append(ITicketCreater.TICK);
            } else if (_dan_red.size() == 0
                    && _dan_blue.size() == 0
                    && _tuo_red.size() == 6
                    && _tuo_blue.size() > 1) {

                ret.append("20");
                ret.append(times);
                ret.append(ITicketCreater.STAR);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TILDE);
                ret.append(CodeUtil.getCode(_tuo_blue));
                ret.append(ITicketCreater.TICK);
            } else if (_dan_red.size() == 0
                    && _dan_blue.size() == 0
                    && _tuo_red.size() > 6
                    && _tuo_blue.size() > 1) {

                ret.append("30");
                ret.append(times);
                ret.append(ITicketCreater.STAR);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TILDE);
                ret.append(CodeUtil.getCode(_tuo_blue));
                ret.append(ITicketCreater.TICK);
            } else if (_dan_red.size() > 0
                    && _dan_blue.size() == 0
                    && _tuo_red.size() > 0
                    && _tuo_blue.size() == 1) {

                ret.append("40");
                ret.append(times);
                ret.append(CodeUtil.getCode(_dan_red));
                ret.append(ITicketCreater.STAR);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TILDE);
                ret.append(CodeUtil.getCode(_tuo_blue));
                ret.append(ITicketCreater.TICK);
            }else if (_dan_red.size() > 0
                    && _dan_blue.size() == 0
                    && _tuo_red.size() > 0
                    && _tuo_blue.size() > 1) {

                ret.append("50");
                ret.append(times);
                ret.append(CodeUtil.getCode(_dan_red));
                ret.append(ITicketCreater.STAR);
                ret.append(CodeUtil.getCode(_tuo_red));
                ret.append(ITicketCreater.TILDE);
                ret.append(CodeUtil.getCode(_tuo_blue));
                ret.append(ITicketCreater.TICK);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ret : "+ret);
        return ret.toString();
    }
}
